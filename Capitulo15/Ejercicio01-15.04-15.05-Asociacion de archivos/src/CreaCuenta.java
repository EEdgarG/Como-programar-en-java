


import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jan 20, 2021
 * @time 3:17:18 PM
 */
public class CreaCuenta extends CreaDatos{
    public CreaCuenta(String archivo){
        super(archivo);
    }
    /**
     * Agrega Cuentas a un archivo de cuentas.
     */
    @Override
    public void agregarRegistros(){
        Scanner entrada = new Scanner(System.in);
        
        System.out.printf("%s%n%s%n? ", "Escriba el numero de cuenta, nombre, apellido y saldo.",
                "Para terminar la entrada, escriba EOF.");
        
        while(!entrada.next().equals("EOF")){
            try{
                super.obtenerSalida().format("%d %s %s %.2f%n", entrada.nextInt(), entrada.next(), entrada.next(),
                        entrada.nextDouble());
            }
            catch(FormatterClosedException formatterClosedException){
                System.err.println("Error al escribir en el archivo. Terminado.");
                break;
            }
            catch(NoSuchElementException noSuchElementException){
                System.err.println("Entrada invalida. Intente de nuevo.");
                entrada.nextLine();
            }
            
            System.out.print("? ");
        }
    }
}
