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
 * @time 9:25:02 PM
 */
import java.io.Serializable;

public class CuentaSerializada implements Serializable{
    private int cuenta;
    private String primerNombre;
    private String apellidoPaterno;
    private double saldo;
    /**
     * Inicializa un objeto Cuenta con valores predeterminados.
     */
    public CuentaSerializada(){
        this(0, "", "", 0.0);
    }
    /**
     * Inicializa un objeto Cuenta a los valores proporcionados.
     * @param cuenta int
     * @param primerNombre String
     * @param apellidoPaterno String
     * @param saldo double
     */
    public CuentaSerializada(int cuenta, String primerNombre, String apellidoPaterno, double saldo){
        this.cuenta = cuenta;
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.saldo = saldo;
    }
    /**
     * Establece el número de cuenta.
     * @param cuenta int
     */
    public void establecerCuenta(int cuenta){
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
     * Establece el primer nombre de la cuenta.
     * @param primerNombre String
     */
    public void establecerPrimerNombre(String primerNombre){
        this.primerNombre = primerNombre;
    }
    /**
     * Obtiene el primer nombre de la cuenta.
     * @return primerNombre String
     */
    public String obtenerPrimerNombre(){
        return primerNombre;
    }
    /**
     * Establece el apellido paterno de la cuenta.
     * @param apellidoPaterno String
     */
    public void establecerApellidoPaterno(String apellidoPaterno){
        this.apellidoPaterno = apellidoPaterno;
    }
    /**
     * Obtiene el apellido paterno.
     * @return apellidoPaterno String
     */
    public String obtenerApellidoPaterno(){
        return apellidoPaterno;
    }
    /**
     * Establece el saldo de la cuenta.
     * @param saldo double.
     */
    public void establecerSaldo(double saldo){
        this.saldo = saldo;
    }
    /**
     * Obtiene el saldo de la cuenta.
     * @return saldo double.
     */
    public double obtenerSaldo(){
        return saldo;
    }
    /**
     * Combina el saldo del objeto Cuenta con el valor del monto
     * del objeto RegistroTransaccion.
     * @param transaccion RegistroTransaccion
     */
    public void combinar(RegistroTransaccionSerializada transaccion){
        saldo += transaccion.obtenerMonto();
    }
}
