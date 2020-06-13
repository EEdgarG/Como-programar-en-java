/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Reina
 * @author eedua
 */
public class Reina {
    /**
     * Fila actual de la reina
     */
    private int filaActual;
    /**
     * Columna actual de la reina
     */
    private int columnaActual;
    /**
     * Identificador de la reina, definido por la cantidad de casillas que ocupara
     */
    private int casillasOcupadas;
    /**
     * Inicializa la reina
     */
    public Reina(){
        filaActual = 0;
        columnaActual = 0;
        casillasOcupadas = 0;
    }
    /**
     * Inicializa la reina en una casilla especifica
     * @param filaActual Fila en la cual estara la reina
     * @param columnaActual Columna en la cual estara la reina
     */
    public Reina(int filaActual, int columnaActual){
        this.filaActual = filaActual;
        this.columnaActual = columnaActual;
        casillasOcupadas = 0;
    }
    /**
     * Inicializa la reina en una casilla especifica con un identificador unico
     * @param filaActual Fila en la cual estara la reina
     * @param columnaActual Columna en la cual estara la reina
     * @param casillasOcupadas Identificador unico de la reina
     */
    public Reina(int filaActual, int columnaActual, int casillasOcupadas){
        this.filaActual = filaActual;
        this.columnaActual = columnaActual;
        this.casillasOcupadas = casillasOcupadas;
    }
    /**
     * Modifica el identificador unico de la reina
     * @param casillasOcupadas Cantidad de casillas que ocupa la reina en una posicion
     */
    public void modificarCasillasOcupadas(int casillasOcupadas){
        this.casillasOcupadas = casillasOcupadas;
    }
    /**
     * Modifica la fila y columna actual de la reina
     * @param filaActual Fila de la reina
     * @param columnaActual Columna de la reina
     */
    public void modificarFilaColumna(int filaActual, int columnaActual){
        modificarFilaActual(filaActual);
        modificarColumnaActual(columnaActual);
    }
    /**
     * Modifica la fila actual de la reina
     * @param filaActual Fila de la reina
     */
    public void modificarFilaActual(int filaActual){
        this.filaActual = filaActual;
    }
    /**
     * Modifica la columna de la reina
     * @param columnaActual Columna de la reina
     */
    public void modificarColumnaActual(int columnaActual){
        this.columnaActual = columnaActual;
    }
    /**
     * Obtiene el identificador unico de la reina
     * @return Identificador de la reina
     */
    public int obtenerCasillasOcupadas(){
        return casillasOcupadas;
    }
    /**
     * Obtiene la fila actual de la reina
     * @return Fila de la reina
     */
    public int obtenerFilaActual(){
        return filaActual;
    }
    /**
     * Obtiene la columna actual de la reina
     * @return Columna de la reina
     */
    public int obtenerColumnaActual(){
        return columnaActual;
    }
}