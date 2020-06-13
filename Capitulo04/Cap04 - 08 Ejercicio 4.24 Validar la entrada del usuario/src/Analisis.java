/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 19/04/2020
 * @time 04:06:41 PM
 */
import java.util.Scanner;

public class Analisis {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        int aprobados = 0;
        int reprobados = 0;
        int contadorEstudiantes = 1;
        
        while(contadorEstudiantes <= 10){
            System.out.print("Escriba el resultado (1 = aprobado, 2 = reprobado): ");
            int resultado = entrada.nextInt();
            
            //Inicia nuevo codigo
            while(resultado != 1 && resultado != 2){
                System.out.print("Escriba el resultado correctamente(1 = aprobado, 2 = reprobado): ");
                resultado = entrada.nextInt();
            }
            //termina nuevo codigo
            
            if(resultado == 1)
                aprobados = aprobados + 1;
            else
                reprobados = reprobados + 1;
            contadorEstudiantes = contadorEstudiantes + 1;
        }
        
        System.out.printf("Aprobados: %d%nReprobados: %d%n", aprobados, reprobados);
        if(aprobados > 8)
            System.out.println("Bono para el instructor!");
    }
}
