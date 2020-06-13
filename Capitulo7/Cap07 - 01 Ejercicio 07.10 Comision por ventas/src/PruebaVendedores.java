/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Muestra y procesa por rangos la cantidad de vendedores que alcanzaron determinada comisión
 * @author eedua
 */
public class PruebaVendedores {
    public static void main(String[] args){
        int[] personal = {1000, 2000, 3000, 4000, 5000, 6000, 7500, 8500, 12000};//<Cantidad de ventas por personal
        Vendedores libro = new Vendedores(personal);
        libro.procesarSueldos();
        libro.mostrarSueldos();
    }
}
