/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 26/05/2020
 * @time 06:29:53 PM
 */
public class EmpleadoPorComision extends Empleado{
    /**
     * Ventas totales por semana
     */
    private double ventasBrutas;
    /**
     * Porcentaje de comisión
     */
    private double tarifaComision;
    /**
     * Constructor que inicializa todas las variables
     * @param primerNombre String
     * @param apellidoPaterno String
     * @param numeroSeguroSocial String
     * @param ventasBrutas double
     * @param tarifaComision double
     */
    public EmpleadoPorComision(String primerNombre, String apellidoPaterno,
            String numeroSeguroSocial, double ventasBrutas, double tarifaComision){
        
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);
        
        if(tarifaComision <= 0.0 || tarifaComision >= 1.0)
            throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1");
        
        if(ventasBrutas < 0.0)
            throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0");
        
        this.tarifaComision = tarifaComision;
        this.ventasBrutas = ventasBrutas;
    }
    /**
     * Establece el monto de ventas brutas
     * @param ventasBrutas double
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
     * Establece la tarifa de comisión
     * @param tarifaComision double
     */
    public void establecerTarifaComision(double tarifaComision){
        if(tarifaComision <= 0.0 || tarifaComision >= 1.0)
            throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1.0");
        
        this.tarifaComision = tarifaComision;
    }
    /**
     * Devuelve la tarifa de comisión
     * @return double
     */
    public double obtenerTarifaComision(){
        return tarifaComision;
    }
    /**
     * Devuelve los ingresos
     * @return 
     */
    @Override
    public double obtenerMontoPago(){
        return obtenerTarifaComision() * obtenerVentasBrutas();
    }
    /**
     * Devuelve representación String del objeto
     * @return String
     */
    @Override
    public String toString(){
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f","empleado por comision", super.toString(),
                "ventas brutas", obtenerVentasBrutas(), "tarifa de comision", obtenerTarifaComision());
    }
}
