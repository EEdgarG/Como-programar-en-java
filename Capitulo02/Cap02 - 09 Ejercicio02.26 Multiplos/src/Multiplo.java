/**
 *
 * @author EEdgar
 * @version Final 1
 * 27/11/17, 11:48am
 * Lee dos enteros y determina si el primero es multiplo del segundo.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Multiplo {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        boolean continuarCiclo = true;
        
        do{
            try{
                System.out.print("Ingrese el primer número: ");
                int numero1 = entrada.nextInt();
                System.out.print("Ingrese el segundo número: ");
                int numero2 = entrada.nextInt();

                if(numero1 % numero2 == 0)
                    System.out.printf("El numero %d es multiplo de %d%n", numero1, numero2);
                if(numero2 % numero1 == 0)
                    System.out.printf("El numero %d es multiplo de %d%n", numero2, numero1);
                
                continuarCiclo = false;
            }
            catch(InputMismatchException e){
                System.err.printf("Introduce números enteros. Excepción: %s%n", e);
                entrada.nextLine();
            }
            catch(ArithmeticException e){
                System.err.printf("Los números deben ser distintos de cero. Excepción; %s%n", e);
            }
            finally{
                System.gc();
            }
        }while(continuarCiclo);
    }
}
