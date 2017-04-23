/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author informatica
 */
public class Livro extends Informacoes {

    private int paginas;
    private String ISBN;
    private int codInformacoes;

    public int getCodInformacoes() {
        return codInformacoes;
    }

    public void setCodInformacoes(int codInformacoes) {
        this.codInformacoes = codInformacoes;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

}
