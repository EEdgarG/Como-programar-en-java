/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 26/05/2020
 * @time 05:58:24 PM
 */
public abstract class Empleado {
    /**
     * Primer nombre
     */
    private final String primerNombre;
    /**
     * Apellido paterno
     */
    private final String apellidoPaterno;
    /**
     * Número seguro social
     */
    private final String numeroSeguroSocial;
    /**
     * Fecha de nacimiento del empleado
     */
    private Fecha fechaNacimiento;
    /**
     * Constructor de 3 parametros
     * @param primerNombre String
     * @param apellidoPaterno String
     * @param numeroSeguroSocial String
     */
    public Empleado(String primerNombre, String apellidoPaterno, String numeroSeguroSocial){
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.numeroSeguroSocial = numeroSeguroSocial;
    }
    /**
     * Constructor de 4 parametros
     * @param primerNombre String
     * @param apellidoPaterno String
     * @param numeroSeguroSocial String
     * @param fechaNacimiento Fecha
     */
    public Empleado(String primerNombre, String apellidoPaterno, String numeroSeguroSocial, Fecha fechaNacimiento){
        this(primerNombre, apellidoPaterno, numeroSeguroSocial);
        
        this.fechaNacimiento = fechaNacimiento;
    }
    /**
     * Devuelve el primer nombre
     * @return String
     */
    public String obtenerPrimerNombre(){
        return primerNombre;
    }
    /**
     * Devuelve el apellido paterno
     * @return String
     */
    public String obtenerApellidoPaterno(){
        return apellidoPaterno;
    }
    /**
     * Devuelve el número de seguro social
     * @return String
     */
    public String obtenerNumeroSeguroSocial(){
        return numeroSeguroSocial;
    }
    /**
     * Devuelve la fecha de nacimiento
     * @return Fecha
     */
    public Fecha obtenerFechaNacimiento(){
        return fechaNacimiento;
    }
    /**
     * Devuelve representación String del objeto
     * @return String
     */
    @Override
    public String toString(){
        return String.format("%s %s%nnúmero de seguro social: %s%nFecha de nacimiento: %s",
                obtenerPrimerNombre(), obtenerApellidoPaterno(), obtenerNumeroSeguroSocial(), fechaNacimiento.toString());
    }
    //metodo abstracto sobreescrito por las clases concretas
    public abstract double ingresos();
}
