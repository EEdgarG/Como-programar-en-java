/**
 *
 * @author EEdgar
 * @version Final 1
 * 27/11/17, 12:37pm
 * Obtiene un numero de 5 digitos y lo separa en cada una de sus cifras
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Separacion {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        boolean continuarCiclo = true;
        
        do{
            try{
                System.out.print("Ingresa un número de 5 cifras: ");
                int numero = entrada.nextInt();
                if(numero < 10000 || numero > 99999)
                    throw new IllegalArgumentException("Introduce un número de 5 cifras");

                separaEnDigitos(numero);
                
                continuarCiclo = false;
            }
            catch(InputMismatchException e){
                System.err.printf("%s: Introduce solo números enteros%n", e);
                entrada.nextLine();
            }
            catch(IllegalArgumentException e){
                System.err.printf("%s%n", e);
            }
            finally{
                System.gc();
            }
        }while(continuarCiclo);
    }
    /**
     * Separa un número de 5 cifras en los digitos que lo componen
     * @param a int
     */
    public static void separaEnDigitos(int a){
        int numero1 = a % 10;
        a -= numero1;
        int numero2 = (a % 100) / 10;
        a -= numero2;
        int numero3 = (a % 1000) / 100;
        a -= numero3;
        int numero4 = (a % 10000) / 1000;
        a -= numero4;
        int numero5 = (a % 100000) / 10000;
        System.out.printf("%d   %d   %d   %d   %d%n", numero5, numero4, numero3,
                numero2, numero1);
    }
}
