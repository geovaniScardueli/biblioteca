/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author informatica
 */
public class Emprestimo {

    int nrSequencia;
    String tituloLivro;
    String usuario;
    Date emprestimo;
    int exemplar;
    int codExemplar;

    public int getNrSequencia() {
        return nrSequencia;
    }

    public void setNrSequencia(int nrSequencia) {
        this.nrSequencia = nrSequencia;
    }

    public int getCodExemplar() {
        return codExemplar;
    }

    public void setCodExemplar(int codExemplar) {
        this.codExemplar = codExemplar;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Date emprestimo) {
        this.emprestimo = emprestimo;
    }

    public int getExemplar() {
        return exemplar;
    }

    public void setExemplar(int exemplar) {
        this.exemplar = exemplar;
    }

}
