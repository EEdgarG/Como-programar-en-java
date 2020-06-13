/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Modificación al juego de Craps del ejemplo 6.8
 * Esta modidicación realiza apuestas
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 30/04/2020
 * @time 06:46:00 PM
 */
import java.security.SecureRandom;
import java.util.Scanner;
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
        Scanner entrada = new Scanner(System.in);
        double saldoBanco = 1000f;
        
        while(saldoBanco != 0){
            System.out.print("Ingrese su apuesta: ");
            double apuesta = entrada.nextFloat();
            while(apuesta < 0 || apuesta > saldoBanco){
                System.out.print("Ingrese una apuesta valida: ");
                apuesta = entrada.nextFloat();
            }
            if(juegoCraps())
                saldoBanco += apuesta;
            else
                saldoBanco -= apuesta;
            System.out.printf("Ahora tienes %f%n", saldoBanco);
            mensaje(saldoBanco);
        }
    }
    public static boolean juegoCraps(){
        boolean juego;
        int miPunto = 0;//<punto si no gana o pierde en el primer tiro
        Estado estadoJuego;//< puede contener CONTINUA, GANO, PERDIO
        
        int sumaDeDados = tirarDados();
        switch(sumaDeDados){
            case SIETE://< Gana con 7 en el primer tiro
            case ONCE://< Gana con 11 en el primer tiro
                estadoJuego = Estado.GANO;
                break;
            case DOS_UNOS://< Pierde con 2 en el primer tiro
            case TRES://< Pierde con 3 en el primer tiro
            case DOCE://< Pierde con 12 en el primer tiro
                estadoJuego = Estado.PERDIO;
                break;
            default://< No gano ni perdió. por lo que guarda el punto
                estadoJuego = Estado.CONTINUA;//< No ha terminado el juego
                miPunto = sumaDeDados;//< Guarda el punto
                break;
        }
        
        while(estadoJuego == Estado.CONTINUA){
            sumaDeDados = tirarDados();//< Tira los dados de nuevo
            
            //determina el estado del juego
            if(sumaDeDados == miPunto)//< Gana haciendo un punto
                estadoJuego = Estado.GANO;
            else if(sumaDeDados == 7)//< Pierde al tirar 7 antes del punto
                estadoJuego = Estado.PERDIO;
        }
        
        //Muestra mensaje de que ganó o perdió
        if(estadoJuego == Estado.GANO){
            System.out.println("El jugador gana");
            juego = true;
        }
        else{
            System.out.println("El jugador pierde");
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
        System.out.printf("El jugador tiro %d + %d = %d%n", dado1, dado2, suma);
        return suma;
    }
    
    public static void mensaje(double i){
        if(i <= 100)
            System.out.println("Parece que estas frito");
        if(i > 100 && i <= 200)
            System.out.println("Te estas quedando sin saldo");
        if(i > 200 && i <= 500)
            System.out.println("Cuidado amigo, estas perdiendo");
        if(i > 500 && i <= 1000)
            System.out.println("Cuidado amigo, estas perdiendo");
        if(i > 1000 && i <= 1500)
            System.out.println("Vaya vaya");
        if(i > 1500 && i <= 2000)
            System.out.println("Vaya que eres buen apostador");
        if(i > 2000)
            System.out.println("Maestro");
    }
}
