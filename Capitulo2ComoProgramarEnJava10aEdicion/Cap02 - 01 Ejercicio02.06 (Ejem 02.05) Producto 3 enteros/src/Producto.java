/**
 *  Realiza la multiplicación de 3 enteros ingresados por el usuario
 * Se hace el añadido de uso de manejo de excepciones
 * @author EEdgar
 * @version final version 3
 * Domingo 26/noviembre/2017, 2:42pm
 * Calcula el producto de tres enteros
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Producto {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        boolean continuarCiclo = true;
        
        do{
            try{
                System.out.println("Introduce el primer entero:");
                int producto = entrada.nextInt();

                System.out.println("Introduce el segundo entero:");
                producto *= entrada.nextInt();

                System.out.println("Introduce el tercer entero:");
                producto *= entrada.nextInt();

                System.out.printf("El producto es: %d%n", producto);
                
                continuarCiclo = false;
            }
            catch(InputMismatchException inputMismatchException){
                System.err.printf("Se deben ingresar solo números enteros. Excepcion: %s%n", inputMismatchException);
                entrada.nextLine();//descarta la entrada para que el usuario intente de nuevo
                System.gc();
            }
        }while(continuarCiclo);
    }
}