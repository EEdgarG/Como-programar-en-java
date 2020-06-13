/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Lee un entero de 4 dígitos introducido por el usuario, y lo cifra de la siguiente manera:
 * Remplaza cada dígito con el resultado de sumarle 7 y obtiene el residuo después de dividir el nuevo valor entre 10
 * Luego intercambia el primer digito con el tercero y el segundo digito con el cuarto.
 * Luego muestra el resultado.
 * Por otra parte
 * Una aplicacion recibe el digito cifrado de 4 digitos y lo decifra invirtiendo el esquema de cifrado para formar el numero original
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 23/04/2020
 * @time 08:24:05 PM
 */
import java.util.Scanner;

public class PruebaCriptografia {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        Cifrado c;
        Descifrado d;
        
        System.out.print("Introduce un entero de 4 dígitos: ");
        int numero = entrada.nextInt();
        while(validarTamano(numero)){
            System.out.print("Ingresa un número de 4 digitos valido: ");
            numero = entrada.nextInt();
        }
        c = new Cifrado(numero);
        int cifra = c.resultado();
        System.out.printf("El numero cifrado es : %d%n", cifra);
        d = new Descifrado(cifra);
        System.out.printf("El numero descifrado es : %d%n", d.resultado());
    }
    /**
     * Si el numero es menor 1000 o mayor a 9999 es verdadero
     * @param numero numero a validar tamaño
     * @return true si esta fuera de rango
     */
    public static boolean validarTamano(int numero){
        return (numero < 1000 || numero > 9999);
    }
}
