/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Determina el crecimiento poblacional de los proximos 75 años y lo divide en 3 columnas
 * La primer columna  muestra el año desde el actual hasta los siguientes 75
 * La segunda columna muestra la pobacion anticipada al final de ese año
 * La tercera muestra el aumento númerico en la población que ocurriría ese año
 * Al final muestra el año en el que el tamaño de la población será del doble del actual
 * Para fines practicos se usa la suposicion de que la tasa de crecimiento permanecera constante
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 24/04/2020
 * @time 08:46:59 PM
 */
public class Crecimiento {
    public static void main(String[] args){
        int anioActual = 2020;
        float poblacionActual = 6000000000L;//< 6000 millones de personas
        float indiceAumentoPoblacional = 1.1f;//1.1% https://datos.bancomundial.org/indicador/sp.pop.grow
        boolean doble = true;
        System.out.println("Año actual\tPoblación a final del año\tAumento de la poblacion\n");
        for(int i = 0; i < 75; i++){
            float poblacionFinAnio = poblacionActual * indiceAumentoPoblacional;
            float diferenciaPoblacional = poblacionFinAnio - poblacionActual;
            System.out.printf("%7d\t\t\t%7.0f\t\t\t%7.0f%n", anioActual, poblacionFinAnio, diferenciaPoblacional);
            poblacionActual = poblacionFinAnio;
            anioActual++;
            
            if((long)poblacionActual / (long)12000000000L == 1 && doble){
                doble = false;
                System.out.println("En este año (arriba) la población sera el doble de la actual");
            }
        }
    }
}
