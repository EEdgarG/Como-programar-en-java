/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Producto 1: 2.98, producto 2: 4.50, producto 3: 9.98, producto 4: 4.49, producto 5 6.87
 * Lee un par de numeros, numero de producto y cantidad vendida
 * usar centinela para dejar de pedir pares de numeros
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 25/04/2020
 * @time 01:40:25 PM
 */

import java.util.Scanner;

public class Ventas {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int cantidad;
        float total = 0;
        short centinela = 1;
        while(centinela != 0){
            System.out.print("Introduce el numero de producto (ingrese 0 para terminar de agregar productos): ");
            centinela = entrada.nextShort();
            switch(centinela){
                case 0:
                    System.out.println("Has terminado de agregar productos");
                    break;
                case 1:
                    System.out.print("Introduce la cantidad a comprar: ");
                    cantidad = entrada.nextInt();
                    total += (cantidad * 2.98f);
                    break;
                case 2:
                    System.out.print("Introduce la cantidad a comprar: ");
                    cantidad = entrada.nextInt();
                    total += (cantidad * 4.50f);
                    break;
                case 3:
                    System.out.print("Introduce la cantidad a comprar: ");
                    cantidad = entrada.nextInt();
                    total += (cantidad * 9.98f);
                    break;
                case 4:
                    System.out.print("Introduce la cantidad a comprar: ");
                    cantidad = entrada.nextInt();
                    total += (cantidad * 4.49f);
                    break;
                case 5:
                System.out.print("Introduce la cantidad a comprar: ");
                cantidad = entrada.nextInt();
                total += (cantidad * 6.87f);
                break;
                default:
                    System.out.println("Esa no es una opcion, prueba de nuevo");
                    break;
            }
        }
        System.out.printf("El total de las compras es %f%n", total);
    }
}
