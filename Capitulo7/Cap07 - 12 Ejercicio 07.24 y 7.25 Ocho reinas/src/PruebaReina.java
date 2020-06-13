/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eedua
 */
public class PruebaReina {
    public static void main(String[] args){
//        //inicio ocho reinas usando solo una heuristica
//        OchoReinasHeuristica juego = new OchoReinasHeuristica();
//        System.out.printf("%s%n", juego);
//        juego.colocarOchoReinas();
//        System.out.printf("%s%n", juego);
//        //fin ocho reinas usando solo una heuristica
        
//        //inicio ocho reinas usando movimientos aleatorios
//        OchoReinasAleatoria juego2 = new OchoReinasAleatoria();
//        System.out.printf("%s%n", juego2);
//        juego2.colocarOchoReinasAleatoria();
//        System.out.printf("%s%n", juego2);
//        //fin ocho reinas usando movimientos aleatorios
        
        
        //inicio ocho reinas usando un metodo exhaustivo
        OchoReinasExhaustiva juego3 = new OchoReinasExhaustiva();
        System.out.printf("%s%n", juego3);
        juego3.colocarOchoReinasExhaustiva();
        System.out.printf("%s%n", juego3);
        //fin ocho reinas usando un metodo exhaustivo
        
        
        
//        OchoReinas juego = new OchoReinas();
//        
//        juego.obtenerTablero();
        
//        Reina re = new Reina(5, 6);
//        System.out.printf("Lugares ocupados%d%n", juego.contarLugaresReina(re));

//        System.out.printf("Cantidad de reinas ocupadas es %d%n", juego.colocarOchoReinasExhaustiva());
//        juego.obtenerTablero();
        
//        Reina reina1 = juego.simularRecorridoReina();
//        juego.realizarMovimientoReina(reina1);
//        System.out.println();
//        juego.obtenerTablero();
        
//        Reina reina2 = juego.simularRecorridoReina();
//        juego.realizarMovimientoReina(reina2);
//        System.out.println();
//        juego.obtenerTablero();
//        juego.eliminarReina(reina2);
//        System.out.println();
//        juego.obtenerTablero();
//        Reina re = new Reina(6, 5);
//        System.out.printf("Lugares ocupados%d%n", juego.contarLugaresReina(re));
//        
//        System.out.printf("Lugares ocupados%d%n", juego.contarLugaresHorizontal(re));
//        System.out.printf("Lugares ocupados%d%n", juego.contarLugaresVertical(re));
//        System.out.printf("Lugares ocupados%d%n", juego.contarPendienteDecrecienteInferior(re));
//        System.out.printf("Lugares ocupados%d%n", juego.contarPendienteCrecienteInferior(re));
////        
//        System.out.printf("Lugares ocupados%d%n", juego.contarPendienteDecrecienteSuperior(re));
//        System.out.printf("Lugares ocupados%d%n", juego.contarPendienteCrecienteSuperior(re));
//        System.gc();
//        Reina reina3 = juego.simularRecorridoReina();
//        juego.realizarMovimientoReina(reina3);
//        System.out.println();
//        juego.obtenerTablero();
//        
//        Reina reina4 = juego.simularRecorridoReina();
//        juego.realizarMovimientoReina(reina4);
//        System.out.println();
//        juego.obtenerTablero();
    }
}
