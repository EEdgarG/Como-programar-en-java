/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Modificación a la clase Tiempo2 de la figura 8.5.
 * La modificación de la clase Tiempo2 no afecta en su uso
 * A la clase pruebaTiempos no se le hizo nunguna modificación
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 2/05/2020
 * @time 12:15:13 PM
 */
public class PruebaTiempos {
    public static void main(String[] args){
        //INICIO DE PRUEBA DE CLASE TIEMPO2
        Tiempo2 t1 = new Tiempo2();//00:00:00
        Tiempo2 t2 = new Tiempo2(2);//02:00:00
        Tiempo2 t3 = new Tiempo2(21, 34);//21:34:00
        Tiempo2 t4 = new Tiempo2(12, 25, 42);//12:25:42
        Tiempo2 t5 = new Tiempo2(t4);//12:25:42
        
        System.out.println("Se construyo con: ");
        mostrarTiempo("t1: todos los argumentos predetermninados", t1);
        mostrarTiempo("t2: se especifico hora; minuto y segundo predeterminados", t2);
        mostrarTiempo("t3: se especificaron hora y minuto; segundo predeterminado", t3);
        mostrarTiempo("t4: se especificaron hora, minuto y segundo", t4);
        mostrarTiempo("t5: se especifico el objeto Tiempo2 llamado t4", t5);
        
        //intento de inicializar t6 con valores inválidos
        try{
            Tiempo2 t6 = new Tiempo2(27, 74, 99);//< valores inválidos
        }
        catch(IllegalArgumentException e){
            System.out.printf("%nExcepcion al inicializar t6: %s%n", e.getMessage());
        }
        
        //FIN DE PRUEBA DE CLASE TIEMPO2
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
