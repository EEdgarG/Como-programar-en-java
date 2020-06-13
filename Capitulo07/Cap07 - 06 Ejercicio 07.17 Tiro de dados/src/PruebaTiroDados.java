/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Realiza la simulación del lanzado de dos dados y cuenta las veces en que cae la suma de ambos
 * @author eedua
 */

import java.security.SecureRandom;

public class PruebaTiroDados {
    public static void main(String[] args){
        SecureRandom dado = new SecureRandom();
        int[] sumaDados = new int[13];
        
        for(int tirar = 0; tirar < 36000000; tirar++){//< Tira los dados 36 millones de veces
            sumaDados[dado.nextInt(6) + 1 + dado.nextInt(6) + 1]++;//< En la posición de la suma de los dados aumenta en uno el contador
        }
        mostrarArreglo(sumaDados);
    }
    /**
     * Muestra el valor de los elementos que contiene un arreglo de enteros
     * @param arreglo Arreglo de enteros
     */
    public static void mostrarArreglo(int[] arreglo){
        System.out.printf("Las sumas son:%n");
        for(int suma : arreglo){
            System.out.printf("%d\t", suma);
        }
    }
}
