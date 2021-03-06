/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliomateca.Emprestimo;

import DAO.EmprestimoDAO;
import DAO.ExemplarDAO;
import DAO.LivroDAO;
import DAO.UsuarioDAO;
import DTO.Emprestimo;
import DTO.Exemplar;
import DTO.Livro;
import DTO.Reserva;
import DTO.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmprestimoPainel extends javax.swing.JPanel {

    private final EmprestimoDAO emprestimoDAO;
    private final ModeloEmprestimo modeloEmprestimo;
    private final UsuarioDAO usuarioDao;
    private final LivroDAO livroDAO;
    private final ExemplarDAO exemplarDAO;

    public EmprestimoPainel() {
        initComponents();
        emprestimoDAO = new EmprestimoDAO();
        livroDAO = new LivroDAO();
        usuarioDao = new UsuarioDAO();
        exemplarDAO = new ExemplarDAO();
        modeloEmprestimo = new ModeloEmprestimo();
        tabela.setModel(modeloEmprestimo);
    }

    public void ativar() {
        modeloEmprestimo.adicionarSelect(emprestimoDAO.select());
        ArrayList<Livro> livros = livroDAO.select();
        ArrayList<Usuario> usuarios = usuarioDao.select();
        livroLB.removeAllItems();
        usuarioLB.removeAllItems();
        for (Livro livro : livros) {
            livroLB.addItem(livro.getTitulo());
        }
        for (Usuario usuario : usuarios) {
            usuarioLB.addItem(usuario.getNome());
        }
    }

    public void reativar() {
        modeloEmprestimo.adicionarSelect(emprestimoDAO.select());
    }

    public boolean podeReservar() {
        String[] exemplar = exemplarLB.getSelectedItem().toString().split("-");
        Reserva temReserva = emprestimoDAO.verificaEmprestimo(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()), usuarioLB.getSelectedItem().toString());
        if (temReserva != null) {
            JOptionPane.showMessageDialog(null, "Este Exemplar já está reservado pelo o usuario: " + temReserva.getUsuario());
            return false;
        } else {
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usuarioLB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        livroLB = new javax.swing.JComboBox<>();
        exemplarLB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        dataEmprestimo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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
        jScrollPane1.setBounds(40, 12, 575, 316);

        jLabel1.setText("usuário:");
        add(jLabel1);
        jLabel1.setBounds(30, 350, 60, 20);

        jLabel2.setText("Data:");
        add(jLabel2);
        jLabel2.setBounds(30, 440, 45, 20);

        add(usuarioLB);
        usuarioLB.setBounds(90, 350, 280, 20);

        jLabel3.setText("Livro:");
        add(jLabel3);
        jLabel3.setBounds(40, 380, 45, 20);

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(430, 350, 120, 30);

        livroLB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                livroLBItemStateChanged(evt);
            }
        });
        add(livroLB);
        livroLB.setBounds(90, 380, 280, 20);

        add(exemplarLB);
        exemplarLB.setBounds(90, 410, 280, 20);

        jLabel4.setText("Exemplar");
        add(jLabel4);
        jLabel4.setBounds(24, 410, 50, 20);

        dataEmprestimo.setToolTipText("");
        add(dataEmprestimo);
        dataEmprestimo.setBounds(90, 440, 110, 20);

        jButton2.setText("devolver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(430, 390, 120, 30);

        jButton3.setText("Renovar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3);
        jButton3.setBounds(430, 430, 120, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void livroLBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_livroLBItemStateChanged
        if (livroLB.getSelectedItem() != null) {
            exemplarLB.removeAllItems();
            ArrayList<Exemplar> exemplares = exemplarDAO.select(emprestimoDAO.selectExemplar(livroLB.getSelectedItem().toString()));
            for (Exemplar exemplar : exemplares) {
                exemplarLB.addItem(exemplar.getNrSequencia() + "-" + exemplar.getCodigoBarra());
            }
        }
    }//GEN-LAST:event_livroLBItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (emprestimoDAO.VerificaMulta(usuarioLB.getSelectedItem().toString())) {
                int index = exemplarLB.getSelectedIndex();
                String[] exemplar = exemplarLB.getSelectedItem().toString().split("-");
                Reserva temReserva = emprestimoDAO.verificaEmprestimo(Integer.parseInt(exemplar[0]), usuarioLB.getSelectedItem().toString());
                if (podeReservar()) {
                    Emprestimo emprestimo = new Emprestimo();
                    emprestimo.setUsuario(usuarioLB.getSelectedItem().toString());
                    emprestimo.setTituloLivro(livroLB.getSelectedItem().toString());
                    emprestimo.setExemplar(Integer.parseInt(exemplar[0]));
                    emprestimo.setEmprestimo(dataEmprestimo.getText());
                    emprestimoDAO.inserirEmprestimo(emprestimo);
                    reativar();
                    exemplarLB.removeItemAt(index);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não é possível realizar o emprestimo, usuário possui multa acima do permitido");
            }

        } catch (Exception ex) {
            System.out.println("erro botao adicionar emprestimo" + ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tabela.getSelectedRow() > -1) {
            emprestimoDAO.deletarEmprestimo(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()));
            reativar();
            livroLBItemStateChanged(null);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (tabela.getSelectedRow() > -1) {
            if (podeReservar()) {
                emprestimoDAO.renovar(dataEmprestimo.getText(), Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(), 0).toString()));
            }
            reativar();
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dataEmprestimo;
    private javax.swing.JComboBox<String> exemplarLB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> livroLB;
    private javax.swing.JTable tabela;
    private javax.swing.JComboBox<String> usuarioLB;
    // End of variables declaration//GEN-END:variables
}
