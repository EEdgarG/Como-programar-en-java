/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Calcula la distancia entre (x1, y1) y (x2, y2)
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 30/04/2020
 * @time 06:05:27 PM
 */
public class DistanciaEntrePuntos {
    public static void main(String[] args){
        double x1 = -5f;
        double y1 = 3f;
        double x2 = 4f;
        double y2 = 3f;
        System.out.printf("La distancia entre los puntos P1(%f, %f) y P2(%f, %f) es: %f%n", x1, y1, x2, y2,
                distanciaDosPuntos(distancia(x2, x1), distancia(y2, y1)));
    }
    public static double distanciaDosPuntos(double d2, double d1){
        return Math.sqrt(Math.pow(d2, 2) + Math.pow(d1, 2));
    }
    public static double distancia(double x2, double x1){
        return x2 - x1;
    }
}
