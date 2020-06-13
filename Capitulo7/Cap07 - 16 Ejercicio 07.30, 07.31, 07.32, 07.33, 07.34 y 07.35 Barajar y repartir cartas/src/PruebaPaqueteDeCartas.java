/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eedua
 */
public class PruebaPaqueteDeCartas {
    public static void main(String[] args){
        PaqueteDeCartas paqueteDeCartas = new PaqueteDeCartas();
        paqueteDeCartas.barajar();
        
//        Carta[] manoA = new Carta[5];
//        manoA[0] = new Carta("Cuatro", "Treboles");
//        manoA[1] = new Carta("Nueve", "Espadas");
//        manoA[2] = new Carta("As", "Diamantes");
//        manoA[3] = new Carta("Cinco", "Corazones");
//        manoA[4] = new Carta("Tres", "Treboles");
//        
//        Carta[] manoB = new Carta[5];
//        manoB[0] = new Carta("Joker", "Espadas");
//        manoB[1] = new Carta("Tres", "Corazones");
//        manoB[2] = new Carta("Rey", "Treboles");
//        manoB[3] = new Carta("Cuatro", "Diamantes");
//        manoB[4] = new Carta("Dos", "Diamantes");
        
        Carta[] manoA = paqueteDeCartas.repartirMano();
        
        Carta[] manoB = paqueteDeCartas.repartirMano();
        
//        Carta[] manoC = paqueteDeCartas.repartirMano();
//        Carta[] manoD = paqueteDeCartas.repartirMano();
//        Carta[] manoE = paqueteDeCartas.repartirMano();
//        Carta[] manoF = paqueteDeCartas.repartirMano();
//        Carta[] manoG = paqueteDeCartas.repartirMano();
//        Carta[] manoH = paqueteDeCartas.repartirMano();
//        Carta[] manoI = paqueteDeCartas.repartirMano();
//        Carta[] manoJ = paqueteDeCartas.repartirMano();
//        Carta[] manoK = paqueteDeCartas.repartirMano();
        
        PaqueteDeCartas.mostrarCartas(manoA);
        System.out.println();
        PaqueteDeCartas.mostrarCartas(manoB);
        System.out.println();

        PaqueteDeCartas.compararManos(manoA, manoB);
        
//        PaqueteDeCartas.mostrarCartas(manoB);
//        System.out.println();
//        PaqueteDeCartas.identificarMano(manoB);
        
//        PaqueteDeCartas.mostrarCartas(manoC);
//        System.out.println();
//        PaqueteDeCartas.mostrarCartas(manoD);
//        System.out.println();
//        PaqueteDeCartas.mostrarCartas(manoE);
//        System.out.println();
//        PaqueteDeCartas.mostrarCartas(manoF);
//        System.out.println();
//        PaqueteDeCartas.mostrarCartas(manoG);
//        System.out.println();
//        PaqueteDeCartas.mostrarCartas(manoH);
//        System.out.println();
//        PaqueteDeCartas.mostrarCartas(manoA);
//        System.out.println();
//        PaqueteDeCartas.mostrarCartas(manoI);
//        System.out.println();
//        PaqueteDeCartas.mostrarCartas(manoJ);
//        System.out.println();
//        PaqueteDeCartas.mostrarCartas(manoK);
//        System.out.println();
    }
}