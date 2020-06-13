/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Determina si un número de 5 digitos es un palindromo
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 20/04/2020
 * @time 07:44:55 PM
 */
import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingresa un número de 5 digitos: ");
        int palindromo = entrada.nextInt();
        while(validarTamano(palindromo)){
            System.out.print("Ingresa un número de 5 digitos valido: ");
            palindromo = entrada.nextInt();
        }
        validarPalindromo(palindromo);
        System.out.printf("%d%n", palindromo);
    }
    /**
     * Valida el tamaño del numero
     * @param numero Número a determinar si es palindromo
     * @return Es verdadero si el numero esta fuera de rango y falso si esta dentro del rango
     */
    public static boolean validarTamano(int numero){
        return (numero < 10000 || numero > 99999);
    }
    /**
     * Determina si un numero es palindromo
     * @param numero Número a determinar si es palindromo
     */
    public static void validarPalindromo(int numero){
        int decenasMillar = numero / 10000;
        numero -= (decenasMillar * 10000);
        
        int unidadesMillar = numero / 1000;
        numero -= (unidadesMillar * 1000);
        
        int centenas = numero / 100;
        numero -= (centenas * 100);
        
        int decenas = numero / 10;
        numero -= (decenas * 10);
        
        int unidades = numero;
        
        if(decenasMillar == unidades && unidadesMillar == decenas)
            System.out.println("Es palindromo");
        else
            System.out.println("No es palindromo");
            
        
    }
}
