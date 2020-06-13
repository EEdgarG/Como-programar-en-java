/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Modificación al ejemplo 6.8 del libro.
 * Esta version hace conteo de juegos perdidos y ganados,
 * asi como la cantidad de pasos que tomo para ganar o perder
 * @author eedua
 */

import java.security.SecureRandom;

public class Craps {
    /**
     * Generador de números aleatorios seguros para usarlo en el método tirarDado
     */
    private static final SecureRandom numerosAleatorios = new SecureRandom();
    /**
     * Enumeración con constantes que representan el estado del juego
     */
    private enum Estado{
        CONTINUA, GANO, PERDIO
    }
    
    //constantes que representan tiros comunes del dado
    private static final int DOS_UNOS = 2;
    private static final int TRES = 3;
    private static final int SIETE = 7;
    private static final int ONCE = 11;
    private static final int DOCE = 12;
    
    public static void main(String[] args){
        int cantidad = 1000000;//< Un millon
        int[] ganados = new int[1000];//< Almacena la cantidad de juegos que se ganaron en tantos pasos
        int[] perdidos = new int[1000];//< Almacena la cantidad de juegos que se perdieron en tantos pasos
        
        inicializarArreglo(ganados);
        inicializarArreglo(perdidos);
        
        for(int i = 0; i < cantidad; i++){//< Cantidad de juegos que se realizan
            juegoCraps(ganados, perdidos);
        }
        
        mostrarSumaGanadosPerdidos(ganados, perdidos);
        System.out.printf("Total de juegos jugados: %,d%n", cantidad);
    }
    /**
     * Muestra la cantidad de juegos ganados y perdidos, asi como la suma de ganados y perdidos
     * @param ganados Arreglo de enteros que contiene la información de los juegos ganados
     * @param perdidos Arreglo de enteros que contiene la información de los juegos perdidos
     */
    public static void mostrarSumaGanadosPerdidos(int[] ganados, int[] perdidos){
        int sumaGanados = 0;//< Suma de control de la cantidad de juegos ganados
        int sumaPerdidos = 0;//< Suma de control de la cantidad de juegos perdidos
        
        System.out.println("Num juego\tGanados\t\tPerdidos\n");
        for(int contador = 0; contador < ganados.length; contador++){
            System.out.printf("%,4d\t\t%,3d\t\t%,3d%n", contador + 1, ganados[contador], perdidos[contador]);
            sumaGanados += ganados[contador];
            sumaPerdidos += perdidos[contador];
        }
        System.out.printf("Total de juegos ganados: %,d\tTotal de juegos perdidos: %,d%n", sumaGanados, sumaPerdidos);
    }
    /**
     * Realiza un juego de Craps llevando la cuenta de en cuantos pasos se gano o se perdio la partida
     * @param ganados Arreglo que contiene la cantidad de veces que se gano y la cantidad de pasos que tomo
     * @param perdidos Arreglo que contiene la cantidad de veces que se perdio y la cantidad de pasos que tomo
     * @return true si gana, false si pierde
     */
    public static boolean juegoCraps(int[] ganados, int[] perdidos){
        int gano = 1;
        int perdio = 1;
        boolean juego;//< Indica si gana o pierde con un boolean
        int miPunto = 0;//<punto si no gana o pierde en el primer tiro
        Estado estadoJuego;//< puede contener CONTINUA, GANO, PERDIO
        
        int sumaDeDados = tirarDados();
        switch(sumaDeDados){
            case SIETE://< Gana con 7 en el primer tiro
            case ONCE://< Gana con 11 en el primer tiro
                estadoJuego = Estado.GANO;
                ganados[0]++;//< Si se gana en el primer tiro se añade 1 en la posición cero de arreglo 
                break;
            case DOS_UNOS://< Pierde con 2 en el primer tiro
            case TRES://< Pierde con 3 en el primer tiro
            case DOCE://< Pierde con 12 en el primer tiro
                estadoJuego = Estado.PERDIO;
                perdidos[0]++;//< Si pierde en el primer tiro se añade 1 en la posición cero del arreglo
                break;
            default://< No gano ni perdió. por lo que guarda el punto
                estadoJuego = Estado.CONTINUA;//< No ha terminado el juego
                miPunto = sumaDeDados;//< Guarda el punto
                break;
        }
        
        while(estadoJuego == Estado.CONTINUA){
            sumaDeDados = tirarDados();//< Tira los dados de nuevo
            
            //determina el estado del juego
            if(sumaDeDados == miPunto){//< Gana haciendo un punto
                estadoJuego = Estado.GANO;
                ganados[gano]++;//< En la posición "gano" (puede ser desde 1 hasta que termine el juego) del arreglo se suma uno
                gano = 1;//< Se hace uno la posicion
            }
            else if(sumaDeDados == 7){//< Pierde al tirar 7 antes del punto
                estadoJuego = Estado.PERDIO;
                perdidos[perdio]++;//< En la posición "perdio" (puede ser desde 1 hasta que termine el juego) del arreglo se suma uno
                perdio = 1;//< Se hace uno la posición
            }
            gano++;//< Se suma uno a la posición actual
            perdio++;//< Se suma uno a la posición actual
        }
        
        //Muestra mensaje de que ganó o perdió
        if(estadoJuego == Estado.GANO){
//            System.out.println("El jugador gana");
            juego = true;
        }
        else{
//            System.out.println("El jugador pierde");
            juego = false;
        }
        return juego;
    }
    /**
     * Realiza el tiro de dos dados y suma los resultados mostrando en la salida estandar el resultado de cada dado
     * asi como su suma
     * @return Suma de los valores de los dos dados lanzados
     */
    public static int tirarDados(){
        //elige valores aleatorios para los dados
        int dado1 = 1 + numerosAleatorios.nextInt(6);//<primer tiro del dado
        int dado2 = 1 + numerosAleatorios.nextInt(6);//< segundo tiro del dado
        
        int suma = dado1 + dado2;//< suma de los valores de los dados
        
        //muestra los resultados de este tiro
//        System.out.printf("El jugador tiro %d + %d = %d%n", dado1, dado2, suma);
        return suma;
    }
    /**
     * Inicializa los valores de los elementos del arreglo de enteros a cero
     * @param arreglo Arreglo que es inicializado
     */
    public static void inicializarArreglo(int[] arreglo){
        for(int i = 0; i < arreglo.length; i++){
            arreglo[i] = 0;
        }
    }
}
