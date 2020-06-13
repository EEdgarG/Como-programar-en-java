/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Calculo de interés compuesto del ejemplo 5.6 modificado para calcular
 * el interes con tasas de 5, 6 , 7, 8, 9, 10%
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 25/04/2020
 * @time 12:33:16 PM
 */
public class Interes {
    public static void main(String[] args){
        
        double principal = 1000.0;//< monto inicial antes de los intereses
        double tasa = 0.05;//< tasa de interés
        
        for(int i = 5; i <= 10; i++){
            //Muestra los encabezados
            System.out.printf("%s%20s%n", "Año", "Monto en deposito");
            calculoInteres(principal, (double)i / 100);
        }
    }
    
    public static void calculoInteres(double principal, double tasa){
        double monto;//< monto depositado al final de cada año
        //Calcula el monto en deposito para cada uno de diez años
        for(int anio = 1; anio <= 10; ++anio){
            //Calcula el nuevo monto para el año especificado
            monto = principal * Math.pow(1.0 + tasa, anio);
            
            //Muestra el año y el monto
            System.out.printf("%4d%, 20.2f%n", anio, monto);
        }
    }
}
