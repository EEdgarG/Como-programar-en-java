/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Calcula el producto de n numeros por medio del metodo
 * producto(int ... numeros) el cual tiene una lista de argumentos de longitud variable
 * @author eedua
 */
public class Prueba {
    public static void main(String[] args){
        System.out.printf("%d%n", producto(5,4,3,2,5));
    }
    /**
     * Calcula el producto de los numeros obtenidos de una lista de argumentos
     * de longitud variable
     * @param numeros Lista de argumentos de longitud variable
     * @return Producto
     */
    public static int producto(int ... numeros){
        int prod = 1;
        for(int num : numeros)
            prod *= num;
        return prod;
    }
}
