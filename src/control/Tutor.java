/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Atividade;
import model.AtividadeDAO;
import model.Avaliacao;
import model.AvaliacaoDAO;
import model.Complexidade;
import model.ComplexidadeDAO;
import model.Perfil;
import model.Solucao;
import model.SolucaoDAO;

/**
 *
 * @author igorfonseca
 */
public class Tutor {
    
    private static final int N_CONCEITOS = 8; //número de conceitos cadastrados no sistema
    private static int numConcluidos[] = new int[N_CONCEITOS]; //número de atividades concluídas do conceito
    private static int medDifConcluidos[] = new int [N_CONCEITOS]; //atividades médias/difíceis concluidas
    
    
    private static AvaliacaoDAO aval_dao = new AvaliacaoDAO();
    private static ComplexidadeDAO complex_dao = new ComplexidadeDAO();
    private static AtividadeDAO ativ_dao = new AtividadeDAO();
    private static SolucaoDAO solucao_dao = new SolucaoDAO();
    
    /*
     * Seleciona um exercício para o estudante dentro do conceito.
    */
    public static Atividade proxAtividade() {
        
        Atividade ativ;
        AtividadeDAO ativ_dao = new AtividadeDAO();
        
        
        // Sistema de seleção da próxima atividade
        // 1. Seleciona o conceito selecConceito()
        int proxConceito = selecConceito();
        System.out.println("Conceito selecionado: " + proxConceito);
        
        // 2. Seleciona atividade dentro do conceito
        //ativ = selecAtividade(proxConceito);
        
        // TEST: random
        /*Random rand = new Random();
        int codAtividade = rand.nextInt((7 - 1) + 1) + 1;
        ativ = ativ_dao.consultar(codAtividade);*/
        ativ = ativ_dao.consultar(22);
        
        return ativ;
        
    }
    
