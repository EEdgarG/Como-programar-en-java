/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 16/06/2020
 * @time 07:50:50 PM
 */
public class Esfera extends FiguraTridimensional{
    /**
     * Radio y calculo del area en 2 dimensiones
     */
    private Circulo c;
    public Esfera(double radio){
        c = new Circulo(radio);
    }
    /**
     * Devuelve el area de la superficie de la esfera
     * @return double
     */
    @Override
    public double obtenerArea(){
        return 4 * c.obtenerArea();
    }
    /**
     * Devuelve el volumen de la esfera
     * @return double
     */
    @Override
    public double obtenerVolumen(){
        return (4.0 / 3.0) * c.obtenerArea() * c.obtenerRadio();
    }
    /**
     * Representación String de la esfera
     * @return String
     */
    @Override
    public String toString(){
        return String.format("Para la esfera%nel area de su superficie: %f%nel volumen: %f",
                obtenerArea(), obtenerVolumen());
    }
}
