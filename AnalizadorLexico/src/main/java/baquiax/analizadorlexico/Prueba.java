/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baquiax.analizadorlexico;

import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> entero = new ArrayList<>();
        ArrayList<Double> decimales = new ArrayList<>();
        ArrayList<String> cadenas = new ArrayList<>();
        ArrayList<String> simbolos = new ArrayList<>();
        String cadena = "aaadadfd df 87987990()()(){}|| a\\d";
        for (int i = 0; i < cadena.length(); i++) {
            System.out.println(cadena.charAt(i));
        }
        System.out.println("holas");
        System.out.println("otro hola");
    }

    public static boolean esNumero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean esEspacio(String cadena){
        return (cadena.equals(" "));
    }
    
}
