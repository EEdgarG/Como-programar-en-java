/**
 *
 * @author EEdgar
 * @version Alfa 1
 * 6/12/17, 5:52pm
 * Clase de prueba de clase Empleado
 */

public class PruebaEmpleado {
    public static void main(String[] args){
        
        //Se crean dos empleados con valores definidos
        Empleado empleado1 = new Empleado("Juan", "Payaso", 40.0);
        Empleado empleado2 = new Empleado("Rafa", "Chavarria", 16345.32);
        
        //Se muestran los salarios anuales de ambos empleados
        System.out.printf("Salario anual de empleado1 es %f%n",
                empleado1.obtenerSalarioM() * 12);
        System.out.printf("Salario anual de empleado2 es %f%n",
                empleado2.obtenerSalarioM() * 12);
        
        //Se les da un bono de 10% a ambos empleados
        empleado1.establecerSalarioM((empleado1.obtenerSalarioM() * .1) + empleado1.obtenerSalarioM());
        empleado2.establecerSalarioM((empleado2.obtenerSalarioM() * .1) + empleado2.obtenerSalarioM());
        
        //Se muestran los salarios de los empleados anteriormente modificados
        System.out.printf("El salario mensual de empleado1 es %f%n",
                empleado1.obtenerSalarioM());
        System.out.printf("El salario mensual de empleado2 es %f%n",
                empleado2.obtenerSalarioM());
    }
}
