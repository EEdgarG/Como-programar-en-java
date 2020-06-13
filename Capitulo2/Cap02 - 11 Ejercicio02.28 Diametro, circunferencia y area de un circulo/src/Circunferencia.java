/**
 *
 * @author EEdgar
 * @version Final 1
 * 27/11/17, 12:01pm
 * Recibe el radio de un circulo y calcula su diametro, circunferencia y el area
 * y lo muestra.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Circunferencia {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        boolean continuarCiclo = true;
        
        do{
            try{
                System.out.print("Introduce el radio del circulo: ");
                int radio = entrada.nextInt();

                System.out.printf("El diametro es %d, la circunferencia es %f y el area es %f%n",
                        2 * radio, 2 * Math.PI * radio, Math.PI * radio * radio);
                
                continuarCiclo = false;
            }
            catch(InputMismatchException e){
                System.err.printf("Introduce solo números enteros. Excepción: %s%n", e);
                entrada.nextLine();
                System.gc();
            }
        }while(continuarCiclo);
    }
}
