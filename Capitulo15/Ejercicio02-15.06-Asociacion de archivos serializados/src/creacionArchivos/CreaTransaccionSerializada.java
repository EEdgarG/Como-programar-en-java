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
 * @time 9:44:33 PM
 */
import Objetos.RegistroTransaccionSerializada;
import creacionArchivos.CreaDatosSerializados;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.IOException;

public class CreaTransaccionSerializada extends CreaDatosSerializados{
    public CreaTransaccionSerializada(String archivo){
        super(archivo);
    }
    @Override
    public void agregarRegistros(){
        Scanner entrada = new Scanner(System.in);
        
        System.out.printf("%s%n%s%n?",
                "Escriba el numero de cuenta y el monto de la transaccion",
                "Para terminar la entrada escriba EOF.");
        
        while(!entrada.next().equals("EOF")){
            try{
                RegistroTransaccionSerializada transaccion =
                        new RegistroTransaccionSerializada(entrada.nextInt(),
                            entrada.nextDouble());
                
                super.obtenerSalida().writeObject(transaccion);
            }
            catch(NoSuchElementException noSuchElementException){
                System.err.println("Entrada invalida. Intente de nuevo.");
                entrada.nextLine();
            }
            catch(IOException iOException){
                System.err.println("Error al escribir en el archivo. Terminado");
                break;
            }
            System.out.print("? ");
        }
    }
}
