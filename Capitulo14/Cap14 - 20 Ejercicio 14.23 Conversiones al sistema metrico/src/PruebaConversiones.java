/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 25, 2020
 * @time 7:21:34 PM
 */
public class PruebaConversiones {
    public static void main(String[] args){
        String pregunta = "¿Cuantas pulgadas hay en 2 metros?";
        
        //medida de comparación es centimetros
        double inicio = 0.0;
        double destino = 0.0;
        int factor = 0;
        for(String palabra: dividirPalabras(pregunta)){
            switch(palabra){
                case "pulgadas":
                    if(inicio == 0.0)
                        inicio = 2.54;
                    else
                        destino = 2.54;
                    break;
                case "metros?":
                    System.out.printf("%s%n", palabra);
                    if(inicio == 0.0)
                        inicio = 100;
                    else
                        destino = 100;
                    break;
            }
            
            if(palabra.length() == 1)
                factor = Integer.parseInt(palabra);
            
            System.out.printf("%s%n", palabra);
        }
        
        System.out.printf("En %d metros hay %f pulgadas", factor, (destino * (double)factor) / inicio);
    }
    public static String[] dividirPalabras(String pregunta){
        return pregunta.split("\\s");
    }
}
