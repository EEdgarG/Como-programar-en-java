/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos;

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jan 24, 2021
 * @time 12:33:55 PM
 */
import java.io.Serializable;

public class RegistroSerializado implements Serializable{
    /**
     * Número de cuenta que se añadira al registro.
     */
    private int cuenta;
    /**
     * Mensaje asociado al número de cuenta
     * que se añadira al registro.
     */
    private String mensaje;
    /**
     * Inicializa un objeto RegistroSerializado con los valores
     * proporcionados.
     * @param cuenta int
     * @param mensaje String
     */
    public RegistroSerializado(int cuenta, String mensaje){
        this.cuenta = cuenta;
        this.mensaje = mensaje;
    }
    /**
     * Inicializa un objeto RegistroSerializado con valores
     * predeterminados.
     */
    public RegistroSerializado(){
        this(0, "");
    }
    /**
     * Establece el número de cuenta.
     * @param cuenta int.
     */
    public void establecerCuenta(int cuenta){
        this.cuenta = cuenta;
    }
    /**
     * Obtiene el número de cuenta.
     * @return cuenta int.
     */
    public int obtenerCuenta(){
        return cuenta;
    }
    /**
     * Establece el mensaje.
     * @param mensaje String.
     */
    public void establecerMensaje(String mensaje){
        this.mensaje = mensaje;
    }
    /**
     * Obtiene el mensaje.
     * @return mensaje String.
     */
    public String obtenerMensaje(){
        return mensaje;
    }
}
