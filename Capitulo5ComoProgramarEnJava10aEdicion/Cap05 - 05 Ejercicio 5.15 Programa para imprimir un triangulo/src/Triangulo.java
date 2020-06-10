/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Dibuja 4 triángulos rectangulos con asteriscos todos las 4 posibles formas diferentes
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 25/04/2020
 * @time 12:58:00 PM
 */
public class Triangulo {
    public static void main(String[] args){
        trianguloA();
        System.out.println();
        trianguloB();
        System.out.println();
        trianguloC();
        System.out.println();
        trianguloD();
    }
    /**
     * Triángulo rectangulo con el cateto opuesto del lado izquierdo y el cateto adyacente abajo
     */
    public static void trianguloA(){
        for(int i = 0; i <= 10; i++){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    /**
     * Triangulo rectangulo con el cateto opuesto a la izquierda y el adyacente arriba
     */
    public static void trianguloB(){
        for(int i = 10; i > 0; i--){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    /**
     * Triángulo rectangulo con el cateto opuesto a la derecha y el dayacente arriba
     */
    public static void trianguloC(){
        for(int i = 0; i < 10; i++){
            for(int k = 0; k < i; k++){
                System.out.print(" ");
            }
            for(int j = i; j < 10; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static void trianguloD(){
        for(int i = 10; i >= 0; i--){
            for(int k = 0; k < i; k++){
                System.out.print(" ");
            }
            for(int j = i; j < 10; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
