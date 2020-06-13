/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Realiza la comparación lexicográfica de dos cadenas de texto ingresadas por el usuario
 * Página 636 de "Cómo programar en java"
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 31/05/2020
 * @time 12:55:54 PM
 */
import java.util.Scanner;

public class ComparacionLexicografica {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingresa la primer cadena de texto");
        String string1 = entrada.nextLine();
        
        System.out.println("Ingresa la segunda cadena de texto");
        String string2 = entrada.nextLine();
        
        if(string1.compareTo(string2) > 0)
            System.out.println("La primer cadena es mayor");
        else if(string1.compareTo(string2) == 0)
            System.out.println("Las cadenas son iguales");
        else
            System.out.println("La primer cadena es menor");
    }
}
