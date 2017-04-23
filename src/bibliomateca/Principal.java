/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliomateca;

import bibliomateca.Emprestimo.Emprestimo;
import bibliomateca.exemplar.Exemplar;
import bibliomateca.livro.LivroPainel;
import bibliomateca.usuario.Usuario;

/**
 *
 * @author informatica
 */
public class Principal extends javax.swing.JFrame {

    LivroPainel livroPainel;
    
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void ativar() {
        LivroPainel livro = new LivroPainel();
        Exemplar exemplar = new Exemplar();
        Emprestimo emprestimo = new Emprestimo();
        Usuario usuario = new Usuario();
        
        setLivroPainel(livro);
        
        container.add("Exemplar", exemplar);
        container.add("Livro", livro);
        container.add("Emprestimo", emprestimo);
        container.add("Usuario", usuario);
        
        setVisible(true);
    }

    public LivroPainel getLivroPainel() {
        return livroPainel;
    }

    public void setLivroPainel(LivroPainel livroPainel) {
        this.livroPainel = livroPainel;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        container.setPreferredSize(new java.awt.Dimension(750, 560));
        container.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                containerStateChanged(evt);
            }
        });
        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void containerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_containerStateChanged
        if (container.getSelectedComponent() == getLivroPainel()){
            getLivroPainel().ativar();
        }
    }//GEN-LAST:event_containerStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane container;
    // End of variables declaration//GEN-END:variables
}
