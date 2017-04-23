/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Livro;
import DTO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author informatica
 */
public class LivroDAO extends ConexaoDAO {

    public ArrayList<Livro> select() {
        ArrayList<Livro> dados = new ArrayList();
        Connection conn = novaConexao();
        String sql = "select * from livro a, informacoes b where b.nr_sequencia = a.nr_informacoes;";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Livro livro = new Livro();
                livro.setAno(rs.getString("ANO"));
                livro.setEditora(rs.getString("EDITORA"));
                livro.setTitulo(rs.getString("TITULO"));
                livro.setAutor(rs.getString("AUTOR"));
                livro.setClassificacao(rs.getString("CLASSIFICACAO"));
                livro.setISBN(rs.getString("ISBN"));
                livro.setPaginas(rs.getInt("PAGINAS"));
                livro.setNrSequencia(rs.getInt("NR_INFORMACOES"));
                dados.add(livro);
            }
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Erroooow: " + ex);
        }
        return dados;
    }

    public void inserirLivro(Livro livro) {
        ArrayList<Livro> dados = new ArrayList();
        Connection conn = novaConexao();
        String sql = "insert into informacoes (CLASSIFICACAO, AUTOR, TITULO, EDITORA, ANO) values("
                + "?, ?, ?, ?, ?);";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, livro.getClassificacao());
            pstmt.setString(2, livro.getAutor());
            pstmt.setString(3, livro.getTitulo());
            pstmt.setString(4, livro.getEditora());
            pstmt.setString(5, livro.getAno());
            pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Erroooow: " + ex);
        }
    }
}
