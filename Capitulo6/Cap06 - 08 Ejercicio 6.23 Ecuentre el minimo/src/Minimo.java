/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Muestra el menor de 3 números de coma flotante
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 28/04/2020
 * @time 08:10:28 PM
 */
public class Minimo {
    public static void main(String[] args){
        double numero1 = 2.2121f;
        double numero2 = 3.123f;
        double numero3 = 1.155f;
        
        System.out.printf("El número menor es %f%n", minimo3(numero1, numero2, numero3));
    }
    public static double minimo3(double numero1, double numero2, double numero3){
        return Math.min(Math.min(numero1, numero2), numero3);
    }
}
