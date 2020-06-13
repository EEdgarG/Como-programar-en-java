/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Determina si 3 numeros pueden formar un triángulo
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 23/04/2020
 * @time 07:16:17 PM
 */
import java.util.Scanner;

public class Triangulo {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduce los 3 lados del triángulo: ");
        float a = entrada.nextFloat();
        float b = entrada.nextFloat();
        float c = entrada.nextFloat();
        
        if(a + b > c && b + c > a && c + a > b)
            System.out.println("Si se forma un triángulo");
        else
            System.out.println("No es un triángulo");
    }
}
