/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Calcula el valor de pi (aproximación) a partir de su serie infinita
 * Para que la precisión sea 3.14159 se requiere un numero de 1 millon
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 25/04/2020
 * @time 03:39:01 PM
 */
public class Pi {
    public static void main(String[] args){
        System.out.printf("El valor de pi es  %.5f%n", calcularPi(1000000));
    }
    /**
     * Calcula numeros de pi con la serie de Gregory-Leibniz
     * @param numero Cantidad de iteraciones para la serie infinita
     * @return Aproximación de pi
     */
    public static double calcularPi(long numero){
        double pi = 4.0;
        double valor = 4.0;
        boolean positivo = false;
        for(int i = 3; i < numero + 3; i++){
            if(i % 2 != 0){//si es impar
                if(positivo == false){
                    pi -= (valor / i);
                    positivo = true;
                }
                else{
                    pi += (valor /  i);
                    positivo = false;
                }
            }
        }
        return pi;
    }
}
