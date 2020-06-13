/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 20/04/2020
 * @time 08:41:27 PM
 */
import java.util.Scanner;

public class BinarioDecimal {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Introduce un numero en binario: ");
        long binario = entrada.nextLong();
        
//        System.out.printf("El numero ingresado es de %d digitos%n", validarTamano(binario));
        
        convertirDecimal(binario);
    }
    /**
     * Muestra la cantidad de digitos que componen un numero
     * @param numero Numero a analizar cantidad de digitos
     * @return Cantidad de digitos que componen el numero analizado
     */
    public static int validarTamano(long numero){
        long tam = 1;
        int i = 0;
        while((numero / tam) > 0 ){
            tam *= 10;
            i++;
        }
        return i;
    }
    /**
     * Convierte un numero escrito en binario a decimal
     * @param numero Numero en binario
     */
    public static void convertirDecimal(long numero){
        long potencia = 10; //< obtiene los digitos uno por uno de menor a mayor
        int contador = 0;
        int decimal = 0;
        while(numero > 0){
            long digito = (numero % potencia);//<digito es el menos significativo
            potencia *= 10;//<al aumentar el valor 10 veces se pasa de las unidades a las decenas a las centenas etc
            numero -= digito;//<se realiza una resta para ir eliminando los digitos que ya se han revisado
            digito /= (potencia / 100);//<Se deja el numero a su digito significativo
            
            if(digito == 1)
                decimal += Math.pow(2, contador);//<Contador es cero al inicio
            contador++;//<Define la potencia a la que tiene que ser elevado el digito
            
//            System.out.printf("%10d %10d %10d%n", numero, digito, contador);
        }
        System.out.printf("El valor en decimal es %d%n", decimal);
        
    }
}
