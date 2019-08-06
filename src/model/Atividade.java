/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author igorfonseca
 */
public class Atividade {
    
    private Integer cod;
    private String premissas;
    private String conclusao;

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getPremissas() {
        return premissas;
    }

    public void setPremissas(String premissas) {
        this.premissas = premissas;
    }

    public String getConclusao() {
        return conclusao;
    }

    public void setConclusao(String conclusao) {
        this.conclusao = conclusao;
    }
    
    
    
}
