/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 21, 2020
 * @time 12:12:51 PM
 */
public class PruebaIntACaracter {
    public static void main(String[] args){
        for(int i = 0; i < 255; i++)
            System.out.printf("Convertir digito: %d a caracter: %s%n", i, (char)i);
//            System.out.printf("Convertir digito: %d a caracter: %s%n", i, Character.forDigit(i, 16));
        
    }
}
