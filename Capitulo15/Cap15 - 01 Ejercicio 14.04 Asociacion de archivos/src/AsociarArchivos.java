
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Formatter;

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Aug 18, 2020
 * @time 1:17:11 PM
 */
public class AsociarArchivos {
    /**
     * Se usa para leer el archivo "antmaest.txt"
     */
    private static Scanner entAntMaest;
    /**
     * Se usa para leer el archivo "trans.txt"
     */
    private static Scanner entTransaccion;
    /**
     * Se usa para escribir en el archivo "nuevomaest.txt"
     */
    private static Formatter salNuevoMaest;
    /**
     * Se usa para escribir en el archivo "registro.txt"
     */
    private static Formatter salRegistro;
    /**
     * Abre dos archivos con nombres definidos en los parametros del
     * constructor y los abre como objetos Scanner
     * @param cuenta String nombre del archivo cuenta
     * @param transaccion String nombre del archivo transaccion
     */
    public AsociarArchivos(String cuenta, String nuevaCuenta, String registro){
        try{
            entAntMaest = new Scanner(Paths.get(cuenta));
            salNuevoMaest =new Formatter(nuevaCuenta);
            salRegistro = new Formatter(registro);
        }
        catch(IOException iOException){
            System.err.println("Error al abrir el archivo. Termiando");
            System.exit(1);
        }
        catch(SecurityException securityException){
            System.err.println("Permiso de escritura denegado. Termiando");
            System.exit(1);
        }
    }
    /**
     * Constructor predeterminado, pasa los nombres de los archivos
     * al constructor de dos parametros String
     */
    public AsociarArchivos(){
        this("antmaest.txt", "nuevomaest.txt", "registro.txt");
    }
    /**
     * Abre el archivo maestro de cuentas
     */
    public void abrirArchivoCuentas(){
        try{
            entAntMaest = new Scanner(Paths.get("antmaest.txt"));
        }
        catch(IOException iOException){
            System.err.println("Error al abrir el archivo. Termiando");
            System.exit(1);
        }
        catch(SecurityException securityException){
            System.err.println("Permiso de escritura denegado. Termiando");
            System.exit(1);
        }
    }
    /**
     * Abre el archivo maestro de transacciones "trans.txt"
     */
    public void abrirArchivoTransacciones(){
        try{
            entTransaccion = new Scanner(Paths.get("trans.txt"));
        }
        catch(IOException iOException){
            System.err.println("Error al abrir el archivo. Termiando");
            System.exit(1);
        }
        catch(SecurityException securityException){
            System.err.println("Permiso de escritura denegado. Termiando");
            System.exit(1);
        }
    }
    /**
     * Compara un objeto Cuenta con los registros del archivo de
     * transacciones y si tienen la misma cuenta se agrega
     * la transacción al objeto Cuenta
     * @param cuenta Cuenta cuenta a comparar
     */
    public void leerArchivoTransacciones(Cuenta cuenta){
        abrirArchivoTransacciones();
        
        try{
            while(entTransaccion.hasNext()){
                RegistroTransaccion transaccion = new RegistroTransaccion(
                    entTransaccion.nextInt(), entTransaccion.nextDouble());
                
                if(cuenta.obtenerCuenta() == transaccion.obtenerCuenta())
                    cuenta.combinar(transaccion);
            }
        }
        catch(NoSuchElementException noSuchElementException){
            System.err.println("El archivo no esta bien formado. Termiando");
        }
        catch(IllegalStateException illegalStateException){
            System.err.println("Error al leer del archivo. Terminado");
        }
        
        cerrarArchivoTransacciones();
    }
    /**
     * Lee el archivo de Cuentas. Compara la transacción del parametro del método
     * con todas las cuentas halladas. Si encuentra una cuenta que coincida con la transacción
     * devuelve true
     * @param transaccion RegistroTransaccion transaccion
     * @return true si encuentra coincidencias de número de cuenta, falso en caso contrario
     */
    public boolean leerArchivoCuentas(RegistroTransaccion transaccion){
        abrirArchivoCuentas();
        boolean existe = false;
        try{
            while(entAntMaest.hasNext()){
                    Cuenta cuenta  = new Cuenta(entAntMaest.nextInt(),
                    entAntMaest.next(), entAntMaest.next(),
                    entAntMaest.nextDouble());// Cuenta actual del archvio cuentas
                    
                    if(transaccion.obtenerCuenta() == cuenta.obtenerCuenta())
                        existe = true;
                }
                cerrarArchivoCuentas();
        }
        catch(NoSuchElementException noSuchElementException){
            System.err.println("El archivo no esta bien formado. Terminado");
        }
        catch(IllegalStateException illegalStateException){
            System.err.println("Error al leer del archivo. Termiando");
        }
        cerrarArchivoCuentas();
        return existe;
    }
    public void asociar(){
        try{
            while(entAntMaest.hasNext()){// Lee el archivo de cuentas
                Cuenta cuenta  = new Cuenta(entAntMaest.nextInt(),
                    entAntMaest.next(), entAntMaest.next(),
                    entAntMaest.nextDouble());// Cuenta actual del archvio cuentas
                
                leerArchivoTransacciones(cuenta);
                
                salNuevoMaest.format("%d %s %s %.2f%n",
                        cuenta.obtenerCuenta(), cuenta.obtenerPrimerNombre(),
                        cuenta.obtenerApellidoPaterno(), cuenta.obtenerSaldo());
            }
            cerrarArchivoCuentas();
            
            abrirArchivoTransacciones();
            while(entTransaccion.hasNext()){
                RegistroTransaccion transaccion = new RegistroTransaccion(
                        entTransaccion.nextInt(), entTransaccion.nextDouble());
                boolean existe = false;
                
                existe = leerArchivoCuentas(transaccion);
                
                if(!existe)
                    salRegistro.format("%d %.2f %s%n",
                          transaccion.obtenerCuenta(), transaccion.obtenerMonto(),
                          "Hay un registro de transacciones no asociado para este numero de cliente");
            }
            cerrarArchivoTransacciones();
        }
        catch(NoSuchElementException noSuchElementException){
            System.err.println("El archivo no esta bien formado. Terminado");
        }
        catch(IllegalStateException illegalStateException){
            System.err.println("Error al leer el archivo. Terminado");
        }
    }
    /**
     * Cierra el archivo maestro de transacciones
     */
    public void cerrarArchivoTransacciones(){
        if(entTransaccion != null)
            entTransaccion.close();
    }
    /**
     * Cierra el archivo maestro de cuentas
     */
    public void cerrarArchivoCuentas(){
        if(entAntMaest != null)
            entAntMaest.close();
    }
    /**
     * Cierra los archivos maestros de cuentas, el nuevo archivo maestro de cuentas
     * y el archivo de registros
     */
    public void cerrarArchivos(){
        if(entAntMaest != null)
            entAntMaest.close();
        if(salNuevoMaest != null)
            salNuevoMaest.close();
        if(salRegistro != null)
            salRegistro.close();
    }
}
