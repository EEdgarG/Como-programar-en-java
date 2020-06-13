/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Usa el metodo Math.floor(numero + 0.5) para redondear numeros tipo double a su entero mayor pero menor a la suma de
 * numero + 0.5
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 27/04/2020
 * @time 08:14:41 PM
 */
import java.util.Scanner;

public class Redondeo {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingresa un valor con punto decimal: ");
        double numero = entrada.nextDouble();
        System.out.printf("El numero orginal es %f, el redondeado es %f", numero, Math.floor(numero + 0.5));
    }
}
