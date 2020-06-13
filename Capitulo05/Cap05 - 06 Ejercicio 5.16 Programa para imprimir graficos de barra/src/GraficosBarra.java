/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Lee 5 numeros de la entrada estandar, cada uno entre 1 y 30. Por cada número el programa muestra el mismo numero
 * con asteriscos adyacentes
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 25/04/2020
 * @time 01:28:49 PM
 */

import java.util.Scanner;

public class GraficosBarra {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduce el primer numero: ");
        int primer = entrada.nextInt();
        while(primer < 1 ||  primer > 30){
            System.out.print("Introduce un numero valido: ");
            primer = entrada.nextInt();
        }
        
        System.out.print("Introduce el segundo numero: ");
        int segundo = entrada.nextInt();
        while(segundo < 1 ||  segundo > 30){
            System.out.print("Introduce un numero valido: ");
            segundo = entrada.nextInt();
        }
        
        System.out.print("Introduce el tercer numero: ");
        int tercer = entrada.nextInt();
        while(tercer < 1 ||  tercer > 30){
            System.out.print("Introduce un numero valido: ");
            tercer = entrada.nextInt();
        }
        
        System.out.print("Introduce el cuarto numero: ");
        int cuarto = entrada.nextInt();
        while(cuarto < 1 ||  cuarto > 30){
            System.out.print("Introduce un numero valido: ");
            cuarto = entrada.nextInt();
        }
        
        System.out.print("Introduce el quinto numero: ");
        int quinto = entrada.nextInt();
        while(quinto < 1 ||  quinto > 30){
            System.out.print("Introduce un numero valido: ");
            quinto = entrada.nextInt();
        }
        
        dibujarGraficoBarras(primer);
        dibujarGraficoBarras(segundo);
        dibujarGraficoBarras(tercer);
        dibujarGraficoBarras(cuarto);
        dibujarGraficoBarras(quinto);
    }
    /**
     * Dibuja una cantidad definida de asteriscos
     * @param primer Cantidad de asteriscos que se van a mostrar
     */
    public static void dibujarGraficoBarras(int primer){
        for(int i = 0; i < primer; i++){
            System.out.print("*");
        }
        System.out.println();
    }
}
