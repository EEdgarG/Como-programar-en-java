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
 * @time 8:01:25 PM
 */
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class AbreDatosSerializados implements Serializable{
    /**
     * Maneja la lectura de un archivo.
     */
    private ObjectInputStream entrada;
    public AbreDatosSerializados(String archivo){
        try{
            entrada = new ObjectInputStream(
                Files.newInputStream(Paths.get(archivo)));
        }
        catch(IOException iOException){
            System.err.println("Error al abrir el archivo. Terminado.");
            System.exit(1);
        }
    }
    /**
     * Obtiene el objeto que maneja la escritura en el archivo.
     * @return entrada ObjectInputStream.
     */
    public ObjectInputStream obtenerEntrada(){
        return entrada;
    }
    /**
     * Lee un archivo serializado con cuentas o transacciones.
     */
    public abstract void leerRegistros();
    
    /**
     * Cierra el archivo y termina la aplicación.
     */
    public void cerrarArchivo(){
        try{
            if(entrada != null)
                entrada.close();
        }
        catch(IOException iOException){
            System.err.println("Error al cerrar el archivo. Terminado.");
            System.exit(1);
        }
    }
}
