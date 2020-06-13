/**
 *
 * @author EEdgar
 * @version Beta 1
 * 7/12/17, 5:07pm
 * Calse de frecuencias cardicacas maximas y esperadas
 */
public class FrecuenciasCardiacas {
    /**
     * Nombre del paciente
     */
    private String nombre;
    /**
     * Apellido del paciente
     */
    private String apellido;
    /**
     * Fecha de nacimiento del paciente
     */
    private Fecha fechaNacimiento;
    /**
     * Fecha actual
     */
    private Fecha fechaActual;
    /**
     * Constructor que inicializa el expediente de un paciente a valores definidos
     * @param nombre Nombre del paciente
     * @param apellido Apellido del paciente
     * @param dia Día de nacimiento
     * @param mes Mes de nacimiento
     * @param anio Año de nacimiento
     */
    public FrecuenciasCardiacas(
            String nombre, String apellido, int mesN, int diaN, int anioN, int mesA, int diaA, int anioA){
        
        this.nombre = nombre;
        this.apellido = apellido;
        fechaNacimiento = new Fecha(mesN, diaN, anioN);
        fechaActual = new Fecha(mesA, diaA, anioA);
    }
    /**
     * Establece el nombre del paciente
     * @param nombre Nombre del paciente
     */
    public void establecerNombre(String nombre){
        this.nombre = nombre;
    }
    /**
     * Obtiene el nombre del paciente
     * @return Nombre del paciente
     */
    public String obtenerNombre(){
        return nombre;
    }
    /**
     * Establece el apellido del paciente
     * @param apellido Apellido del paciente
     */
    public void establecerApellido(String apellido){
        this.apellido = apellido;
    }
    /**
     * Obtiene el apellido del paciente
     * @return Apellido del paciente
     */
    public String obtenerApellido(){
        return apellido;
    }
    /**
     * Obtiene la edad del paciente
     * @return Edad del paciente
     */
    public int obtenerEdad(){
        return fechaActual.obtenerAnio() - fechaNacimiento.obtenerAnio();
    }
    /**
     * Obtiene la frecuencia máxima del paciente
     * @return Frecuencia cardiaca máxima
     */
    public int frecuenciaCardiacaMaxima(){
        return 220 - obtenerEdad();
    }
    /**
     * Muestra la frecuencia cardiaca esperada del paciente
     */
    public String frecuenciaCardiacaEsperada(){
        return String.format("La frecuencia cardiaca esperada esta en el rango de %.2f a %.2f%n",
                frecuenciaCardiacaMaxima() * .5, frecuenciaCardiacaMaxima() * .85);
    }
    /**
     * Devuelve una representación String del objeto
     * @return String
     */
    @Override
    public String toString(){
        return String.format("Nombre del paciente: %s %s%nFecha de nacimiento: %s%nInformacion medica%n%s", 
                obtenerNombre(), obtenerApellido(), fechaNacimiento, frecuenciaCardiacaEsperada());
    }
}
