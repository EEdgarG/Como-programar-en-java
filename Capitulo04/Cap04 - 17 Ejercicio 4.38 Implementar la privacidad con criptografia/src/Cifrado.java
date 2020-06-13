/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 24/04/2020
 * @time 06:11:20 PM
 */
public class Cifrado {
    private int unidadesMillarB;
    private int centenasA;
    private int decenasB;
    private int unidadesA;
    
    public Cifrado(int numero){
        separarDigitos(numero);
        sumaResiduo();
        intercambio();
    }
    /**
     * Separa los digitos del numero
     * @param numero Numero de 4 digitos
     */
    public void separarDigitos(int numero){
        unidadesA = numero % 10; 
        numero -= unidadesA;
        
        decenasB = numero % 100 / 10;
        numero -= decenasB;
        
        centenasA = numero % 1000 / 100;
        numero -= centenasA;
        
        unidadesMillarB = numero % 10000 / 1000;
        numero -= unidadesMillarB;
        
    }
    /**
     * Suma 7 a cada digito y luego obiene el modulo 10
     */
    public void sumaResiduo(){
        unidadesMillarB += 7;
        unidadesMillarB %= 10;
        
        centenasA += 7;
        centenasA %= 10;
        
        decenasB += 7;
        decenasB %= 10;
        
        unidadesA += 7;
        unidadesA %= 10;
    }
    /**
     * Intercambia el primer digito con el tercero y el segundo con el cuarto
     */
    public void intercambio(){
        int temporal = unidadesMillarB;
        unidadesMillarB = decenasB;
        decenasB = temporal;
        
        temporal = centenasA;
        centenasA = unidadesA;
        unidadesA = temporal;
    }
    /**
     * Muestra la suma de los digitos con su correspondiente valor
     * @return Suma del los digitos
     */
    public int resultado(){
        return (unidadesMillarB * 1000) + (centenasA * 100) + (decenasB * 10) + unidadesA;
    }
}
