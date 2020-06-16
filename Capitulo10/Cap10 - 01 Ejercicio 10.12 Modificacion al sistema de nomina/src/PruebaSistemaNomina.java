/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 26/05/2020
 * @time 07:17:01 PM
 */
public class PruebaSistemaNomina {
    public static void main(String[] args){
        Fecha fechaActual = new Fecha(02, 28, 2020);
        //Crea objetos Fecha para las fechas de nacimiento para los empleados
        Fecha f1 = new Fecha(01, 02, 1990);
        Fecha f2 = new Fecha(02, 03, 1991);
        Fecha f3 = new Fecha(03, 04, 1992);
        Fecha f4 = new Fecha(04, 05, 1993);
        
        //Crea un arreglo Empleado de 4 elementos
        Empleado[] empleados = new Empleado[4];
        
        //inicializa el arreglo con objetos Empleado
        empleados[0] = new EmpleadoAsalariado("Jhon", "Smith", "111-11-1111", 800.00, f1);
        empleados[1] = new EmpleadoPorHoras("Karen", "Price", "222-22-2222", 16.75, 40, f2);
        empleados[2] = new EmpleadoPorComision("Sue", "Jones", "333-33-33330", 10000, 0.6, f3);
        empleados[3] = new EmpleadoBaseMasComision("Bob", "Lewis", "444-44-4444", 5000, .04, 300, f4);
        
        //procesa en forma generica a cada elemento del arreglo empleados
        for(Empleado empleadoActual: empleados){
            System.out.println(empleadoActual);//< incova a toString
            if(fechaActual.obtenerMes() == empleadoActual.obtenerFechaNacimiento().obtenerMes())
                System.out.printf("ingresos $%,.2f%ningresos mas bono de cumpleaños $100: $%,.2f%n%n",
                        empleadoActual.ingresos() * 4.0, (empleadoActual.ingresos() * 4.0) + 100);
            else
                System.out.printf("ingresos $%,.2f%n%n", empleadoActual.ingresos() * 4.0);
        }
    }
}
