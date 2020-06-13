/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Pide al usuario 5 numeros en el rango de 10 a 100
 * muestra solo aquellos que no estan repetidos
 * el peor caso es cuando todos son diferentes
 * @author eedua
 */

import java.util.Scanner;

public class PuebaDuplicados {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int[] numeros = new int[5];
        int ent = 0;
        inicializacionArreglo(numeros);
        
        for(int i = 0; i < 5; i++){//ciclo que introduce 5 numeros
            do{
                System.out.printf("Introduce el numero %d (entre 10 y 100): ", i + 1);
                ent = entrada.nextInt();//numero introducido
                numeros[i] = ent;
            }while(ent < 10 || ent > 100);//< Verifica que el número introducido este en el rango de 10 a 100
            
            verificacionRepetidos(numeros, i);
            
            mostrarArreglo(numeros);
        }
        
    }
    /**
     * Inicializa los elementos de un arreglo de enteros a cero
     * @param arreglo Arreglo de enteros a inicializar
     */
    public static void inicializacionArreglo(int[] arreglo){
        for(int i = 0; i < arreglo.length; i++){
            arreglo[i] = 0;
        }
    }
    /**
     * Muestra en la salida estandar los elementos que componen a un arreglo de enteros
     * siempre y cuando los elementos sean distintos de cero
     * @param arreglo Arreglo de enteros a mostrar
     */
    public static void mostrarArreglo(int[] arreglo){
        for(int num : arreglo){//imprime el arreglo
                if(num != 0)
                    System.out.printf("%d%n", num);
            }
    }
    /**
     * Los elementos del arreglo con el mismo valor los vuelve cero
     * @param arreglo Arreglo de enteros a analizar
     * @param i Indice que indica el limite de elementos a analizar
     */
    public static void verificacionRepetidos(int[] arreglo, int i){
        for(int j = 0; j < i; j++){//busqueda de duplicados desde cero hasta el valor actual de i
                    if(arreglo[j] == arreglo[i])
                        arreglo[i] = arreglo[j] = 0;
            }
    }
}
