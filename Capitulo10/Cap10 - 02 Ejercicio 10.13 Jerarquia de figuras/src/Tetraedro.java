/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 16/06/2020
 * @time 07:51:01 PM
 */
public class Tetraedro extends FiguraTridimensional{
    /**
     * Triangulo que sirve como base del tetraedro
     */
    private Triangulo c;
    /**
     * Inicializa la base del tetraedro con dos parametros
     * @param base double
     * @param altura double
     */
    public Tetraedro(double base, double altura){
        c = new Triangulo(base, altura);
    }
    /**
     * Devuelve el area de la superficie del tetraedro
     * @return double
     */
    @Override
    public double obtenerArea(){
        return c.obtenerArea() * 4;
    }
    /**
     * Devuelve el volumen del tetraedro
     * @return double
     */
    @Override
    public double obtenerVolumen(){
        return (1.0 / 3.0) * c.obtenerArea() * c.obtenerAltura();
    }
    /**
     * Devuelve la representación String del objeto
     * @return String
     */
    @Override
    public String toString(){
        return String.format("Para el tetraedro%narea de la superficie: %f%nvolumen: %f", obtenerArea(), obtenerVolumen());
    }
}
