/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Prueba de la clase rectángulo
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 4/05/2020
 * @time 01:00:55 PM
 */
public class PruebaRectangulo {
    public static void main(String[] args){
        Rectangulo rectangulo = new Rectangulo();
        
        System.out.printf("%s%n", rectangulo.toString());
        
        try{
            rectangulo.establecerAnchura(0.5f);
            rectangulo.establecerLongitud(22.0f);
        }catch(IllegalArgumentException e){
            System.out.printf("Excepción: %s%n%n", e.getMessage());
        }
        
        System.out.printf("%s%n", rectangulo.toString());
    }
}
