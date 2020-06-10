/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Muestra un cuadrado  vacio de tamaño definido por el usuario, ademas requiere un caracter que sera el contorno del cuadrado
 * Es una version ligeramente diferente pero de mayor dificultad que la requerida en el ejercicio 6.18 y 6.19 del libro
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 28/04/2020
 * @time 07:41:56 PM
 */
import java.util.Scanner;

public class Cuadrado {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        int numero = entrada.nextInt();
        System.out.print("Introduce un caracter: ");
        char caracter = entrada.next().charAt(0);
        cuadrado(numero, caracter);
    }
    public static void cuadrado(int lado, char caracter){
        for(int i = 0; i < lado; i++){
            for(int j = 0; j < lado; j++){
                if(i == 0 || i == lado - 1 || j == 0 || j == lado - 1)
                    System.out.print(caracter);
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
