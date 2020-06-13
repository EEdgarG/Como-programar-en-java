/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 19/05/2020
 * @time 04:16:45 PM
 */
public class Cuadrilatero {
    /**
     * Vertice a
     */
    private final Punto a;
    /**
     * Vertice b
     */
    private final Punto b;
    /**
     * Vertice c
     */
    private final Punto c;
    /**
     * Vertice d
     */
    private final Punto d;
    /**
     * Inicializa un cuadrilatero con sus 4 puntos
     * @param a Punto
     * @param b Punto
     * @param c Punto
     * @param d Punto
     */
    public Cuadrilatero(Punto a, Punto b, Punto c, Punto d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    /**
     * Devuelve la información de los puntos del cuadrilatero
     * @return String
     */
    @Override
    public String toString(){
        return String.format("Los puntos del cuadrilatero son: %s, %s, %s, %s", a, b, c, d);
    }
}
