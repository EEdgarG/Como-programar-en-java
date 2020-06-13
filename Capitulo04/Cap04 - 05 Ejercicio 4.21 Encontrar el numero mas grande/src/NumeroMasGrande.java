/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * De 10 numeros introducidos muestra el mayor
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 19/04/2020
 * @time 02:12:41 PM
 */

import java.util.Scanner;

public class NumeroMasGrande {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        float mayor = 0;
        for(int i = 0; i < 10; i++){
            System.out.printf("Introduce el elemento %d ", i + 1);
            float numero = entrada.nextFloat();
            if(numero > mayor)
                mayor = numero;
        }
        System.out.printf("El numero mas grande es %f%n", mayor);
    }
}
