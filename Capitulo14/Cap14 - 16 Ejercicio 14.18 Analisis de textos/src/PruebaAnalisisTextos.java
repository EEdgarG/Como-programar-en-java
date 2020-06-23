/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 22, 2020
 * @time 6:20:13 PM
 */
public class PruebaAnalisisTextos {
    public static void main(String[] args){
        String oracion = "Anita! lava la tina, y oración, Anita, corazón";
        
        ocurrenciasAbecedario(oracion);
        tamanoDePalabras(oracion);
        
        String[] palabras = dividirEnPalabras(oracion);
        int[] cuenta = conteoDePalabras(palabras);
        for(int i = 0; i < cuenta.length; i++){
            if(cuenta[i] != 0)
                System.out.printf("La palabra %s aparece %d veces%n", palabras[i], cuenta[i]);
        }
    }
    public static void tamanoDePalabras(String oracion){
        int[] tamanos = tamanoPalabras(dividirEnPalabras(oracion));
        for(int i = 0; i < tamanos.length; i++){
            if(tamanos[i] != 0)
                System.out.printf("Palabras con tamaño %d: %d%n", i, tamanos[i]);
        }
    }
    public static void ocurrenciasAbecedario(String oracion){
        char[] alfabetoEspanol = {'a', 'b' , 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        int j = 0;
        System.out.println("Letra Ocurrencias");
        for(int i: ocurrenciasLetras(oracion, alfabetoEspanol)){
            System.out.printf("%5c%10d%n", alfabetoEspanol[j++], i);
        }
    }
     /**
     * Devuelve un arreglo de ocurrencias de los caracteres provistos al método
     * @param oracion String
     * @param alfabetoEspanol char[]
     * @return int[]
     */
    public static int[] ocurrenciasLetras(String oracion, char[] alfabetoEspanol){
        int[] alfabetoOcurrencias = new int[alfabetoEspanol.length];
        for(int i = 0; i < alfabetoOcurrencias.length; i++){
            alfabetoOcurrencias[i] = 0;
        }
        
        String oracionLowerCase = oracion.toLowerCase();
        int i = 0;
        for(char letra: alfabetoEspanol){
            alfabetoOcurrencias[i++] = ocurrencias(oracionLowerCase, letra);
        }
        return alfabetoOcurrencias;
    }
    /**
     * Obtiene las ocurrencias de el caracter busqueda
     * @param oracion char
     * @param busqueda String
     * @return int
     */
    public static int ocurrencias(String oracion, char busqueda){
        int ocurrencias = 0;
        int indice = 0;
        
        while(indice != -1){
            indice = oracion.indexOf(busqueda, indice);
            if(indice != -1)
                indice++;
            ocurrencias++;
        }
        
        return ocurrencias - 1;
    }
    /**
     * Devueve un arreglo de String
     * @param oracion
     * @return 
     */
    public static String[] dividirEnPalabras(String oracion){
        return oracion.split("[^a-zA-Z]\\s|\\s+");
    }
    /**
     * Cuenta el tamaño de una palabra y almacena su valor en un arreglo
     * @param palabras Arreglo de String
     * @return arreglo de enteros int[]
     */
    public static int[] tamanoPalabras(String[] palabras){
        int[] tamanos = new int[50];
        
        for(int i = 0; i < tamanos.length; i++)
            tamanos[i] = 0;
        
        for(String palabra: palabras)
            tamanos[palabra.length()]++;
        return tamanos;
    }
    /**
     * Devuelve un arreglo de ocurrencias de palabras
     * @param palabras Arreglo de String
     * @return arreglo de enteros con los resultados del conteo
     */
    public static int[] conteoDePalabras(String[] palabras){
        int[] tamanos = new int[palabras.length];
        String[] palabrasMinusculas = new String[palabras.length];
        
        for(int i = 0; i < palabras.length; i++){
            palabrasMinusculas[i] = new String(palabras[i].toLowerCase());
        }
        
        for(int i = 0; i < tamanos.length; i++)//< Inicializa el arreglo
            tamanos[i] = 0;
        
        for(int i = 0; i < tamanos.length; i++){
            String actual = palabrasMinusculas[i].toLowerCase();//< Copia de String en minúsculas
            if(actual != ""){
                for(int j = i; j < tamanos.length; j++){
                    if(actual.equals(palabrasMinusculas[j])){
                        tamanos[i]++;
                        palabrasMinusculas[j] = "";
                    }
                }
            }
        }
        return tamanos;
    }
}
