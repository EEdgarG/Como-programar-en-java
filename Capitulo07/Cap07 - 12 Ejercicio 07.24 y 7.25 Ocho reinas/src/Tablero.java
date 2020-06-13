/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Tablero de ajedrez, lugares vacios son iguales a cero
 * @author eedua
 */
public class Tablero {
    /**
     * Cantidad de filas del tablero
     */
    private final int FILAS = 8;
    /**
     * Cantidad de columnas del tablero
     */
    private final int COLUMNAS = 8;
    /**
     * Tablero de ajedrez
     */
    private int[][] tablero;
    /**
     * Inicialización del tablero de ajedrez con sus casillas en cero (desocupadas)
     */
    public Tablero(){
        tablero = new int[FILAS][COLUMNAS];
        for(int fila = 0; fila < FILAS; fila++){
            for(int columna = 0; columna < COLUMNAS; columna++){
                tablero[fila][columna] = 0;
            }
        }
    }
    /**
     * Marca una casilla con el entero "numero" en la posicion fila y columna 
     * @param fila Fila en la cual se va a modificar la posición
     * @param columna Columna en la cual se va a modificar la posición
     * @param numero Número con el cual se va a modificar la casilla
     */
    public void modificarTablero(int fila, int columna, int numero){
        tablero[fila][columna] = numero;
    }
    /**
     * Verifica si una casilla esta vacía
     * @param fila Fila en la cual se va a verificar la casilla vacía
     * @param columna Columna en la cual se va a verificar la casilla vacía
     * @return true si esta vacía la casilla o false en caso contrario
     */
    public boolean casillaVacia(int fila, int columna){
        return tablero[fila][columna] == 0;
    }
    /**
     * Obtiene la cantidad de filas del tablero
     * @return Cantidad de filas del tablero
     */
    public int obtenerFilas(){
        return FILAS;
    }
    /**
     * Obtiene la cantidad de columnas del tablero
     * @return Cantidad de columnas del tablero
     */
    public int obtenerColumnas(){
        return COLUMNAS;
    }
    /**
     * Muestra el estado actual del tablero i.e. lo imprime
     */
    public void mostrarTablero(){
        for(int fila = 0; fila < FILAS; fila++){
            for(int columna : tablero[fila]){
                System.out.printf("%2d ", columna);
            }
            System.out.println();
        }
    }
    /**
     * Obtiene el estado actual de una casilla especifica del tablero
     * @param fila Fila de la casilla a verificar estado
     * @param columna Columna de la casilla a verificar estado
     * @return Estado de la casilla: 0 para vacia
     */
    public int obtenerValor(int fila, int columna){
        return tablero[fila][columna];
    }
    
    /**
     * Muestra el estado del tablero en un objeto String
     * @return String estado del tablero
     */
    @Override
    public String toString(){
        String juego = "";
        for (int[] tablero1 : tablero) {
            for (int casilla : tablero1) {
                juego += String.format("%2d ", casilla);
            }
            juego += String.format("%n");
        }
        return juego;
    }
}
