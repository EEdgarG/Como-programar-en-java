/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Ejercicio 15.4 y 15.5
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jan 20, 2021
 * @time 3:13:25 PM
 */
public class PruebaAsociacionArchivos {
    public static void main(String[] args){
        // Agrega las cuentas en el archivo de cuentas.
//        CreaCuenta cuentas = new CreaCuenta("antmaest.txt");
//        cuentas.agregarRegistros();
//        cuentas.cerrarArchivo();
        
        // Agrega las transacciones en el archivo de transacciones.
//        CreaTransaccion transacciones = new CreaTransaccion("trans.txt");
//        transacciones.agregarRegistros();
//        transacciones.cerrarArchivo();
        
        // Asocia un archivo de cuentas y uno de transacciones
        AsociarArchivos archivos = new AsociarArchivos(
                "nuevomaest.txt", "registro.txt");
        archivos.asociar();
        archivos.generarRegistro();
        archivos.cerrarArchivos();
    }
}
