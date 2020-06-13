/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Busca números primos usando el metodo de la criba de Eratostenes
 * @author eedua
 */
public class PruebaEratostenes {
    private static final int NUMERO = 50000;
    public static void main(String[] args){
        boolean[] primos = new boolean[NUMERO];
        
        inicializar(primos);
        
        verificar(primos);
        
        mostrar(primos);
    }
    public static void inicializar(boolean[] primos){
        for(int i = 0; i < NUMERO; i++){
            primos[i] = true;
        }
    }
    public static void verificar(boolean[] primos){
        for(int numero = 2; numero < NUMERO; numero++){
            for(int num = numero + 1; num < NUMERO; num++){
                if((num % numero) == 0)
                    primos[num] = false;
            }
        }
    }
    
    public static void mostrar(boolean[] primos){
        for(int i = 2; i < NUMERO; i++){
            if(primos[i] == true)
                System.out.printf("Numero %2d es primo%n", i);
            else
                System.out.printf("Numero %2d no es primo%n", i);
        }
    }
}
