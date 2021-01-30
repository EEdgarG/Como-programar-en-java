/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abrirArchivos;

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jan 24, 2021
 * @time 9:55:40 AM
 */

import Objetos.RegistroTransaccionSerializada;
import java.io.EOFException;
import java.io.IOException;

public class AbreTransaccionSerializada extends AbreDatosSerializados{
    public AbreTransaccionSerializada(String archivo){
        super(archivo);
    }
    /**
     * Lee los registros de un archivo de transacciones
     * que se encuentra serializado.
     */
    @Override
    public void leerRegistros(){
        System.out.printf("%-10s%10s%n",
                "Cuenta", "Saldo");
        
        try{
            while(true){
                RegistroTransaccionSerializada transaccion = 
                        (RegistroTransaccionSerializada) super.obtenerEntrada().readObject();
                
                // Muestra el contenido del registro.
                System.out.printf("%-10d%-10.2f%n",
                        transaccion.obtenerCuenta(), transaccion.obtenerMonto());
            }
        }
        catch(EOFException eOFException){
            System.out.printf("%nNo hay mas registros%n");
        }
        catch(ClassNotFoundException classNotFoundExeption){
            System.err.println("Tipo de objeto invalido. Terminado.");
        }
        catch(IOException iOException){
            System.err.printf("Error al leer del archivo. Terminado.");
        }
    }
}
