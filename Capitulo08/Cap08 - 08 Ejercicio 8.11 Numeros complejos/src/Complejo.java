/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 5/05/2020
 * @time 01:13:46 PM
 */
public class Complejo {
    /**
     * Parte real de número complejo
     */
    private double parteReal;
    /**
     * Parte imaginaria de número complejo
     */
    private double parteImaginaria;
    /**
     * Letra i que representa la raiz cuadrada de -1
     */
    private static final String i = "i";
    /**
     * Constructor que inicializa las variables de instancia con parametros del constructor
     * @param parteReal Parte real del número complejo
     * @param parteImaginaria Parte imaginaria del número complejo
     */
    public Complejo(double parteReal, double parteImaginaria){
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }
    /**
     * Constructor predeterminado, no recibe parametros
     */
    public Complejo(){
        this(0.0, 0.0);
    }
    /**
     * Obtiene la parte real del número complejo
     * @return Parte real
     */
    public double obtenerParteReal(){
        return parteReal;
    }
    /**
     * Obtiene la parte imaginaria
     * @return Parte imaginaria
     */
    public double obtenerParteImaginaria(){
        return parteImaginaria;
    }
    /**
     * Devuelve la suma del número complejo a mas el objeto que invoca este método
     * @param a Complejo
     * @return Complejo
     */
    public Complejo suma(Complejo a){
        return new Complejo(obtenerParteReal() + a.obtenerParteReal(), obtenerParteImaginaria() + a.obtenerParteImaginaria());
    }
    /**
     * Devuelve la resta del objeto que invoca este método menos el Complejo del argumento a
     * @param a Complejo
     * @return Complejo
     */
    public Complejo resta(Complejo a){
        return new Complejo(obtenerParteReal() - a.obtenerParteReal(), obtenerParteImaginaria() - a.obtenerParteImaginaria());
    }
    /**
     * Obtiene el número complejo en su totalidad en un objeto String
     * @return String del número complejo
     */
    @Override
    public String toString(){
        return String.format("%f+%f%s", obtenerParteReal(), obtenerParteImaginaria(), i);
    }
}
