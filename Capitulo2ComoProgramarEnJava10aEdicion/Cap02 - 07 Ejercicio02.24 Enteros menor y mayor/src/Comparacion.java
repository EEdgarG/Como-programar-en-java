/**
 *
 * @author EEdgar
 * @version Final 1
 * 26/11/17, 9:56pm
 * Lee 5 numeros dados por el usuario e imprime solo el mayor y el menor.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Comparacion {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        boolean continuarCiclo = true;
        
        do{
            try{
                System.out.print("Ingresa el primer número: ");
                int numero1 = entrada.nextInt();
                System.out.print("Ingresa el segundo número: ");
                int numero2 = entrada.nextInt();
                System.out.print("Ingresa el tercer número: ");
                int numero3 = entrada.nextInt();
                System.out.print("Ingresa el cuarto número: ");
                int numero4 = entrada.nextInt();
                System.out.print("Ingresa el quinto número: ");
                int numero5 = entrada.nextInt();

                mayorDeCincoNumeros(numero1, numero2, numero3, numero4, numero5);

                menorDeCincoNumeros(numero1, numero2, numero3, numero4, numero5);
                
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
     * Muestra el mayor de 5 números ingresados
     * @param a int
     * @param b int
     * @param c int
     * @param d int
     * @param e int
     */
    public static void mayorDeCincoNumeros(int a, int b, int c, int d, int e){
        if(a > b && a > c && a > d
                        && a > e)
                    System.out.printf("El número %d es el mayor%n", a);
                if(b > a && b > c && b > d
                        && b > e)
                    System.out.printf("El número %d es el mayor%n", b);
                if(c > a && c > b && c > d
                        && c > e)
                    System.out.printf("El número %d es el mayor%n", c);
                if(d > a && d > b && d > c
                        && d > e)
                    System.out.printf("El número %d es el mayor%n", d);
                if(e > a && e > b && e > c
                        && e > d)
                    System.out.printf("El número %d es el mayor%n", e);
    }
    /**
     * Muestra el menor de 5 números
     * @param a int
     * @param b int
     * @param c int 
     * @param d int
     * @param e int
     */
    public static void menorDeCincoNumeros(int a, int b, int c, int d, int e){
        if(a < b && a < c && a < d
                        && a < e)
                    System.out.printf("El número %d es el menor%n", a);
                if(b < a && b < c && b < d
                        && b < e)
                    System.out.printf("El número %d es el menor%n", b);
                if(c < a && c < b && c < d
                        && c < e)
                    System.out.printf("El número %d es el menor%n", c);
                if(d < a && d < b && d < c
                        && d < e)
                    System.out.printf("El número %d es el menor%n", d);
                if(e < a && e < b && e < c
                        && e < d)
                    System.out.printf("El número %d es el menor%n", e);
    }
}
