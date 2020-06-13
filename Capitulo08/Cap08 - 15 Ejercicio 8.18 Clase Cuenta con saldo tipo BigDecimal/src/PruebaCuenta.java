/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Modificación a la clase Cuenta de la sección 3.5.
 * Se cambio el uso de double por BigDecimal en la clase Cuenta para el manejo interno de los números.
 * Se añadio el uso de manejo de excepciones
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 11/06/2020
 * @time 07:01:23 PM
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class PruebaCuenta {
    public static void main(String[] args){
        
        Cuenta cuenta1 = new Cuenta("Jane Green", 50.00);
        Cuenta cuenta2 = new Cuenta("Jhon Blue", 7.53);
        
        //Muestra el saldo inicial de cada objeto
        System.out.printf("Saldo de %s: $%.2f%n", cuenta1.obtenerNombre(), cuenta1.obtenerSaldo());
        System.out.printf("Saldo de %s: $%.2f%n%n", cuenta2.obtenerNombre(), cuenta2.obtenerSaldo());
        
        
        //Crea un objeto Scanner para obtener la entrada de la ventana de comandos
        Scanner entrada = new Scanner(System.in);
        boolean continuarCiclo = true;
        boolean eleccionCuenta = false;
        do{
            try{
                if(eleccionCuenta == false){
                    System.out.print("Escriba el monto a depositar para la cuenta 1: ");
                    double montoDeposito = entrada.nextDouble();
                    System.out.printf("%nSumando %.2f al saldo de cuenta1%n%n", montoDeposito);
                    cuenta1.despositar(montoDeposito);
                    eleccionCuenta = true;
                }
                
                if(eleccionCuenta == true){
                    //Muestra los saldos
                    System.out.printf("Saldo de %s: $%.2f%n", cuenta1.obtenerNombre(), cuenta1.obtenerSaldo());
                    System.out.printf("Saldo de %s: $%.2f%n%n", cuenta2.obtenerNombre(), cuenta2.obtenerSaldo());


                    System.out.print("Escriba el monto a depositar para la cuenta 2: ");
                    double montoDeposito = entrada.nextDouble();
                    System.out.printf("%nSumando %.2f al saldo de cuenta2%n%n", montoDeposito);
                    cuenta2.despositar(montoDeposito);

                    //Muestra los saldos
                    System.out.printf("Saldo de %s: $%.2f%n", cuenta1.obtenerNombre(), cuenta1.obtenerSaldo());
                    System.out.printf("Saldo de %s: $%.2f%n%n", cuenta2.obtenerNombre(), cuenta2.obtenerSaldo());
                }
                
                continuarCiclo = false;
            }
            catch(InputMismatchException | IllegalArgumentException e){
                System.err.println(e);
                entrada.nextLine();
                System.gc();
            }
        }while(continuarCiclo);
    }
}
