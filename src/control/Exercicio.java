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
        System.out.println("formatado1 = " + formatado);
        
        formatado = formatado.replace("^", "\u2227");
        System.out.println("formatado2 = " + formatado);
        
        formatado = formatado.replace("|-", "\u22A2");
        System.out.println("formatado3 = " + formatado);
        
        formatado = formatado.replace("|", "\u2228");
        System.out.println("formatado4 = " + formatado);
        
        return formatado;
        
    }
    
}
