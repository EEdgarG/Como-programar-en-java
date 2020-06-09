/**
 *
 * @author EEdgar
 * @version Alfa 1
 * 6/12/17, 5:44pm
 * Clase empleado
 */
public class Empleado {
    /**
     * Nombre del empleado
     */
    private String nombre;
    /**
     * Apellido paterno del empleado
     */
    private String apPaterno;
    /**
     * Salario mensual del empleado
     */
    private double salarioMensual;
    
    /**
     * Constructor que crea un nuevo empleado con parametros definidos
     * @param nombre Nombre del empleado
     * @param apPaterno Apellido del empleado
     * @param salarioMensual Salario mensual del empleado
     */
    public Empleado(String nombre, String apPaterno, double salarioMensual){
        if(salarioMensual < 0.0)
            throw new IllegalArgumentException("El salario debe ser > 0.0");
        
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.salarioMensual = salarioMensual;
    }
    /**
     * Obtiene el nombre del empleado
     * @return Nombre del empleado
     */
    public String obtenerNombre(){
        return nombre;
    }
    /**
     * Establece el nombre del empleado
     * @param nombre Nombre del empleado
     */
    public void establecerNombre(String nombre){
        this.nombre = nombre;
    }
    /**
     * Obtiene el apellido paterno del empleado
     * @return Apellido paterno del empleado
     */
    public String obtenerApPaterno(){
        return apPaterno;
    }
    /**
     * Establece el apellido paterno del empleado
     * @param apPaterno Apellido paterno del empleado
     */
    public void establecerApPaterno(String apPaterno){
        this.apPaterno = apPaterno;
    }
    /**
     * Obtiene el salario mensual del empleado
     * @return Salario mensual del empleado
     */
    public double obtenerSalarioM(){
        return salarioMensual;
    }
    /**
     * Establece el salario mensual del empleado
     * @param salarioMensual Salario mensual del empleado
     */
    public void establecerSalarioM(double salarioMensual){
        if(salarioMensual < 0.0)
            throw new IllegalArgumentException("El salario mensual debe ser > 0.0");
        
        this.salarioMensual = salarioMensual;
    }
    /**
     * Regresa una representacion String del objeto Empleado
     * @return String
     */
    @Override
    public String toString(){
        return String.format("Empleado: %s %s%nSalario: $%.2f%n", 
                obtenerNombre(), obtenerApPaterno(), obtenerSalarioM());
    }
}
