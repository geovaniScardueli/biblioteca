/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliomateca;

import bibliomateca.Emprestimo.EmprestimoPainel;
import bibliomateca.exemplar.ExemplarPainel;
import bibliomateca.livro.LivroPainel;
import bibliomateca.reserva.ReservaPainel;
import bibliomateca.usuario.UsuarioPanel;

/**
 *
 * @author informatica
 */
public class Principal extends javax.swing.JFrame {

    LivroPainel livroPainel;
    ExemplarPainel exemplarPainel;
    UsuarioPanel usuarioPainel;
    EmprestimoPainel emprestimoPainel;
    ReservaPainel reservaPainel;

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void ativar() {
        LivroPainel livro = new LivroPainel();
        ExemplarPainel exemplar = new ExemplarPainel();
        EmprestimoPainel emprestimo = new EmprestimoPainel();
        UsuarioPanel usuario = new UsuarioPanel();
        ReservaPainel reserva = new ReservaPainel();
        
        setLivroPainel(livro);
        setExemplarPainel(exemplar);
        setUsuarioPainel(usuario);
        setEmprestimoPainel(emprestimo);
        setReservaPainel(reserva);
        
        container.add("Livro", livro);
        container.add("Exemplar", exemplar);
        container.add("Usuario", usuario);
        container.add("Emprestimo", emprestimo);
        container.add("Reserva", reserva);
        
        setVisible(true);
    }

    public LivroPainel getLivroPainel() {
        return livroPainel;
    }

    public void setLivroPainel(LivroPainel livroPainel) {
        this.livroPainel = livroPainel;
    }

    public ExemplarPainel getExemplarPainel() {
        return exemplarPainel;
    }

    public void setExemplarPainel(ExemplarPainel exemplarPainel) {
        this.exemplarPainel = exemplarPainel;
    }

    public UsuarioPanel getUsuarioPainel() {
        return usuarioPainel;
    }

    public void setUsuarioPainel(UsuarioPanel usuarioPainel) {
        this.usuarioPainel = usuarioPainel;
    }

    public EmprestimoPainel getEmprestimoPainel() {
        return emprestimoPainel;
    }

    public void setEmprestimoPainel(EmprestimoPainel emprestimoPainel) {
        this.emprestimoPainel = emprestimoPainel;
    }

    public ReservaPainel getReservaPainel() {
        return reservaPainel;
    }

    public void setReservaPainel(ReservaPainel reservaPainel) {
        this.reservaPainel = reservaPainel;
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
        if (container.getSelectedComponent() == getLivroPainel()) {
            getLivroPainel().ativar();
        } else if (container.getSelectedComponent() == getExemplarPainel()) {
            getExemplarPainel().ativar();
        } else if (container.getSelectedComponent() == getUsuarioPainel()) {
            getUsuarioPainel().ativar();
        } else if (container.getSelectedComponent() == getEmprestimoPainel()) {
            getEmprestimoPainel().ativar();
        } else if (container.getSelectedComponent() == getReservaPainel()) {
            getReservaPainel().ativar();
        }
    }//GEN-LAST:event_containerStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane container;
    // End of variables declaration//GEN-END:variables
}
