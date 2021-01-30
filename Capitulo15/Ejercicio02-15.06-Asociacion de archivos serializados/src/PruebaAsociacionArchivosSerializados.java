import creacionArchivos.CreaTransaccionSerializada;
import abrirArchivos.AbreCuentaSerializada;
import abrirArchivos.AbreTransaccionSerializada;
import abrirArchivos.AbreRegistroSerializado;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jan 21, 2021
 * @time 9:52:41 PM
 */
public class PruebaAsociacionArchivosSerializados {
    public static void main(String[] args){
        // Añade cuentas y transacciones.
//        CreaCuentaSerializada cuentas = new CreaCuentaSerializada("antmaest.ser");
//        cuentas.agregarRegistros();
//        cuentas.cerrarArchivo();
//        
//        CreaTransaccionSerializada transacciones = new CreaTransaccionSerializada("trans.ser");
//        transacciones.agregarRegistros();
//        transacciones.cerrarArchivo();
//        // Termina de añadir cuentas y transacciones.
        
        // Muestra cuentas y transacciones en los archivos.
        AbreCuentaSerializada abrirCuentas = new AbreCuentaSerializada("antmaest.ser");
        abrirCuentas.leerRegistros();
        abrirCuentas.cerrarArchivo();
        
        AbreTransaccionSerializada abreTransaccion = new AbreTransaccionSerializada("trans.ser");
        abreTransaccion.leerRegistros();
        abreTransaccion.cerrarArchivo();
        // Termina de mostrar cuentas y  transacciones en los archivos.
        
        // Asocia archivos
        AsociarArchivoSerializado asociar = new AsociarArchivoSerializado("nuevomaest.ser", "registro.ser");
        asociar.asociar();
        asociar.generarRegistro();
        asociar.cerrarArchivos();
        // Termina de asociar archivos
        
        // Muestra el contenido del nuevo archivo maestro y de registro.
        AbreCuentaSerializada nuevoMaest = new AbreCuentaSerializada("nuevomaest.ser");
        nuevoMaest.leerRegistros();
        nuevoMaest.cerrarArchivo();
        
        AbreRegistroSerializado registro = new AbreRegistroSerializado("registro.ser");
        registro.leerRegistros();
        registro.cerrarArchivo();
        // Termina de mostrar el contenido de los nuevos archivos.
    }
}
