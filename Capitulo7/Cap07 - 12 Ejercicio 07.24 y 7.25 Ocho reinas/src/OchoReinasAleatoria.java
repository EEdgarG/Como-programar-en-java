
import java.security.SecureRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 17/05/2020
 * @time 11:31:43 AM
 */
public class OchoReinasAleatoria {
    private Tablero tablero;
    /**
     * Inicializa el tablero
     */
    public OchoReinasAleatoria(){
        tablero = new Tablero();
    }
    /**
     * Coloca 8 reinas en un tablero de ajedrez eligiendo la posicion aleatoriamente
     * @return 
     */
    public int colocarOchoReinasAleatoria(){
        //mientas
        int cantidadReinas = 0;
        int casillasOcupadas = 0;
        
        while(casillasOcupadas < 64){//< Mientras la cantidad de casillas ocupadas sea menor a 64
            Reina reina = simularRecorridoReinaAleatoria();
            realizarMovimientoReina(reina);
            casillasOcupadas += reina.obtenerCasillasOcupadas();
            cantidadReinas++;
        }
        System.out.printf("casillas ocupadas %d%n", casillasOcupadas);
        return cantidadReinas;
    }
    /**
     * Entrega una reina con la posicion en la que ocuparia menos lugares en el tablero
     * @return reina
     */
    public Reina simularRecorridoReinaAleatoria(){
        SecureRandom posicion = new SecureRandom() ;
        int fila = posicion.nextInt(8);
        int columna = posicion.nextInt(8);
        
        while(!tablero.casillaVacia(fila, columna)){
            fila = posicion.nextInt(8);
            columna = posicion.nextInt(8);
        }
        
        Reina reinaAleatoria = new Reina(fila, columna);
        reinaAleatoria.modificarCasillasOcupadas(contarLugaresReina(reinaAleatoria));
        return reinaAleatoria;
    }
     /**
     * Cuenta los lugares que puede ocupa la reina en la posicion indicada
     * y devuelve ese numero como un entero
     * @param reina La reina (su posición)
     * @return cantidad de lugares ocupados por la reina
     */
    public int contarLugaresReina(Reina reina){
        return contarLugaresHorizontal(reina) + contarLugaresVertical(reina)
                + contarLugaresDiagonales(reina) + 1;
    }
    /**
     * Cuenta la cantidad de lugares ocupados por la reina en horizontal
     * @param reina
     * @return lugares ocupados por la reina
     */
    public int contarLugaresHorizontal(Reina reina){
        int cuentaHorizontal = 0;
        for(int columna = 0; columna < tablero.obtenerColumnas(); columna++){
            if(tablero.casillaVacia(reina.obtenerFilaActual(), columna) && columna != reina.obtenerColumnaActual()){
                cuentaHorizontal++;
            }
        }
        return cuentaHorizontal;
    }
    /**
     * Cuenta los lugares ocupados por la reina en direccion vertical
     * @param reina
     * @return Lugares ocupados por la reina
     */
    public int contarLugaresVertical(Reina reina){
        int cuentaVertical = 0;
        for(int fila = 0; fila < tablero.obtenerFilas(); fila++){
            if(tablero.casillaVacia(fila, reina.obtenerColumnaActual()) && fila != reina.obtenerFilaActual()){
                cuentaVertical++;
            }
        }
        return cuentaVertical;
    }
    /**
     * Cuenta las diagonales de la reina sin importar la ubicacion de la reina
     * @param reina
     * @return cantidad todal de casillas ocupadas por la reina
     */
    public int contarLugaresDiagonales(Reina reina){
        return contarPendienteDecrecienteSuperior(reina)
        + contarPendienteDecrecienteInferior(reina)
        + contarPendienteCrecienteSuperior(reina)
        + contarPendienteCrecienteInferior(reina);
    }
    /**
     * Cuenta la cantidad de lugares cubiertos por la reina cuando la diagonal es una pendiente decreciente
     * que pasa por arriba de la diagonal del tablero
     * @param reina
     * @return cantidad de lugares ocupados por la reina
     */
    public int contarPendienteDecrecienteSuperior(Reina reina){
        int cuentaPendienteDecrecienteSuperior = 0;
        if(reina.obtenerColumnaActual() >= reina.obtenerFilaActual()){
            int fila = 0;
            for(int columna = reina.obtenerColumnaActual() - reina.obtenerFilaActual(); columna < 8; columna++){
                if(tablero.casillaVacia(fila, columna) && columna != reina.obtenerColumnaActual() && fila != reina.obtenerFilaActual()){
                    cuentaPendienteDecrecienteSuperior++;
                }
                fila++;
            }
        }
        return cuentaPendienteDecrecienteSuperior;
    }
    /**
     * Cuenta los lugares ocupados por la reina en la direccion de una pendiente decreciente que pasa por debajo
     * de la diagonal del tablero
     * @param reina
     * @return numero de casillas alcanzadas por la reina
     */
    public int contarPendienteDecrecienteInferior(Reina reina){
        int cuentaPendienteDecrecienteInferior = 0;
        if(reina.obtenerFilaActual() > reina.obtenerColumnaActual()){
            int columna = 0;
            for(int fila = reina.obtenerFilaActual() - reina.obtenerColumnaActual(); fila < 8; fila++){
                if(tablero.casillaVacia(fila, columna) && fila != reina.obtenerFilaActual() && columna != reina.obtenerColumnaActual()){
                    cuentaPendienteDecrecienteInferior++;
                }
                columna++;
            }
        }
        return cuentaPendienteDecrecienteInferior;
    }
    /**
     * Cuenta los lugares cubiertos por la reina cuando la diagonal es de pendiente creciente y se encuentra
     * en la parte superior izquierdo del tablero
     * @param reina
     * @return total de casillas cubiertas por la reina
     */
    public int contarPendienteCrecienteSuperior(Reina reina){
        int cuentaPendienteCrecienteSuperior = 0;
        int sumaFC = reina.obtenerFilaActual() + reina.obtenerColumnaActual();
        if(sumaFC < 8){
            int fila = 0;
            for(int columna = reina.obtenerColumnaActual() + reina.obtenerFilaActual(); columna > -1; columna--){
                if(tablero.casillaVacia(fila, columna) && columna != reina.obtenerColumnaActual() && fila != reina.obtenerFilaActual()){
                    cuentaPendienteCrecienteSuperior++;
                }
                fila++;
            }
        }
        return cuentaPendienteCrecienteSuperior;
    }
    /**
     * Cuenta los lugares cubiertos por la reina cuando la diagonal es de pendiente creciente y se encuentra
     * en la parte inferior izquierda del tablero
     * @param reina
     * @return total de casillas cubiertas por la reina
     */
    public int contarPendienteCrecienteInferior(Reina reina){
        int cuentaPendienteCrecienteInferior = 0;
        int sumaFC = reina.obtenerFilaActual() + reina.obtenerColumnaActual();
        if(sumaFC >= 8){
            int columna = 7;
            for(int fila = reina.obtenerFilaActual() - (7 - reina.obtenerColumnaActual()); fila < 8; fila++){
                if(tablero.casillaVacia(fila, columna) && fila != reina.obtenerFilaActual() && columna != reina.obtenerColumnaActual()){
                    cuentaPendienteCrecienteInferior++;
                }
                columna--;
            }
        }
        return cuentaPendienteCrecienteInferior;
    }
    /**
     * Dada una reina en la posicion que ella guarda se realizan las modificaciones
     * en el tablero ocupando todas las casillas por las que la reina puede pasar
     * @param reina 
     */
    public void realizarMovimientoReina(Reina reina){
        modificarTablero(reina);
        movimientoHorizontal(reina);
        movimientoVertical(reina);
        movimientoDiagonales(reina);
    }
    /**
     * Coloca una reina en el tablero con el identificador de la cantidad de casillas que ocupa
     * @param reina 
     */
    public void modificarTablero(Reina reina){
        tablero.modificarTablero(reina.obtenerFilaActual(), reina.obtenerColumnaActual(), reina.obtenerCasillasOcupadas());
    }
    /**
     * Cubre todas las casillas en horizontal que la reina puede cubrir
     * @param reina 
     */
    public void movimientoHorizontal(Reina reina){
        for(int columna = 0; columna < tablero.obtenerColumnas(); columna++){
            if(tablero.casillaVacia(reina.obtenerFilaActual(), columna)){
                tablero.modificarTablero(reina.obtenerFilaActual(), columna, reina.obtenerCasillasOcupadas());
            }
        }
    }
    /**
     * Cubre todas las casillas en vertical que la reina puede cubrir
     * @param reina 
     */
    public void movimientoVertical(Reina reina){
        for(int fila = 0; fila < tablero.obtenerFilas(); fila++){
            if(tablero.casillaVacia(fila, reina.obtenerColumnaActual())){
                tablero.modificarTablero(fila, reina.obtenerColumnaActual(), reina.obtenerCasillasOcupadas());
            }
        }
    }
    /**
     * Cubre todas las casillas en diagonales que la reina puede cubrir
     * @param reina 
     */
    public void movimientoDiagonales(Reina reina){
        moverPendienteDecrecienteSuperior(reina);
        moverPendienteDecrecienteInferior(reina);
        moverPendienteCrecienteSuperior(reina);
        moverPendienteCrecienteInferior(reina);
    }
    /**
     * Cubre todas las casillas en diagonal que la reina puede cubrir cuando
     * la pendiente es decreciente y esta en la parte superior derecha del tablero
     * @param reina 
     */
    public void moverPendienteDecrecienteSuperior(Reina reina){
        if(reina.obtenerColumnaActual() >= reina.obtenerFilaActual()){
            int fila = 0;
            for(int columna = reina.obtenerColumnaActual() - reina.obtenerFilaActual(); columna < 8; columna++){
                if(tablero.casillaVacia(fila, columna)){
                    tablero.modificarTablero(fila, columna, reina.obtenerCasillasOcupadas());
                }
                fila++;
            }
        }
    }
    /**
     * Cubre todas las casillas en diagonal que la reina puede cubrir cuando la
     * pendiente es decreciente y esta en la parte inferior izquierda
     * @param reina 
     */
    public void moverPendienteDecrecienteInferior(Reina reina){
        if(reina.obtenerFilaActual() > reina.obtenerColumnaActual()){
            int columna = 0;
            for(int fila = reina.obtenerFilaActual() - reina.obtenerColumnaActual(); fila < 8; fila++){
                if(tablero.casillaVacia(fila, columna)){
                    tablero.modificarTablero(fila, columna, reina.obtenerCasillasOcupadas());
                }
                columna++;
            }
        }
    }
    /**
     * Cubre todas las casillas en diagonal que la reina puede cubrir cuando la
     * pendiente es creciente y esta en la parte superior izquierda
     * @param reina 
     */
    public void moverPendienteCrecienteSuperior(Reina reina){
        int sumaFC = reina.obtenerFilaActual() + reina.obtenerColumnaActual();
        if(sumaFC < 8){
            int fila = 0;
            for(int columna = reina.obtenerColumnaActual() + reina.obtenerFilaActual(); columna > -1; columna--){
                if(tablero.casillaVacia(fila, columna)){
                    tablero.modificarTablero(fila, columna, reina.obtenerCasillasOcupadas());
                }
                fila++;
            }
        }
    }
    /**
     * Cubre todas las casillas en diagonal que la reina puede cubrir cuando la
     * pendiente es creciente y esta en la parte inferior derecha
     * @param reina 
     */
    public void moverPendienteCrecienteInferior(Reina reina){
        int sumaFC = reina.obtenerFilaActual() + reina.obtenerColumnaActual();
        if(sumaFC >= 8){
            int columna = 7;
            for(int fila = reina.obtenerFilaActual() - (7 - reina.obtenerColumnaActual()); fila < 8; fila++){
                if(tablero.casillaVacia(fila, columna)){
                    tablero.modificarTablero(fila, columna, reina.obtenerCasillasOcupadas());
                }
                columna--;
            }
        }
    }
    @Override
    public String toString(){
        return tablero.toString();
    }
}
