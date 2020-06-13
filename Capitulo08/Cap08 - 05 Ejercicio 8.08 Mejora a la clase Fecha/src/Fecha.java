/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 4/05/2020
 * @time 04:13:53 PM
 */
public class Fecha {
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
     * Confirma el valor apropiado para el mes y el día, dado el año
     * @param mes Mes actual
     * @param dia Día actual
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
        
        System.out.printf("Constructor de objeto Fecha para la fecha %s%n", this);
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
     * Devuelve un objeto String de la forma mes/dia/año
     * @return 
     */
    public String toString(){
        return String.format("%d/%d/%d", mes, dia, anio);
    }
}
