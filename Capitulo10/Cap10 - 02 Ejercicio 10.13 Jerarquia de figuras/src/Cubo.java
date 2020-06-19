/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 16/06/2020
 * @time 07:50:53 PM
 */
public class Cubo extends FiguraTridimensional{
    /**
     * Lado y calculo del area en 2 dimensiones
     */
    private Cuadrado c;
    /**
     * Inicializa una de las caras del cubo con el valor de su lado
     * @param lado double
     */
    public Cubo(double lado){
        c = new Cuadrado(lado);
    }
    /**
     * Devuelve el area de la superficie del cubo
     * @return double
     */
    @Override
    public double obtenerArea(){
        return c.obtenerArea() * 6;
    }
    /**
     * Devuelve el volumne del cubo
     * @return double
     */
    @Override
    public double obtenerVolumen(){
        return c.obtenerArea() * c.obtenerLado();
    }
    /**
     * Devuelve la representación String del cubo
     * @return String
     */
    @Override
    public String toString(){
        return String.format("cubo");
    }
}
