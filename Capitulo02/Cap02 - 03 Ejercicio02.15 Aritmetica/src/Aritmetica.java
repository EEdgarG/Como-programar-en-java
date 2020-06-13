/**
 *
 * @author EEdgar
 * @version final 1
 * 26/11/17, 3:17pm
 * Pide al usuario 2 números e imprime la suma, producto, diferencia y cociente.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Aritmetica {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        boolean continuarCiclo = true;
        do{
            try{
                System.out.println("Introduce el primer numero:");
                int numero1 = entrada.nextInt();
                System.out.println("Introduce el segundo numero:");
                int numero2 = entrada.nextInt();
                
                System.out.printf("La suma es: %d%n", numero1 + numero2);

                System.out.printf("El producto es: %d%n", numero1 * numero2);

                System.out.printf("La diferencia es: %d%n", numero1 - numero2);

                System.out.printf("El cociente es: %d%n", numero1 / numero2);
                continuarCiclo = false;
            }
            catch(InputMismatchException e){
                System.err.printf("Introduce solo números enteros. Excepcion: %s%n", e);
                entrada.nextLine();
            }
            catch(ArithmeticException e){
                System.err.printf("El segundo número tiene que ser diferente de cero. Excepción: %s%n", e);
            }
            finally{
                System.gc();
            }
        }while(continuarCiclo);
    }
}
