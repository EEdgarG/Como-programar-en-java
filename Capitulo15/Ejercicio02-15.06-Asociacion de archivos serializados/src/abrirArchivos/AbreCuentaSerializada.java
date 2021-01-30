/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abrirArchivos;

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jan 22, 2021
 * @time 8:01:02 PM
 */

import Objetos.CuentaSerializada;
import java.io.IOException;
import java.io.EOFException;

public class AbreCuentaSerializada extends AbreDatosSerializados{
    public AbreCuentaSerializada(String archivo){
        super(archivo);
    }
    /**
     * Lee los registros de un archivo de cuentas
     * que se encuentra serializado.
     */
    @Override
    public void leerRegistros(){
        System.out.printf("%-10s%-12s%-12s%10s%n",
                "Cuenta", "Primer nombre", "Apellido paterno", "Saldo");
        
        try{
            while(true){
                CuentaSerializada cuenta =
                        (CuentaSerializada) super.obtenerEntrada().readObject();
                
                // Muestra el contenido del registro.
                System.out.printf("%-10d%-12s%-12s%10.2f%n",
                        cuenta.obtenerCuenta(), cuenta.obtenerPrimerNombre(),
                        cuenta.obtenerApellidoPaterno(), cuenta.obtenerSaldo());
            }
        }
        catch(EOFException eOFException){
            System.out.printf("%nNo hay mas registros%n");
        }
        catch(ClassNotFoundException classNotFoundException){
            System.err.println("Tipo de objeto invalido. Terminado.");
        }
        catch(IOException iOException){
            System.err.printf("Error al leer del archivo. Terminado.");
        }
    }
}
