/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Importación de métodos estaticos especificos de java.lang.Math
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 9/06/2020
 * @time 07:24:02 PM
 */
import static java.lang.Math.sqrt;
import static java.lang.Math.ceil;
import static java.lang.Math.E;
import static java.lang.Math.PI;

public class PruebaImportStatic {
    public static void main(String[] args){
        System.out.printf("sqrt(900.0) = %.1f%n", sqrt(900.0));
        System.out.printf("ceil(-9.8) = %.1f%n", ceil(-9.8));
        System.out.printf("E = %f%n", E);
        System.out.printf("PI = %f%n", PI );
    }
}
