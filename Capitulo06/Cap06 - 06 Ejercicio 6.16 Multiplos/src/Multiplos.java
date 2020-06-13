/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Por medio de un metodo llamado esMultiplo() que recibe dos números enteros determina si el segundo es multiplo del primero
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 28/04/2020
 * @time 06:42:40 PM
 */
public class Multiplos {
    public static void main(String[] args){
        int numeroA = 14;
        int numeroB = 7;
        System.out.printf("El número %d %s multiplo de %d%n", numeroB, (esMultiplo(numeroA, numeroB) ? "es" : "no es"), numeroA);
    }
    /**
     * Determina si numeroB es multiplo de numeroA
     * @param numeroA Número base
     * @param numeroB Número a checar si es multiplo de numeroA
     * @return True si numeroB es multiplo de numeroA, False si numeroB no es multiplo de numeroA
     */
    public static boolean esMultiplo(int numeroA, int numeroB){
        return (numeroB % numeroA) == 0;
    }
}
