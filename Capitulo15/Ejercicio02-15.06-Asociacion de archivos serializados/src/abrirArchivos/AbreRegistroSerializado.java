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
 * @time 12:48:06 PM
 */

import Objetos.RegistroSerializado;
import java.io.EOFException;
import java.io.IOException;

public class AbreRegistroSerializado extends AbreDatosSerializados{
    public AbreRegistroSerializado(String archivo){
        super(archivo);
    }
    /**
     * Lee los registros de un archivo de registros que se encuenta
     * serializado.
     */
    @Override
    public void leerRegistros(){
        System.out.printf("%-10s%-12s%n", "Cuenta", "Mensaje");
        
        try{
            while(true){
                RegistroSerializado registro =
                        (RegistroSerializado) super.obtenerEntrada().readObject();
                
                // Muestra el contenido del registro.
                System.out.printf("%-10d%s%n",
                        registro.obtenerCuenta(), registro.obtenerMensaje());
            }
        }
        catch(EOFException eOFException){
            System.out.printf("%nNo hay mas registros%n");
        }
        catch(ClassNotFoundException classNotFoundException){
            System.err.println("Tipo de objeto invalido. Terminado.");
        }
        catch(IOException iOException){
            System.err.println("Error al leer del archivo. Terminado.");
        }
    }
}
