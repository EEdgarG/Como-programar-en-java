/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 19/05/2020
 * @time 03:53:52 PM
 */
public class PruebaEmpleadoBaseMasComision {
    public static void main(String[] args){
        EmpleadoBaseMasComision empleado = new EmpleadoBaseMasComision(
                "Edgar", "González", "0123456789", 5123.321, 0.4, 4356.125);
        
        System.out.printf("%s%niIngresos por %f%n", empleado, empleado.ingresos());
    }
}
