/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Calcula la hipotenusa de un triángulo rectangulo con sus catetos
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 28/04/2020
 * @time 06:32:12 PM
 */
public class Hipotenusa {
    public static void main(String[] args){
        double ca = 3.45f;
        double co = 44.1256f;
        System.out.printf("La hipotenusa de %f y %f es %f%n", ca, co, hipotenusa(ca, co));
        System.out.printf("La hipotenusa de %f y %f es %f", ca, co, Math.hypot(ca, co));
    }
    public static double hipotenusa(double catetoAdyacente, double catetoOpuesto){
        return Math.sqrt(Math.pow(catetoAdyacente, 2) + Math.pow(catetoOpuesto, 2));
    }
}
