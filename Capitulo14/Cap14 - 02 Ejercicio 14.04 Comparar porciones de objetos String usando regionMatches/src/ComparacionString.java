/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Recibe dos cadenas de texto del usuario, la cantidad de caracteres a comparar y el índice inicial de comparación.
 * Luego hace la comparación de esos tramos de ambas cadenas con el método regionMatches
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 31/05/2020
 * @time 01:07:47 PM
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class ComparacionString {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese la primer cadena de texto");
        String string1 = entrada.nextLine();
        System.out.println("Ingrese la segunda cadena de texto");
        String string2 = entrada.nextLine();
        
        boolean continuarCiclo = true;
        do{
            try{
                System.out.print("Ingresa la cantidad de letras a comparar: ");
                int cantidad = entrada.nextInt();
                System.out.print("Ingresa el índice inicial de comparación: ");
                int indice = entrada.nextInt();
                
                if(cantidad < 0)
                    throw new IllegalArgumentException("La cantidad de letras a comparar debe ser >= 0");
                if(indice < 0)
                    throw new IllegalArgumentException("El índice inicial de comparacion debe ser >= 0");
                if((cantidad + indice) > string1.length() || (cantidad + indice) > string2.length())
                    throw new IllegalArgumentException("La comparación excede el tamaño de las cadenas de texto");
                
                if(string1.regionMatches(true, indice, string2, indice, cantidad))
                    System.out.println("Los tramos son iguales");
                else
                    System.out.println("Los tramos no son iguales");
                
                continuarCiclo = false;
            }
            catch(InputMismatchException e){
                System.err.printf("%s: %s%n", "Ingresa solo números enteros", e);
                entrada.nextLine();
            }
            catch(IllegalArgumentException e){
                System.err.printf("%s%n", e);
                entrada.nextLine();
            }
            finally{
                System.gc();
            }
        }while(continuarCiclo);
    }
}
