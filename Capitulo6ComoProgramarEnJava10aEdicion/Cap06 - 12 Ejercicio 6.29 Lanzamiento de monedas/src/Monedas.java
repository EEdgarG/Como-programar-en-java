/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Pide al usuario lanzar una moneda la cantidad de veces que el usuario lo desea, y muestra
 * cuantas veces salio cara y cuantas salio cruz
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 29/04/2020
 * @time 07:39:06 PM
 */
import java.security.SecureRandom;
import java.util.Scanner;

public class Monedas {
    private enum Moneda {CARA, CRUZ};
    private static final SecureRandom lanzar = new SecureRandom();
    
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Presione 1 para lanzar una moneda 0 para salir: ");
        int opcion =  entrada.nextInt();
        int cara = 0;
        int cruz = 0;
        while(opcion != 0){
            switch(opcion){
                case 0:
                    System.out.println("Has elegido salir");
                    break;
                case 1:
                    Moneda moneda = tirar();
                    if(moneda == Moneda.CARA)
                        cara++;
                    else
                        cruz++;
                    break;
                default:
                    System.out.println("Esa no es una opción, prueba de nuevo");
                    break;
            }
            System.out.print("Presione 1 para lanzar otra moneda 0 para salir: ");
            opcion =  entrada.nextInt();
        }
        System.out.printf("La cantidad de caras es %d y cruces es %d%n", cara, cruz);
    }
    public static Moneda tirar(){
        Moneda moneda;
        if(lanzar.nextInt(2) == 0)
            return moneda = Moneda.CARA;
        else
            return moneda = Moneda.CRUZ;
    }
}
