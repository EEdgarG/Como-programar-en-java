/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Cuenta las ocurrencias de un caracter determinado por medio de los metodos de String 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 20, 2020
 * @time 3:20:35 PM
 */
public class PruebaBusquedaString {
    public static void main(String[] args){
        String oracion = "anita lava la tina br";
        char busqueda = 'x';
        
        System.out.printf("Las ocurrencias de %c son %d%n%n", busqueda, ocurrencias(oracion, busqueda));
    }
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
