/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author informatica
 */
public class ConexaoDAO {

    protected Connection novaConexao() {
        Connection conn = null;
        final String nome = "root";
        final String senha = "w8dsa5ret2";
        final String db_url = "jdbc:mysql://localhost/bibliomatec";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(db_url, nome, senha);

        } catch (Exception ex) {
            System.out.println("Não vai da não: " + ex);
        }

        return conn;
    }
}
