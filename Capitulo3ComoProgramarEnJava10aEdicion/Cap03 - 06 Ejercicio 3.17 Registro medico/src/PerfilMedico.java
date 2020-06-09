/**
 *
 * @author EEdgar
 * @version Alfa 1
 * 12/12/17, 10:07am
 * Clase perfil medico
 */

public class PerfilMedico {
    /**
     * Nombre de la persona
     */
    private Persona persona;
    /**
     * Sexo del paciente
     */
    private String sexo;
    /**
     * Fecha de nacimiento del paciente
     */
    private Fecha fecha_nacimiento;
    /**
     * Fecha actual
     */
    private Fecha fecha_actual;
    /**
     * Altura del paciente
     */
    private int altura;
    /**
     * Peso del paciente
     */
    private int peso;
    /**
     * Este constructor inicializa todas las variables de instancia con valores definidos por el usuario
     * @param nombre String
     * @param apellido String
     * @param sexo String
     * @param diaN int
     * @param mesN int
     * @param anioN int
     * @param mesA int
     * @param diaA int
     * @param anioA int
     * @param altura int en cm
     * @param peso int en kg
     */
    public PerfilMedico(String nombre, String apellido, String sexo, int mesN,
            int diaN, int anioN, int mesA, int diaA, int anioA, int altura, int peso){
        if(peso <= 0)
            throw new IllegalArgumentException("El peso debe ser > 0");
        
        persona = new Persona(nombre, apellido);
        
        fecha_nacimiento = new Fecha(mesN, diaN, anioN);
        fecha_actual = new Fecha(mesA, diaA, anioA);
        
        this.sexo = sexo;
        this.peso = peso;
        establecerAltura(altura);
    }
    /**
     * Establece el genero del paciente
     * @param sexo Genero del paciente
     */
    public void establecerSexo(String sexo){
        this.sexo = sexo;
    }
    /**
     * Obtiene el sexo del paciente
     * @return Sexo del paciente
     */
    public String obtenerSexo(){
        return sexo;
    }
    /**
     * Establece la altura del paciente
     * @param altura Altura del paciente
     */
    public void establecerAltura(int altura){
        if(altura <= 0)
            throw new IllegalArgumentException("La altura no puede ser < 0");
        this.altura = altura;
    }
    /**
     * Obtiene la altura del paciente
     * @return Altura del paciente
     */
    public int obtenerAltura(){
        return altura;
    }
    /**
     * Establece el peso del paciente
     * @param peso Peso del paciente
     */
    public void establecerPeso(int peso){
        if(peso <= 0)
            throw new IllegalArgumentException("El peso debe ser > 0");
            this.peso = peso;
    }
    /**
     * Obtiene el peso del paciente
     * @return  Peso del paciente
     */
    public int obtenerPeso(){
        return peso;
    }
    /**
     * Obtiene la edad del paciente
     * @return Edad del paciente
     */
    public int obtenerEdad(){
        return fecha_actual.obtenerAnio() - fecha_nacimiento.obtenerAnio();
    }
    /**
     * Calcula la frecuencia cardiaca máxima del paciente
     * @return Frecuencia cardiaca máxima
     */
    public int frecuenciaCardiacaMaxima(){
        return 220 - obtenerEdad();
    }
    /**
     * Calcula la frecuencia cardiaca esperada y la muestra en la salida estandar
     */
    public void frecuenciaCardiacaEsperada(){
        System.out.printf("La frecuencia cardiaca esperada esta en el rango de %.2f a %.2f%n",
                frecuenciaCardiacaMaxima() * .5, frecuenciaCardiacaMaxima() * .85);
    }
    /**
     * Calcula el indice de masa corporal
     * @return Indice de masa corporal
     */
    public double BMI(){
        return peso / ((altura / 100.0) * (altura / 100.0));
    }
    /**
     * Representacion String del perfil medico de un paciente
     * @return String
     */
    @Override
    public String toString(){
        return String.format("Paciente: %s%nInformación%nAltura: %d,\tpeso: %d,\tsexo: %s\tFecha de nacimiento: %s", 
                persona, obtenerAltura(), obtenerPeso(), obtenerSexo(), fecha_nacimiento);
    }
}
