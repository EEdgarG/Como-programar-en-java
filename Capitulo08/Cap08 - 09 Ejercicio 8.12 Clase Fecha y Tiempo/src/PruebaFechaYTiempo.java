/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Modificacion de la clase Tiempo2 (modificada) y Tiempo (modificada)
 * en una clase que maneja la hora y fecha
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 5/05/2020
 * @time 02:09:23 PM
 */
public class PruebaFechaYTiempo {
    public static void main(String[] args){
        FechaYTiempo ft = new FechaYTiempo(23, 59, 50, 12, 31, 2019);
        
        for(int i = 0; i < 120; i++){
            ft.ticTac();
            System.out.printf("%s%n", ft.aStringUniversal());
        }
    }
}
