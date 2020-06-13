/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eedua
 */

import java.security.SecureRandom;

public class CaballoAleatorio {
    /**
     * Tablero de ajedrez inicialmente vacio(en ceros)
     */
    private int[][] tablero;
    /**
     * Fila actual del caballo
     */
    private int filaActual;
    /**
     * Columna actual del caballo
     */
    private int columnaActual;
    /**
     * Movimientos del caballo en horizontal
     */
    private final int[] horizontal = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
    /**
     * Movimientos del caballo en vertical
     */
    private final int[] vertical = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    /**
     * Identificador unico para cada movimiento valido del caballo
     */
    private int contador;
    /**
     * Realiza los movimientos aleatorios del caballo
     */
    private final SecureRandom eleccion = new SecureRandom();
    
    private boolean movimiento;
    
    private int fracaso;
    
    CaballoAleatorio(){
        fracaso = 0;
        movimiento = false;
        
        contador = 1;
        
        //inicio posicion aleatoria del caballo
        filaActual = eleccion.nextInt(8);
        columnaActual = eleccion.nextInt(8);
        //fin posicion aleatoria del caballo
        
        //inicializa el tablero
        tablero = new int[8][8];
        for(int i = 0; i < tablero.length; i++){
            for(int j = 0; j < tablero[i].length; j++){
                tablero[i][j] = 0;
            }
        }
        tablero[filaActual][columnaActual] = contador++;//< posicion inicial del caballo
        //fin de inicializacion de tablero
    }
    
    public void recorrido(){
        for(int mov = 0; mov < 63; mov++){//<ciclo principal
            int indiceMovMenor = busMov();
            
            if(movimiento)
                moverCaballo(indiceMovMenor);//< arreglo de posibles movimientos
            else{
//                System.out.printf("movimiento: %2d es falso%n", mov+1);
                if(fracaso == 0)
                    fracaso = mov + 1;
            }
        }
    }
    
    public int busMov(){
        boolean[] movimientosValidos = new boolean[8];
        inicializarValidos(movimientosValidos);
        
        int sinOpciones = 0;
        
        int mov = 0;
        
        movimiento = false;
        
        for(int nMov = 0; nMov < 8; nMov++){//< encuentra movimientos validos
            if(validacionBordesCasilla(nMov)){
                    movimientosValidos[nMov] = true;
                    movimiento = true;
            }
        }
        
        sinOpciones = sinMovimientos(movimientosValidos);
        
        if(sinOpciones == 8){
//            System.out.println("no quedan movimientos disponibles");
            movimiento = false;
        }
        else{
            mov = movimientoAleatorio(movimientosValidos);
        }
        return mov;
    }
    /**
     * Realiza un movimiento aleatorio dentro de un arreglo de movimientos validos
     * @param arreglo boolean Arreglo con los movimientos validos en true
     * @return int Indice de movimiento
     */
    private int movimientoAleatorio(boolean[] arreglo){
        int indice = eleccion.nextInt(8);
        while(arreglo[indice] == false){
            indice = eleccion.nextInt(8);
        }
        return indice;
    }
    /**
     * Determina si existen opciones de movimientos
     * @param arreglo boolean Contiene los movimientos que se pueden realizar
     * @return int Cantidad de movimientos invalidos
     */
    private int sinMovimientos(boolean[] arreglo){
        int sinOpciones = 0;
        for(boolean elemento: arreglo){
            if(elemento == false)
                sinOpciones++;
        }
        return sinOpciones;
    }
    /**
     * Inicializa los elementos de un arreglo booleano con false
     * @param arreglo boolean[] Arreglo a inicializar
     */
    private void inicializarValidos(boolean[] arreglo){
        for(int i = 0; i < arreglo.length; i++){
            arreglo[i] = false;
        }
    }
    /**
     * Dado un indice de movimiento a realizar, determina si el movimiento esta dentro del tablero y si la casilla donde busca
     * posicionarse esta vacia.
     * @param indice int indice de movimiento a realizar por le caballo
     * @return boolean, true si esta dentro del tablero y la casilla esta vacia, false en caso contrario
     */
    private boolean validacionBordesCasilla(int indice){
        return dentroTablero(indice) && casillaVacia(indice);
    }
    /**
     * Determina si el movimiento que intenta realizar el caballo
     * esta dentro del tablero
     * @param indice int Tipo de movimiento ejecutado por el caballo
     * @return boolean true si esta dentro del tablero, false si esta fuera
     */
    private boolean dentroTablero(int indice){
        return (filaActual + vertical[indice] >= 0) && (columnaActual + horizontal[indice] >= 0)
                && (filaActual + vertical[indice] < 8) && (columnaActual + horizontal[indice] < 8);
    }
    /**
     * Determina si la casilla donde se puede mover el caballo esta vacía
     * @param indice int Número de movimiento que pretende ejecutar el caballo
     * @return boolean true si la casilla esta vacía, false en caso contrario
     */
    private boolean casillaVacia(int indice){
        return tablero[filaActual + vertical[indice]][columnaActual + horizontal[indice]] == 0;
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
    
    public int obtenerFracaso(){
        return fracaso;
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