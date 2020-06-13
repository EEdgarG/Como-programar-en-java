
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Determina si 3 numeros pueden formar un triángulo rectangulo
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 23/04/2020
 * @time 07:25:17 PM
 */
public class TrianguloRectangulo {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduce los 3 lados del triángulo rectangulo: ");
        float a = entrada.nextFloat();
        float b = entrada.nextFloat();
        float c = entrada.nextFloat();
        
        if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) || Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2) || 
                Math.pow(c, 2) + Math.pow(a, 2) == Math.pow(b, 2))
            System.out.println("Si se forma un triángulo rectángulo");
        else
            System.out.println("No es un triángulo");
    }
}
