/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Exemplar;
import DTO.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author isold
 */
public class ReservaDAO extends ConexaoDAO {

    public ArrayList<Reserva> selectAll() {
        ArrayList<Reserva> dados = new ArrayList();
        Connection con = novaConexao();
        String sql = "select * from reserva;";
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setSequencia(rs.getInt("NR_SEQUENCIA"));
                reserva.setLivro(rs.getString("LIVRO"));
                reserva.setUsuario(rs.getString("USUARIO"));
                dados.add(reserva);
            }
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro ao trazer informacoes reserva" + ex);
        }
        return dados;
    }

    public void inserir(Reserva reserva) {
        Connection con = novaConexao();
        String sql = "insert into reserva(LIVRO, USUARIO, NR_EXEMPLAR) values (?, ?, ?);";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, reserva.getLivro());
            pstmt.setString(2, reserva.getUsuario());
            pstmt.setInt(3, reserva.getSequenciaExemplar());
            
            pstmt.executeUpdate();
            
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro ao inserir reserva" + ex);
        }
    }
    
    public void deletar(int seq) {
        Connection con = novaConexao();
        String sql = "delete from reserva where nr_sequencia = ?;";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, seq);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro ao deletar reserva" + ex);
        }
    }
    
    public ArrayList<Exemplar> selectExemplarLC(int sequencia) {
        ArrayList<Exemplar> dados = new ArrayList();
        Connection conn = novaConexao();
        String sql = "select * from exemplar where nr_livro = ? and nr_sequencia not in(select nr_exemplar from reserva);";
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
}
