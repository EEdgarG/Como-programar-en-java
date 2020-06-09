/**
 *
 * @author EEdgar
 * @version final 1
 * 26/11/17, 5:08pm
 * Obtiene dos números del usuario y muestra el mas grande junto con el mensaje
 * "Es mas grande" si son iguales imprime "Estos numeros son iguales"
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Comparacion {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        boolean continuarCiclo = true;
        do{
            try{
                System.out.println("Ingresa el primer número:");
                int numero1 = entrada.nextInt();
                System.out.println("Ingresa el segundo número:");
                int numero2 = entrada.nextInt();

                compara(numero1, numero2);
                
                continuarCiclo = false;
            }
            catch(InputMismatchException e){
                System.err.printf("Introduce solo números enteros. Excepción: %s%n", e);
                entrada.nextLine();
                System.gc();
            }
        }while(continuarCiclo);
    }
    /**
     * Compara dos enternos, muestra sin son iguales y el mayor de los dos
     * @param a int
     * @param b int
     */
    public static void compara(int a, int b){
        if(a > b)
            System.out.printf("El número %d es mas grande %n", a);
        if(a < b)
            System.out.printf("El número %d es mas grande %n", b);
        if(a == b)
            System.out.printf("Estos números son iguales: %d%n", a);
    }
}
