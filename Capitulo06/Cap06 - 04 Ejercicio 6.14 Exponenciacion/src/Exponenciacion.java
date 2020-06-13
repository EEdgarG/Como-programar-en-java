/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Contiene un metodo llamado enteroPotencia(base, exponente) que calcula base elevado a exponente
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 27/04/2020
 * @time 08:56:08 PM
 */
public class Exponenciacion {
    public static void main(String[] args){
        System.out.printf("El resultado es: %d%n", enteroPotencia(-2, 3));
    }
    
    public static int enteroPotencia(int base, int exponente){
        int resultado = 1;
        for(int i = 0; i < exponente; i++){
            resultado *= base;
        }
        return resultado;
    }
}
