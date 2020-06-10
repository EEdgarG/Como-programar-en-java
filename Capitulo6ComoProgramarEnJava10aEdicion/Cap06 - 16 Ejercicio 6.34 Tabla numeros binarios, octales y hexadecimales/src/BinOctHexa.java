/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Realiza la conversion de decimal a binario, octal y hexadecimal
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 1/05/2020
 * @time 11:30:59 AM
 */
public class BinOctHexa {
    public static void main(String[] args){
        System.out.println("Decimal\t\tBinario\t\tOctal\t\tHexadecimal");
        for(int numero = 0; numero < 256; numero++){
            System.out.printf("%3d\t%14d\t%12d\t%12s%n", numero, binario(numero), octal(numero), hexadecimal(numero));
        }
    }
    /**
     * Convierte un número decimal en binario
     * @param decimal Número en decimal
     */
    public static int binario(int decimal){
        int binario = 0;
        int contador = 1;
        if(decimal == 0){
            binario = 0;
        }
        while(decimal != 0){
            int digitoMenosSignificativo = decimal % 2;
            binario += (digitoMenosSignificativo * contador);
            contador *= 10;
            decimal = decimal / 2;
        }
        return binario;
    }
    /**
     * Convierte un número decimal en octal
     * @param decimal Número en decimal
     */
    public static int octal(int decimal){
        int octal = 0;
        int contador = 1;
        if(decimal < 8){
            octal = decimal;
        }
        else{
            while(decimal != 0){
                int digitoMenosSignificativo = decimal % 8;
                octal += (digitoMenosSignificativo * contador);
                contador *= 10;
                decimal = decimal / 8;
            }
        }
        return octal;
    }
    /**
     * Convierte un número decimal a hexadecimal
     * @param decimal Número en decimal
     */
    public static String hexadecimal(int decimal){
        String hexadecimal = "";
        if(decimal < 16){
            hexadecimal = numeracionH(decimal);
        }
        else{
            while(decimal != 0){
                int digitoMenosSignificativo = decimal % 16;
                String temporal = hexadecimal;
                hexadecimal = numeracionH(digitoMenosSignificativo) + temporal;
                decimal = decimal / 16;
            }
        }
        return hexadecimal;
    }
    /**
     * Contiene los valores numericos del sistema hexadecimal con respecto al decimal
     * @param decimal Número en decimal < 16
     * @return Numero de 1 digito en hexadecimal
     */
    public static String numeracionH(int decimal){
        String hexadecimal = "";
        if(decimal < 10)
                hexadecimal = decimal + "";
        else{
            switch(decimal){
                        case 10:
                            hexadecimal = "A";
                            break;
                        case 11:
                            hexadecimal = "B";
                            break;
                        case 12:
                            hexadecimal = "C";
                            break;
                        case 13:
                            hexadecimal = "D";
                            break;
                        case 14:
                            hexadecimal = "E";
                            break;
                        case 15:
                            hexadecimal = "F";
                            break;
                    }
        }
        return hexadecimal;
    }
}
