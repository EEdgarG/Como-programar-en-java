/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 25/05/2020
 * @time 04:21:14 PM
 */
public class Persona {
    /**
     * Nombre
     */
    private String nombre;
    /**
     * Apellido paterno
     */
    private String apellidoPaterno;
    /**
     * Constructor que inicializa las variables a unas dadas en el constructor
     * @param nombre String
     * @param apellido_paterno String
     */
    public Persona(String nombre, String apellidoPaterno){
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
    }
    /**
     * Establece el nombre
     * @param nombre String
     */
    public void establecerNombre(String nombre){
        this.nombre = nombre;
    }
    /**
     * Obtiene el nombre
     * @return String
     */
    public String obtenerNombre(){
        return nombre;
    }
    /**
     * Establece el apellido paterno
     * @param apellido String
     */
    public void establecerApellido(String apellidoPaterno){
        this.apellidoPaterno = apellidoPaterno;
    }
    /**
     * Obtiene el apellido paterno
     * @return String
     */
    public String obtenerApellidoPaterno(){
        return apellidoPaterno;
    }
    /**
     * Obtiene una representacion String del objeto persona
     * @return String
     */
    @Override
    public String toString(){
        return String.format("%s %s", obtenerNombre(), obtenerApellidoPaterno());
    }
}
