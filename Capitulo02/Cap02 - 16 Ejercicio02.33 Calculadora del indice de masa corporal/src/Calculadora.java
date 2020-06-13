/**
 *
 * @author EEdgar
 * @version Alfa 1
 * 27/11/17, 1:31pm
 * Lee el peso del usuario y su altura y calcula su indice de masa corporal,
 * incluyendo el aviso del departamento de salud.
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        boolean continuarCiclo = true;
        
        do{
            try{
                System.out.print("Ingresa tu peso en kg: ");
                int peso = entrada.nextInt();
                System.out.print("Ingresa tu altura en metros: ");
                float altura = entrada.nextFloat();

                System.out.printf("El valor BMI es: %f%nVALORES BMI%nBajo peso: menos de 18.5%n",
                        peso / (altura * altura));
                System.out.println("Normal:\tentre 18.5 y 24.9\nSobrepeso: entre 25 y 29.9");
                System.out.println("Obeso:\t30 o más");
                
                continuarCiclo = false;
            }
            catch(InputMismatchException e){
                System.err.printf("%s: Introduce valores adecuados%n", e);
                entrada.nextLine();
                System.gc();
            }
        }while(continuarCiclo);
    }
}
