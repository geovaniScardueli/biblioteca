/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliomateca.reserva;

import DAO.EmprestimoDAO;
import DAO.ExemplarDAO;
import DAO.LivroDAO;
import DAO.ReservaDAO;
import DAO.UsuarioDAO;
import DTO.Exemplar;
import DTO.Livro;
import DTO.Reserva;
import DTO.Usuario;
import java.util.ArrayList;

/**
 *
 * @author isold
 */
public class ReservaPainel extends javax.swing.JPanel {

    private final UsuarioDAO usuarioDao;
    private final LivroDAO livroDAO;
    private final ExemplarDAO exemplarDAO;
    private final EmprestimoDAO emprestimoDAO;
    private final ModeloReserva modeloReserva;
    private final ReservaDAO reservaDAO;

    public ReservaPainel() {
        initComponents();
        exemplarDAO = new ExemplarDAO();
        livroDAO = new LivroDAO();
        usuarioDao = new UsuarioDAO();
        emprestimoDAO = new EmprestimoDAO();
        reservaDAO = new ReservaDAO();
        modeloReserva = new ModeloReserva();
        tabela.setModel(modeloReserva);
    }

    public void ativar() {
        atualizar();
        usuarioCB.removeAllItems();
        livroCB.removeAllItems();
        exemplarCB.removeAllItems();
        ArrayList<Livro> livros = livroDAO.select();
        ArrayList<Usuario> usuarios = usuarioDao.select();
        for (Livro livro : livros) {
            livroCB.addItem(livro.getTitulo());
        }
        for (Usuario usuario : usuarios) {
            usuarioCB.addItem(usuario.getNome());
        }
    }

    public void atualizar() {
        modeloReserva.adicionarSelect(reservaDAO.selectAll());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        usuarioCB = new javax.swing.JComboBox<>();
        livroCB = new javax.swing.JComboBox<>();
        exemplarCB = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(null);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        add(jScrollPane1);
        jScrollPane1.setBounds(52, 11, 484, 240);

        usuarioCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(usuarioCB);
        usuarioCB.setBounds(120, 300, 270, 20);

        livroCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        livroCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                livroCBItemStateChanged(evt);
            }
        });
        add(livroCB);
        livroCB.setBounds(120, 330, 270, 20);

        exemplarCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(exemplarCB);
        exemplarCB.setBounds(120, 360, 270, 20);

        jButton1.setText("Reservar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(430, 300, 90, 30);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(430, 340, 90, 30);

        jLabel1.setText("Usuário: ");
        add(jLabel1);
        jLabel1.setBounds(60, 300, 50, 14);

        jLabel2.setText("Livro: ");
        add(jLabel2);
        jLabel2.setBounds(70, 330, 40, 14);

        jLabel3.setText("Exemplar: ");
        add(jLabel3);
        jLabel3.setBounds(50, 360, 60, 14);
    }// </editor-fold>//GEN-END:initComponents

    private void livroCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_livroCBItemStateChanged
        if (livroCB.getSelectedItem() != null) {
            exemplarCB.removeAllItems();
            ArrayList<Exemplar> exemplares = reservaDAO.selectExemplarLC(emprestimoDAO.selectExemplar(livroCB.getSelectedItem().toString()));
            for (Exemplar exemplar : exemplares) {
                exemplarCB.addItem(exemplar.getNrSequencia() + "-" + exemplar.getCodigoBarra());
            }
        }
    }//GEN-LAST:event_livroCBItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index = exemplarCB.getSelectedIndex();
        Reserva reserva = new Reserva();
        reserva.setUsuario(usuarioCB.getSelectedItem().toString());
        reserva.setLivro(livroCB.getSelectedItem().toString());
        String[] seq = exemplarCB.getSelectedItem().toString().split("-");
        reserva.setSequenciaExemplar(Integer.parseInt(seq[0]));
        reservaDAO.inserir(reserva);
        atualizar();
        exemplarCB.removeItemAt(index);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tabela.getSelectedRow() > -1) {
            reservaDAO.deletar(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()));
            atualizar();
            livroCBItemStateChanged(null);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> exemplarCB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> livroCB;
    private javax.swing.JTable tabela;
    private javax.swing.JComboBox<String> usuarioCB;
    // End of variables declaration//GEN-END:variables
}
