/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 11/06/2020
 * @time 06:40:47 PM
 */
import java.math.BigDecimal;

public class Cuenta {
    /**
     * Nombre del cliente
     */
    private String nombre;
    /**
     * Saldo del cliente
     */
    private BigDecimal saldo;
    /**
     * Recibe dos parametros, Nombre y saldo del cliente
     * @param nombre String
     * @param saldo BigDecimal
     */
    public Cuenta(String nombre, double saldo){
        if(saldo < 0.0)
            throw new IllegalArgumentException("El saldo debe ser >= 0.0");
        
        this.nombre = nombre;
        this.saldo = new BigDecimal(saldo);
    }
    /**
     * Deposita una cantidad en el saldo del cliente
     * @param montoDeposito double >= 0.0
     */
    public void despositar(double montoDeposito){
        if(montoDeposito < 0.0)
            throw new IllegalArgumentException("El saldo debe ser >= 0.0");
        BigDecimal deposito = new BigDecimal(montoDeposito);//< Se convierte el monto a depositar a BigDecimal
        saldo = saldo.add(deposito);
    }
    /**
     * Devuelve el saldo de la cuenta
     * @return double
     */
    public double obtenerSaldo(){
        return saldo.doubleValue();
    }
    /**
     * Establece el nombre del cliente
     * @param nombre String
     */
    public void establecerNombre(String nombre){
        this.nombre = nombre;
    }
    /**
     * Devuelve el nombre del cliente
     * @return String
     */
    public String obtenerNombre(){
        return nombre;
    }
    
}
