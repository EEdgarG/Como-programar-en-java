/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 21, 2020
 * @time 12:33:44 PM
 */
public class IndexOf {
    private String cadena;
    
    public IndexOf(String cadena){
        this.cadena = cadena;
    }
    /**
     * Devuelve el índice de la ocurrencia de ch en el String. Busca desde el final de la cadena al inicio
     * @param ch carácter de búsqueda
     * @param indiceInicial índice iniical de búsqueda
     * @return índice de ocurrencia. -1 si no se encuentra ocurrencia
     */
    public int lastIndexOf(int ch, int indiceInicial){
        int i = indiceInicial;
        while((i != 0) && (ch != cadena.charAt(i))){
            i--;
        }
        if(i == 0)
            return -1;
        else
            return i;
    }
    public int lastIndexOf(int ch){
        return lastIndexOf(ch, cadena.length() - 1);
    }
    /**
     * Devuelve el índice de la primer ocurrencia del caracter del parametro del método
     * @param ch caracter a comparar
     * @param indiceInicial indice desde donde se comienza la búsqueda
     * @return indice de la ocurrencia. -1 si no se encuentra ocurrencia
     */
    public int indexOf(int ch, int indiceInicial){
        int i = indiceInicial;
        while((i < cadena.length()) && (ch != cadena.charAt(i))){
            i++;
        }
        if(i == cadena.length())
            return -1;
        else
            return i;
    }
    /**
     * Devuelve el índice donde encuentra la ocurrencia del caracter ch
     * @param ch caracter de búsqueda
     * @return índice de la ocurrencia encontrada del carácter. -1 si no se encuentra ocurrencia
     */
    public int indexOf(int ch){
        return indexOf(ch, 0);
    }
}
