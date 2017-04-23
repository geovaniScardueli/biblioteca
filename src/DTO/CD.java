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
public class CD extends Informacoes{

    private int tempoDuracao;
    private int codInformacoes;

    public int getCodInformacoes() {
        return codInformacoes;
    }

    public void setCodInformacoes(int codInformacoes) {
        this.codInformacoes = codInformacoes;
    }

    public int getTempoDuracao() {
        return tempoDuracao;
    }

    public void setTempoDuracao(int tempoDuracao) {
        this.tempoDuracao = tempoDuracao;
    }

}
