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
public class Tiempo2 {
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
     * Constructor Tiempo2 sin argumentos
     * Inicializa cada variable de instancia a cero
     */
    public Tiempo2(){
        this(0, 0, 0);//< Invoca al constructor de Tiempo2 con 3 argumentos
    }
    /**
     * Se suministra hora; minuto y segundo con valor predeterminado de 0
     * @param hora Hora suministrada al constructor
     */
    public Tiempo2(int hora){
        this(hora, 0, 0);//< Invoca al constructor con e argumentos
    }
    /**
     * Se suministra hora y minuto; segundo con valor predeterminado de 0
     * @param hora Hora suministrada
     * @param minuto Minuto suministrado
     */
    public Tiempo2(int hora, int minuto){
        this(hora, minuto, 0);//< Invoca al constructor con 3 argumentos
    }
    /**
     * Se suministran hora, minuto y segundo
     * @param hora Hora suministrada
     * @param minuto Minuto suministrado
     * @param segundo Segundo suministrado
     */
    public Tiempo2(int hora, int minuto, int segundo){
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
     * Se suministra otro objeto Tiempo2
     * @param tiempo Objeto Tiempo2
     */
    public Tiempo2(Tiempo2 tiempo){
        //invoca al constructor con 3 argumentos
        this(tiempo.obtenerHora(), tiempo.obtenerMinuto(), tiempo.obtenerSegundo());
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
        }
        else
            hora++;
    }
    /**
     * Convierte a objeto String en formato de hora universal (HH:MM:SS)
     * @return Tiempo en formato String de hora universal
     */
    public String aStringUniversal(){
        return String.format("%02d:%02d:%02d", obtenerHora(), obtenerMinuto(), obtenerSegundo());
    }
    /**
     * Convierte a objeto String en formato de hora estándar (H:MM:SS AM o PM)
     * @return Tiempo en formato de hora estándar
     */
    public String toString(){
        return String.format("%d:%02d:%02d %s", ((obtenerHora() == 0 || obtenerHora() == 12) ? 12: obtenerHora() % 12),
                obtenerMinuto(), obtenerSegundo(), (obtenerHora() < 12 ? "AM" : "PM"));
    }
}
