/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Cargos por estacionamiento, de 1 a 3 horas $2, despues de ese tiempo son $.5 por fraccion u hora completa
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 27/04/2020
 * @time 07:40:56 PM
 */
public class Estacionamiento {
    public static void main(String[] args){
        float horasF = 3.2f;//3.5
        float horasC = (float)Math.ceil(horasF);//<redondea al entero mas pequeño mayor que horasF
        System.out.printf("El cargo por %f horas es %f%n", horasF, cargos(horasC));
    }
    public static float cargos(float horas){
        float costo = 0f;
        if(horas <= 3){
            costo = 2.0f;
        }
        else{
            costo += (0.5 * (horas - 3)) + 2;
        }
        return costo;
    }
}
