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
    
    // Transforma o formato armazenado no BD para o formato legível pelo usuário
    public static String formatarFormula(String texto) {
        
        String formatado = texto.replace("->", "\u2192");
        formatado = formatado.replace("^", "\u2227");
        formatado = formatado.replace("|-", "\u22A2");
        formatado = formatado.replace("|", "\u2228");
        
        return formatado;
        
    }
    
    // Transforma o resultado de saída do parser para o formato legível pelo usuário
    public static String formatarParserParaLegivel(String texto) {
        String formatado = texto.replace(">", " \u2192 ");
        formatado = formatado.replace("*", " \u2227 ");
        //formatado = formatado.replace("~", "\TODO");
        formatado = formatado.replace("+", " \u2228 ");
        return formatado;
    }
    
    public static String[] getPremissas(String exercicio) {
        String premissas[];
        // Remove tags HTML <html><font face='Roboto'> e </font></html>
        exercicio = exercicio.substring(26, exercicio.length()-14);
        // Remove a conclusão
        exercicio = exercicio.substring(0, exercicio.indexOf('⊢')-1);
        premissas = exercicio.split(", ");
        return premissas;
    }
    
}
