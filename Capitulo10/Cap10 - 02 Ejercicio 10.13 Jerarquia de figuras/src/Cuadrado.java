/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.lang.Math.pow;
/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 16/06/2020
 * @time 07:50:38 PM
 */
public class Cuadrado extends FiguraBidimensional{
    /**
     * Lado del cuadrado
     */
    private double lado;
    /**
     * Inicializa la variable lado a un valor dado
     * @param lado double >= 0.0
     */
    public Cuadrado(double lado){
        if(lado < 0.0)
            throw new IllegalArgumentException("El lado del cuadrado debe ser >= 0.0");
            
        this.lado = lado;
    }
    /**
     * Devuelve el lado del cubo
     * @return double
     */
    public double obtenerLado(){
        return lado;
    }
    /**
     * Devuelve el area del cuadrado
     * @return double
     */
    @Override
    public double obtenerArea(){
        return pow(lado, 2);
    }
    /**
     * Devuelve la representación String del objeto Cuadrado
     * @return String
     */
    @Override
    public String toString(){
        return String.format("cuadrado");
    }
}
