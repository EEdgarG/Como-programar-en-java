/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Calcula el producto de los enteros impares del 1 al 15
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 25/04/2020
 * @time 12:11:06 PM
 */
public class ProductoImpares {
    public static void main(String[] args){
        int producto = 1;
        for(int i = 1; i < 16; i++){
            System.out.printf("%d%n", i);
            if(i % 2 != 0)
                producto *= i;
        }
        System.out.printf("El producto es %d%n", producto);
    }
}
