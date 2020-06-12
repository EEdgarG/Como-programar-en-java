/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 8/06/2020
 * @time 06:44:56 PM
 */
import java.util.Scanner;
import java.util.InputMismatchException;
public class PruebaJuegoGato {
    public static void main(String[] args){
        JuegoGato juego = new JuegoGato();
        Scanner entrada = new Scanner(System.in);
        
        boolean continuarCiclo = true;
        
        System.out.printf("Bienvenido al juego de gato%n%nEl estado actual del tablero es:%n%s%n", juego);
        
        do{
            
            try{
                
                boolean ganar = false;
                do{
                    
                    if(!juego.tableroLleno() && !juego.ganar(JuegoGato.Celda.X) && !juego.ganar(JuegoGato.Celda.O)){
                        
                        System.out.print("Para X: Introduce la posicion que quieres ocupar como fila y columna: ");
                        int fila = entrada.nextInt();//< Puede dar un InputMismatchExeption
                        int columna = entrada.nextInt();

                        juego.colocarX(fila, columna);//< Puede dar un IndexOutOfBoundsException o un IllegalArgumentException
                        System.out.printf("%s%n", juego);
                    }
                    
                    if(!juego.tableroLleno() && !juego.ganar(JuegoGato.Celda.X) && !juego.ganar(JuegoGato.Celda.O)){
                        
                        System.out.print("Para O: Introduce la posicion que quieres ocupar como fila y columna: ");
                        int fila = entrada.nextInt();
                        int columna = entrada.nextInt();
                        
                        juego.colocarO(fila, columna);
                        System.out.printf("%s%n", juego);
                    }
                    
                    if(juego.ganar(JuegoGato.Celda.X) || juego.tableroLleno())
                        ganar = true;
                    if(juego.ganar(JuegoGato.Celda.O) || juego.tableroLleno())
                        ganar = true;
                    
                }while(!ganar);
                
                if(juego.ganar(JuegoGato.Celda.X))
                    System.out.println("Gana X");
                else if(juego.ganar(JuegoGato.Celda.O))
                    System.out.println("Gana O");
                else
                    System.out.println("Empate");
                
                continuarCiclo = false;
            }
            catch(InputMismatchException | IndexOutOfBoundsException | IllegalArgumentException ia){
                System.err.printf("Introduce solo números validos");
                entrada.nextLine();
                System.gc();
            }
        }while(continuarCiclo);
    }
}
