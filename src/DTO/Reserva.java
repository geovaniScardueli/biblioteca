/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author isold
 */
public class Reserva {

    String usuario;
    String livro;
    int sequencia;
    int sequenciaExemplar;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getLivro() {
        return livro;
    }

    public void setLivro(String livro) {
        this.livro = livro;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public int getSequenciaExemplar() {
        return sequenciaExemplar;
    }

    public void setSequenciaExemplar(int sequenciaExemplar) {
        this.sequenciaExemplar = sequenciaExemplar;
    }

}
