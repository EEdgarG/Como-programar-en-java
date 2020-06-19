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
        //Crea objetos de las subclases
        EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado("Jhon",
                "Smith", "111-11-1111", 800.00);
        EmpleadoPorHoras empleadoPorHoras = new EmpleadoPorHoras("Karen",
                "Price", "222-22-2222", 16.75, 40);
        EmpleadoPorComision empleadoPorComision = new EmpleadoPorComision("Sue",
                "Jones", "333-33-33330", 10000, 0.6);
        EmpleadoBaseMasComision empleadoBaseMasComision = new EmpleadoBaseMasComision("Bob",
                "Lewis", "444-44-4444", 5000, .04, 300);
        TrabajadorPorPiezas trabajadorPorPieza = new TrabajadorPorPiezas("Deitel", "Pearson", "555-55-5555", 99.9, 10);
        
        System.out.println("Empleados procesados por separado");
        
        System.out.printf("%n%s%n%s: $%,.2f%n%n", empleadoAsalariado, "ingresos", empleadoAsalariado.ingresos());
        System.out.printf("%s%n%s: $%,.2f%n%n", empleadoPorHoras, "ingresos", empleadoPorHoras.ingresos());
        System.out.printf("%s%n%s: $%,.2f%n%n", empleadoPorComision, "ingresos", empleadoPorComision.ingresos());
        System.out.printf("%s%n%s: $%,.2f%n%n", empleadoBaseMasComision, "ingresos", empleadoBaseMasComision.ingresos());
        System.out.printf("%s%n%s: $%,.2f%n%n", trabajadorPorPieza, "ingresos", trabajadorPorPieza.ingresos());
        
        //Crea un arreglo Empleado de 4 elementos
        Empleado[] empleados = new Empleado[5];
        
        //inicializa el arreglo con objetos Empleado
        empleados[0] = empleadoAsalariado;
        empleados[1] = empleadoPorHoras;
        empleados[2] = empleadoPorComision;
        empleados[3] = empleadoBaseMasComision;
        empleados[4] = trabajadorPorPieza;
        
        System.out.printf("Empleados procesados de manera polimorfica%n%n");
        
        //procesa en forma generica a cada elemento del arreglo empleados
        for(Empleado empleadoActual: empleados){
            System.out.println(empleadoActual);//< incova a toString
            
            //determina si el elemento es un EmpleadoBaseMasComision
            if(empleadoActual instanceof EmpleadoBaseMasComision){
                //conversion descendiente de la referencia de Empleado
                //a una referencia de EmpleadoBaseMasComision
                EmpleadoBaseMasComision empleado = (EmpleadoBaseMasComision) empleadoActual;
                
                empleado.establecerSalarioBase(1.10f * empleado.obtenerSalarioBase());
                System.out.printf("el nuevo salario base con 10%% de aumento  es: $%,.2f%n", empleado.obtenerSalarioBase());
            }
            
            System.out.printf("ingresos $%,.2f%n%n", empleadoActual.ingresos());
        }
        
        //obtiene el nombre del tipo de cada objeto en el arreglo de empleados
        for(int j = 0; j < empleados.length; j++){
            System.out.printf("El empleado %d es un %s%n", j, empleados[j].getClass().getName());
        }
    }
}
