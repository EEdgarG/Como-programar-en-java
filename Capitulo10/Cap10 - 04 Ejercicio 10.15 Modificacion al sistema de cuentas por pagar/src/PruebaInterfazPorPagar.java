/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 27/05/2020
 * @time 06:53:27 PM
 */
public class PruebaInterfazPorPagar {
    public static void main(String[] args){
        //Crea arreglo PorPagar con 4 elementos
        PorPagar[] objetosPorPagar = new PorPagar[7];
        
        //Llena el arreglo con objetos que implementan la interfaz PorPagar
        objetosPorPagar[0] = new Factura("01234", "asiento", 2, 375.00);
        objetosPorPagar[1] = new Factura("56789", "llanta", 4, 79.95);
       
        objetosPorPagar[2] = new EmpleadoAsalariado("Jhon", "Smith", "111-11-1111", 800.00);
        objetosPorPagar[3] = new EmpleadoPorHoras("Karen", "Price", "222-22-2222", 16.75, 40);
        objetosPorPagar[4] = new EmpleadoPorComision("Sue", "Jones", "333-33-33330", 10000, 0.6);
        objetosPorPagar[5] = new EmpleadoBaseMasComision("Bob", "Lewis", "444-44-4444", 5000, .04, 300);
        objetosPorPagar[6] = new TrabajadorPorPiezas("Deitel", "Pearson", "555-55-5555", 99.9, 10);
        
        //Muestra los empleados y facturas
        for(PorPagar porPagarActual: objetosPorPagar)
            System.out.printf("%n%s %n%s: $%,.2f%n",
                    porPagarActual.toString(), "pago vencido", porPagarActual.obtenerMontoPago());
        
        System.out.println("Despues de algunos cambios%n");
        
        //procesa en forma generica cada elemento  en el arreglo objetosPorPagar
        for(PorPagar porPagarActual: objetosPorPagar){
            if(porPagarActual instanceof EmpleadoBaseMasComision){
                ((EmpleadoBaseMasComision) porPagarActual).establecerSalarioBase(
                        (((EmpleadoBaseMasComision) porPagarActual).obtenerSalarioBase() * .1) +
                                ((EmpleadoBaseMasComision) porPagarActual).obtenerSalarioBase());
            }
            System.out.printf("%n%s %n%s: $%,.2f%n",
                    porPagarActual.toString(), "pago vencido", porPagarActual.obtenerMontoPago());
        }
    }
}
