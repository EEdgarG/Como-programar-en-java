/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Implementación propia de los métodos indexOf y lastIndexOf de String sobrecagados
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 21, 2020
 * @time 12:30:44 PM
 */
public class PruebaIndexOfLastIndexOf {
    public static void main(String[] args){
        String oracion = "Hola mundo";
        
        IndexOf o = new IndexOf(oracion);
        System.out.printf("%d%n", o.indexOf('o', 3));
        System.out.printf("%d%n", o.indexOf('o'));
        System.out.printf("%d%n", o.lastIndexOf('o', oracion.length() - 2));
        System.out.printf("%d%n", o.lastIndexOf('o'));
    }
}
