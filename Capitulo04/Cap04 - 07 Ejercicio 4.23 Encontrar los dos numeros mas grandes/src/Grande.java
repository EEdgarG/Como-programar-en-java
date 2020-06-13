
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 19/04/2020
 * @time 03:53:46 PM
 */
public class Grande {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        float mayor1 = 0;
        float mayor2 = 0;
        
        for(int i = 0; i < 10; i++){
            System.out.printf("Introduce el elemento %d ", i + 1);
            float numero = entrada.nextFloat();
            if(numero > mayor1){
                mayor2 = mayor1;
                mayor1 = numero;
            }
            else if(numero > mayor2)
                mayor2 = numero;
        }
        System.out.printf("Los dos numeros mas grandes son %f y %f%n", mayor1, mayor2);
    }
}
