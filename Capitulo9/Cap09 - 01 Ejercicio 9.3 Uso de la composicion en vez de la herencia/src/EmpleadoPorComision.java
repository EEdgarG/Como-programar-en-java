/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 19/05/2020
 * @time 02:08:30 PM
 */
public class EmpleadoPorComision {
    /**
     * Primer nombre del empleado por comisión
     */
    private final String primerNombre;
    /**
     * Apellido paterno de empleado por comisión
     */
    private final String apellidoPaterno;
    /**
     * Número de seguro social del empleado por comisión
     */
    private final String numeroSeguroSocial;
    /**
     * Ventas totales por semana
     */
    private double ventasBrutas;
    /**
     * Porcentaje de comision
     */
    private double tarifaComision;
    /**
     * Iniciliza todas las variables de instancia con parametros establecidos en el constructor
     * @param primerNombre String
     * @param apellidoPaterno String
     * @param numeroSeguroSocial String
     * @param ventasBrutas double
     * @param tarifaComision double
     */
    public EmpleadoPorComision(String primerNombre,
            String apellidoPaterno, String numeroSeguroSocial, double ventasBrutas, double tarifaComision){
        //la llamada implicita al constructor de Object ocurre aqui
        
        //si ventas burtas no son válidas, lanza excepción
        if(ventasBrutas < 0.0)
            throw new IllegalArgumentException("Ventas brutas debe ser >= 0.0");
        
        //si tarifa comisión no es válida, lanza excepción
        if(tarifaComision <= 0.0 || tarifaComision >= 1.0)
            throw new IllegalArgumentException("La tarifa de comision debe ser > 0.0 y < 1.0");
        
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.numeroSeguroSocial = numeroSeguroSocial;
        this.ventasBrutas =  ventasBrutas;
        this.tarifaComision = tarifaComision;
    }
    /**
     * Obtiene el primer nombre
     * @return String
     */
    public String obtenerPrimerNombre(){
        return primerNombre;
    }
    /**
     * Obtiene el apellido paterno
     * @return String
     */
    public String obtenerApellidoPaterno(){
        return apellidoPaterno;
    }
    /**
     * Obtiene el número de seguro social
     * @return String
     */
    public String obtenerNumeroSeguroSocial(){
        return numeroSeguroSocial;
    }
    /**
     * Establece el monto de ventas brutas
     * @param ventasBrutas double > 0.0
     */
    public void establecerVentasBrutas(double ventasBrutas){
        if(ventasBrutas < 0.0)
            throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");
        
        this.ventasBrutas = ventasBrutas;
    }
    /**
     * Devuelve el monto de ventas brutas
     * @return double
     */
    public double obtenerVentasBrutas(){
        return ventasBrutas;
    }
    /**
     * Establece la tarifa de comision
     * @param tarifaComision double
     */
    public void establecerTarifaComision(double tarifaComision){
        if(tarifaComision <= 0.0 || tarifaComision >= 1.0)
            throw new IllegalArgumentException("La tarifa de comision debe ser > 0.0 y < 1.0");
        
        this.tarifaComision = tarifaComision;
    }
    /**
     * Devuelve la tarifa de comisión
     * @return 
     */
    public double obtenerTarifaComision(){
        return tarifaComision;
    }
    /**
     * Obtiene los ingresos
     * @return double
     */
    public double ingresos(){
        return obtenerTarifaComision() + obtenerVentasBrutas();
    }
    /**
     * Devuelve la representación String del objeto EmpleadoPorComision
     * @return String
     */
    @Override
    public String toString(){
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", "empleado por comisión",
                obtenerPrimerNombre(), obtenerApellidoPaterno(), "numero de seguro social", obtenerNumeroSeguroSocial(),
                "ventas brutas", obtenerVentasBrutas(), "tarifa de comision", obtenerTarifaComision());
    }
}
