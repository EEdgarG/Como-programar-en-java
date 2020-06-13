/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Prueba del paseo del caballo con solo fuerza bruta para resolverlo
 * inciso b del ejercicio 7.22
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 12/05/2020
 * @time 06:44:03 PM
 */
public class CaballoB {
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
     * Describe los movimientos en horizontal que puede realizar el caballo
     */
    private final int[] horizontal = new int[]{2, 1, -1, -2, -2, -1, 1, 2};;
    /**
     * Describe los movimientos en vertical que puede realizar el caballo
     */
    private final int[] vertical = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    /**
     * Se usa para identificar los lugares donde ha estado el caballo, con el número de movimiento realizado
     */
    private int contador;
    /**
     * Inicializa el tablero y el caballo, en el caso del caballo lo coloca en la posición (0,0)
     */
    CaballoB(){
        this(0, 0);//< llama al constructor de dos argumentos
    }
    /**
     * Inicializa el tablero a sus valores predeterminados
     * En el caso del caballo lo inicializa a un lugar definido
     * @param filaActual Fila actual que tendra el caballo
     * @param columnaActual Columna actual que tendra el caballo
     */
    CaballoB(int filaActual, int columnaActual){
        if(filaActual < 0 || filaActual > 7)
            throw new IllegalArgumentException("La fila supero las filas del tablero");
        
        if(columnaActual < 0 || columnaActual > 7)
            throw new IllegalArgumentException("La columna supero las columnas del tablero");
        
        contador = 1;//< Contador se hace uno para la posición inicial del caballo
        
        this.filaActual = filaActual;//< Se elige la posición inicial de la fila del caballo
        this.columnaActual = columnaActual;//< Se elige la posición inicial de la columna del caballo
        
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
     * Metodo principal del caballo. Realiza el recorrido del caballo
     */
    public void recorrido(){
        int numeroMovimiento = 0;
        
        while(numeroMovimiento < 8){//< Recorre los movimientos y realiza el primero encontrado
            
            if(dentroTablero(numeroMovimiento) && casillaVacia(numeroMovimiento)){
                moverCaballo(numeroMovimiento);
                numeroMovimiento = 0;
            }
            else
                numeroMovimiento++;//< cambia de movimiento
        }
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
     * Mueve al caballo a la posición indicada por el numeroMovimiento
     * @param numeroMovimiento int Indice de número de movimiento que ejecutara el caballo
     */
    private void moverCaballo(int numeroMovimiento){
        filaActual += vertical[numeroMovimiento];//< Le suma las casillas definidas por el numeroMovimiento
        columnaActual += horizontal[numeroMovimiento];//< Suma las casiilas definidas por el numeroMovimiento
        tablero[filaActual][columnaActual] = contador++;//< Se marca la casilla actual del caballo con su identificador de movimiento
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
