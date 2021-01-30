package Objetos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jan 21, 2021
 * @time 9:29:33 PM
 */
import java.io.Serializable;

public class RegistroTransaccionSerializada implements Serializable{
     /**
     * Numero de cuenta de la transacción.
     */
    private int cuenta;
    /**
     * Monto de la transacción efectuada por la cuenta.
     */
    private double montoTransaccion;
    /**
     * Inicializa un objeto RegistroTransaccion a los valores proporcionados.
     * @param cuenta int
     * @param montoTransaccion double
     */
    public RegistroTransaccionSerializada(int cuenta, double montoTransaccion){
        this.cuenta = cuenta;
        this.montoTransaccion = montoTransaccion;
    }
    /**
     * Establece el número de cuenta de donde proviene
     * la transacción.
     * @param cuenta int
     */
    public void establecerCuenta(int cuenta){
        if(cuenta < 0)
            throw new IllegalArgumentException("Cuenta debe ser >= 0");
        
        this.cuenta = cuenta;
    }
    /**
     * Obtiene el número de cuenta.
     * @return cuenta int
     */
    public int obtenerCuenta(){
        return cuenta;
    }
    /**
     * Establece el monto de la transacción a efectura.
     * @param monto double
     */
    public void estableceMonto(double monto){
        this.montoTransaccion = monto;
    }
    /**
     * Obtiene el monto de la transacción.
     * @return montoTransaccion double
     */
    public double obtenerMonto(){
        return montoTransaccion;
    }
}
