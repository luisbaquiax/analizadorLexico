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
        ArrayList<String> enteros = new ArrayList<>();
        ArrayList<String> decimales = new ArrayList<>();
        ArrayList<String> identificadores = new ArrayList<>();
        ArrayList<String> simbolos = new ArrayList<>();
        String cadena = "aaadadfd 55 5.5 df 87987990()()(){}|| a\\d";
        ArrayList<String> partes = new ArrayList<>();
        String abecedario = "abcdefghijklmnopqrstuvwxyzñ";
        String digitos = "1234567890";
        String parte = "";
        int ultimaParte = 0;
        for (int i = 0; i < cadena.length(); i++) {
            System.out.println("carater --> " + cadena.charAt(i));
            if (!esEspacio(String.valueOf(cadena.charAt(i)))) {
                parte += cadena.charAt(i);
            } else {
                ultimaParte++;
                partes.add(parte);
                parte = "";
                continue;
            }
        }
        String ultimaCadena = cadena.substring(ultimaParte, cadena.length());
        partes.add(ultimaCadena);
        for (String parteCadena : partes) {
            System.out.println("cadena -> " + parteCadena);
            if (esEntero(parteCadena, digitos)) {
                enteros.add(parteCadena);
            }
            if (esDecimal(parteCadena)) {
                decimales.add(parteCadena);
            }
            if (esIdentificador(parteCadena, abecedario, digitos) || purasLetras(parteCadena, abecedario)) {
                identificadores.add(parteCadena);
            }

        }
        System.out.println("");
        System.out.println("lista enteros");
        for (String parte1 : enteros) {
            System.out.println(parte1);
        }
        System.out.println("lista decimales");
        for (String parte1 : decimales) {
            System.out.println(parte1);
        }
        System.out.println("LIsta identificadores");
        for (String identificadore : identificadores) {
            System.out.println(identificadore);
        }
        System.out.println("Lista de simbolos");
        for (String simbolo : simbolos) {
            System.out.println(simbolo);
        }
    }

    public static boolean esEntero(String cadena, String digitos) {
        int cantidadDigitos = 0;
        for (int i = 0; i < cadena.length(); i++) {
            for (int j = 0; j < digitos.length(); j++) {
                if (cadena.charAt(i) == digitos.charAt(j)) {
                    cantidadDigitos++;
                }
            }
        }
        return (cantidadDigitos == cadena.length());
    }

    public static boolean esDecimal(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean puntoPorEnMedio(String cadena) {
        return (!".".equals(cadena.substring(0, 1)))
                && (!".".equals(cadena.substring(cadena.length() - 1, cadena.length())));
    }

    public static boolean esIdentificador(String cadena, String abecedario, String digitos) {
        int contadorId = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (esEntero(String.valueOf(cadena.charAt(i)), digitos)
                    || esLetra(String.valueOf(cadena.charAt(i)), abecedario)) {
                contadorId++;
            }
        }
        return ((contadorId == cadena.length() - 1)
                && (esLetra(String.valueOf(cadena.substring(0, 1)), abecedario)));
    }

    public static boolean esLetra(String caracter, String abecedario) {
        for (int i = 0; i < abecedario.length(); i++) {
            if (caracter.equalsIgnoreCase(abecedario.charAt(i) + "")) {
                return true;
            }
        }
        return false;
    }

    public static boolean purasLetras(String cadena, String abecedario) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            for (int j = 0; j < abecedario.length(); j++) {
                if (String.valueOf(cadena.charAt(i)).
                        equalsIgnoreCase(String.valueOf(abecedario.charAt(j)))) {
                    contador++;
                }
            }
        }
        return (contador == cadena.length());
    }

    public static boolean esNumero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean esEspacio(String cadena) {
        return (cadena.equals(" "));
    }

}
