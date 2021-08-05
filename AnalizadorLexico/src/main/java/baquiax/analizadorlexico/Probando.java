/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baquiax.analizadorlexico;

/**
 *
 * @author luis
 */
public class Probando {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(puntoPorEnMedio("5"));
    }
    
    public static boolean puntoPorEnMedio(String cadena) {
        return (!".".equals(cadena.substring(0, 1)))
                && (!".".equals(cadena.substring(cadena.length() - 1, cadena.length())));
    }
    
}
