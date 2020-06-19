/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 26/05/2020
 * @time 06:15:21 PM
 */
public class EmpleadoPorHoras extends Empleado{
    /**
     * Sueldo por hora
     */
    private double sueldo;
    /**
     * Horas trabajadas por semana
     */
    private double horas;
    
    public EmpleadoPorHoras(
            String primerNombre, String apellidoPaterno, String numeroSeguroSocial, double sueldo, double horas){
        
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);
        
        if(sueldo < 0.0)
            throw new IllegalArgumentException("El sueldo debe ser >= 0.0");
        
        if((horas < 0.0) || (horas > 168.0))
            throw new IllegalArgumentException("Las horas trabajadas deben ser  >= 0.0 y <= 168");
        
        this.sueldo = sueldo;
        this.horas = horas;
    }
    /**
     * Establece el sueldo
     * @param sueldo double
     */
    public void establecerSueldo(double sueldo){
        if(sueldo < 0.0)
            throw new IllegalArgumentException("El sueldo por horas debe ser >= 0.0");
        
        this.sueldo = sueldo;
    }
    /**
     * Devuelve el sueldo
     * @return double
     */
    public double obtenerSueldo(){
        return sueldo;
    }
    /**
     * Establece las horas trabajadas
     * @param horas double
     */
    public void establecerHoras(double horas){
        if((horas < 0.0) || (horas > 168.0))
            throw new IllegalArgumentException("Las horas trabajadas deben ser >= 0.0 y <= 168");
        
        this.horas = horas;
    }
    /**
     * Devuelve las horas trabajadas a la semana
     * @return double
     */
    public double obtenerHoras(){
        return horas;
    }
    /**
     * Devuelve los ingresos
     * @return double
     */
    @Override
    public double obtenerMontoPago(){
        if(obtenerHoras() <= 40)//no hay tiempo extra
            return obtenerSueldo() * obtenerHoras();
        else
            return 40 * obtenerSueldo() + (obtenerHoras() - 40) * obtenerSueldo() * 1.5;
    }
    /**
     * Devuelve la representación String del objeto
     * @return String
     */
    @Override
    public String toString(){
        return String.format("empleado por horas: %s%n%s: $%,.2f; %s: %,.2f",
                super.toString(), "sueldo por hora", obtenerSueldo(), "horas trabajadas", obtenerHoras());
    }
}
