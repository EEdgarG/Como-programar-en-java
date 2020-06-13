/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 8/06/2020
 * @time 06:28:58 PM
 */
public class JuegoGato {
    /**
     * Conjunto de valores que puede contener una celda
     */
    public static enum Celda{
        X, O, VACIO;
    };
    /**
     * Tablero de juego gato
     */
    private Celda[][] tablero;
    /**
     * Tamaño del tablero
     */
    private static final int TAMANOTABLERO = 3;
    public JuegoGato(){
        tablero = new Celda[TAMANOTABLERO][TAMANOTABLERO];//< Tablero de 3 por 3
        for(Celda[] fila: tablero){
            for(int columna = 0; columna < fila.length; columna++){
                fila[columna] = Celda.VACIO;
            }
        }
    }
    /**
     * Coloca una X en la posición especificada
     * @param fila int
     * @param columna int 
     */
    public void colocarX(int fila, int columna){
        if(tablero[fila][columna] != Celda.VACIO)
            throw new IllegalArgumentException("La posición esta ocupada");
        
        tablero[fila][columna] = Celda.X;
    }
    /**
     * Devuelve true si encuentra 3 elementos (X, O o Vacio) en la misma fila, columna o diagonal
     * @param celda Celda
     * @return boolean
     */
    public boolean ganar(Celda celda){
        if(tresEnFila(celda) || tresEnColumna(celda) || tresEnDiagonalAdelante(celda) ||tresEnDiagonalAtras(celda))
            return true;
        else
            return false;
    }
    /**
     * Coloca una O en la posición especificada
     * @param fila int
     * @param columna int 
     */
    public void colocarO(int fila, int columna){
        if(tablero[fila][columna] != Celda.VACIO)
            throw new IllegalArgumentException("La posición esta ocupada");
        
        tablero[fila][columna] = Celda.O;
    }
    /**
     * MÉTODO DE APOYO
     * Devuelve true si en una sola fila encuentra el enum especificado (X, O o Vacio)
     * @param celda Celda
     * @return boolean
     */
    private boolean tresEnFila(Celda celda){
        int x = 0;
        for(int fila = 0; fila < tablero.length; fila++){
            for(int columna = 0; columna < tablero[fila].length; columna++){
                if(tablero[fila][columna] == celda)
                    x++;
            }
            if(x < tablero.length)
                x = 0;
        }
        if(x == 3)
            return true;
        else
            return false;
    }
    /**
     * MÉTODO DE APOYO
     * Devuelve true si en una sola columna encuentra el enum especificado (X, O o Vacio);
     * @param celda Celda
     * @return boolean
     */
    private boolean tresEnColumna(Celda celda){
        int x = 0;
        for(int columna = 0; columna < tablero.length; columna++){
            for(int fila = 0; fila < tablero[columna].length; fila++){
                if(tablero[fila][columna] == celda)
                    x++;
            }
            if(x < tablero.length)
                x = 0;
        }
        if(x == 3)
            return true;
        else
            return false;
    }
    /**
     * MÉTODO DE APOYO
     * Devuelve true si encuentra 3 X o O (depende del valor de celda) en diagonal inclinada hacia adelante
     * @param celda Celda
     * @return boolean
     */
    private boolean tresEnDiagonalAdelante(Celda celda){
        int d = 0;
        for(int diagonal = 0; diagonal < tablero.length; diagonal++){
            if(tablero[diagonal][diagonal] == celda)
                d++;
        }
        if(d == 3)
            return true;
        else
            return false;
    }
    /**
     * MÉTODO DE APOYO
     * Devuelve true si encuentra 3 X o O (depende del valor de celda) en diagonal inclinada hacia atras
     * @param celda Celda
     * @return boolean
     */
    private boolean tresEnDiagonalAtras(Celda celda){
        int d = 0;
        for(int diagonal = 0; diagonal < tablero.length; diagonal++){
            if(tablero[diagonal][tablero.length -1 - diagonal] == celda)
                d++;
        }
        if(d == 3)
            return true;
        else
            return false;
    }
    
    public boolean tableroLleno(){
        int lleno = 0;
        for(Celda[] fila: tablero){
            for(Celda columna: fila)
                if(columna != Celda.VACIO)
                    lleno++;
        }
        if(lleno == (9))
            return true;
        else
            return false;
    }
    /**
     * Muestra el juego de gato en una representación String
     * @return String
     */
    @Override
    public String toString(){
        String s = new String();
        for(Celda[] fila: tablero){
            for(Celda columna: fila){
                if(columna == Celda.VACIO)
                    s += " ";
                else
                    s += columna;
                
                s += " | ";
            }
            s += String.format("%n");
            
            for(int columna = 0; columna < fila.length; columna++){
                s += "________";
            }
            s += String.format("%n");
            
            s += String.format("%n");
        }
        
        return s;
    }
}
