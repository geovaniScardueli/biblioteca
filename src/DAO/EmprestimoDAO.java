/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Emprestimo;
import DTO.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author isold
 */
public class EmprestimoDAO extends ConexaoDAO{

    public ArrayList<Emprestimo> select() {
        ArrayList<Emprestimo> dados = new ArrayList();
        Connection conn = novaConexao();
        String sql = "select * from emprestimo;";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setNrSequencia(rs.getInt("NR_SEQUENCIA"));
                emprestimo.setUsuario(rs.getString("USUARIO"));
                emprestimo.setTituloLivro(rs.getString("LIVRO"));
                emprestimo.setEmprestimo(rs.getString("EMPRESTIMO"));
                dados.add(emprestimo);
            }
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Erroooow: " + ex);
        }
        return dados;
    }
    
    public int selectExemplar(String texto) {
        Connection conn = novaConexao();
        String sql = "select * from informacoes a where a.titulo = ?;";
        PreparedStatement pstmt = null;
        int retorno = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, texto);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                retorno = rs.getInt("NR_SEQUENCIA");
            }
            pstmt.close();
            conn.close();
            return retorno;
        } catch (Exception ex) {
            System.out.println("Erroooow: " + ex);
        }
        return 0;
    }
    
    public void inserirEmprestimo(Emprestimo emprestimo) {
        Connection conn = novaConexao();
        String sql = "insert into emprestimo(LIVRO, USUARIO, EMPRESTIMO, NR_EXEMPLAR) values(?,?,?,?);";
        PreparedStatement pstmt = null;
        int retorno = 0;
        try {
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, emprestimo.getTituloLivro());
            pstmt.setString(2, emprestimo.getUsuario());
            pstmt.setString(3, emprestimo.getEmprestimo());
            pstmt.setInt(4, emprestimo.getExemplar());
            pstmt.executeUpdate();
            pstmt.close();
            
            String sql2 = "delete from reserva where nr_exemplar = ?;";
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setInt(1, emprestimo.getExemplar());
            pstmt2.executeUpdate();
            pstmt2.close();
            
            conn.close();
        } catch (Exception ex) {
            System.out.println("Erro insert emprestimo: " + ex);
        }
    }
    
    public void deletarEmprestimo(int sequencia) {
        Connection conn = novaConexao();
        String sql2 = "delete from emprestimo where nr_sequencia = ?;";
        String sql = "update usuario set multa = null where nome = (select usuario from emprestimo where nr_sequencia = ?);";
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sequencia);
            pstmt.executeUpdate();
            
            pstmt.close();
            
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setInt(1, sequencia);
            pstmt2.executeUpdate();
            pstmt2.close();
            
            conn.close();
        } catch (Exception ex) {
            System.out.println("Erro delete emprestimo: " + ex);
        }
    }
    
    public boolean VerificaMulta(String nome) {
        Connection conn = novaConexao();
        String sql = "select multa from usuario where nome = ?;";
        boolean podeEmprestar = true;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nome);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (rs.getInt("MULTA") > 10) {
                    podeEmprestar = false;
                }
            }
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Erro pode emprestar: " + ex);
        }
        return podeEmprestar;
    }
    
    public Reserva verificaEmprestimo(int seqExemplar, String usuario) {
        Connection con = novaConexao();
        Reserva reserva = new Reserva();
        String sql = "select * from reserva where nr_sequencia = ? and usuario = ?;";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, seqExemplar);
            pstmt.setString(2, usuario);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {                
                reserva.setUsuario(rs.getString("USUARIO"));
                return reserva;
            }
        } catch(Exception ex) {
            System.out.println("erro ao verificar emprestimo" + ex);
        }
        return null;
    }
    
    public void renovar(String data, int seq) {
        Connection con = novaConexao();
        String sql = "update emprestimo set emprestimo = ? where nr_sequencia = ?;";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, data);
            pstmt.setInt(2, seq);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch(Exception ex){ 
            System.out.println("erroa o renovar: " + ex);
        }
    }
}
