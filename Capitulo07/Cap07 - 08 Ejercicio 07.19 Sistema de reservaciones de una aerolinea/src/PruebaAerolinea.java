/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Hace reservaciones en un avión de 10 pasajeros con dos clases, economica y primera clase
 * economica son del 6 al 10 y primera clase del 1 al 5, si la clase ya esta llena pregunta si
 * desea reservar en la otra, si dice que si asigna a la otra clase de lo contrario muestra un mensaje
 * para avisar que el siguiente vuelo sale en 3 horas. El programa termina cuando todo el avión esta lleno
 * @author eedua
 */

import java.util.Scanner;

public class PruebaAerolinea {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        boolean[] avion = new boolean[10];
        
        inicializarArreglo(avion);
        
        int primera = 0;
        int economica = 5;
        while(primera < 5 || economica < 10){
            System.out.println("Por favor escriba 1 para Primera Clase");
            System.out.println("Por favor escriba 2 para Clase Economica");
            int clase = entrada.nextInt();
            if(clase == 1){
                if(primera < 5){
                    avion[primera++] = true;
                    System.out.printf("Su asiento es el %d de primera clase%n", primera);
                }
                else{
                    System.out.println("Los asientos de primera clase estan llenos "
                            + "deseas que se te asigne un asiento en economica?");
                    System.out.println("Por favor escriba 1 para no asignar a clase economica");
                    System.out.println("Por favor escriba 2 para Clase Economica");
                    clase = entrada.nextInt();
                    if(clase == 1)
                        System.out.println("El proximo vuelo sale en 3 horas");
                }
            }
            if(clase == 2){
                if(economica < 10){
                    avion[economica++] = true;
                    System.out.printf("Su asiento es el %d de clase economica%n", economica);
                }
                else{
                    System.out.println("Los asientos de clase economica estan llenos"
                            + "deseas que se te asigne un asiento en primera clase?");
                    System.out.println("Por favor escriba 1 para asignar a primera clase");
                    System.out.println("Por favor escriba 2 para no asignar primera Clase");
                    clase = entrada.nextInt();
                    if(clase == 2)
                        System.out.println("El proximo vuelo sale en 3 horas");
                }
            }
        }
    }
    /**
     * Inicializa un arreglo de elementos booleanos a false
     * @param arreglo Arreglo booleano a ser inicializado
     */
    public static void inicializarArreglo(boolean[] arreglo){
        for(int asiento = 0; asiento < arreglo.length; asiento++){
            arreglo[asiento] = false;
        }
    }
}
