/**
 *
 * @author EEdgar
 * @version Final 1
 * 26/11/17, 10:16pm
 * Lee un entero y determina si es par o impar
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Par {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        boolean continuarCiclo = true;
        
        do{
            try{
                System.out.printf("Ingresa un número: ");
                int numero = entrada.nextInt();

                if(numero % 2 == 0)
                    System.out.printf("El numero %d es par%n", numero);
                if(numero % 2 != 0)
                    System.out.printf("El numero %d es impar%n", numero);
                
                continuarCiclo = false;
            }
            catch(InputMismatchException e){
                System.err.printf("Introduce solo número enteros. Excepción: %s%n", e);
                entrada.nextLine();
                System.gc();
            }
        }while(continuarCiclo);
    }
}
