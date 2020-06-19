/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 26/05/2020
 * @time 06:05:56 PM
 */
public class EmpleadoAsalariado extends Empleado{
    /**
     * Salario semanal
     */
    private double salarioSemanal;
    /**
     * Constructor de 4 argumentos: inicializa todas las variables de instancia
     * @param primerNombre String
     * @param apellidoPaterno String
     * @param numeroSeguroSocial String
     * @param salarioSemanal double
     */
    public EmpleadoAsalariado(
            String primerNombre, String apellidoPaterno, String numeroSeguroSocial, double salarioSemanal){
        
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);
        
        if(salarioSemanal < 0.0)
            throw new IllegalArgumentException("El salario semanal debe ser >= 0.0");
        
        this.salarioSemanal = salarioSemanal;
    }
    /**
     * Establece el salario
     * @param salarioSemanal double
     */
    public void establecerSalarioSemanal(double salarioSemanal){
        if(salarioSemanal < 0.0)
            throw new IllegalArgumentException("El salario semanl debe ser >= 0.0");
        
        this.salarioSemanal = salarioSemanal;
    }
    /**
     * Devuelve el salario semanal
     * @return double
     */
    public double obtenerSalarioSemanal(){
        return salarioSemanal;
    }
    /**
     * Calcula los ingresos
     * Implementa el metodo obtenerMontoPago que era abstracto en la superclase Empleado
     * @return double
     */
    @Override
    public double obtenerMontoPago(){
        return obtenerSalarioSemanal();
    }
    /**
     * Devuelve representación String del objeto
     * @return String
     */
    @Override
    public String toString(){
        return String.format("empleado asalariado: %s%n%s: $%.2f",
                super.toString(), "salario semanal", obtenerSalarioSemanal());
    }
}
