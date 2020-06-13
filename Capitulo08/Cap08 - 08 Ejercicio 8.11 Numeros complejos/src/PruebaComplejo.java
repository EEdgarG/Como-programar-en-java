/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Suma y resta números complejos
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 5/05/2020
 * @time 01:18:35 PM
 */
public class PruebaComplejo {
    public static void main(String[] args){
        Complejo a = new Complejo(1f, 3f);
        Complejo b = new Complejo(-2.0, 0.0);
        
        // Muestra los dos números Complejos
        System.out.printf("El número complejo a es: %s%n", a);
        System.out.printf("El número complejo b es: %s%n", b);
        
        // Suma de a mas b
        Complejo c = a.suma(b);
        System.out.printf("La suma de complejos a + b = c; %s + %s = %s%n", a, b, c);
        
        // Resta de a menos b
        Complejo d = a.resta(b);
        System.out.printf("La resta de complejos a + b = c; %s + %s = %s%n", a, b, d);
    }
}
