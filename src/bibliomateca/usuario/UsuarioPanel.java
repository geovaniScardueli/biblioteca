/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliomateca.usuario;

import DAO.UsuarioDAO;
import DTO.Usuario;

/**
 *
 * @author informatica
 */
public class UsuarioPanel extends javax.swing.JPanel {

    ModeloUsuario modelo;
    UsuarioDAO usuarioDAO;

    public UsuarioPanel() {
        initComponents();
        usuarioDAO = new UsuarioDAO();
        modelo = new ModeloUsuario();
        tabelaUsuario.setModel(modelo);
    }

    public void ativar() {
        modelo.adicionarSelect(usuarioDAO.select());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuario = new javax.swing.JTable();
        DS_NOME = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        IE_SERVIDOR = new javax.swing.JCheckBox();
        diaAtual = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setLayout(null);

        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaUsuario);

        add(jScrollPane1);
        jScrollPane1.setBounds(110, 20, 530, 290);
        add(DS_NOME);
        DS_NOME.setBounds(130, 350, 370, 20);

        jLabel1.setText("Nome:");
        add(jLabel1);
        jLabel1.setBounds(70, 360, 50, 14);

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(300, 410, 110, 30);

        IE_SERVIDOR.setText("Servidor");
        add(IE_SERVIDOR);
        IE_SERVIDOR.setBounds(120, 410, 80, 23);

        diaAtual.setToolTipText("");
        add(diaAtual);
        diaAtual.setBounds(10, 120, 90, 30);

        jButton2.setText("atualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(10, 170, 90, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Usuario usuario = new Usuario();
        usuario.setNome(DS_NOME.getText());
        usuario.setTipo(IE_SERVIDOR.isSelected() ? "S" : "N");
        usuarioDAO.adicionar(usuario);
        jButton2ActionPerformed(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!"".equals(diaAtual.getText())) {
            modelo.adicionarSelect(usuarioDAO.selectAplicandoMulta(diaAtual.getText()));
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DS_NOME;
    private javax.swing.JCheckBox IE_SERVIDOR;
    private javax.swing.JTextField diaAtual;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaUsuario;
    // End of variables declaration//GEN-END:variables
}
