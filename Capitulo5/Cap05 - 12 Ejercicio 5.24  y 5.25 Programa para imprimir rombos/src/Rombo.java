/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Imprime un rombo con asteriscos en la salida estandar
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 26/04/2020
 * @time 12:42:13 PM
 */
import java.util.Scanner;

public class Rombo {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un numero impar entre 1 y 19: ");
        int tamano = entrada.nextInt();
        while((tamano < 1 || tamano > 19) || (tamano % 2 == 0)){
            System.out.print("Introduce un numero impar entre 1 y 19 valido: ");
            tamano = entrada.nextInt();
        }
        rombo(tamano);
    }
    /**
     * Imprime un rombo 
     * @param tamano Cantidad de filas que tiene el rombo
     */
    public static void rombo(int tamano){
        int superior = (tamano / 2) + 1;
        int inferior = (tamano / 2);
        triangulo(superior);
        trianguloInvertido(inferior);
    }
    /**
     * Imprime un triángulo con la punta hacia arriba
     * @param tamano Cantidad de filas del triángulo
     */
    private static void triangulo(int tamano){
        for(int fila = 0 ; fila < tamano; fila++){
            espacios(fila, tamano);
            asteriscos(fila);
            System.out.println();
        }
    }
    /**
     * Imprime espacios en forma de triángulo
     * @param i Fila actual del triángulo
     * @param tamano Cantidad total de filas del triángulo
     */
    private static void espacios(int i, int tamano){
        for(int j = 0; j < tamano - i - 1; j++){
            System.out.print(" ");
        }
    }
    /**
     * Imprime asteriscos en funcion de i
     * @param i Fila actual
     */
    public static void asteriscos(int i){
        int temporal;
        if(i == 0)
            temporal = 1;
        else if(i == 1)
            temporal = 3;
        else
            temporal = (i * 2) + 1;
        
        for(int j = 0; j < temporal; j++){
            System.out.print("*");
        }
    }
    /**
     * Imprime un triángulo con la punta hacia abajo
     * @param tamano Cantidad de filas del triángulo
     */
    public static void trianguloInvertido(int tamano){
        int temporal = (tamano * 2) - 1;
        for(int fila = 0 ; fila < tamano; fila++){
            espaciosInvertido(fila + 1);
            asteriscosInvertido(fila, temporal);
            temporal -= 2;
            System.out.println();
        }
    }
    /**
     * Imprime espacios en forma de triángulos en funcion de la fila actual
     * @param i Fila actual
     */
    public static void espaciosInvertido(int i){
        for(int j = 0; j < i; j++){
            System.out.print(" ");
        }
    }
    /**
     * Imprime asteriscos en forma de triángulo en funcion de la fila actual (i)
     * @param i Fila actual
     * @param tamano Tamaño total del triángulo
     */
    public static void asteriscosInvertido(int i, int tamano){
        for(int j = 0; j < tamano; j++){
            System.out.print("*");
        }
    }
}