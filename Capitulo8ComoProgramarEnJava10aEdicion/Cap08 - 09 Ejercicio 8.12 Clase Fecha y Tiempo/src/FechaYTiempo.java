/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Segundo ejemplo de la clase tiempo;
 * excepciones, referencias this y sobrecarga de constructores
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 2/05/2020
 * @time 11:57:41 AM
 */
public class FechaYTiempo {
    /**
     * Horas: 0 - 23
     */
    private int hora;
    /**
     * Minutos: 0 - 59
     */
    private int minuto;
    /**
     * Segundos 0 - 59
     */
    private int segundo;
    /**
     * Manjea la fecha
     */
    /**
     * Controla el mes, va del 1 al 12
     */
    private int mes;
    /**
     * Controla el dia, va del 1 al 31 con base en el mes
     */
    private int dia;
    /**
     * Controla el año, cualquier año
     */
    private int anio;
    
    private static final int[] diasPorMes =
    {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    /**
     * Constructor Tiempo2 sin argumentos
     * Inicializa cada variable de instancia a cero
     */
    public FechaYTiempo(){
        this(0, 0, 0, 1, 1, 0);//< Invoca al constructor de Tiempo2 con 6 argumentos
    }
    public FechaYTiempo(int hora, int minuto, int segundo, int mes, int dia, int anio){
        if(hora < 0 || hora >=24)
            throw new IllegalArgumentException("Hora debe estar entre 0 y 23");
        
        if(minuto < 0 || minuto >= 60)
            throw new IllegalArgumentException("Minuto debe estar entre 0 y 59");
        
        if(segundo < 0 || segundo >= 60)
            throw new IllegalArgumentException("Segundo debe estar entre 0 y 59");
        if(mes <= 0 || mes > 12)//< revisa que el mes este en rango
            throw new IllegalArgumentException("mes (" + mes + ") debe ser 1 - 12");
        
        if(dia <= 0 || (dia > diasPorMes[mes] && !(mes == 2 && dia == 29)))//< revisa si dia esta en el rango para mes
            throw new IllegalArgumentException("dia (" + dia + ") fuera de rango para el mes y anio especificados");
        
        if(mes == 2 && dia == 29 && !(anio % 400 == 0 || (anio % 4 == 0 && anio % 100 != 0)))//< revisa si es año bisiesto cuando mes es 2 y dia es 29
            throw new IllegalArgumentException("dia (" + dia + ") fuera de rango para el mes y año especificados");
        
        if(anio < 0)//< revisa si dia esta en rango positivo
            throw new IllegalArgumentException("año (" + anio + ") fuera de rango, el año debe ser mayor a cero");
        
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        
        this.mes = mes;
        this.dia = dia;
        this.anio = anio;
    }
    /**
     * Establece el tiempo
     * @param hora Hora
     * @param minuto Minuto
     * @param segundo Segundo
     */
    public void establecerTiempo(int hora, int minuto, int segundo){
        if(hora < 0 || hora >=24)
            throw new IllegalArgumentException("Hora debe estar entre 0 y 23");
        
        if(minuto < 0 || minuto >= 60)
            throw new IllegalArgumentException("Minuto debe estar entre 0 y 59");
        
        if(segundo < 0 || segundo >= 60)
            throw new IllegalArgumentException("Segundo debe estar entre 0 y 59");
        
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    /**
     * Valida y establece la hora
     * @param hora Hora
     */
    public void establecerHora(int hora){
        if(hora < 0 || hora >=24)
            throw new IllegalArgumentException("Hora debe estar entre 0 y 23");
        this.hora = hora;
    }
    /**
     * Establece minuto
     * @param minuto Minuto
     */
    public void establecerMinuto(int minuto){
        if(minuto < 0 || minuto >= 60)
            throw new IllegalArgumentException("Minuto debe estar entre 0 y 59");
        this.minuto = minuto;
    }
    /**
     * Establece segundo
     * @param segundo Segundo
     */
    public void establecerSegundo(int segundo){
        if(segundo < 0 || segundo >= 60)
            throw new IllegalArgumentException("Segundo debe estar entre 0 y 59");
        this.segundo = segundo;
    }
    /**
     * Devuelve la hora
     * @return Hora
     */
    public int obtenerHora(){
        return hora;
    }
    /**
     * Devuelve el minuto
     * @return Minuto
     */
    public int obtenerMinuto(){
        return minuto;
    }
    /**
     * Devuelve el segundo
     * @return Segundo
     */
    public int obtenerSegundo(){
        return segundo;
    }
    /**
     * Verifica que el año sea bisiesto
     * @return True si es año bisiesto, falso para cuando no lo es
     */
    public boolean esBisiesto(){
        boolean div4 = anio % 4 == 0;//< primer condicion de año bisiesto
        boolean anioSecular = anio % 100 == 0;//< año secular: debe ser falso para que sea biciesto
        boolean div400 = anio % 400 == 0;//< condicion unica para años seculares
        return div400 || (div4 && !anioSecular);
    }
    /**
     * Hace el cambio de dia con base en la cantidad de dias del mes, mas el caso especial
     * de febrero en año bisiesto. Si el dia llego a su limite del mes se hace 1 y avanza de mes
     */
    public void siguienteDia(){
        if(esBisiesto() && mes == 2 && dia == diasPorMes[mes])
                dia++;
        else if(dia == diasPorMes[mes] || (mes == 2 && dia == 29)){
            dia = 1;
            siguienteMes();
        }
        else
            dia++;
    }
    /**
     * Hace el cambio de mes, si el mes es el doceavo cambia de año
     */
    public void siguienteMes(){
        if(mes == 12){
            mes = 1;
            siguienteAnio();
        }
        else
            mes++;
    }
    /**
     * Hace el cambio de año
     */
    public void siguienteAnio(){
        anio++;
    }
    /**
     * Incrementa en 1 los segundos, si segundos son 59 regresa a 0
     * y aumenta en uno los minutos
     */
    public void ticTac(){
        if(segundo == 59){
            segundo = 0;
            incrementarMinuto();
        }
        else
            segundo++;
    }
    /**
     * Incrementa en uno los minutos, si los minutos son 59 regresa a 0
     * y aumenta en 1 las horas
     */
    public void incrementarMinuto(){
        if(minuto == 59){
            minuto = 0;
            incrementarHora();
        }
        else
            minuto++;
    }
    /**
     * Incrementa en 1 las horas, si las horas son 23 vuelve a 0
     */
    public void incrementarHora(){
        if(hora == 23){
            hora = 0;
            siguienteDia();
        }
        else{
            hora++;
        }
    }
    /**
     * Obtiene el mes
     * @return Mes
     */
    public int obtenerMes(){
        return mes;
    }
    /**
     * Obtiene el día
     * @return Día
     */
    public int obtenerDia(){
        return dia;
    }
    /**
     * Obtiene el año
     * @return Año
     */
    public int obtenerAnio(){
        return anio;
    }
    /**
     * Convierte a objeto String en formato de hora universal (HH:MM:SS)
     * @return Tiempo en formato String de hora universal
     */
    public String aStringUniversal(){
        return String.format("%02d:%02d:%02d %d/%d/%d", obtenerHora(), obtenerMinuto(), obtenerSegundo(),
                obtenerMes(), obtenerDia(), obtenerAnio());
    }
    /**
     * Convierte a objeto String en formato de hora estándar (H:MM:SS AM o PM)
     * @return Tiempo en formato de hora estándar
     */
    public String toString(){
        return String.format("%d:%02d:%02d %s %d/%d/%d", ((obtenerHora() == 0 || obtenerHora() == 12) ? 12: obtenerHora() % 12),
                obtenerMinuto(), obtenerSegundo(), (obtenerHora() < 12 ? "AM" : "PM"), obtenerMes(), obtenerDia(), obtenerAnio());
    }
}
