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
public class Perfil {
    
    private Integer cod_estudante;
    private String nome;
    private Integer idade;
    private String genero;
    //private String estado_atual;
    //private String caminho_seguido;
    //private String tabela_conceitos;

    public Integer getCod_estudante() {
        return cod_estudante;
    }

    public void setCod_estudante(Integer cod_estudante) {
        this.cod_estudante = cod_estudante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return nome;
    }
       
}
