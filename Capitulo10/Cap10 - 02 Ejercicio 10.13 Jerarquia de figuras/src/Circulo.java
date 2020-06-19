/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 16/06/2020
 * @time 07:50:33 PM
 */
import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Circulo extends FiguraBidimensional{
    /**
     * Radio del circulo
     */
    private double radio;
    /**
     * Constructor de 1 parametro, inicializa la variable radio a un valor dado
     * @param radio double >= 0.0
     */
    public Circulo(double radio){
        if(radio < 0.0)
            throw new IllegalArgumentException("El radio debe ser >= 0.0");
        
        this.radio = radio;
    }
    /**
     * Devuelve el radio del circulo
     * @return double
     */
    public double obtenerRadio(){
        return radio;
    }
    /**
     * Devuelve el area del circulo
     * @return double
     */
    @Override
    public double obtenerArea(){
        return PI * pow(radio, 2);
    }
    /**
     * Obtiene una representación String del objeto Circulo
     * @return String
     */
    @Override
    public String toString(){
        return String.format("circulo");
    }
}
