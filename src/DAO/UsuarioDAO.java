/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author informatica
 */
public class UsuarioDAO extends ConexaoDAO {

    public ArrayList<Usuario> select() {
        ArrayList<Usuario> dados = new ArrayList();
        Connection conn = novaConexao();
        String sql = "select * from usuario;";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setEmprestimo(rs.getDate("EMPRESTIMO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setValor_multa(rs.getInt("MULTA"));
                usuario.setTipo(rs.getString("TIPO"));
                usuario.setSequencia(rs.getInt("NR_SEQUENCIA"));
                dados.add(usuario);
            }
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Erroooow: " + ex);
        }
        return dados;
    }

    public ArrayList<Usuario> selectAplicandoMulta(String dataAtual) {
        ArrayList<Usuario> dados = new ArrayList();
        Connection conn = novaConexao();
        String sql = "select * from usuario;";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setEmprestimo(rs.getDate("EMPRESTIMO"));
                usuario.setNome(rs.getString("NOME"));
                usuario.setTipo(rs.getString("TIPO"));
                usuario.setSequencia(rs.getInt("NR_SEQUENCIA"));
                dados.add(usuario);
            }
            pstmt.close();

            String sql2 = "select TIMESTAMPDIFF(DAY, STR_TO_DATE(a.emprestimo, '%d/%m/%Y'), STR_TO_DATE(?, '%d/%m/%Y')) tempo from emprestimo a, "
                    + "usuario b where a.usuario = ? group by a.usuario;";
            for (int i = 0; i < dados.size(); i++) {
                ArrayList<Integer> tempos = new ArrayList();
                PreparedStatement pstmt2 = null;
                pstmt2 = conn.prepareStatement(sql2);
                pstmt2.setString(1, dataAtual);
                pstmt2.setString(2, dados.get(i).getNome());
                ResultSet retorno = pstmt2.executeQuery();
                while (retorno.next()) {
                    tempos.add(retorno.getInt("TEMPO"));
                }
                pstmt2.close();
                
                int multa = calculaMulta(dados.get(i).getTipo(), tempos);
                if (multa > 0) {
                    String sql3 = "update usuario set MULTA = ? where nr_sequencia = ?";
                    PreparedStatement pstmt3 = null;
                    pstmt3 = conn.prepareStatement(sql3);
                    pstmt3.setInt(1, multa);
                    pstmt3.setInt(2, dados.get(i).getSequencia());
                    pstmt3.executeUpdate();
                    pstmt3.close();
                }
                dados.get(i).setValor_multa(multa);
            }
            conn.close();
        } catch (Exception ex) {
            System.out.println("Erro select novo: " + ex);
        }
        return dados;
    }

    public int calculaMulta(String servidor, ArrayList<Integer> tempos) {
        int multa = 0;
        if ("S".equals(servidor)) {
            for (int tempo : tempos) {
                if (tempo > 30) {
                    multa = multa + (tempo - 30);
                }
            }
        } else {
            for (int tempo : tempos) {
                if (tempo > 14) {
                    multa = multa + (tempo - 14);
                }
            }
        }
        return multa;
    }

    public void adicionar(Usuario usuario) {
        Connection conn = novaConexao();
        String sql = "insert into usuario(NOME, TIPO) values(?, ?);";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getTipo());

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Erroooow: " + ex);
        }
    }
}
