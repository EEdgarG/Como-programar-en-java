/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Obtiene los numeros perfectos que existen del 1 al 1000
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 28/04/2020
 * @time 08:23:26 PM
 */
public class Perfectos {
    public static void main(String[] args){
//        int numero = 28;
        for(int numero = 1; numero < 10000000; numero++){
            System.out.printf("%s", esPerfecto(numero) ? (numero + " es perfecto\n") : "");
        }
    }
    public static boolean esPerfecto(int numero){
        int cuenta = 0;
        for(int i = 1; i < (numero / 2) + 1; i++){
            if(numero % i == 0)
                cuenta += i;
        }
        return numero == cuenta;
    }
}
