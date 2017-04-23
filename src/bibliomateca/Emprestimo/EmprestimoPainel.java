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
import DTO.Usuario;
import java.util.ArrayList;

public class EmprestimoPainel extends javax.swing.JPanel {

    private EmprestimoDAO emprestimoDAO;
    private ModeloEmprestimo modeloEmprestimo;
    private UsuarioDAO usuarioDao;
    private LivroDAO livroDAO;
    private ExemplarDAO exemplarDAO;

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
        for (Livro livro : livros) {
            livroLB.addItem(livro.getTitulo());
        }
        for (Usuario usuario : usuarios) {
            usuarioLB.addItem(usuario.getNome());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        dataEmprestimo = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        usuarioLB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        livroLB = new javax.swing.JComboBox<>();
        exemplarLB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

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
        jLabel1.setBounds(30, 350, 60, 14);

        dataEmprestimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        dataEmprestimo.setToolTipText("");
        add(dataEmprestimo);
        dataEmprestimo.setBounds(90, 440, 140, 20);

        jLabel2.setText("Data:");
        add(jLabel2);
        jLabel2.setBounds(30, 440, 45, 14);

        add(usuarioLB);
        usuarioLB.setBounds(90, 350, 280, 20);

        jLabel3.setText("Livro:");
        add(jLabel3);
        jLabel3.setBounds(40, 380, 45, 14);

        jButton1.setText("Adicionar");
        add(jButton1);
        jButton1.setBounds(430, 370, 90, 30);

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
        jLabel4.setBounds(24, 410, 50, 14);
    }// </editor-fold>//GEN-END:initComponents

    private void livroLBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_livroLBItemStateChanged
        ArrayList<Exemplar> exemplares = exemplarDAO.select(emprestimoDAO.selectExemplar(livroLB.getSelectedItem().toString()));
        for (Exemplar exemplar : exemplares) {
            exemplarLB.addItem(exemplar.getNrSequencia() + "-" + exemplar.getCodigoBarra());
        }
    }//GEN-LAST:event_livroLBItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField dataEmprestimo;
    private javax.swing.JComboBox<String> exemplarLB;
    private javax.swing.JButton jButton1;
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
