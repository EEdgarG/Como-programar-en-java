/**
 *
 * @author EEdgar
 * @version Final 1
 * 26/11/17, 5:15pm
 * Recibe 3 enteros del usuario y muestra la suma, promedio (entero), producto y
 * menor y mayor de esos números.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Aritmetica {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
      
        boolean continuarCiclo = true;
        do{
            try{
                System.out.println("Ingresa el primer número:");
                int numero1 = entrada.nextInt();
                System.out.println("Ingresa el segundo número:");
                int numero2 = entrada.nextInt();
                System.out.println("Ingresa el tercer número:");
                int numero3 = entrada.nextInt();

                System.out.printf("La suma es %d%n", suma(numero1, numero2, numero3));

                System.out.printf("El promedio es %d%n", suma(numero1, numero2, numero3) / 3);

                System.out.printf("El producto es %d%n", multiplicacion(numero1, numero2, numero3));

                //mayor
                mayorTresNumeros(numero1, numero2, numero3);

                //menor
                menorTresNumeros(numero1, numero2, numero3);
                
                continuarCiclo = false;
            }
            catch(InputMismatchException e){
                System.err.printf("Introudce solo números enteros. Excepción: %s%n", e);
                entrada.nextLine();
                System.gc();
            }
        }while(continuarCiclo);
    }
    /**
     * Devuelve la suma de 3 números
     * @param a int 
     * @param b int 
     * @param c int
     * @return int
     */
    public static int suma(int a, int b, int c){
        return a + b + c;
    }
    /**
     * Devuelve la multiplicación de 3 números
     * @param a int
     * @param b int
     * @param c int
     * @return int
     */
    public static int multiplicacion(int a, int b, int c){
        return a * b * c;
    }
    /**
     * Muestra el mayor de 3 números ingresados
     * @param a int
     * @param b int
     * @param c int
     */
    public static void mayorTresNumeros(int a, int b, int c){
        if(a > b && a > c)
            System.out.printf("El número %d es el mayor%n", a);
        if(b > a && b > c)
            System.out.printf("El número %d es el mayor%n", b);
        if(c > a && c > b)
            System.out.printf("El numero %d es el mayor%n", c);
    }
    /**
     * Muestra el menor de 3 números ingresados
     * @param a int
     * @param b int
     * @param c int
     */
    public static void menorTresNumeros(int a, int b, int c){
        if(a < b && a < c)
            System.out.printf("El numero %d es el menor%n", a);
        if(b < a && b < c)
            System.out.printf("El numero %d es el menor%n", b);
        if(c < a && c < b)
            System.out.printf("El numero %d es el menor%n", c);
    }
}
