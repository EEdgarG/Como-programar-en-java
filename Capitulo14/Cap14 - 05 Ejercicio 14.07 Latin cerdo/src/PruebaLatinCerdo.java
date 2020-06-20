/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 20, 2020
 * @time 12:24:55 PM
 */
import java.util.Scanner;
public class PruebaLatinCerdo {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        StringBuilder enunciados = new StringBuilder();
        int continuarCiclo = 1;
        
        do{
            System.out.print("Introduce una oración para convertirla a latin cerdo: ");
            String oracion = entrada.nextLine();


            for(String palabra: LatinCerdo.dividirOracion(oracion)){
                enunciados.append(LatinCerdo.traducirPalabraALatin(palabra)).append(" ");
                LatinCerdo.imprimirPalabraEnLatin(LatinCerdo.traducirPalabraALatin(palabra));
            }
            enunciados.append("\n");
            
            System.out.printf("%n%s%n", enunciados);
            System.out.print("Introduce cualquier tecla para ingresar otra oración (0 para terminar): ");
            continuarCiclo = entrada.nextLine().charAt(0);
        }while(continuarCiclo != '0');
    }
}
