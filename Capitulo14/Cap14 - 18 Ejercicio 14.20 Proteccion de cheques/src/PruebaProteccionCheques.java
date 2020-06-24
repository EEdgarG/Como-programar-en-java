/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 23, 2020
 * @time 7:29:35 PM
 */
public class PruebaProteccionCheques {
    public static void main(String[] args){
        String cantidadT = "1800.56";
        
        String[] cantidadD = dividirNumero(cantidadT);
        String cantidadE = cantidadD[0];
        String cantidadDecimal = cantidadD[1];
        
        String numero = "";
        for(int i = 0; i < 9 - cantidadE.length(); i++){
            numero += "*";
        }
        numero += cantidadE + "." + cantidadDecimal;
        System.out.printf("%s%n", numero);
        
        System.out.printf("%s con %s/100%n", numeroEnteroALetras(cantidadE), cantidadDecimal);
    }
    /**
     * Devuelve un arreglo String con la parte entera del numero en una posición y la flotante en otra
     * @param cantidad String
     * @return String[]
     */
    public static String[] dividirNumero(String cantidad){
        return cantidad.split("[.]");
    }
    /**
     * Devuelve un String de un numero menor a 2000 convertido en letras
     * @param numero String
     * @return String
     */
    public static String numeroEnteroALetras(String numero){
        int n = Integer.parseInt(numero);
        
        if(n > 1999 || n < 0)
            throw new IllegalArgumentException("El número debe ser >= 0 o <= 1000");
        
        int millar = n / 1000;//< uno o cero
        n -= millar * 1000;
        int centenas = n / 100;
        n -= centenas * 100;
        int decenas = n / 10;
        n -= decenas * 10;
        int unidades = n;
        String nf = convertirMillares(millar) + convertirCentenas(centenas);
        switch(decenas){
            case 2:
                if(unidades != 0)
                    nf += " veinti" + convertirUnidades(unidades);
                else
                    nf += " veinte";
                break;
            case 1:
                if(unidades == 0)
                    nf += " diez";
                else
                    nf += convertirUnidadesB(unidades);
                break;
            case 0:
                if(unidades != 0)
                    nf += " " + convertirUnidades(unidades);
                break;
            default:
                nf += convertirDecenas(decenas);
                switch(unidades){
                    case 0:
                        break;
                    default:
                        nf += " y " + convertirUnidades(unidades);
                        break;
                }
                break;
        }
        return nf;
    }
    /**
     * Devuelve un String con el valor común de las unidades
     * @param unidades int
     * @return String
     */
    public static String convertirUnidades(int unidades){
        String u = "";
        switch(unidades){
            case 9:
                u += "nueve";
                break;
            case 8:
                u += "ocho";
                break;
            case 7:
                u += "siete";
                break;
            case 6:
                u += "seis";
                break;
            case 5:
                u += "cinco";
                break;
            case 4:
                u += "cuatro";
                break;
            case 3:
                u += "tres";
                break;
            case 2:
                u += "dos";
                break;
            case 1:
                u += "uno";
                break;
        }
        return u;
    }
    /**
     * Devuelve un String con el valor de las unidades cuando las decenas valen uno
     * @param unidades int
     * @return String
     */
    public static String convertirUnidadesB(int unidades){
        String u = " ";
        switch(unidades){
            case 9:
                u += "diecinueve";
                break;
            case 8:
                u += "dieciocho";
                break;
            case 7:
                u += "diecisiete";
                break;
            case 6:
                u += "dieciseis";
                break;
            case 5:
                u += "quince";
                break;
            case 4:
                u += "catorce";
                break;
            case 3:
                u += "trece";
                break;
            case 2:
                u += "doce";
                break;
            case 1:
                u += "once";
                break;
        }
        return u;
    }
    /**
     * Convierte las decenas en letras
     * @param decenas int
     * @return String
     */
    public static String convertirDecenas(int decenas){
        String d = " ";
        switch(decenas){
            case 9:
                d += "noventa";
                break;
            case 8:
                d += "ochenta";
                break;
            case 7:
                d += "setenta";
            case 6:
                d += "sesenta";
                break;
            case 5:
                d += "cincuenta";
                break;
            case 4:
                d += "cuarenta";
                break;
            case 3:
                d += "treinta";
                break;
            case 2:
                d += "veinte";
                break;
            case 1:
                d += "diez";
                break;
        }
        return d;
    }
    /**
     * Devuelve las centenas convertidas a letras
     * @param centenas int
     * @return String
     */
    public static String convertirCentenas(int centenas){
        String c = " ";
        switch(centenas){
            case 9:
                c += "novecientos";
                break;
            case 8:
                c += "ochocientos";
                break;
            case 7:
                c += "setecientos";
                break;
            case 6:
                c += "seiscientos";
                break;
            case 5:
                c += "quinientos";
                break;
            case 4:
                c += "cuatrocientos";
                break;
            case 3:
                c += "trescientos";
                break;
            case 2:
                c += "doscientos";
                break;
            case 1:
                c += "ciento";
                break;
        }
        return c;
    }
    /**
     * Devuelve el millar convertido en letras
     * @param millar int
     * @return String
     */
    public static String convertirMillares(int millar){
        if(millar == 0)
            return "";
        else
            return "mil";
    }
}
