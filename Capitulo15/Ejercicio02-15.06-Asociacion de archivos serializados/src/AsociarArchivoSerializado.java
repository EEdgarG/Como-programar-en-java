/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jan 24, 2021
 * @time 10:22:51 AM
 */

import Objetos.CuentaSerializada;
import Objetos.RegistroTransaccionSerializada;
import Objetos.RegistroSerializado;
import java.util.NoSuchElementException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AsociarArchivoSerializado {
    /**
     * Lee el archivo maestro "antmaest.ser".
     */
    private ObjectInputStream entAntMaest;
    /**
     * Lee el archivo de registro "trans.ser".
     */
    private ObjectInputStream entTransaccion;
    /**
     * Escribe en el nuevo archivo maestro "nuevomaest.ser".
     */
    private ObjectOutputStream salNuevoMaest;
    /**
     * Escribe en el archivo de registros "registro.ser".
     */
    private ObjectOutputStream salRegistro;
    /**
     * Crea y abre los archivos de registro y nuevo maestro en modo
     * salida.
     * @param nuevoMaest ObjectOutputStream
     * @param registro ObjectOutputStream
     */
    public AsociarArchivoSerializado(String nuevoMaest, String registro){
        try{
            salNuevoMaest = new ObjectOutputStream(
                Files.newOutputStream(Paths.get(nuevoMaest)));
            
            salRegistro = new ObjectOutputStream(
                Files.newOutputStream(Paths.get(registro)));
        }
        catch(IOException iOException){
            System.err.println("Error al abrir el archivo. Terminado.");
            System.exit(1);
        }
    }
    /**
     * Cierra el archivo nuevo maestro que se encuentra en modo salida
     * (escritura).
     */
    private void cerrarSalNuevoMaest(){
        try{
            if(salNuevoMaest != null)
                salNuevoMaest.close();
        }
        catch(IOException iOException){
            System.err.println("Error al cerrar el archivo. Terminado.");
            System.exit(1);
        }
    }
    /**
     * Cierra el archivo de registro que se se encuentra en modo salida
     * (escritura).
     */
    private void cerrarSalRegistro(){
        try{
            if(salRegistro != null)
                salRegistro.close();
        }
        catch(IOException iOException){
            System.err.println("Error al cerrar el archivo. Terminado.");
            System.exit(1);
        }
    }
    /**
     * Abre el archivo anterior maestro en modo de entrada (lectura),
     * "antmaest.ser".
     */
    private void abrirEntAntMaest(){
        try{
            entAntMaest = new ObjectInputStream(
                Files.newInputStream(Paths.get("antmaest.ser")));
        }
        catch(IOException iOException){
            System.err.println("Error al abrir el archivo. Terminado.");
            System.exit(1);
        }
    }
    /**
     * Cierra el archivo anterior maestro "antmaest.ser".
     */
    private void cerrarEntAntMaest(){
        try{
            if(entAntMaest != null)
                entAntMaest.close();
        }
        catch(IOException iOException){
            System.err.println("Error al cerrar el archivo. Terminado.");
            System.exit(1);
        }
    }
    /**
     * Abre el archivo de transacciones en modo de entrada (lectura),
     * "trans.ser".
     */
    private void abrirEntTransaccion(){
        try{
            entTransaccion = new ObjectInputStream(
                Files.newInputStream(Paths.get("trans.ser")));
        }
        catch(IOException iOException){
            System.err.println("Error al abrir el archivo. Terminado.");
            System.exit(1);
        }
    }
    /**
     * Cierra el archivo de transacciones "trans.ser".
     */
    private void cerrarEntTransaccion(){
        try{
            if(entTransaccion != null){
                entTransaccion.close();
            }
        }
        catch(IOException iOException){
            System.err.println("Error al cerrar el archivo. Terminado.");
            System.exit(1);
        }
    }
    /**
     * Cierra todos los archivos que se encuentran abiertos.
     */
    public void cerrarArchivos(){
        cerrarSalNuevoMaest();
        cerrarSalRegistro();
        cerrarEntAntMaest();
        cerrarEntTransaccion();
    }
    /**
     * Asocia el archivo maestro "antmaest.ser" y el archivo de transaccioes
     * "trans.ser" y escribe los cambios en "nuevomaest.ser".
     */
    public void asociar(){
        abrirEntAntMaest();
        try{
            while(true){
                CuentaSerializada cuenta =
                        (CuentaSerializada) entAntMaest.readObject();
                
                abrirEntTransaccion();
                empatarCuentaTransaccion(cuenta);
                cerrarEntTransaccion();
                agregarASalNuevoMaest(cuenta);
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
    /**
     * Combina una transacción en la que su número de cuenta es el
     * mismo que en el objeto CuentaSerializada que recibe el método.
     * @param cuenta CuentaSerializada.
     */
    private void empatarCuentaTransaccion(CuentaSerializada cuenta){
        try{
            while(true){
                RegistroTransaccionSerializada transaccion =
                        (RegistroTransaccionSerializada) entTransaccion.readObject();
                
                if(cuenta.obtenerCuenta() == transaccion.obtenerCuenta())
                    cuenta.combinar(transaccion);
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
    /**
     * Agrega una cuenta al archivo "nuevomaest.ser".
     * @param cuenta CuentaSerializada.
     */
    private void agregarASalNuevoMaest(CuentaSerializada cuenta){
        try{
            salNuevoMaest.writeObject(cuenta);
        }
        catch(NoSuchElementException noSuchElementException){
            System.err.println("Entrada invalida. Intente de nuevo.");
        }
        catch(IOException iOException){
            System.err.println("Error al escribir en el archivo. Terminado.");
            System.exit(1);
        }
    }
    
    public void generarRegistro(){
        abrirEntTransaccion();
        try{
            while(true){
                RegistroTransaccionSerializada transaccion =
                        (RegistroTransaccionSerializada) entTransaccion.readObject();
                
                abrirEntAntMaest();
                
                boolean r = empatarTransaccionCuenta(transaccion);
                
                cerrarEntAntMaest();
                
                if(!r)
                    agregarARegistro(transaccion.obtenerCuenta());
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
    /**
     * Si una transacción no empata con ninguna cuenta en el archivo
     * maestro "antmaest.se" devuelve false, en caso de que
     * si empate devuelve true.
     * @param transaccion RegistroTransaccionSerializada
     * @return boolean
     */
    private boolean empatarTransaccionCuenta(RegistroTransaccionSerializada transaccion){
        try{
            while(true){
                CuentaSerializada cuenta =
                        (CuentaSerializada) entAntMaest.readObject();
                
                if(transaccion.obtenerCuenta() == cuenta.obtenerCuenta())
                    return true;
            }
        }
        catch(EOFException eOFException){
            System.out.println("%nNo hay mas registros%n");
        }
        catch(ClassNotFoundException classNotFoundException){
            System.err.println("Tipo de objeto invalido. Terminado.");
        }
        catch(IOException iOException){
            System.err.println("Error al escribir en el archivo. Terminado.");
        }
        return false;
    }
    /**
     * Agrega un objeto RegistroSerializado al archivo de registro
     * "registro.ser".
     * @param numeroCuenta 
     */
    private void agregarARegistro(int numeroCuenta){
        try{
            RegistroSerializado registro = new RegistroSerializado(
                numeroCuenta, "Hay un registro de transacciones no asociado para ese numero de cliente...");
            salRegistro.writeObject(registro);
        }
        catch(NoSuchElementException noSuchElementException){
            System.err.println("Entrada invalida. Intente de nuevo.");
        }
        catch(IOException iOException){
            System.err.println("Error al escribir en el archivo. Terminado.");
            System.exit(1);
        }
    }
}
