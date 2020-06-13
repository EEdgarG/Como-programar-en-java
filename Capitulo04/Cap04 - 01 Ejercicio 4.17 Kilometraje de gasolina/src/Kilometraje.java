/**
 * Calcula los kilómetros por litro de cada viaje y del total de los viajes
 * 
 * Inicializa las variables
 * Introduce kilómetros recorridos y litros usados
 * Suma el total de kilómetros recorridos y el total de litros usados
 * Calcula el rendimiento actual
 * Calcula el rendimiento total
 * Muestra el resultado
 * 
 * Inicializa litrosTotales en cero
 * Inicializa kilometrosTotales en cero
 * Pedir al usuario la cantidad de kilómetros recorridos
 * Recibe en la entrada los kilómetros recorridos (puede ser el centinela)
 *  Pide al usuario la cantidad de litros usados
 *  Suma los kilómetros recorridos a kilometrosTotales
 *  Suma los litros usados a litrosTotales
 *  Divide los kilómetros recorridos entre los litros usados y los imprime en pantalla
 *  Divide kilometrosTotales entre litrosTotales y los imprime en pantalla
 *  Pedir al usuario la cantidad de kilómetros recorridos
 *  Recibe en la entrada los kilómetros recorridos (puede ser el centinela)
 */
/**
 *
 * @author eedua
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kilometraje {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        boolean continuarCiclo = true;
        int litrosTotales = 0;
        int kilometrosTotales = 0;
        int kilometros = 0;
        
        do{
            try{
                System.out.print("\nIntroduce los kilometros recorridos (-1 para terminar): ");
                kilometros = entrada.nextInt();
                while(kilometros != -1){
                    System.out.print("Introduce los litros usados: ");
                    int litros = entrada.nextInt();

                    litrosTotales += litros;
                    kilometrosTotales += kilometros;

                    System.out.printf("El rendimiento es de %f kilometros por litro%n", (float)kilometros / litros);
                    System.out.printf("El rendimiento total es de %f kilometros por litro%n", (float)kilometrosTotales / litrosTotales);
                    System.out.print("\nIntroduce los kilometros recorridos (-1 para terminar): ");
                    kilometros = entrada.nextInt();
                }
                
                continuarCiclo = false;
            }
            catch(InputMismatchException e){
                System.err.printf("%s: Se deben introducir números enteros unicamente... prueba de nuevo%n", e);
                entrada.nextLine();
                System.gc();
            }
        }while(continuarCiclo);
    }
}
