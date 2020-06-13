/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 19/05/2020
 * @time 12:52:02 PM
 */

import java.util.Scanner;

public class PruebaSimpletron {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int[] memoria = inicializarMemoria();
        
        System.out.println("*** Bienvenido a Simpletron! ***");
        System.out.println("*** Por favor, introduzca en su programa una instrucción ***");
        System.out.println("*** (o palabra de datos) a la vez. Yo le mostrare ***");
        System.out.println("*** el número de ubicación y un signo de interrrogación (?) ***");
        System.out.println("*** Entonces usted escribira la palabra para esa ubicación. ***");
        System.out.println("*** Teclee -9999 para dejar de introducir su programa. ***");
        
        int e = 0;
        int ubicacion = 0;
        while(e != -9999){
            System.out.printf("%02d ? ", ubicacion);
            e = entrada.nextInt();
            memoria[ubicacion++] = e;
        }
        System.out.println("*** Se completo la carga del programa ***");
        System.out.println("*** Empieza la ejecución ***");
        
        for(int m: memoria)
            System.out.printf("%04d ", m);
    }
    
    public static int[] inicializarMemoria(){
        int[] memoria = new int[100];
        
        for(int i = 0; i < 100; i++){
            memoria[i] = 0;
        }
        
        return memoria;
    }
}
