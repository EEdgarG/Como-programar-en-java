/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 20, 2020
 * @time 2:25:51 PM
 */
public class PruebaEnunciadoPalabrasInvertidas {
    public static void main(String[] args){
        String enunciado = "anita lava la tina";
        
        for(String palabra: dividirOracion(enunciado)){
            StringBuilder palabraR = new StringBuilder(palabra);
            palabraR.reverse();
            System.out.printf("%s ", palabraR);
        }
    }
    
    public static String[] dividirOracion(String oracion){
        return oracion.split("\\s");
    }
}
