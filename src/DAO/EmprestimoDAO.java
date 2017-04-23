/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Emprestimo;
import DTO.Livro;
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
                emprestimo.setNrSequencia(rs.getInt(sql));
                emprestimo.setUsuario(rs.getString(sql));
                emprestimo.setTituloLivro(rs.getString(sql));
                emprestimo.setEmprestimo(rs.getDate(sql));
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
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, texto);
            ResultSet rs = pstmt.executeQuery();
            pstmt.close();
            conn.close();
            return rs.getInt("NR_SEQUENCIA");
        } catch (Exception ex) {
            System.out.println("Erroooow: " + ex);
        }
        return 0;
    }
}
