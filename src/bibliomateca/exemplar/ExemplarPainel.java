/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliomateca.exemplar;

import DAO.ExemplarDAO;
import DAO.LivroDAO;
import DTO.Exemplar;
import bibliomateca.livro.ModeloTabela;

public class ExemplarPainel extends javax.swing.JPanel {

    private final LivroDAO livroDAO;
    private final ModeloTabela modelo;
    private final ExemplarDAO exemplarDAO;
    private final ModeloExemplar modeloExemplar;

    public ExemplarPainel() {
        initComponents();
        livroDAO = new LivroDAO();
        exemplarDAO = new ExemplarDAO();
        modelo = new ModeloTabela();
        tabelaLivro.setModel(modelo);
        modeloExemplar = new ModeloExemplar();
        tabelaExemplar.setModel(modeloExemplar);
    }

    public void ativar() {
        modelo.adicionarSelect(livroDAO.select());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLivro = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaExemplar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CD_BARRAS = new javax.swing.JTextField();
        NR_PATRIMONIOS = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(null);

        tabelaLivro.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaLivroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaLivro);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 300, 460);

        tabelaExemplar.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelaExemplar);

        add(jScrollPane2);
        jScrollPane2.setBounds(340, 240, 400, 240);

        jLabel1.setText("código barra:");
        add(jLabel1);
        jLabel1.setBounds(350, 120, 90, 14);

        jLabel2.setText("patrimonio: ");
        add(jLabel2);
        jLabel2.setBounds(360, 160, 80, 14);
        add(CD_BARRAS);
        CD_BARRAS.setBounds(450, 120, 170, 30);
        add(NR_PATRIMONIOS);
        NR_PATRIMONIOS.setBounds(450, 160, 170, 30);

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(430, 50, 90, 23);

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(570, 50, 90, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int linhaSelecionada = tabelaLivro.getSelectedRow();
        if (tabelaLivro.getSelectedRow() > -1) {
            Exemplar exemplar = new Exemplar();
            exemplar.setCodigoBarra(Integer.parseInt(CD_BARRAS.getText()));
            exemplar.setPatrimonio(Integer.parseInt(NR_PATRIMONIOS.getText()));
            exemplarDAO.adicionar(exemplar, (int) tabelaLivro.getValueAt(tabelaLivro.getSelectedRow(), 0));
            ativar();
            CD_BARRAS.setText("");
            NR_PATRIMONIOS.setText("");
            tabelaLivro.setRowSelectionInterval(linhaSelecionada, linhaSelecionada);
            tabelaLivroMouseClicked(null);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaLivroMouseClicked
        modeloExemplar.adicionarSelect(exemplarDAO.select(Integer.parseInt(tabelaLivro.getValueAt(tabelaLivro.getSelectedRow(), 0).toString())));
    }//GEN-LAST:event_tabelaLivroMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tabelaExemplar.getSelectedRow() > -1) {
            exemplarDAO.excluir(Integer.parseInt(tabelaExemplar.getValueAt(tabelaExemplar.getSelectedRow(), 0).toString()));
            ativar();
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CD_BARRAS;
    private javax.swing.JTextField NR_PATRIMONIOS;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaExemplar;
    private javax.swing.JTable tabelaLivro;
    // End of variables declaration//GEN-END:variables
}
