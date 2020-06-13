/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Prueba de la clase Racional que realiza operaciones aritméticas con fracciones
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 8/05/2020
 * @time 08:06:12 PM
 */
public class PruebaRacionales {
    public static void main(String[] args){
        Racional a = new Racional(47, 200);
        Racional b = new Racional(200, 2);
        
        // Representación flotante de a y b
        System.out.printf("%s%n%s%n%n", a.representacionFlotante(5), a);
        System.out.printf("%s%n%s%n%n", b.representacionFlotante(5), b);
        
        // Suma de racional b en a
        Racional c = Racional.suma(a, b);
        System.out.printf("%s%n%n", c);
        
        // Resta de racional a menos b
        Racional d = Racional.resta(a, b);
        System.out.printf("%s%n%n", d);
        
        // Multiplicacion de a x b
        Racional e = Racional.multiplicacion(a, b);
        System.out.printf("%s%n%n", e);
        
        // División de a % b
        Racional f = Racional.division(a, b);
        System.out.printf("%s%n", f);
    }
}
