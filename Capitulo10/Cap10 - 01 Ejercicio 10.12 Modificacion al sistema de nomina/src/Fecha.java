/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 15/06/2020
 * @time 05:32:16 PM
 */
public class Fecha {
    /**
     * Mes
     */
    private int mes;
    /**
     * Día
     */
    private int dia;
    /**
     * Año
     */
    private int anio;
    /**
     * Arreglo con los días que tiene cada mes
     */
    private static final int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    /**
     * Constructor de 3 parametros
     * @param mes int
     * @param dia int 
     * @param anio int
     */
    public Fecha(int mes, int dia, int anio){
        if(mes <= 0 || mes > 12)
            throw new IllegalArgumentException("mes (" + mes + ") debe ser 1-12");
        //Validacion de dia excepto cuando es bisiesto
        if(dia <= 0 || (dia > diasPorMes[mes] &&  !(mes == 2 && dia == 29)))
            throw new IllegalArgumentException("dia (" + dia + ") fuera de rango para el mes y año especificados");
        
        //Validacion de año bisiesto
        if(mes == 2 && dia == 29 && !(anio % 400 == 0 || (anio % 4 == 0 && anio % 100 != 0)))
            throw new IllegalArgumentException("dia (" + dia + ") fuera de rango para el mes y año especificados");
        
        this.mes = mes;
        this.dia = dia;
        this.anio = anio;
    }
    /**
     * Devuelve el mes
     * @return int
     */
    public int obtenerMes(){
        return mes;
    }
    /**
     * Devuelve el dia
     * @return int
     */
    public int obtenerDia(){
        return dia;
    }
    /**
     * Devuelve el anio
     * @return int
     */
    public int obtenerAnio(){
        return anio;
    }
    /**
     * Devuelve una representación String del objeto Fecha
     * @return String
     */
    @Override
    public String toString(){
        return String.format("%d/%d/%d", mes, dia, anio);
    }
}
