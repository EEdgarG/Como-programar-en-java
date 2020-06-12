/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Primer ejemplo de la clase tiempo
 * ejemplo de lanzamiento de excepciones
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 2/05/2020
 * @time 11:57:41 AM
 */
public class Tiempo1 {
    /**
     * Horas: 0 - 23
     */
    private int hora;
    /**
     * Minutos: 0 - 59
     */
    private int minuto;
    /**
     * Segundos 0 - 59
     */
    private int segundo;
    
    public void establecerTiempo(int hora, int minuto, int segundo){
        //valida la hora, el minuto y el segundo
        if(hora < 0 || hora >= 24 || minuto < 0 || minuto >= 60 || segundo < 0 || segundo >= 60){
            throw new IllegalArgumentException("Hora, minuto y/o segundo estaban fuera de rango");
        }
        
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    /**
     * Convierte a objeto String en formato de hora universal (HH:MM:SS)
     * @return Tiempo en formato String de hora universal
     */
    public String aStringUniversal(){
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }
    /**
     * Convierte a objeto String en formato de hora estándar (H:MM:SS AM o PM)
     * @return Tiempo en formato de hora estándar
     */
    public String toString(){
        return String.format("%d:%02d:%02d %s", ((hora == 0 || hora == 12) ? 12: hora % 12), minuto, segundo, (hora < 12 ? "AM" : "PM"));
    }
}
