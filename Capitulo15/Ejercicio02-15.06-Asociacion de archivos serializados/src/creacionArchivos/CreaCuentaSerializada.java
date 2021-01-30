package creacionArchivos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jan 21, 2021
 * @time 9:31:11 PM
 */
import Objetos.CuentaSerializada;
import creacionArchivos.CreaDatosSerializados;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.IOException;

public class CreaCuentaSerializada extends CreaDatosSerializados{
    public CreaCuentaSerializada(String archivo){
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
                CuentaSerializada cuenta = new CuentaSerializada(
                    entrada.nextInt(), entrada.next(), entrada.next(),
                    entrada.nextDouble());
                
                super.obtenerSalida().writeObject(cuenta);
            }
            catch(NoSuchElementException noSuchElementException){
                System.err.println("Entrada invalida. Intente de nuevo.");
                entrada.nextLine();
            }
            catch(IOException iOException){
                System.err.println("Error al escribir en el archivo. Terminado.");
                break;
            }
            System.out.print("? ");
        }
    }
}
