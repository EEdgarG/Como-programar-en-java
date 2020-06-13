/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 19/04/2020
 * @time 01:55:52 PM
 */
public class Empleado {
    /**
     * Horas trabajadas por el empleado
     */
    private int horasTrabajadas;
    /**
     * Tarifa por hora del empleado
     */
    private float tarifaPorHora;
    
    public Empleado(int horasTrabajadas, float tarifaPorHora){
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }
    /**
     * Calcula el salario del empleado
     */
    public void salario(){
        float salario = 0;
        if(horasTrabajadas < 40){
            salario = horasTrabajadas * tarifaPorHora;
        }
        else{
            salario = (40 * tarifaPorHora) + ((horasTrabajadas - 40) * (tarifaPorHora * 1.5f));
        }
            
        System.out.printf("El sueldo es: %f%n", salario);
    }
}
