/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Igor
 */
public class Complexidade {
    
    private int cod_complexidade;
    private int cod_conceito;
    private Atividade atividade;
    private int valor;

    public int getCod_complexidade() {
        return cod_complexidade;
    }

    public void setCod_complexidade(int cod_complexidade) {
        this.cod_complexidade = cod_complexidade;
    }

    public int getCod_conceito() {
        return cod_conceito;
    }

    public void setCod_conceito(int cod_conceito) {
        this.cod_conceito = cod_conceito;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
