/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Random;
import model.Atividade;
import model.AtividadeDAO;

/**
 *
 * @author igorfonseca
 */
public class Tutor {
    
    /*
     * Seleciona um exercício para o estudante dentro do conceito.
    */
    public static Atividade selecAtividade() {
        
        Atividade ativ = new Atividade();
        AtividadeDAO ativ_dao = new AtividadeDAO();
        
        Random rand = new Random();
        int codAtividade = rand.nextInt((7 - 1) + 1) + 1;
        //ativ = ativ_dao.consultar(codAtividade);
        ativ = ativ_dao.consultar(7);
        
        // TODO: sistema de seleção da próxima atividade
        // 1. Seleciona o conceito selecConceito()
        // 2. Seleciona atividade dentro do conceito
        
        return ativ;
        
    }
    
    /* Avalia a nota do estudante nos conceitos para selecionar qual
     * deve ser trabalhado a seguir. Para isso, considera a nota no 
     * exercício, os conceitos e o grau de dificuldade.
    */
    private void selecConceito() {
        
        
        
    }
    
    /*
     * Calcula e armazena a nota do estudante no último exercício
    */
    public static void notaExercicio(int idExercicio, int dif) {
        
    }
    
    
    
}
