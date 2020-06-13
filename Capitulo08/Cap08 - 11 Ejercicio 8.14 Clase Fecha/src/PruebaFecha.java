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
        Fecha f1 = new Fecha(2, 28, 2020);
        Fecha f2 = new Fecha("Enero", 12, 2020);
        Fecha f3 = new Fecha(365, 2019);
            System.out.printf("%s%n%s%n%s%n%n", f1, f1.letrasNumeros(), f1.diaDelAnio());
            System.out.printf("%s%n%s%n%s%n%n", f2, f2.letrasNumeros(), f2.diaDelAnio());
            System.out.printf("%s%n%s%n%s%n%n", f3, f3.letrasNumeros(), f3.diaDelAnio());
//        }
        
    }
}
