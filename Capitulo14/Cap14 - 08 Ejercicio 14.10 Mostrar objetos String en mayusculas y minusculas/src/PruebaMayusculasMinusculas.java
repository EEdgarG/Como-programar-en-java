/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 20, 2020
 * @time 2:46:19 PM
 */
public class PruebaMayusculasMinusculas {
    public static void main(String[] args){
        String oracion = "Anita lava la tina";
        
        String oracionLower = oracion.toLowerCase();
        String oracionUpper = oracion.toUpperCase();
        
        System.out.printf("%s%n%s%n%n", oracionLower, oracionUpper);
    }
}
