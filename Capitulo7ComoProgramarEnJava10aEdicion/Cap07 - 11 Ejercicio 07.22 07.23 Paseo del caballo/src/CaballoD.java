/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Prueba del paseo del caballo con una heuristica de accesibilidad y acertando en el mejor movimiento de dos movimientos
 * empatados
 * inciso d del ejercicio 7.22
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 12/05/2020
 * @time 07:36:54 PM
 */
public class CaballoD {
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
     * Identificador unico para cada movimiento valido del caballo
     */
    private int contador;
    /**
     * Indica si el movimiento se puede realizar
     */
    private boolean movimiento = false;
    /**
     * Constructor predeterminado, inicializa la posicion del caballo en (0,0)
     */
    CaballoD(){
        this(0, 0);
    }
    /**
     * Inicializa la posición inicial del caballo con parametros del contstructor
     * @param fila int Fila inicial del caballo
     * @param columna int Columna inicial del caballo
     */
    CaballoD(int filaActual, int columnaActual){
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
     * Metodo principal, realiza el paseo del caballo
     */
    public void recorrido(){
        for(int nMov = 0; nMov < 64; nMov++){//<ciclo principal
                int indiceMovimientoMenor = buscarMovMenor();
            if(movimiento)
                moverCaballo(indiceMovimientoMenor);//< mueve el caballo
//            else
//                System.out.printf("movimiento: %2d es falso%n", nMov + 1);
        }
    }
    /**
     * Obtiene el indice del movimiento donde la jerarquia de accesibilidad es menor
     * eso con la finalidad de que se eliminen las posiciones mas problematicas primero
     * @return int Indice con el movimiento donde la jerarquia de accesibilidad es menor
     */
    private int buscarMovMenor(){
        int indiceMovMenor = 0;
        int jerarquiaMenor = 8;//< se usa para poder elegir la casilla con la menor jerarquia (8 es la mas grande)
        movimiento = false;
        
        for(int numMov = 0; numMov < 8; numMov++){//< recorre los 8 movimientos que puede realizar el caballo
            //< si el movimiento esta dentro del tablero, la casilla esta vacia y el movimiento encontrado tiene una jararquia
            //de posicion menor
            if(validacionBordesCasilla(numMov) && (jerarquiaMovimiento(numMov) <= jerarquiaMenor)){
                indiceMovMenor = numMov;
                jerarquiaMenor = jerarquiaMovimiento(numMov);
                movimiento = true;
            }
        }
        if(movimiento){//< si encontro un movimiento
            indiceMovMenor = movimientosEmpatados(jerarquiaMenor);//< se buscan todos los elementos con la misma jerarquia
        }
        
        return indiceMovMenor;
    }
    
    /**
     * Busca todos los movimientos cuya jerarquia coincida con el parametro del metodo
     * @param movimientoMenorJerarquia int jerarquia del movimiento valido
     */
    private int movimientosEmpatados(int movimientoMenorJerarquia){
        boolean[] empatados = new boolean[8];
        inicializarEmpatados(empatados);
        
        for(int movimiento = 0; movimiento < 8; movimiento++){//< recorre los 8 movimientos que puede realizar el caballo
            if(validacionBordesCasilla(movimiento) && (jerarquiaMovimiento(movimiento) == movimientoMenorJerarquia)){
                empatados[movimiento] = true;
            }
        }
        return movimientoMenor(empatados);
    }
    /**
     * Inicializa los elementos de un arreglo booleano con false
     * @param arreglo boolean[] Arreglo a inicializar
     */
    private void inicializarEmpatados(boolean[] arreglo){
        for(int i = 0; i < arreglo.length; i++){
            arreglo[i] = false;
        }
    }
    /**
     * Dado un arreglo con movimientos validos (todos con la misma jerarquia de movimiento y todos con la jerarquia menor
     * encontrada) busca para cada movimiento valido su mejor movimiento, el que tenga el mejor movimiento (jerarquia
     * menor) se elige para realizar el movimiento.
     * @param arreglo boolean[] Arreglo con movimientos validos (con true)
     * @return int indice del movimiento mas eficiente
     */
    private int movimientoMenor(boolean[] arreglo){
        int jerarquiaMenor = 8;//< de manera predeterminada la jerarquia del movimiento menor es 8 (el mayor)
        int indiceElegido = 0;//< el indice del movimiento a realizar
        
        for(int movimiento = 0; movimiento < arreglo.length; movimiento++){//<Recorre todo el arreglo
            
            if(arreglo[movimiento] == true){//< si hay un indice con un movimiento valido (en true)
                
                int jerarquiaSiguiente = mejorMovimientoSiguiente(movimiento);
                
                if(jerarquiaSiguiente <= jerarquiaMenor){//<si la jerarquia del movimiento encontrado es menor
                    jerarquiaMenor = jerarquiaSiguiente;
                    indiceElegido = movimiento;
                }
            }
        }
        
        return indiceElegido;
    }
    /**
     * Dado un indice de movimiento, encuentra el mejor de sus posibles movimientos siguientes
     * @param indice int Indice de movimiento desde donde se realiza la busqueda
     * @return int Jerarquia menor hallada en el tablero de accesibilidad
     */
    private int mejorMovimientoSiguiente(int indice){
        int fila = this.filaActual + vertical[indice];//< fila actual temporal
        int columna = this.columnaActual + horizontal[indice];//< columna actual temporal
        int jerarquiaMenor = 8;//< de manera predeterminada la jerarquia del movimiento menor es 8 (el mayor)
        
        for(int movimiento = 0; movimiento < 8; movimiento++){//< recorrido de los 8 movimientos del caballo
            if(validacionBordesCasilla(fila, columna, movimiento) && (jerarquiaMovimiento(fila, columna, movimiento) <= jerarquiaMenor)){
                
                jerarquiaMenor = jerarquiaMovimiento(fila, columna, movimiento);
            }
        }
        return jerarquiaMenor;
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
     * Dada una posicion (fila, columna) del caballo y un indice de movimiento a realizar, determina si el movimiento esta
     * dentro del tablero y si la casilla donde busca posicionarse esta vacia
     * @param fila int fila que ocupa el caballo
     * @param columna int columna que ocupa el caballo
     * @param indice int indice de movimiento a realizar por el caballo
     * @return boolean, true si esta dentro del tablero y la casilla esta vacia, false en caso contrario
     */
    private boolean validacionBordesCasilla(int fila, int columna, int indice){
        return dentroTablero(fila, columna, indice) && casillaVacia(fila, columna, indice);
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
     * Dada una posicion (fila, columna) del caballo y un indice de movimiento a realizar, determina si el movimiento esta
     * dentro del tablero
     * @param fila int fila que ocupa el caballo
     * @param columna int columna que ocupa el caballo
     * @param indice int indice de movimiento a realizar por el caballo
     * @return boolean true si el movimiento esta dentro del tablero, false en caso contrario
     */
    private boolean dentroTablero(int fila, int columna, int indice){
        return (fila + vertical[indice] >= 0) && (columna + horizontal[indice] >= 0)
                && (fila + vertical[indice] < 8) && (columna + horizontal[indice] < 8);
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
     * Dada una posicion (fila, columna) del caballo y un indice de movimiento a realizar, determina si la casilla donde se
     * situara el caballo esta vacia.
     * @param fila int fila del caballo
     * @param columna int columna del caballo
     * @param indice int indice de movimiento del caballo
     * @return boolean true si la casilla esta vacia, false en caso contrario
     */
    private boolean casillaVacia(int fila, int columna, int indice){
        return tablero[fila + vertical[indice]][columna + horizontal[indice]] == 0;
    }
    
    /**
     * Dado un indice de movimiento, determina la jerarquia que tiene la casilla donde estara el caballo con base al
     * tablero de accesibilidad.
     * @param indice int Indice de tipo de movimiento a efectuar por el caballo
     * @return int Jerarquia de la casilla
     */
    private int jerarquiaMovimiento(int indice){
        return accesibilidad[filaActual + vertical[indice]][columnaActual + horizontal[indice]];
    }
    /**
     * Dada una posicion (fila, columna) del caballo y un indice de movimiento a realizar, determina la jerarquia que tiene la
     * casilla donde estara el caballo con base al tablero de accesibilidad
     * @param fila int Fila del caballo
     * @param columna int Columna del caballo
     * @param indice int Indice de movimiento del caballo
     * @return int jerarquia que ocupa la posicion del caballo
     */
    private int jerarquiaMovimiento(int fila, int columna, int indice){
        return accesibilidad[fila + vertical[indice]][columna + horizontal[indice]];
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
     * Muestra el tablero de accesibilidad
     */
    public void mostrarAccesibilidad(){
        for(int i = 0; i < accesibilidad.length; i++){
            for(int j : accesibilidad[i]){
                System.out.printf("%2d ", j);
            }
            System.out.println();
        }
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
