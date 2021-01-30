/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jan 20, 2021
 * @time 2:57:37 PM
 */
import java.util.Formatter;
import java.io.FileNotFoundException;

public abstract class CreaDatos {
    /**
     * Maneja la escritura en el archivo.
     */
    private Formatter salida;
    /**
     * Crea o abre un archivo.
     * @param archivo String
     */
    public CreaDatos(String archivo){
        try{
            salida = new Formatter(archivo);
        }
        catch(SecurityException securityException){
            System.err.println("Permiso de escritura denegado. Terminado.");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException){
            System.err.println("Error al abrir el archivo. Terminado.");
            System.exit(1);
        }
    }
    /**
     * Obtiene el objeto que maneja la salida del archivo.
     * @return salida Formatter.
     */
    public Formatter obtenerSalida(){
        return salida;
    }
    /**
     * Agrega cuentas al archivo de cuentas.
     */
    public abstract void agregarRegistros();
    /**
     * Cierra el archivo.
     */
    public void cerrarArchivo(){
        if(salida != null)
            salida.close();
    }
}
