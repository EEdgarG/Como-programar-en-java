/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Encuentra el valor menor de varios enteros introducidos,
 * el primer valor es la cantidad de valores que el usuario introducira
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 25/04/2020
 * @time 11:54:44 AM
 */
import java.util.Scanner;

public class Menor {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce la cantidad de numeros a analizar: ");
        short cantidad = entrada.nextShort();
        int menor = Integer.MAX_VALUE;
        for(int i = 0 ; i < cantidad; i++){
            System.out.printf("Introduce el valor del %d entero: ", i + 1);
            int numero =  entrada.nextInt();
            if(numero < menor)
                menor = numero;
        }
        System.out.printf("El valor menor es %d%n", menor);
    }
}
