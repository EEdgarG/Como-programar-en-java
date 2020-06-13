/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Calcula el máximo común divisor de dos numero a y b
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 29/04/2020
 * @time 06:05:39 PM
 */
public class MCD {
    public static void main(String[] args){
        int a = 12437685;
        int b = 124375;
        System.out.printf("El MCD de %d y %d es %d%n", a, b, mcd(a, b));
    }
    public static int mcd(int a, int b){
        int mcd = 0;
        int r = 1;
        while(a != 0){
            r = b % a;
            b = a;//<el número más grande ahora es b
            a = r;//< el residuo ahora es b
        }
        return b;
    }
}
