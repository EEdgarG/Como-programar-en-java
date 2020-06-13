/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 9/06/2020
 * @time 07:12:17 PM
 */
public class PruebaEnumLuzSemaforo {
    public static void main(String[] args){
        for(LuzSemaforo semaforo: LuzSemaforo.values()){
            System.out.printf("%s: %s%n", semaforo, semaforo.obtenerDuracion());
        }
    }
}
