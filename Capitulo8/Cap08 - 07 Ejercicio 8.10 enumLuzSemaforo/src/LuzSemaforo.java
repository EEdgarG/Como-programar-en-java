/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EEdgarG <eedduardo33@gmail.com>
 */
public enum LuzSemaforo {
    /**
     * Luz roja del semaforo
     */
    ROJO(3),
    /**
     * Luz verde del semaforo
     */
    VERDE(1),
    /**
     * Luz amarilla del semaforo
     */
    AMARILLO(2);
    /**
     * Duración de la constante del semaforo
     */
    private int duracion;
    /**
     * Constructor de un parametro del enum
     * @param duracion int
     */
    LuzSemaforo(int duracion){
        if(duracion < 0)
            throw new IllegalArgumentException("La duración debe ser >= 0");
        this.duracion = duracion;
    }
    /**
     * Devuelve la duración del semaforo
     * @return int
     */
    public int obtenerDuracion(){
        return duracion;
    }
}
