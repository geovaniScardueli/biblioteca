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
                usuario.setEmprestimo(rs.getDate("emprestimo"));
                usuario.setNome(rs.getString("nome"));
                usuario.setValor_multa(rs.getInt("valor_multa"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setSequencia(rs.getInt("sequencia"));
                dados.add(usuario);
            }
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Erroooow: " + ex);
        }
        return dados;
    }

}
