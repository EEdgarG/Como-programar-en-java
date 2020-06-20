/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Cuenta las ocurrencias de letras que tiene una oración
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 20, 2020
 * @time 6:29:59 PM
 */
public class PruebaBusquedaString {
    public static void main(String[] args){
        char[] alfabetoEspanol = {'a', 'b' , 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        
        String oracion = "Anita lava la tina";
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
}
