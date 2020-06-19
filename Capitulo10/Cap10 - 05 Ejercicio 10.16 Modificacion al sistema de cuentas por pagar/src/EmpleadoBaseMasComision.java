/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 26/05/2020
 * @time 07:08:25 PM
 */
public class EmpleadoBaseMasComision extends EmpleadoPorComision{
    /**
     * Salario base por semana
     */
    private double salarioBase;
    /**
     * Constructor que inicializa todas las variables de instancia
     * @param primerNombre String
     * @param apellidoPaterno String
     * @param numeroSeguroSocial String
     * @param ventasBrutas double
     * @param tarifaComision double
     * @param salarioBase double
     */
    public EmpleadoBaseMasComision(String primerNombre, String apellidoPaterno, String numeroSeguroSocial,
            double ventasBrutas, double tarifaComision, double salarioBase){
        
        super(primerNombre, apellidoPaterno, numeroSeguroSocial, ventasBrutas, tarifaComision);
        
        if(salarioBase < 0.0)
            throw new IllegalArgumentException("El salario base debe ser >= 0.0");
        
        this.salarioBase = salarioBase;
    }
    /**
     * Establece el salario base
     * @param salarioBase double
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
     * Devuelve los ingresos
     * @return double
     */
    @Override
    public double ingresos(){
        return obtenerSalarioBase() * super.ingresos();
    }
    
    @Override
    public String toString(){
        return String.format("%s %s; %s: $%,.2f", "con salario base", super.toString(), "salario base", obtenerSalarioBase());
    }
}
