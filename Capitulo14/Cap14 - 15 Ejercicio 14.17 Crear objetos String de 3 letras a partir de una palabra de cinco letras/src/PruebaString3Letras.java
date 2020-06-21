/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Dada un String de tamaño 5, genera todas las cadenas tamaño 3
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 21, 2020
 * @time 1:34:36 PM
 */
public class PruebaString3Letras {
    public static void main(String[] args){
        String palabraP = "casas";
        
        for(String palabra: palabras3Letras(palabraP))
            System.out.printf("%s%n", palabra);
    }
    public static String palabra3Letras(String palabra, int primerLetra, int segundaLetra, int tercerLetra){
        return String.valueOf(palabra.charAt(primerLetra)) + palabra.charAt(segundaLetra) + palabra.charAt(tercerLetra);
    }
    public static String[] palabras3Letras(String palabra){
        String[] palabras = new String[10];
        
        int i = 0;
        for(int j = 0; j < palabra.length(); j++){
            for(int k = j + 1; k < palabra.length(); k++){
                for(int l = k + 1; l < palabra.length(); l++)
                    palabras[i++] = new String(palabra3Letras(palabra, j, k, l));
            }
        }
        
        return palabras;
    }
}
