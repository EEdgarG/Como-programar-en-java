/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 4/05/2020
 * @time 12:47:20 PM
 */
public class Rectangulo {
    /**
     * Ancho del rectangulo
     */
    private float  longitud;
    /**
     * Largo del rectangulo
     */
    /**
     * Constructor predeterminado, inicializa los atributos a 1
     */
    private float anchura;
    public Rectangulo(){
        longitud = 1f;
        anchura = 1f;
    }
    /**
     * Establece la longitud del rectangulo si esta esta en un rango de 0.0 < longitud <= 20
     * @param longitud Longitud del rectangulo
     */
    public void establecerLongitud(float longitud){
        if(longitud <= 0.0f || longitud > 20f)
            throw new IllegalArgumentException("Longitud esta fuera de rango");
        this.longitud = longitud;
    }
    /**
     * Obtiene la longitud del rectangulo
     * @return Longitud de rectangulo (float)
     */
    public float obtenerLongitud(){
        return longitud;
    }
    /**
     * Establece el ancho del rectangulo definido como 0.0 < anchura <= 20
     * @param anchura Ancho del rectángulo
     */
    public void establecerAnchura(float anchura){
        if(anchura <= 0.0f || anchura > 20f)
            throw new IllegalArgumentException("Ancho esta fuera de rango");
        this.anchura = anchura;
    }
    /**
     * Obtiene el ancho del rectángulo
     * @return Ancho del rectángulo
     */
    public float obtenerAnchura(){
        return anchura;
    }
    /**
     * Convierte a objeto String la información del rectángulo
     * @return 
     */
    @Override
    public String toString(){
        return String.format("Rectángulo: largo %f, ancho %f", obtenerLongitud(), obtenerAnchura());
    }
}
