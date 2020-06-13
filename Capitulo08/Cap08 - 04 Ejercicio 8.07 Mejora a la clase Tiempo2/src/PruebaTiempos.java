/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Modificación del ejemplo 8.5
 * Se crean 3 metodos mas, uno que aumenta en uno la hora y regresa a cero cuando se llega a 24
 * otro que aumenta en uno los minutos y regresa a cero cuando se llega a 60 y aumenta en uno las horas
 * y otro que aumenta en uno los segundos y regresa a cero cando llega a 60 y aumenta en uno los minutos
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 2/05/2020
 * @time 12:15:13 PM
 */
public class PruebaTiempos {
    public static void main(String[] args){
        Tiempo2 t4 = new Tiempo2(23, 58, 58);
        for(int i = 0; i < 130; i++){
            t4.ticTac();
            mostrarTiempo("t4: se especificaron hora, minuto y segundo", t4);
        }
    }
    /**
     * Muestra un objeto Tiempo2 en formatos de 24 y 12 horas
     * @param encabezado String con el encabezado de impresión
     * @param t Objeto tipo Tiempo2
     */
    private static void mostrarTiempo(String encabezado, Tiempo2 t){
        System.out.printf("%s%n %s%n %s%n", encabezado, t.aStringUniversal(), t.toString());
    }
}
