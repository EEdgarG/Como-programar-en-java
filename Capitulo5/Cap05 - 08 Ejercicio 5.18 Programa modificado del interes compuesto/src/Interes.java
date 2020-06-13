/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Calculo de interés compuesto del ejemplo 5.6 modificado para usar solo numeros enteros
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 25/04/2020
 * @time 12:33:16 PM
 */
public class Interes {
    public static void main(String[] args){
        
        int principal = 1000 * 100;//< monto inicial antes de los intereses en centavos
        double tasa = 0.05;//< tasa de interés

        //Muestra los encabezados
        System.out.printf("%s%20s%n", "Año", "Monto en deposito");
        calculoInteres(principal, tasa);
    }
    
    public static void calculoInteres(double principal, double tasa){
        int monto;//< monto depositado al final de cada año
        //Calcula el monto en deposito para cada uno de diez años
        for(int anio = 1; anio <= 10; ++anio){
            //Calcula el nuevo monto para el año especificado
            monto = (int) (principal * Math.pow(1.0 + tasa, anio));
            
            //Muestra el año y el monto
            System.out.printf("%4d%, 20d.%2d%n", anio, monto / 100, monto % 100);
        }
    }
}
