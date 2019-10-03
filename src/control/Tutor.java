/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Atividade;
import model.AtividadeDAO;

/**
 *
 * @author igorfonseca
 */
public class Tutor {
    
    public static Atividade selecAtividade(/*int id*/) {
        
        Atividade ativ = new Atividade();
        AtividadeDAO ativ_dao = new AtividadeDAO();
        
        ativ = ativ_dao.consultar(4);

        // TODO: sistema de seleção da próxima atividade
        
        return ativ;
        
    }
    
}
