/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 20, 2020
 * @time 12:17:58 PM
 */
public class LatinCerdo {
    /**
     * Devuelve el String oración en un arreglo de String dividido por los espacios contenidos en la oración
     * @param oracion String
     * @return String[]
     */
    public static String[] dividirOracion(String oracion){
        return oracion.split("\\s");
    }
    /**
     * Devuelve el String palabra convertido en latin cerdo. La primer letra de la oración la coloca al final y luego añade
     * las letras "ae"
     * @param palabra String
     * @return String
     */
    public static String traducirPalabraALatin(String palabra){
        return palabra.substring(1) + palabra.charAt(0) + "ae";
    }
    
    public static void imprimirPalabraEnLatin(String palabra){
        System.out.printf("%s ", palabra);
    }
}
