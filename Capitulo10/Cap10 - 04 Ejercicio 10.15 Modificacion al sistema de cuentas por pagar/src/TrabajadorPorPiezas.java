/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 17/06/2020
 * @time 09:08:55 AM
 */
public class TrabajadorPorPiezas extends Empleado{
    /**
     * Sueldo por cada pieza
     */
    private double sueldo;
    /**
     * Piezas fabricadas
     */
    private int piezas;
    /**
     * Inicializa todas las variables de instancia con los parametros del constructor
     * @param primerNombre String
     * @param apellidoPaterno String
     * @param numeroSeguroSocial String
     * @param sueldo double
     * @param piezas int
     */
    public TrabajadorPorPiezas(String primerNombre,
            String apellidoPaterno, String numeroSeguroSocial, double sueldo, int piezas){
        
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);
        
        if(sueldo < 0.0)
            throw new IllegalArgumentException("El sueldo debe ser >= 0.0");
        if(piezas < 0)
            throw new IllegalArgumentException("La cantidad de piezas debe ser >= 0");
        
        this.sueldo = sueldo;
        this.piezas = piezas;
    }
    /**
     * Devuelve el sueldo
     * @return double
     */
    public double obtenerSueldo(){
        return sueldo;
    }
    /**
     * Devuelve la cantidad de piezas fabricadas
     * @return int
     */
    public int obtenerPiezas(){
        return piezas;
    }
    /**
     * Calcula y devuelve los ingresos
     * @return double
     */
    @Override
    public double obtenerMontoPago(){
        return obtenerSueldo() * obtenerPiezas();
    }
    @Override
    public String toString(){
        return String.format("Trabajador por piezas: %s%n%s: $%.2f",
                super.toString(), "salario por pieza fabricada", obtenerSueldo());
    }
}
