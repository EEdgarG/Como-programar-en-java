/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author eedua
 */
public class PruebaCaballo {
    public static void main(String[] args){
        
//         //Inicio de prueba caballo por fuerza bruta inciso b de 7.22
//         // cero casos de exito
//        CaballoB caballo1 = new CaballoB();
//        for(int i = 0; i < 8; i++){
//            for(int j = 0; j < 8; j++){
//                System.out.printf("fila %d, columna %d%n", i, j);
//                caballo1 = new CaballoB(i, j);
//                caballo1.recorrido();
////                System.out.printf("%s%n", caballo1);
//                System.out.printf("%s%n", caballo1.obtenerContador() == 65 ? "RECORRIDO COMPLETO" : "");
//            }
//        }
//        //Fin de prueba de caballo por fuerza bruta


//        //Inicio de prueba de caballo con heuristica por fuerza bruta
////        int fila = 6;
////        int columna = 0;
////        (1, 1), (2, 3), (5, 1), (6, 0) completan el recorrido
//        for(int fila = 0; fila < 8; fila++){//< 64 juegos de caballo variando posicion inicial
//            for(int columna = 0; columna < 8; columna++){
//                CaballoC caballo2 = new CaballoC(fila, columna);
//                caballo2.recorrido();
//                System.out.printf("%s", caballo2);
//                System.out.printf("fila: %d, columna: %d %s%n%n", fila, columna,
//                        caballo2.obtenerContador() == 65 ? "RECORRIDO COMPLETO" : "");
//            }
//        }
//        //Fin de prueba de caballo con heuristica por fuerza bruta


////        //Inicio de prueba de caballo con heuristica y mirando el mejor de los siguientes dos movimientos
////        int fila = 0;
////        int columna = 0;
//        for(int fila = 0; fila < 1; fila++){//< 64 juegos de caballo variando posicion inicial
//            for(int columna = 0; columna < 1; columna++){
//                CaballoD caballo3 = new CaballoD(fila, columna);
//                caballo3.recorrido();
//                System.out.printf("%s", caballo3);
//                System.out.printf("fila: %d, columna: %d %s%n%n", fila, columna,
//                        caballo3.obtenerContador() == 65 ? "RECORRIDO COMPLETO" : "");
//            }
//        }
////        //Fin de prueba de caballo con heuristica y mirando el mejor de los siguientes dos movimientos

        CaballoAleatorio caballo4 = new CaballoAleatorio();
        System.out.printf("%s%n", caballo4);
        caballo4.recorrido();
        System.out.printf("%s%n", caballo4);
        


//        //Inicio de caballo fuerza bruta heuristico aleatorio
//        int JUEGOS = 1000;
//        int sc = 0;
//        int contador = 0;
//        int[] paseos = new int[JUEGOS];
//        for(int i = 0; i < JUEGOS; i++)
//            paseos[i] = 0;
//        
//        
//        for(int juego = 0; juego < JUEGOS; juego++){
//            CaballoAleatorio caballo2 = new CaballoAleatorio();
////            caballo2.mostrarTablero();
////            System.out.println();
//            caballo2.recorrido();
//            paseos[juego] = caballo2.obtenerFracaso();
////            caballo2.mostrarTablero();
//            System.out.println("\n");
//        }
////        
//        for(int i = 0; i < JUEGOS; i++){
////            System.out.printf("paseo %d: llego al mov: %d%n", i, paseos[i]);
//            if(paseos[i] == 63){
//                System.out.printf("%n%nDETENETE! paseo %d: llego al mov: %d%n%n", i, paseos[i]);
//            }
//        }
//        System.out.println();
//
//
//        while(sc != 64){
//            CaballoAleatorio caballo2 = new CaballoAleatorio();
////            caballo2.mostrarTablero();
////            System.out.println();
//            caballo2.recorrido();
//            paseos[juego] = caballo2.obtenerFracaso();
////            caballo2.mostrarTablero();
//            System.out.println("\n");
//            sc = caballo2.obtenerFracaso();
//            contador++;
//        }
//        System.out.printf("paseo %d: llego al mov: 64%n", contador);
    }
}
