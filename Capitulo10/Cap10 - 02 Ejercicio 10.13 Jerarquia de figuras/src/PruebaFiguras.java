/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 16/06/2020
 * @time 08:10:06 PM
 */
public class PruebaFiguras {
    public static void main(String[] args){
        //Arreglo de objetos figuras
        Figura[] figuras = new Figura[6];
        
        //Creacion de tipos especificos de Figura
        figuras[0] = new Circulo(4);
        figuras[1] = new Cuadrado(3);
        figuras[2] = new Triangulo(5, 3);
        
        figuras[3] = new Esfera(5);
        figuras[4] = new Cubo(7);
        figuras[5] = new Tetraedro(6, 4);
        
        for(Figura figura: figuras){
            if(figura instanceof Circulo)
                System.out.printf("Circulo con instanceof");
            if(figura instanceof Cuadrado)
                System.out.printf("Cuadrado con instanceof");
            if(figura instanceof Triangulo)
                System.out.printf("Triangulo con instanceof");
            if(figura instanceof Esfera)
                System.out.printf("Esfera con instanceof");
            if(figura instanceof Cubo)
                System.out.printf("Cubo con instanceof");
            if(figura instanceof Tetraedro)
                System.out.printf("Tetraedro con instanceof");
            System.out.printf("%s%n%n", figura);
        }
    }
}
