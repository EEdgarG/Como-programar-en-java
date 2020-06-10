/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Crea un ciclo infinito de potencias de dos y se observa el comportamiento del programa
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 22/04/2020
 * @time 09:32:46 PM
 */
public class Multiplos {
    public static void main(String[] args){
        /*
        * El comportamiento del programa es el siguiente: la ejecucion continua hasta que el valor de la potencia de 2
        * rebasa el valor que puede contener el tipo primitivo y se detiene el programa
        */
        long dos = 2;
        while(dos != 0){
            System.out.printf("%d%n", dos);
            dos *= 2;
        }
    }
}
