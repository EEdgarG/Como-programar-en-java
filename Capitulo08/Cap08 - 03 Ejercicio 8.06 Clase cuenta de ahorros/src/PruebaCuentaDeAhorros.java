/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 4/05/2020
 * @time 03:16:27 PM
 */
public class PruebaCuentaDeAhorros {
    public static void main(String[] args){
        try{
            CuentaDeAhorros ahorrador1 = new CuentaDeAhorros(2000.0);
            CuentaDeAhorros ahorrador2 =  new CuentaDeAhorros(3000.0);
            CuentaDeAhorros.modificarTasaInteres(0.04);

            mostrarMeses(ahorrador1); 
            System.out.println();
            mostrarMeses(ahorrador2);

            CuentaDeAhorros.modificarTasaInteres(0.0f);//< lanzara excepcion IllegalArgumentException
            ahorrador2.calcularInteresMensual();
            System.out.printf("Siguiente mes\t%f%n", ahorrador2.obtenerSaldoAhorros());
            System.out.printf("Siguiente mes\t%f%n", ahorrador1.obtenerSaldoAhorros());
        }catch(IllegalArgumentException e){
            System.out.printf("Excepcion al cambiar la tasa de interés: %s%n", e.getMessage());
        }
    }
    public static void mostrarMeses(CuentaDeAhorros cuenta){
        System.out.println("Mes\tAhorro");
        for(int i = 0; i < 12; i++){
            cuenta.calcularInteresMensual();
            System.out.printf("%2d\t%f%n", i + 1, cuenta.obtenerSaldoAhorros());
        }
    }
}
