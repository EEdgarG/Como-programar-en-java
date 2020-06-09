/**
 *
 * @author EEdgar
 * @verion Alfa 1
 * 7/12/17, 4:36pm
 * Clase fecha
 */
public class Fecha {
    /**
     * Mes del año
     */
    private int mes;
    /**
     * Dia del año
     */
    private int dia;
    /**
     * Año actual
     */
    private int anio;
    /**
     * Contiene los dias que tiene cada mes
     */
    private static final int[] diasPorMes =
    {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    /**
     * Constructor que inicializa todas las variables de instancia
     * @param mes Mes del año
     * @param dia Dia del año
     * @param anio Año actual
     */
    public Fecha(int mes, int dia, int anio){
        if(mes <= 0 || mes > 12)//< revisa que el mes este en rango
            throw new IllegalArgumentException("mes (" + mes + ") debe ser 1 - 12");
        
        if(dia <= 0 || (dia > diasPorMes[mes] && !(mes == 2 && dia == 29)))//< revisa si dia esta en el rango para mes
            throw new IllegalArgumentException("dia (" + dia + ") fuera de rango para el mes y anio especificados");
        
        if(mes == 2 && dia == 29 && !(anio % 400 == 0 || (anio % 4 == 0 && anio % 100 != 0)))//< revisa si es año bisiesto cuando mes es 2 y dia es 29
            throw new IllegalArgumentException("dia (" + dia + ") fuera de rango para el mes y año especificados");
        
        if(anio < 0)//< revisa si dia esta en rango positivo
            throw new IllegalArgumentException("año (" + anio + ") fuera de rango, el año debe ser mayor a cero");
        
        this.mes = mes;
        this.dia = dia;
        this.anio = anio;
    }
    /**
     * Establece el dia del año
     * @param dia Dia del año
     */
    public void establecerDia(int dia){
        if(dia <= 0 || (dia > diasPorMes[mes] && !(mes == 2 && dia == 29)))//< revisa si dia esta en el rango para mes
            throw new IllegalArgumentException("dia (" + dia + ") fuera de rango para el mes y anio especificados");
        
        if(mes == 2 && dia == 29 && !(anio % 400 == 0 || (anio % 4 == 0 && anio % 100 != 0)))//< revisa si es año bisiesto cuando mes es 2 y dia es 29
            throw new IllegalArgumentException("dia (" + dia + ") fuera de rango para el mes y año especificados");
        
        this.dia = dia;
    }
    /**
     * Obtiene el dia del año
     * @return Dia del año
     */
    public int obtenerDia(){
        return dia;
    }
    /**
     * Establece el mes del año
     * @param mes Mes del año
     */
    public void establecerMes(int mes){
        if(mes <= 0 || mes > 12)//< revisa que el mes este en rango
            throw new IllegalArgumentException("mes (" + mes + ") debe ser 1 - 12");
        
        this.mes = mes;
    }
    /**
     * Obtiene el mes del año
     * @return Mes del año
     */
    public int obtenerMes(){
        return mes;
    }
    /**
     * Establece el año actual
     * @param anio Año actual
     */
    public void establecerAnio(int anio){
        if(anio < 0)//< revisa si dia esta en rango positivo
            throw new IllegalArgumentException("año (" + anio + ") fuera de rango, el año debe ser mayor a cero");
        
        this.anio = anio;
    }
    /**
     * Obtiene el año actual
     * @return Año actual
     */
    public int obtenerAnio(){
        return anio;
    }
    /**
     * Devuelve un objeto String de la forma mm/dd/aaaa
     * @return 
     */
    @Override
    public String toString(){
        return String.format("%2d/%2d/%2d", mes, dia, anio);
    }
}
