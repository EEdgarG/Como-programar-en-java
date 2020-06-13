/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.lang.Math.sqrt;
import static java.lang.Math.ceil;
import static java.lang.Math.E;
import static java.lang.Math.PI;
/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 4/05/2020
 * @time 02:41:49 PM
 */
public class CuentaDeAhorros {
    /**
     * Tasa de interés anual para todos los cuentahabientes
     */
    private static double tasaInteresAnual;
    /**
     * Cantidad que el ahorrador tiene actualmente en depósito
     */
    private double saldoAhorros;
    
    public CuentaDeAhorros(double saldoAhorros){
        if(saldoAhorros < 0)
            throw new IllegalArgumentException("La cantidad de ahorro no puede ser negativa");
        
        this.saldoAhorros = saldoAhorros;
    }
    /**
     * Calcula el monto de interés mensual
     * @return Monto interés mensual
     */
    public void calcularInteresMensual(){
        saldoAhorros += ((obtenerSaldoAhorros() * obtenerTasaInteresAnual()) / 12);
    }
    /**
     * Obtiene el ahorro del cuentahabiente
     * @return Ahorro
     */
    public double obtenerSaldoAhorros(){
        return saldoAhorros;
    }
    /**
     * Obtiene la tasa de interés anual
     * @return Tasa de interés anual
     */
    public static double obtenerTasaInteresAnual(){
        return tasaInteresAnual;
    }
    /**
     * Modifica la tasa de interés anual, tal que 0.0 <= tasaInteresAnual < 1
     * @param tasaInteresAnual Tasa de interés anual
     */
    public static void modificarTasaInteres(double tasaInteresAnual){
        if(tasaInteresAnual <= 0.0f || tasaInteresAnual > 1)
            throw new IllegalArgumentException("La tasa de interés anual debe ser mayor a 0 y menor que 1");
        CuentaDeAhorros.tasaInteresAnual = tasaInteresAnual;
    }
}
