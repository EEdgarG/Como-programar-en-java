/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Calcula el factorial de un numero, calcula el valor de la constante e y calcula e elevado a la x
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 23/04/2020
 * @time 07:35:12 PM
 */
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        //Calculo de factorial
//        System.out.print("Introduce un numero entero para calcular su factorial: ");
//        int factorial = entrada.nextInt();
//        System.out.printf("El factorial de %d es %d%n", factorial, calcularFactorial(factorial));

        //Calculo de e
//        System.out.print("Introduzca la cantidad de terminos a calcular de e: ");
//        int terminos = entrada.nextInt();
//        System.out.printf("La aproximación de e con %d terminos es %f", terminos, calcularE(terminos));

        //Calculo de e elevado a la x
        System.out.print("Introduzca la cantidad de terminos a calcular de e^x: ");
        int terminos = entrada.nextInt();
        System.out.print("Introduzca el valor de x para e^x: ");
        int x = entrada.nextInt();
        System.out.printf("El valor de e^x con %d terminos y x = %d de precisión es %f", terminos, x, calcularEx(terminos, x));
    }
    /**
     * Calcula el factorial de un numero
     * @param numero Numero entero del cual se calcula el factorial
     * @return factorial de numero
     */
    public static long calcularFactorial(int numero){
        long factorial = 1;
        while(numero > 0){
            factorial *= numero;
            numero--;
        }
        return factorial;
    }
    /**
     * Calcula una aproximacion de e recibiendo el valor de la precisión numerica del mismo
     * @param terminos Precisión de e
     * @return Aproximacion de e
     */
    public static double calcularE(int terminos){
        double e = 1;
        if(terminos == 1)
            return e;
        else{
            for(int i = 1; i < terminos; i++){
                e += (double)1 / calcularFactorial(i);
            }
            return e;
        }
    }
    /**
     * Calcula una aproximación de e elevado a la x
     * @param terminos Precisión con la cual se calcula e elevado a la x
     * @param x Valor de x
     * @return Aproximación de e elevado a la x
     */
    public static double calcularEx(int terminos, int x){
        double e = 1;
        if(terminos == 1)
            return e;
        else{
            for(int i = 1; i < terminos; i++){
                e += (double)Math.pow(x, i) / calcularFactorial(i);
            }
            return e;
        }
    }
}
