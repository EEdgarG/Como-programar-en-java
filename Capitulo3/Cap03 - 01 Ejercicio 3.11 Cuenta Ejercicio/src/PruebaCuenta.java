
/**
 *
 * @author EEdgar
 * @version Alfa 2 28/11/17, 7:2pm
 * Clase prueba de la clase Cuenta.java
 */

import java.util.Scanner;

public class PruebaCuenta{

    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        
        //Creamos dos objetos cuenta
        Cuenta cuenta1 = new Cuenta("Edgar", 50.00);
        Cuenta cuenta2 = new Cuenta("Eduardo", 0);
        
        //Muestra la informacion de las cuentas
        mostrarCuenta(cuenta1);
        mostrarCuenta(cuenta2);
        
        //Se hacen modificaciones a la cuenta1
        cuenta1.depositar(100);
        
        //Se muestran las cuentas nuevamente
        mostrarCuenta(cuenta1);
        mostrarCuenta(cuenta2);
        
        //Se modifica la cuenta2
        cuenta2.depositar(400);
        
        //Se muestran las cuentas
        mostrarCuenta(cuenta1);
        mostrarCuenta(cuenta2);
        
        //Se modifican ambas cuentas
        cuenta1.retirar(50);
        cuenta2.retirar(100);
        
        //Se muestran ambas cuentas
        mostrarCuenta(cuenta1);
        mostrarCuenta(cuenta2);
    }
    
    /**
     * Muestra la informacion de un objeto Cuenta
     * @param unaCuenta La cuenta que se mostrara
     */
    public static void mostrarCuenta(Cuenta unaCuenta){
        System.out.printf("%s%n%n", unaCuenta);
    }
}
