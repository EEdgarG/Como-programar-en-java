/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jan 20, 2021
 * @time 3:30:50 PM
 */
import java.util.Scanner;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

public class AsociarArchivos {
    /**
     * Lee el archivo "antmaest.txt".
     */
    private Scanner entAntMaest;
    /**
     * Lee el archivo "trans.txt".
     */
    private Scanner entTransaccion;
    /**
     * Escribe en el archivo "nuevomaest.txt".
     */
    private Formatter salNuevoMaest;
    /**
     * Escribe en el archivo "registro.txt".
     */
    private Formatter salRegistro;
    
    public AsociarArchivos(String nuevoMaest, String registro) {
        try{
            salNuevoMaest = new Formatter(nuevoMaest);
            salRegistro = new Formatter(registro);
        }
        catch(SecurityException securityException){
            System.err.println("Permiso de escritura denegado. Terminado.");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException){
            System.err.println("Error al abrir el archivo. Terminado.");
        }
    }
    /**
     * Abre el archivo "trans.txt".
     */
    public void abrirEntTransaccion(){
        try{
            entTransaccion = new Scanner(Paths.get("trans.txt"));
        }
        catch(IOException iOException){
            System.err.println("Error al abrir el archivo. Terminado.");
        }
    }
    /**
     * Abre el archivo "antmaest.txt".
     */
    public void abrirEntAntMaest(){
        try{
            entAntMaest = new Scanner(Paths.get("antmaest.txt"));
        }
        catch(IOException iOException){
            System.err.println("Permiso de escritura denegado. Terminado.");
            System.exit(1);
        }
    }
    /**
     * Asocia el archivo maestro "antmaest.txt" y el archivo de
     * transacciones "trans.txt" y escribe los cambios en "nuevomaest.txt".
     */
    public void asociar(){
        abrirEntAntMaest();
        try{
            while(entAntMaest.hasNext()){
                Cuenta cuenta = new Cuenta(entAntMaest.nextInt(),
                    entAntMaest.next(), entAntMaest.next(),
                    entAntMaest.nextDouble());
                abrirEntTransaccion();
                
                empatarCuentaTransaccion(cuenta);
                cerrarEntTransaccion();
                agregarASalNuevoMaest(cuenta);
            }
        }
        catch(NoSuchElementException noSuchElementException){
            System.err.println("El archivo no esta bien formado. Terminado.");
        }
        catch(IllegalStateException illegalStateException){
            System.err.println("Error al leer del archivo. Terminado.");
        }
    }
    public void generarRegistro(){
        abrirEntTransaccion();
        try{
            while(entTransaccion.hasNext()){
                RegistroTransaccion transaccion = new RegistroTransaccion(
                    entTransaccion.nextInt(), entTransaccion.nextDouble());
                
                abrirEntAntMaest();
                
                boolean r = empatarTransaccionCuenta(transaccion);
                
                cerrarEntAntMaest();
                
                if(!r)
                    agregarARegistro(transaccion);
            }
        }
        catch(NoSuchElementException noSuchElementException){
            System.err.println("El archivo no esta bien formado. Terminado.");
        }
        catch(IllegalStateException illegalStateException){
            System.err.println("Error al leer del archivo. Terminado.");
        }
    }
    /**
     * Combina una transacción en la que su número de cuenta
     * es el mismo que en el objeto Cuenta que recibe el método.
     * @param cuenta Cuenta.
     */
    private void empatarCuentaTransaccion(Cuenta cuenta){
        try{
            while(entTransaccion.hasNext()){
                RegistroTransaccion transaccion = new RegistroTransaccion(
                    entTransaccion.nextInt(), entTransaccion.nextDouble());
                
                if(cuenta.obtenerCuenta() == transaccion.obtenerCuenta())
                    cuenta.combinar(transaccion);
            }
                
        }
        catch(NoSuchElementException noSuchElementException){
            System.err.println("El archivo no esta bien formado. Terminado.");
        }
        catch(IllegalStateException illegalStateException){
            System.err.println("Error al leer del archivo. Terminado.");
        }
    }
    private boolean empatarTransaccionCuenta(RegistroTransaccion transaccion){
        try{
            while(entAntMaest.hasNext()){
                Cuenta cuenta = new Cuenta(entAntMaest.nextInt(),
                    entAntMaest.next(), entAntMaest.next(),
                    entAntMaest.nextDouble());
                
                if(transaccion.obtenerCuenta() == cuenta.obtenerCuenta())
                    return true;
            }
        }
        catch(NoSuchElementException noSuchElementException){
            System.err.println("El archvio no esta bien formado. Terminado.");
        }
        catch(IllegalStateException illegalStateException){
            System.err.println("Error al leer del archivo. Terminado.");
        }
        return false;
    }
    /**
     * Agrega una cuenta al archivo "nuevomaest.txt".
     * @param cuenta Cuenta
     */
    private void agregarASalNuevoMaest(Cuenta cuenta){
        try{
            salNuevoMaest.format("%d %s %s %.2f%n",
                    cuenta.obtenerCuenta(), cuenta.obtenerPrimerNombre(),
                    cuenta.obtenerApellidoPaterno(), cuenta.obtenerSaldo());
        }
        catch(FormatterClosedException formatterClosedException){
            System.err.println("Permiso de escritura denegado. Terminado.");
            System.exit(1);
        }
    }
    /**
     * Agrega en el archivo "registro.txt" las incidencias donde existe una
     * transacción en el archivo de transacciones pero no existe el número
     * de cuenta en el archivo maestro.
     * @param transaccion RegistroTransaccion
     */
    private void agregarARegistro(RegistroTransaccion transaccion){
        try{
            salRegistro.format("%d %.2f %s%n", transaccion.obtenerCuenta(),
                    transaccion.obtenerMonto(),
                    "Hay un registro de transacciones no asociado para ese numero de cliente...");
        }
        catch(FormatterClosedException formatterClosedException){
            System.err.println("Permiso de escritura denegado. Terminado.");
            System.exit(1);
        }
    }
    /**
     * Cierra el archivo "antmaest.txt".
     */
    private void cerrarEntAntMaest(){
        if(entAntMaest != null)
            entAntMaest.close();
    }
    /**
     * Cierra el archivo "trans.txt".
     */
    private void cerrarEntTransaccion(){
        if(entTransaccion != null)
            entTransaccion.close();
    }
    /**
     * Cierra el archivo "nuevomaest.txt".
     */
    private void cerrarSalNuevoMaest(){
        if(salNuevoMaest != null)
            salNuevoMaest.close();
    }
    /**
     * Cierra el archivo "registro.txt".
     */
    private void cerrarSalRegistro(){
        if(salRegistro != null)
            salRegistro.close();
    }
    /**
     * Cierra los archivos
     */
    public void cerrarArchivos(){
        cerrarEntAntMaest();
        cerrarEntTransaccion();
        cerrarSalNuevoMaest();
        cerrarSalRegistro();
    }
}
