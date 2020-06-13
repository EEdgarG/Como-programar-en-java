/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Prueba del paseo del caballo con una heuristica de accesibilidad para resolverlo
 * inciso c del ejercicio 7.22
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 12/05/2020
 * @time 07:52:53 PM
 */
public class CaballoC {
    /**
     * primera y ultima fila del arreglo de accesibilidad
     */
    private final int[] fila1 = {2, 3, 4, 4, 4, 4, 3, 2};
    /**
     * Segunda y penultima fila del arreglo de accesibilidad
     */
    private final int[] fila2 = {3, 4, 6, 6, 6, 6, 4, 3};
    /**
     * Tercera, cuarta y quinta fila del arreglo de accesibilidad
     */
    private final int[] fila3 = {4, 6, 8, 8, 8, 8, 6, 4};
    /**
     * Contiene un tablero marcado con una jeqrarquia de accesibilidad, siendo las
     * casillas con el número menor las de acceso más dificil
     */
    private final int[][] accesibilidad = new int[][]{fila1, fila2, fila3, fila3, fila3, fila3, fila2, fila1};
    /**
     * Movimientos del caballo en horizontal
     */
    private final int[] horizontal = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
    /**
     * Movimientos del caballo en vertical
     */
    private final int[] vertical = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    /**
     * Tablero de ajedrez
     */
    private int[][] tablero;
    /**
     * Controla fila actual del caballo
     */
    private int filaActual;
    /**
     * Controla la columna actual del caballo
     */
    private int columnaActual;
    /**
     * Se usa para identificar los lugares donde ha estado el caballo, con el número de movimiento realizado
     */
    private int contador;
    /**
     * Indica si el movimiento se puede realizar
     */
    private boolean movimiento = false;
    /**
     * Constructor predeterminado, inicializa la posicion del caballo en 0,0
     */
    CaballoC(){
        this(0, 0);
    }
    /**
     * Inicaliza la posición inicial fila y columna del caballo a un lugar definido por el usuario
     * @param fila int Fila de la posición inicial del caballo esta entre 0 y 7
     * @param columna int Columna de la posición inicial del caballo esta entre 0 y 7
     */
    CaballoC(int filaActual, int columnaActual){
        if(filaActual < 0 || filaActual > 7)
            throw new IllegalArgumentException("La fila supero las filas del tablero");
        
        if(columnaActual < 0 || columnaActual > 7)
            throw new IllegalArgumentException("La columna supero las columnas del tablero");
        
        contador = 1;
        
        this.filaActual = filaActual;
        this.columnaActual = columnaActual;
        
        // Inicializa el tablero colocando al caballo en su posicion inicial
        tablero = new int[8][8];
        for (int[] tablero1 : tablero) {
            for (int j = 0; j < tablero1.length; j++) {
                tablero1[j] = 0;
            }
        }
        tablero[this.filaActual][this.columnaActual] = contador++;//< posicion inicial del caballo
    }
    /**
     * Realiza el movimiento del caballo, en caso de ser invalido el movimiento mostrara un aviso
     */
    public void recorrido(){
        for(int mov = 0; mov < 63; mov++){//< recorre todas las casillas
            int indiceMovimientoMenor = buscarMovMenor();
            if(movimiento)
                moverCaballo(indiceMovimientoMenor);
        }
    }
    /**
     * Obtiene el indice del movimiento donde la jerarquia de accesibilidad es menor
     * eso con la finalidad de que se eliminen las posiciones mas problematicas primero
     * @return int Indice con el movimiento donde la jerarquia de accesibilidad es menor
     */
    private int buscarMovMenor(){
        int indiceMovMenor = 0;
        int movMenor = 8;//< se usa para poder elegir la casilla con la menor jerarquia (8 es la mas grande)
        movimiento = false;
        
        for(int numMov = 0; numMov < 8; numMov++){//< recorre los 8 movimientos que puede realizar el caballo
            //< si el movimiento esta dentro del tablero, la casilla esta vacia y el movimiento encontrado tiene una jararquia
            //de posicion menor
            if(dentroTablero(numMov) && casillaVacia(numMov) && (simularMovimiento(numMov) <= movMenor)){
                indiceMovMenor = numMov;
                movMenor = simularMovimiento(numMov);
                movimiento = true;
            }
        }
        return indiceMovMenor;
    }
    /**
     * Determina si el movimiento que intenta realizar el caballo
     * esta dentro del tablero
     * @param numMov int Tipo de movimiento ejecutado por el caballo
     * @return boolean true si esta dentro del tablero, false si esta fuera
     */
    private boolean dentroTablero(int numMov){
        return (filaActual + vertical[numMov] >= 0)
                && (columnaActual + horizontal[numMov] >= 0)
                && (filaActual + vertical[numMov] < 8)
                && (columnaActual + horizontal[numMov] < 8);
    }
    /**
     * Determina si la casilla donde se puede mover el caballo esta vacía
     * @param numMov int Número de movimiento que pretende ejecutar el caballo
     * @return boolean true si la casilla esta vacía, false en caso contrario
     */
    private boolean casillaVacia(int numMov){
        return tablero[filaActual + vertical[numMov]][columnaActual + horizontal[numMov]] == 0;
    }
    /**
     * Verifica la jerarquia de la casilla dado un indice de movimiento que
     * realiza el caballo
     * @param numeroMovimiento int Indice de tipo de movimiento a efectuar por el caballo
     * @return int Jerarquia de la casilla
     */
    private int simularMovimiento(int numeroMovimiento){
        return accesibilidad[filaActual + vertical[numeroMovimiento]][columnaActual + horizontal[numeroMovimiento]];
    }
    /**
     * Realiza el movimiento del caballo con el indice del movimiento a realizar
     * @param numeroMovimiento Indice del movimiento a realizar
     */
    public void moverCaballo(int numeroMovimiento){
        filaActual += vertical[numeroMovimiento];
        columnaActual += horizontal[numeroMovimiento];
        tablero[filaActual][columnaActual] = contador++;
    }
    /**
     * Obtiene el contador de movimientos efectivos del caballo
     * @return int Contador de movimientos del caballo
     */
    public int obtenerContador(){
        return contador++;
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
