/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Transforma una oración en español (sin ñ) en código morse, además transforma el código morse
 * en oraciones en español (sin ñ)
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 24, 2020
 * @time 7:55:14 PM
 */
public class PruebaMorse {
    public static void main(String[] args){
        String oracion = "Karina De La Rosa";
        
        
        String morse = letrasAMorse(oracion);
        System.out.printf("%s%n", letrasAMorse(oracion));
        
        String literal = oracionMorseAPalabras(morse);
        System.out.printf("%s%n", literal);
    }
    public static String oracionMorseAPalabras(String morse){
        String oracionL = "";
        for(String oracionM: oracionAPalabrasMorse(morse)){//Divide las palabras separadas por dos espacios
            for(String letra: oracionAPalabras(oracionM))//Divide las letras separadas por un espacio
                oracionL += morseALetra(letra);
            oracionL += " ";
        }
        return oracionL;
    }
    /**
     * Devuelve el código morse en su forma literal
     * @param morse String
     * @return String
     */
    public static String morseALetra(String morse){
        String letra = "";
        switch(morse){
            case ".-":
                letra += "a";
                break;
            case "-...":
                letra += "b";
                break;
            case "-.-.":
                letra += "c";
                break;
            case "-..":
                letra += "d";
                break;
            case ".":
                letra += "e";
                break;
            case "..-.":
                letra += "f";
                break;
            case "--.":
                letra += "g";
                break;
            case "....":
                letra += "h";
                break;
            case "..":
                letra += "i";
                break;
            case ".---":
                letra += "j";
                break;
            case "-.-":
                letra += "k";
                break;
            case ".-..":
                letra += "l";
                break;
            case "--":
                letra += "m";
                break;
            case "-.":
                letra += "n";
                break;
            case "---":
                letra += "o";
                break;
            case ".--.":
                letra += "p";
                break;
            case "--.-":
                letra += "q";
                break;
            case ".-.":
                letra += "r";
                break;
            case "...":
                letra += "s";
                break;
            case "-":
                letra += "t";
                break;
            case "..-":
                letra += "u";
                break;
            case "...-":
                letra += "v";
                break;
            case ".--":
                letra += "w";
                break;
            case "-..-":
                letra += "x";
                break;
            case "-.--":
                letra += "y";
                break;
            case "--..":
                letra += "z";
                break;
            case ".----":
                letra += "1";
                break;
            case "..---":
                letra += "2";
                break;
            case "...--":
                letra += "3";
                break;
            case "....-":
                letra += "4";
                break;
            case ".....":
                letra += "5";
                break;
            case "-....":
                letra += "6";
                break;
            case "--...":
                letra += "7";
                break;
            case "---..":
                letra += "8";
                break;
            case "----.":
                letra += "9";
                break;
            case "-----":
                letra += "0";
                break;
        }
        return letra;
    }
    /**
     * Devuelve una oración en morse dividida como un arreglo de las palabras que la componen
     * @param oracion String
     * @return String[]
     */
    public static String[] oracionAPalabrasMorse(String oracion){
        return oracion.toLowerCase().split("\\s\\s");
    }
    /**
     * Devuelve una oración convertida a morse
     * @param oracion String
     * @return String
     */
    public static String letrasAMorse(String oracion){
        String[] palabras = oracionAPalabras(oracion);
        String oracionMorse = "";
        for(String palabra: palabras)
            oracionMorse += String.format("%s ", palabraAMorse(palabra));
        
        return oracionMorse;
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
            palabraMorse += String.format("%s ", letraAMorse(String.valueOf(palabraMinuscula.charAt(i))));
//            palabraMorse += letraAMorse(String.valueOf(palabraMinuscula.charAt(i)));
        
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
                morse += ".-";//2
                break;
            case "b":
                morse += "-...";//4
                break;
            case "c":
                morse += "-.-.";//4
                break;
            case "d":
                morse += "-..";//3
                break;
            case "e":
                morse += ".";//1
                break;
            case "f":
                morse += "..-.";//4
                break;
            case "g":
                morse += "--.";//3
                break;
            case "h":
                morse += "....";//4
                break;
            case "i":
                morse += "..";//2
                break;
            case "j":
                morse += ".---";//4
                break;
            case "k":
                morse += "-.-";//3
                break;
            case "l":
                morse += ".-..";//4
                break;
            case "m":
                morse += "--";//2
                break;
            case "n":
                morse += "-.";//2
                break;
            case "o":
                morse += "---";//3
                break;
            case "p":
                morse += ".--.";//4
                break;
            case "q":
                morse += "--.-";//4
                break;
            case "r":
                morse += ".-.";//3
                break;
            case "s":
                morse += "...";//3
                break;
            case "t":
                morse += "-";//1
                break;
            case "u":
                morse += "..-";//3
                break;
            case "v":
                morse += "...-";//4
                break;
            case "w":
                morse += ".--";//3
                break;
            case "x":
                morse += "-..-";//4
                break;
            case "y":
                morse += "-.--";//4
                break;
            case "z":
                morse += "--..";//4
                break;
            case "1":
                morse += ".----";//5
                break;
            case "2":
                morse += "..---";//5
                break;
            case "3":
                morse += "...--";//5
                break;
            case "4":
                morse += "....-";//5
                break;
            case "5":
                morse += ".....";//5
                break;
            case "6":
                morse += "-....";//5
                break;
            case "7":
                morse += "--...";//5
                break;
            case "8":
                morse += "---..";//5
                break;
            case "9":
                morse += "----.";//5
                break;
            case "0":
                morse += "-----";//5
                break;
        }
        return morse;
    }
}
