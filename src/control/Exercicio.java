/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author igorfonseca
 */
public class Exercicio {
    
    public static String formatarFormula(String texto) {
        
        String formatado = texto.replace("->", "\u2192");
        formatado = formatado.replace("^", "\u2227");
        formatado = formatado.replace("|-", "\u22A2");
        formatado = formatado.replace("|", "\u2228");
        
        return formatado;
        
    }
    
    public static String[] getPremissas(String exercicio) {
        
        String premissas[];
//        System.out.println(exercicio);
        
        // Remove tags HTML <html><font face='Roboto'> e </font></html>
        exercicio = exercicio.substring(26, exercicio.length()-14);
//        System.out.println(exercicio);
        
        // Remove a conclusão
        exercicio = exercicio.substring(0, exercicio.indexOf('⊢')-1);
//        System.out.println(exercicio);
        
        premissas = exercicio.split(", ");
        
//        for (String s : premissas) 
//            System.out.println(s); 
        
        return premissas;
        
    }
    
}
