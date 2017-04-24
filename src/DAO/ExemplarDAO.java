/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Exemplar;
import DTO.Livro;
import DTO.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author isold
 */
public class ExemplarDAO extends ConexaoDAO {

    public ArrayList<Exemplar> select(int sequencia) {
        ArrayList<Exemplar> dados = new ArrayList();
        Connection conn = novaConexao();
        String sql = "select * from exemplar where nr_livro = ? and nr_sequencia not in(select nr_exemplar from emprestimo);";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sequencia);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Exemplar exemplar = new Exemplar();
                exemplar.setNrSequencia(rs.getInt("NR_SEQUENCIA"));
                exemplar.setCodigoBarra(rs.getInt("COD_BARRAS"));
                exemplar.setPatrimonio(rs.getInt("PATRIMONIO"));
                dados.add(exemplar);
            }
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Erroooow: " + ex);
        }
        return dados;
    }

    public void adicionar(Exemplar exemplar, int sequencia) {
        Connection conn = novaConexao();
        String sql = "insert into exemplar(COD_BARRAS, PATRIMONIO, NR_LIVRO) values(?, ?, ?);";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, exemplar.getCodigoBarra());
            pstmt.setInt(2, exemplar.getExemplar());
            pstmt.setInt(3, sequencia);
            
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            System.out.println("erro: " + e);
        }
    }
    
    public void excluir(int sequencia) {
        Connection conn = novaConexao();
        String sql = "delete from exemplar where nr_sequencia = ?;";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, sequencia);
            
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            System.out.println("erro: " + e);
        }
    }
}
