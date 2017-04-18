/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliomateca;

import bibliomateca.exemplar.Exemplar;
import bibliomateca.livro.Livro;

/**
 *
 * @author informatica
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }


    public void ativar() {
        Livro livro = new Livro();
        Exemplar exemplar = new Exemplar();
        
        container.add("Exemplar", exemplar);
        container.add("Livro", livro);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        container.setPreferredSize(new java.awt.Dimension(750, 560));
        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane container;
    // End of variables declaration//GEN-END:variables
}
