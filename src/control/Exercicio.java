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
    
}
