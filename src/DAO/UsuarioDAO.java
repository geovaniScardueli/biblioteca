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
