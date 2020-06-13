/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Calcula los factoriales del 1 al 20
 * El problema de calcular el factorial de 100 esta en el alcance del tipo primitico long
 * A partir del factorial de 21 se supera el alcance del tipo primitivo y la aplicacion comienza a mostrar
 * valores falsos
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 25/04/2020
 * @time 12:16:31 PM
 */
public class Factorial {
    public static void main(String[] args){
        for(int i = 1; i < 21; i++){
            System.out.printf("El factorial de %2d es %20d%n", i, calcularFactorial(i));
        }
    }
    public static long calcularFactorial(int numero){
        long fact = 1;
        while(numero > 0){
            fact *= numero;
            numero--;
        }
        return fact;
    }
}
