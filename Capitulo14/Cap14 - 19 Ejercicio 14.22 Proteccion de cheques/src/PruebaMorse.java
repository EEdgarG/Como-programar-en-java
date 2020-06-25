/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 24, 2020
 * @time 7:55:14 PM
 */
public class PruebaMorse {
    public static void main(String[] args){
        String oracion = "Hola mundo";
        
        String[] palabras = oracionAPalabras(oracion);
        String oracionMorse = "";
        for(String palabra: palabras)
            oracionMorse += String.format("%s ", palabraAMorse(palabra));
        
        System.out.printf("%s%n", oracionMorse);
    }
    /**
     * Devuelve una oración dividida como un arreglo de las palabras que la componen
     * @param oracion String
     * @return String[]
     */
    public static String[] oracionAPalabras(String oracion){
        return oracion.toLowerCase().split("\\s");
    }
    /**
     * Devuelve la representación de una palabra en su formato morse
     * @param palabra String
     * @return String
     */
    public static String palabraAMorse(String palabra){
        String palabraMinuscula = palabra.toLowerCase();
        String palabraMorse = "";
        
        for(int i = 0; i < palabraMinuscula.length(); i++)
            palabraMorse += letraAMorse(String.valueOf(palabraMinuscula.charAt(i)));
        
        return palabraMorse;
    }
    /**
     * Devuelve la conversión a codigó morse de cualquier letra del alfabeto incluidos los números del 0-9
     * @param letra String
     * @return String
     */
    public static String letraAMorse(String letra){
        String morse = "";
        switch(letra){
            case "a":
                morse += ".-";
                break;
            case "b":
                morse += "-...";
                break;
            case "c":
                morse += "-.-.";
                break;
            case "d":
                morse += "-..";
                break;
            case "e":
                morse += ".";
                break;
            case "f":
                morse += "..-.";
                break;
            case "g":
                morse += "--.";
                break;
            case "h":
                morse += "....";
                break;
            case "i":
                morse += "..";
                break;
            case "j":
                morse += ".---";
                break;
            case "k":
                morse += "-.-";
                break;
            case "l":
                morse += ".-..";
                break;
            case "m":
                morse += "--";
                break;
            case "n":
                morse += "-.";
                break;
            case "o":
                morse += "---";
                break;
            case "p":
                morse += ".--.";
                break;
            case "q":
                morse += "--.-";
                break;
            case "r":
                morse += ".-.";
                break;
            case "s":
                morse += "...";
                break;
            case "t":
                morse += "-";
                break;
            case "u":
                morse += "..-";
                break;
            case "v":
                morse += "...-";
                break;
            case "w":
                morse += ".--";
                break;
            case "x":
                morse += "-..-";
                break;
            case "y":
                morse += "-.--";
                break;
            case "z":
                morse += "--..";
                break;
            case "1":
                morse += ".----";
                break;
            case "2":
                morse += "..---";
                break;
            case "3":
                morse += "...--";
                break;
            case "4":
                morse += "....-";
                break;
            case "5":
                morse += ".....";
                break;
            case "6":
                morse += "-....";
                break;
            case "7":
                morse += "--...";
                break;
            case "8":
                morse += "---..";
                break;
            case "9":
                morse += "----.";
                break;
            case "0":
                morse += "-----";
                break;
        }
        return morse;
    }
}
