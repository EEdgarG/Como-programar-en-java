/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eedua
 */

import java.util.Scanner;

public class ComisionPorVenta {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int agregarArticulo = 1;
        float precioArticulo = 0f;
        
        
        System.out.println("Ingrese el precio del articulo");
        precioArticulo += entrada.nextFloat();
        System.out.println("Desea agregar otro articulo?(0 para no)");
        agregarArticulo = entrada.nextInt();
        while(agregarArticulo != 0){
            System.out.println("Ingrese el precio del articulo");
            precioArticulo += entrada.nextFloat();
            System.out.println("Desea agregar un articulo?(0 para no)");
            agregarArticulo = entrada.nextInt();
        }
        System.out.printf("Los ingresos del vendedor son: %f%n", 200 + (precioArticulo * .09));
    }
}
