/**
 *
 * @author EEdgar
 * @version Final 1
 * 27/11/17, 1:14pm
 * Recibe 5 números e imprime la cantidad de negativos, positivos y ceros.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Positivos {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        boolean continuarCiclo = true;
        
        do{
            try{
                System.out.print("Escribe el primer número: ");
                int numero1 = entrada.nextInt();
                System.out.print("Escribe el segundo número: ");
                int numero2 = entrada.nextInt();
                System.out.print("Escribe el tercer número: ");
                int numero3 = entrada.nextInt();
                System.out.print("Escribe el cuarto número: ");
                int numero4 = entrada.nextInt();
                System.out.print("Escribe el quinto número: ");
                int numero5 = entrada.nextInt();

                int negativos = cuentaNegativos(numero1, numero2, numero3, numero4, numero5);

                int positivos = cuentaPositivos(numero1, numero2, numero3, numero4, numero5);

                int iguales = cuentaIguales(numero1, numero2, numero3, numero4, numero5);

                System.out.printf("Mayores: %d. Menores: %d. Iguales: %d%n",
                        positivos, negativos, iguales);
                
                continuarCiclo = false;
            }
            catch(InputMismatchException e){
                System.err.printf("%s: Introduce solo números enteros%n", e);
                entrada.nextLine();
                System.gc();
            }
        }while(continuarCiclo);
    }
    /**
     * Devuelve la cuenta de numeros positivos en la lista de parametros del metodo
     * @param numeros int[]
     * @return int
     */
    public static int cuentaPositivos(int ... numeros){
        int positivos = 0;
        
        for(int numero: numeros){
            if(numero > 0)
                positivos++;
        }
        
        return positivos;
    }
    /**
     * Devuelve la cantidad de números negativos en el parametro del metodo
     * @param numeros int[]
     * @return int
     */
    public static int cuentaNegativos(int ... numeros){
        int negativos = 0;
        
        for(int numero: numeros){
            if(numero < 0)
                negativos++;
        }
        
        return negativos;
    }
    /**
     * Devuelve la cantidad de números iguales a cero en el parametro del metodo
     * @param numeros int[]
     * @return int
     */
    public static int cuentaIguales(int ... numeros){
        int iguales = 0;
        
        for(int numero: numeros){
            if(numero == 0)
                iguales++;
        }
        
        return iguales;
    }
}
