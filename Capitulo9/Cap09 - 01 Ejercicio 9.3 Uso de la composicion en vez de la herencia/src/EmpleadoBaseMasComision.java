/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 19/05/2020
 * @time 02:34:35 PM
 */
public class EmpleadoBaseMasComision {
    /**
     * Salario base por semana
     */
    private double salarioBase;
    /**
     * Agrega la informacion de EmpleadoPorComision
     */
    private EmpleadoPorComision empleadoComision;
    /**
     * Inicializa todas las variables con los parametros del constructor
     * @param primerNombre String
     * @param apellidoPaterno String
     * @param numeroSeguroSocial String
     * @param ventasBrutas double
     * @param tarifaComision double
     * @param salarioBase double
     */
    public EmpleadoBaseMasComision(String primerNombre, String apellidoPaterno,
            String numeroSeguroSocial, double ventasBrutas, double tarifaComision, double salarioBase){
        
        empleadoComision = new EmpleadoPorComision(
                primerNombre, apellidoPaterno, numeroSeguroSocial, ventasBrutas, tarifaComision);
        
        if(salarioBase < 0.0)
            throw new IllegalArgumentException("El salario base debe ser >= 0.0");
        
        this.salarioBase = salarioBase;
    }
    /**
     * Establece el salario base
     * @param salarioBase double >= 0.0
     */
    public void establecerSalarioBase(double salarioBase){
        if(salarioBase < 0.0)
            throw new IllegalArgumentException("El salario base debe ser >= 0.0");
        
        this.salarioBase = salarioBase;
    }
    /**
     * Devuelve el salario base
     * @return double
     */
    public double obtenerSalarioBase(){
        return salarioBase;
    }
    /**
     * Calcula los ingresos
     * @return double
     */
    public double ingresos(){
        return obtenerSalarioBase() + empleadoComision.ingresos();
    }
    /**
     * Devuelve la representación String de EmpleadoBaseMasComision
     * @return String
     */
    @Override
    public String toString(){
        return String.format("%s %s%n%s: %.2f", "con sueldo base",
                empleadoComision.toString(), "sueldo base", obtenerSalarioBase());
    }
}
