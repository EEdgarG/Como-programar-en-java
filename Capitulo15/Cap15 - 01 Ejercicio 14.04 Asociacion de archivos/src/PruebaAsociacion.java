
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.FormatterClosedException;
import java.nio.file.Paths;
import java.io.IOException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Aug 14, 2020
 * @time 7:41:56 PM
 */
public class PruebaAsociacion {
    private final static OpcionMenu[] opciones = OpcionMenu.values();
    /**
     * Se usa para escribir registros en los archivos "antmaest.txt" y "trans.txt"
     */
    private static Formatter salida;
    /**
     * Se usa para leer el archivo "antmaest.txt"
     */
    private static Scanner entAntMaest;
    /**
     * Se usa para leer el archivo "trans.txt"
     */
    private static Scanner entTransaccion;
//    
//    public static void main(String[] args){
//        // Obtiene la solicitud del usuario (saldo cero, con crédito o con débito)
//        OpcionMenu tipoCuenta = obtenerSolicitud();
//        
//        while(tipoCuenta != OpcionMenu.FIN){
//            switch(tipoCuenta){
//                case AGREGAR_CUENTA:
//                    escribirArchivoCuenta();
//                    
//                    break;
//                case AGREGAR_TRANSACCION:
//                    System.out.printf("%nAgregar transaccion%n");
//                    escribirArchivoTransaccion();
//                    break;
//                case MOSTRAR_CUENTAS:
//                    System.out.printf("%nCuentas en el archivo \".txt\":%n");
//                    leerArchivoCuenta();
//                    
//                    break;
//                case MOSTRAR_TRANSACCIONES:
//                    System.out.printf("%nTransacciones en el archivo \"trans.txt\":%n");
//                    leerArchivoTransaccion();
//                break;
//            }
////            leerArchivoCuenta(tipoCuenta);
//            tipoCuenta = obtenerSolicitud();// Obtiene la solicitud del usuario
//        }
//    }
//    
    /**
     * Obtiene la solicitud del usuario
     * @return OpcionMenu opcion
     */
    private static OpcionMenu obtenerSolicitud(){
        int solicitud = 5;

        // Muestra opciones de solicitud
        System.out.printf("%nEscriba solicitud%n%s%n%s%n%s%n%s%n%s%n",
        " 1 - Agregar una cuenta",
        " 2 - Agregar una transaccion",
        " 3 - Mostrar cuentas",
        " 4 - Mostrar transacciones",
        " 5 - Terminar programa");

        try{
            Scanner entrada = new Scanner(System.in);

            do{// Recibe solicitud del usuario
                System.out.printf("%n? ");
                solicitud = entrada.nextInt();
            }while((solicitud < 1) || (solicitud > 5));
        }
        catch(NoSuchElementException noSuchElementException){
            System.err.println("Entrada invalida. Terminado");
        }
        
        return opciones[solicitud - 1];// Devuelve el valor del enum para la opcion
    }
    /**
     * Abre un archivo en modo salida con el nombre definido en el parametro del método
     * @param nombreArchivo String nombre del archivo
     */
    public static void abrirArchivoEscritura(String nombreArchivo){
        try{
            salida = new Formatter(nombreArchivo);
        }
        catch(SecurityException securityException){
            System.err.println("Permiso de escritura denegado. Terminado");
            System.exit(1);
        }
        catch(FileNotFoundException fileNotFoundException){
            System.err.println("Error al abrir el archivo. Terminado");
            System.exit(1);
        }
    }
    /**
     * Escribe en el archivo cuenta datos de una cuenta
     */
    public static void escribirArchivoCuenta(){
        System.out.printf("%nAgregar cuenta%n");
        System.out.printf("%s%n%s%n? ", "Escriba el n�mero de cuenta, nombre, apellido y saldo.",
            "Para terminar la entrada, escriba el indicador de fin de archivo.");
        abrirArchivoEscritura("antmaest.txt");

        // Escribiendo en el archivo
        Scanner entrada = new Scanner(System.in);
        while(entrada.hasNext()){
            try{
                salida.format("%d %s %s %.2f%n", entrada.nextInt(), entrada.next(), entrada.next(), entrada.nextDouble());
            }
            catch(FormatterClosedException formatterClosedException){
                System.err.println("Error al escribir en el archivo. Terminado");
                System.exit(1);
            }
            catch(NoSuchElementException noSuchElementException){
                System.err.println("Entrada invalida. Intente de nuevo");
                entrada.nextLine();
                System.gc();
            }

            System.out.print("? ");
        }

        if(entrada != null)
            entrada.close();

        if(salida != null)
            salida.close();
    }
    /**
     * Escribe en el archivo transacción una nueva transacción
     */
    public static void escribirArchivoTransaccion(){
        System.out.printf("%nAgregar transaccion%n");
        System.out.printf("%s%n%s%n? ", "Escriba el número de cuenta y monto de la transacción.",
            "Para terminar la entrada, escriba el indicador de fin de archivo.");
        abrirArchivoEscritura("trans.txt");
        
        // Escribiendo en el archivo
        Scanner entrada = new Scanner(System.in);
        while(entrada.hasNext()){
            try{
                salida.format("%d %.2f%n", entrada.nextInt(), entrada.nextDouble());
            }
            catch(FormatterClosedException formatterClosedException){
                System.err.println("Error al escribir en el archivo. Terminado");
                System.exit(1);
            }
            catch(NoSuchElementException noSuchElementException){
                System.err.println("Entrada invalida. Intente de nuevo");
                entrada.nextLine();
                System.gc();
            }

            System.out.print("? ");
        }

        if(entrada != null)
            entrada.close();

        if(salida != null)
            salida.close();
    }
    /**
     * Lee los registros en el archivo de cuenta
     */
    public static void leerArchivoCuenta(){
        // Inicio apertura de archivo
        try{
            String archivo = "antmaest.txt";
            entAntMaest = new Scanner(Paths.get(archivo));
        }
        catch(IOException ioException){
            System.err.println("Error al abrir el archivo. Terminado");
            System.exit(1);
        }
        // Fin apertura de archivo
        
        // Inicio lectura de archivo
        System.out.printf("%-10s%-12s%-12s%10s%n",
            "Cuenta", "Primer nombre", "Apellido paterno", "Saldo");
        
        try{
            while(entAntMaest.hasNext()){
                Cuenta cuenta = new Cuenta(entAntMaest.nextInt(),
                        entAntMaest.next(), entAntMaest.next(), entAntMaest.nextDouble());
                System.out.println(cuenta);
                
            }
        }
        catch(NoSuchElementException noSuchElementException){
            System.err.println("El archivo no esta bien formado. Terminado");
            
        }
        catch(IllegalStateException illegalStateException){
            System.err.println("Error al leer el archivo. Terminado");
        }
        //fin lectura de archivo
        
        //inicio cerrar archivo
        if(entAntMaest != null)
            entAntMaest.close();
    }
    /**
     * Lee los registros en el archivo de transacciones
     */
    public static void leerArchivoTransaccion(){
        // Inicio apertura de archivo
        try{
            String archivo = "trans.txt";
            entTransaccion = new Scanner(Paths.get(archivo));
        }
        catch(IOException ioException){
            System.err.println("Error al abrir el archivo. Terminado");
            System.exit(1);
        }
        // Fin apertura de archivo
        
        // Inicio lectura de archivo
        
        try{
            while(entTransaccion.hasNext()){
                RegistroTransaccion transaccion = new RegistroTransaccion(entTransaccion.nextInt(),
                        entTransaccion.nextDouble());
                System.out.println(transaccion);
                
            }
        }
        catch(NoSuchElementException noSuchElementException){
            System.out.println("El archivo no esta bien formado. Terminado");
            
        }
        catch(IllegalStateException illegalStateException){
            System.out.println("Error al leer el archivo. Terminado");
        }
        //fin lectura de archivo
        
        //inicio cerrar archivo
        if(entTransaccion != null)
            entTransaccion.close();
    }
}
