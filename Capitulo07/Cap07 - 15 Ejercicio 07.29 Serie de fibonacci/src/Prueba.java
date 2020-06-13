/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Calcula el n-esimo número de fibonacci
 * @author eedua
 */
public class Prueba {
    public static void main(String[] args){
        long n = 44;
        System.out.printf("El numero %d de fibonacci es %d%n", n, fibonacci(n));
    }
    public static long fibonacci(long n){
        if(n == 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
