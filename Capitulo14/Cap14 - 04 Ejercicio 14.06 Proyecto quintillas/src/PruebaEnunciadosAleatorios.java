/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Genera enunciados de manera aleatoria
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 1/06/2020
 * @time 06:47:35 PM
 */
public class PruebaEnunciadosAleatorios {
    public static void main(String[] args){
        String primera = EnunciadosAleatorios.oracionAleatoria();
        String segunda = EnunciadosAleatorios.enunciadoRima(primera.substring(primera.length() - 3));
        String tercera = EnunciadosAleatorios.oracionAleatoria();
        String cuarta = EnunciadosAleatorios.enunciadoRima(tercera.substring(primera.length() - 3));
        String quinta = EnunciadosAleatorios.enunciadoRima(primera.substring(primera.length() - 3));
        System.out.printf("%s%n%s%n%s%n%s%n%s%n", primera, segunda, tercera, cuarta, quinta);
    }
}
