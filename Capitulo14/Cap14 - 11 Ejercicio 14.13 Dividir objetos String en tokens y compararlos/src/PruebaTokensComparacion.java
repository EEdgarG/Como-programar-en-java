/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Muetra solo las palabras que empiezan con b
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 20, 2020
 * @time 6:54:41 PM
 */
public class PruebaTokensComparacion {
    public static void main(String[] args){
        String oracion = "Anita la banana en su bautismo barato";
        
        for(String palabra: dividirPalabras(oracion)){
            if(palabra.startsWith("b"))
                System.out.printf("%s%n", palabra);
        }
    }
    /**
     * Devueve un arreglo de String
     * @param oracion
     * @return 
     */
    public static String[] dividirPalabras(String oracion){
        return oracion.split("\\s");
    }
}
