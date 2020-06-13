/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Modificación de la figura 8.7 de la clase Fecha
 * para incorporar un metodo llamado siguienteDia que cambia el dia en uno
 * funcionando para cambiar el mes y el año de ser necesario, tomando en cuenta
 * si el año es biciesto o no lo es
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 5/05/2020
 * @time 12:01:12 PM
 */
public class PruebaFecha {
    public static void main(String[] args){
        Fecha nacimiento = new Fecha(2, 29, 2020);
        for(int i = 0; i < 10; i++){
            nacimiento.siguienteDia();
            System.out.printf("%s%n", nacimiento);
        }
        
    }
}