    public static void initConcluidos() {
        
        // Inicializar arrays
        for (int i = 0; i < N_CONCEITOS; i++) {
            numConcluidos[i] = 0;
            medDifConcluidos[i] = 0;
        }
        
        try {
            List<Avaliacao> notas = aval_dao.listar();
            for (int i = 0; i < notas.size(); i++) {
                int esteCodigoAtividade = notas.get(i).getAtividade().getCod();
                // Consulta as complexidades da atividade
                List<Complexidade> complex_ativ = complex_dao.listarPorAtividade(esteCodigoAtividade);
                List<Solucao> solucao_ativ = solucao_dao.listarPorAtividade(esteCodigoAtividade);
                
                // Para cada complexidade da atividade, adiciona aos arrays
                for(int j = 0; j < complex_ativ.size(); j++) {
                    Complexidade estaComplex = complex_ativ.get(j);
                    int codConceito = estaComplex.getCod_conceito()-1;
                    numConcluidos[codConceito]++;
                    // Dependendo da dificuldade, adiciona a medDifConcluidos[]
                    int dificuldadeAtiv = solucao_ativ.get(0).getDificuldade();
                    /* Dificuldades: até 6 fácil; 7 a 10 médio; 11 ou mais difícil */
                    if(dificuldadeAtiv > 6)
                        medDifConcluidos[codConceito]++;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Tutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Imprimir valores
        for (int i = 0; i < N_CONCEITOS; i++) {
            System.out.println("Conceito "+(i+1)+": "+numConcluidos[i]+" concluídos, "+medDifConcluidos[i]+" méd/dif.");
        }
        
    }
    
    /* Avalia a nota do estudante nos conceitos para selecionar qual
     * deve ser trabalhado a seguir. Para isso, considera a nota no 
     * exercício, os conceitos e o grau de dificuldade.
    */
    public static int selecConceito() {
        
        try {
            List<Avaliacao> notas = aval_dao.listar();
            
            /*
                1 - Obter nota de cada atividade
                2 - Somar a nota da atividade em cada conceito
                3 - Fazer a média pra cada conceito
                4 - Selecionar conceito
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
            
            //2 - Somar a nota da atividade em cada conceito
            
            // Arrays com o numero de conceitos
            double medias[] = new double[N_CONCEITOS]; //notas do estudante no conceito
            int divisor[] = new int[N_CONCEITOS]; //contador de avaliações
            for (int i = 0; i < N_CONCEITOS; i++) {
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
            
            // 3 - Fazer a média pra cada conceito
            for (int i = 0; i < N_CONCEITOS; i++) {
                if(divisor[i]>0)
                    medias[i] = medias[i]/divisor[i];
                else
                    medias[i] = 0;
                //System.out.println("Média do conceito " +(i+1)+": "+medias[i]);
            }
            
            // 4 - Selecionar conceito
            // Seleção estática simples: considerar notas nos conceitos por ordem de dificuldade
            // Ordem: {1, 2, 8, 3}, 6, 4, {5, 7}
            if(medias[1-1] < 6 || medias[2-1] < 6 || medias[8-1] < 6 || medias[3-1] < 6) {
                if(medias[1-1] <= medias[2-1] && medias[1-1] <= medias[8-1] && medias[1-1] <= medias[3-1])
                    return 1;
                else if(medias[2-1] <= medias[8-1] && medias[2-1] <= medias[3-1])
                    return 2;
                else if(medias[8-1] <= medias[3-1])
                    return 8;
                else
                    return 3;
            }
            else if(medias[6-1] < 6) {
                return 6;
            }
            else if(medias[4-1] < 6) {
                return 4;
            }
            else if(medias[5-1] < 6 || medias[7-1] < 6) {
                if(medias[5-1] <= medias[7-1])
                    return 5;
                else
                    return 7;
            }
            else {
                // Escolhe a menor média entre todas
                return getMinIndex(medias)+1;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Tutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Em caso de erro
        return -1;
    }
    
    private static int getMinIndex(double[] numbers){
        double minValue = numbers[0];
        int minIndex = 0;
        for(int i=1;i<numbers.length;i++){
          if(numbers[i] < minValue){
                minValue = numbers[i];
                minIndex = i;
              }
        }
        return minIndex;
    }
    
    public static Atividade selecAtividade(int codConceito) {
        
        try {
            // Lista as atividades do conceito selecionado
            List<Atividade> ativDoConceito = ativ_dao.listarPorConceito(codConceito);
            
            List<Atividade> ativFeitas = new ArrayList<>();
            List<Atividade> ativNaoFeitas = new ArrayList<>();
            
            // Lista quais atividades não possuem nota
            for(int i = 0; i < ativDoConceito.size(); i++) {
                int esteCodAtiv = ativDoConceito.get(i).getCod();
                List<Avaliacao> avalAtividade = aval_dao.listarPorAtividade(esteCodAtiv);
                if(avalAtividade.isEmpty())
                    ativNaoFeitas.add(ativDoConceito.get(i));
                else
                    ativFeitas.add(ativDoConceito.get(i));
            }
            
            // Se houver atividades não feitas, seleciona
            if(!ativNaoFeitas.isEmpty()) {
                // Seleciona estaticamente a primeira
                return ativNaoFeitas.get(0);
            }
            else {
                // Se todas foram feitas, seleciona a de menor nota
                List<Avaliacao> notasDoConceito = aval_dao.listarPorConceito(codConceito);
                List<Integer> codigos_ativ = new ArrayList<>();
                List<Double> notas_ativ = new ArrayList<>();
                int ultimoCodigo;
                int maiorNota;
                for(int i = 0; i < notasDoConceito.size(); i++) {
                    double estaNota = notasDoConceito.get(i).getNota();
                    int estaAtividade = notasDoConceito.get(i).getAtividade().getCod();
                    // Se for o primeiro, só adiciona
                    if(i==0) {
                        notas_ativ.add(estaNota);
                        codigos_ativ.add(estaAtividade);
                    }
                    else {
                        // Se não for o primeiro, compara com o anterior

                        int atividadeAnterior = notasDoConceito.get(i-1).getAtividade().getCod();
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
                
                // Seleciona a atividade de menor nota
                int menorCodigo = 0;
                double menorNota = 11;
                for(int i = 0; i < codigos_ativ.size(); i++) {
                    if(notas_ativ.get(i) < menorNota) {
                        menorNota = notas_ativ.get(i);
                        menorCodigo = codigos_ativ.get(i);
                    }
                }
                Atividade menor_nota = ativ_dao.consultar(menorCodigo);
                return menor_nota;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Tutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Caso de erro
        return null;
        
    }
    
    /*
     * Calcula e armazena a nota do estudante no último exercício
    */
    public static void notaExercicio(Atividade ativ, int contAjudas) {
       
        Avaliacao aval = new Avaliacao();
        aval.setAtividade(ativ);
        aval.setConcluido(true);
        
        Perfil perfil = new Perfil();
        perfil.setCod_estudante(1);
        aval.setPerfil(perfil);
        
        // Calcula a nota
        double nota = 10;
        if(contAjudas > 3)
            nota -= ((contAjudas-3)*0.5);
        
        aval.setNota(nota);
        
        try {
            aval_dao.adicionar(aval);
            List<Complexidade> complex_ativ = complex_dao.listarPorAtividade(ativ.getCod());
            List<Solucao> solucao_ativ = solucao_dao.listarPorAtividade(ativ.getCod());

            // Para cada complexidade da atividade, adiciona aos arrays
            for(int j = 0; j < complex_ativ.size(); j++) {
                Complexidade estaComplex = complex_ativ.get(j);
                int codConceito = estaComplex.getCod_conceito()-1;
                numConcluidos[codConceito]++;
                // Dependendo da dificuldade, adiciona a medDifConcluidos[]
                int dificuldadeAtiv = solucao_ativ.get(0).getDificuldade();
                /* Dificuldades: até 6 fácil; 7 a 10 médio; 11 ou mais difícil */
                if(dificuldadeAtiv > 6)
                    medDifConcluidos[codConceito]++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
