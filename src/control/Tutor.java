/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Atividade;
import model.AtividadeDAO;
import model.Avaliacao;
import model.AvaliacaoDAO;
import model.Complexidade;
import model.ComplexidadeDAO;

/**
 *
 * @author igorfonseca
 */
public class Tutor {
    
    private static AvaliacaoDAO aval_dao = new AvaliacaoDAO();
    private static ComplexidadeDAO complex_dao = new ComplexidadeDAO();
    
    /*
     * Seleciona um exercício para o estudante dentro do conceito.
    */
    public static Atividade selecAtividade() {
        
        Atividade ativ;
        AtividadeDAO ativ_dao = new AtividadeDAO();
        
        Random rand = new Random();
        int codAtividade = rand.nextInt((7 - 1) + 1) + 1;
        ativ = ativ_dao.consultar(codAtividade);
        //ativ = ativ_dao.consultar(7);
        
        // TODO: sistema de seleção da próxima atividade
        // 1. Seleciona o conceito selecConceito()
        // 2. Seleciona atividade dentro do conceito
        
        return ativ;
        
    }
    
    /* Avalia a nota do estudante nos conceitos para selecionar qual
     * deve ser trabalhado a seguir. Para isso, considera a nota no 
     * exercício, os conceitos e o grau de dificuldade.
    */
    public static void selecConceito() {
        
        try {
            // Fazer média do estudante por conceito
            List<Avaliacao> notas = aval_dao.listar();
            
            /*
                1 - Obter nota de cada atividade
                2 - Somar a nota da atividade em cada conceito
                3 - Fazer a média pra cada conceito
            */
            
            // 1 - Obter nota de cada atividade
            List<Double> notas_ativ = new ArrayList<>();
            List<Integer> codigos_ativ = new ArrayList<>();
            //int contNotas = 1;
            for (int i = 0; i < notas.size(); i++) {
                
                double estaNota = notas.get(i).getNota();
                int estaAtividade = notas.get(i).getAtividade().getCod();
                
                // Se for o primeiro, só adiciona
                if(i==0) {
                    notas_ativ.add(estaNota);
                    codigos_ativ.add(estaAtividade);
                }
                else {
                    // Se não for o primeiro, compara com o anterior
                    
                    int atividadeAnterior = notas.get(i-1).getAtividade().getCod();
                    int ultimoIndice = notas_ativ.size()-1;
                    double ultimoValor = notas_ativ.get(ultimoIndice);

                    if(estaAtividade != atividadeAnterior) {
                        //Se é uma nova atividade, adiciona
                        notas_ativ.add(estaNota);
                        codigos_ativ.add(estaAtividade);
                        
                        //Divide nota anterior pelo número de notas
                        //notas_ativ.set(ultimoIndice,ultimoValor/contNotas);
                        //contNotas = 1;
                    }
                    else {
                        //Se é a mesma atividade, pega a maior
                        if(estaNota > ultimoValor)
                            notas_ativ.set(ultimoIndice,estaNota);
                        //contNotas++;
                    }
                }
            }
            
            /*for (int i = 0; i < notas_ativ.size(); i++) {
                System.out.println("Atividade " + codigos_ativ.get(i) + ": nota " + notas_ativ.get(i));
            }*/
            
            //2 - Somar a nota da atividade em cada conceito
            
            // Arrays com o numero de conceitos
            double medias[] = new double[8]; //notas do estudante no conceito
            int divisor[] = new int[8]; //contador de avaliações
            for (int i = 0; i < 8; i++) {
                // Inicializar arrays
                medias[i] = 0;
                divisor[i] = 0;
            }
            
            for(int i = 0; i < codigos_ativ.size(); i++) {
                // Para a atividade i, percorre os conceitos e adiciona aos arrays
                double estaNotaAtividade = notas_ativ.get(i);
                int esteCodigoAtividade = codigos_ativ.get(i);
                
                // Consulta as complexidades da atividade
                List<Complexidade> complex_ativ = complex_dao.listarPorAtividade(esteCodigoAtividade);
                
                // Para cada complexidade da atividade, adiciona aos arrays
                for(int j = 0; j < complex_ativ.size(); j++) {
                    Complexidade estaComplex = complex_ativ.get(j);
                    int codConceito = estaComplex.getCod_conceito()-1;
                    int pesoComplexidade = estaComplex.getValor();
                    medias[codConceito] += estaNotaAtividade*pesoComplexidade;
                    divisor[codConceito] += pesoComplexidade;
                }
                
            }
            
            // Fazer médias
            for (int i = 0; i < 8; i++) {
                medias[i] = medias[i]/divisor[i];
                System.out.println("Média do conceito " +i+": "+medias[i]);
            }
            
            // Considerar ordem de dificuldade dos conceitos
            // Selecionar conceito
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Tutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
     * Calcula e armazena a nota do estudante no último exercício
    */
    public static void notaExercicio(int idExercicio, int dif) {
        
    }
    
    
    
}
