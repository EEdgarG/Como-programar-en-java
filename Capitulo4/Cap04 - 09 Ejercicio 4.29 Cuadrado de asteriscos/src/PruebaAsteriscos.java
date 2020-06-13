/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Crea un cuadrado de asterisco del tamaño introducido por el usuario
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 20/04/2020
 * @time 08:58:22 AM
 */
import java.util.Scanner;

public class PruebaAsteriscos {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduce el tamaño (en asteriscos) que tendra el cuadrado: ");
        int lado = entrada.nextInt();
        dibujarCuadrado(lado);
    }
    /**
     * Dibuja un cuadrado de lado tam
     * @param tam Tamaño del lado del cuadrado
     */
    public static void dibujarCuadrado(int tam){
        for(int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){
                if(i == 0 || i == (tam - 1)){
                    System.out.print("* ");
                }
                else{
                    if(j == 0 || j == (tam - 1))
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
