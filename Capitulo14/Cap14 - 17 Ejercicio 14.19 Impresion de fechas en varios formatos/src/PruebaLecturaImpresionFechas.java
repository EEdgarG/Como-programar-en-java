/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Transforma una fecha en formato dd/mm/aaaa a formato MesActual dd, aaaa
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 23, 2020
 * @time 5:56:02 PM
 */
public class PruebaLecturaImpresionFechas {
    public static void main(String[] args){
        String fechaT = "02/29/2020";
        
        String[] f = separarFecha(fechaT);
        int mes = convertirStringANumero(f[0]);
        int dia = convertirStringANumero(f[1]);
        int anio = convertirStringANumero(f[2]);
        System.out.printf("%s%n", cambiarFormatoFecha(mes, dia, anio));
        
    }
    /**
     * Devuelve un arreglo de String y en cada elemento del arreglo hay números como cadenas String
     * @param fechaT String
     * @return String[]
     */
    public static String[] separarFecha(String fechaT){
        return fechaT.split("\\/");
    }
    /**
     * Devuelve el valor numerico de un String que almacena un número
     * @param num String
     * @return int
     */
    public static int convertirStringANumero(String num){
        return Integer.parseInt(num);
    }
    public static String cambiarFormatoFecha(int mes, int dia, int anio){
        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] meses = {"","Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
    "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        
        if(mes <= 0 || mes > 12)//< revisa que el mes este en rango
            throw new IllegalArgumentException("mes (" + mes + ") debe ser 1 - 12");
        
        if(dia <= 0 || (dia > diasPorMes[mes] && !(mes == 2 && dia == 29)))//< revisa si dia esta en el rango para mes
            throw new IllegalArgumentException("dia (" + dia + ") fuera de rango para el mes y anio especificados");
        
        if(mes == 2 && dia == 29 && !(anio % 400 == 0 || (anio % 4 == 0 && anio % 100 != 0)))//< revisa si es año bisiesto cuando mes es 2 y dia es 29
            throw new IllegalArgumentException("dia (" + dia + ") fuera de rango para el mes y año especificados");
        
        if(anio < 0)//< revisa si dia esta en rango positivo
            throw new IllegalArgumentException("año (" + anio + ") fuera de rango, el año debe ser mayor a cero");
        
        return String.format("%s %d, %d", meses[mes], dia, anio);
    }
}
