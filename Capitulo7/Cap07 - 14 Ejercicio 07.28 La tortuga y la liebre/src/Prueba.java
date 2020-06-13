/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Simula la carreta de la tortuga y la liebre
 * @author eedua
 */
import java.security.SecureRandom;

public class Prueba {
    private static int tortuga = 1;
    private static int liebre = 1;
    
    public static void main(String[] args){
        SecureRandom tiempo = new SecureRandom();
        
        System.out.println("PUM!!!!\nY ARRANCAN!!!!!");
        mostrarJuego();
        while(tortuga < 70 && liebre < 70){
            tipoMovimiento(tiempo.nextInt(9 + 1));
            mostrarJuego();
        }
        obtenerGanador();
    }
    
    public static void tipoMovimiento(int tiempo){
        movimientoTortuga(tiempo);
        movimientoLiebre(tiempo);
    }
    public static void movimientoTortuga(int tiempo){
        if(tiempo >= 1 && tiempo <= 5){//<paso pesado rapido
            tortuga += 3;
        }
        else if(tiempo >= 6 && tiempo <= 7){//<resbalon
            tortuga -= 6;
            if(tortuga < 1)
                tortuga = 1;
        }
        else if(tiempo >= 8 && tiempo <= 10){//<paso pesado lento
            tortuga += 1;
        }
    }
    public static void movimientoLiebre(int tiempo){
        if(tiempo >= 1 && tiempo <= 2){//<dormir
            ;
        }
        else if(tiempo >= 3 && tiempo <= 4){//<gran salto
            liebre += 9;
        }
        else if(tiempo == 5){//<gran resbalon
            liebre -= 12;
            if(liebre < 1)
                liebre = 1;
        }
        else if(tiempo >= 6 && tiempo <= 8){//<pequeño salto
            liebre += 1;
        }
        else if(tiempo >= 9 && tiempo <= 10){//<pequeño resbalon
            liebre -= 2;
            if(liebre < 1)
                liebre = 1;
        }
    }
    public static void mostrarJuego(){
        for(int lugar = 0; lugar < 70; lugar++){
            System.out.printf("%4d ", lugar + 1);
        }
        System.out.println();
        System.out.print("   ");
        for(int lugar = 1; lugar < 71; lugar++){
            if(liebre == tortuga && lugar == liebre)
                System.out.print("OUCH ");
            else{
                if(lugar == tortuga)
                    System.out.print("T    ");
                else if(lugar == liebre)
                    System.out.print("H    ");
                else
                    System.out.print("     ");
            }
        }
        System.out.println();
    }
    public static void obtenerGanador(){
        if(tortuga > liebre)
            System.out.printf("Tortuga gana, posicion: %d%n", tortuga);
        else if(liebre > tortuga)
            System.out.printf("Liebre gana, posicion: %d%n", liebre);
        else if(tortuga == liebre)
            System.out.printf("Empate, posicion tortuga: %d, posicion liebre: %d%n", tortuga, liebre);
    }
}
