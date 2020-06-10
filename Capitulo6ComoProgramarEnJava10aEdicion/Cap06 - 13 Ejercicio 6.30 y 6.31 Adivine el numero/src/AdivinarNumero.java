/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * La aplicación elige un numero aleatorio en el rango del 1 al 1,000 y pide al usuario que lo adivine
 * no hay limite de intentos
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 29/04/2020
 * @time 08:34:12 PM
 */
import java.security.SecureRandom;
import java.util.Scanner;

public class AdivinarNumero {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        SecureRandom adivinar = new SecureRandom();
        
        int intentos;
        int eleccion;
        do{
            intentos = 0;
            System.out.print("Ingrese un número entre el 1 y el 1,000: ");
            eleccion = entrada.nextInt();
        
        int numero = adivinar.nextInt(1000) + 1;
        
            while(eleccion != numero){
                if(eleccion > numero)
                    System.out.println("Demasiado alto");
                else
                    System.out.println("Demasiado bajo");
                System.out.print("Ingrese de nuevo un número entre el 1 y el 1,000: ");
                eleccion = entrada.nextInt();
                intentos++;
            }
            if(intentos < 10)
                System.out.println("¡O ya sabía usted el secreto, o tuvo suerte!");
            else if(intentos == 10)
                System.out.println("¡Aja! ¡Sabía usted el secreto!");
            else
                System.out.println("¡Debería haberlo hecho mejor! ¿Porqué no se deben requerir más de 10 intentos?");
            System.out.println("Felicidades, adivinaste el número");
            System.out.print("Si deseas volver a jugar presiona 1 de lo contrario presiona 0: ");
            eleccion = entrada.nextInt();
        }while(eleccion != 0);
    }
}