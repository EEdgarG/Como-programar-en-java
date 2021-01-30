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
 * @time 5:34:46 PM
 */
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class CreaDatosSerializados {
    /**
     * Maneja la escritura en un archivo.
     */
    private ObjectOutputStream salida;
    /**
     * Abre un archivo en modo de salida para escribir datos serializados.
     * @param archivo String
     */
    public CreaDatosSerializados(String archivo){
        try{
            salida = new ObjectOutputStream(
                Files.newOutputStream(Paths.get(archivo)));
        }
        catch(IOException iOException){
            System.err.println("Error al abrir el archivo. Terminado.");
            System.exit(1);
        }
    }
    /**
     * Obtiene el objeto que maneja la salida del archivo.
     * @return salida ObjectOutputStream.
     */
    public ObjectOutputStream obtenerSalida(){
        return salida;
    }
    /**
     * Agrega cuentas al archivo de cuentas o
     * registros al archivo de registros.
     */
    public abstract void agregarRegistros();
    /**
     * Cierra el archivo.
     */
    public void cerrarArchivo(){
        try{
            if(salida != null)
                salida.close();
        }
        catch(IOException iOException){
            System.err.println("Error al cerrar el archivo. Terminado.");
        }
    }
}
