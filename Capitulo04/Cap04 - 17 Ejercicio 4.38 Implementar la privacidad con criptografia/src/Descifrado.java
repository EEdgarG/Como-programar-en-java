/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 24/04/2020
 * @time 07:04:54 PM
 */
public class Descifrado {
    private int unidadesMillarB;
    private int centenasA;
    private int decenasB;
    private int unidadesA;
    
    public Descifrado(int numero){
        separarDigitos(numero);
        intercambio();
        sumaResiduo();
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
     * Suma 10 a cada digito y luego le resta 7
     */
    public void sumaResiduo(){
        unidadesMillarB += 10;
        unidadesMillarB -= 7;
        if(unidadesMillarB > 9)
            unidadesMillarB -= 10;
        
        centenasA += 10;
        centenasA -= 7;
        if(centenasA > 9)
            centenasA -= 10;
        
        decenasB += 10;
        decenasB -= 7;
        if(decenasB > 9)
            decenasB -= 10;
        
        unidadesA += 10;
        unidadesA -= 7;
        if(unidadesA > 9)
            unidadesA -= 10;
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
