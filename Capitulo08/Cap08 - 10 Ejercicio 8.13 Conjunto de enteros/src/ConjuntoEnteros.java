/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 5/05/2020
 * @time 04:13:32 PM
 */
public class ConjuntoEnteros {
    /**
     * Almacena enteros en el rango de 0 a 100
     */
    private boolean[] arreglo;
    /**
     * Maneja el rango del arreglo
     */
    private static final int RANGO = 100;
    /**
     * Inicializa los elementos del arreglo a false
     */
    public ConjuntoEnteros(){
        arreglo = new boolean[RANGO];
        for(int i = 0; i < RANGO; i++){
            arreglo[i] = false;
        }
    }
    /**
     * Inserta un elemento entero k en el arreglo tal que 0 <= k <= 100
     * @param k Número a insertar
     */
    public void insertarElemento(int k){
        if(k < 0 || k > 100)
            throw new IllegalArgumentException("El numero (" + k + ") debe estar entre 0 y 100");
        arreglo[k] = true;
    }
    /**
     * Elimina un elemento entero k del conjunto
     * @param k Número a eliminar tal que, 0 <= k <= 100
     */
    public void eliminarElementos(int k){
        if(k < 0 || k > 100)
            throw new IllegalArgumentException("El número (" + k + ") debe estar entre 0 y 100");
        arreglo[k] = false;
    }
    /**
     * Realiza la union de dos conjuntos
     * @param a Conjunto de enteros a
     * @param b Conjunto de enteros b
     * @return ConjutnoEnteros con la union de a y b
     */
    public static ConjuntoEnteros union(ConjuntoEnteros a, ConjuntoEnteros b){
        ConjuntoEnteros c = new ConjuntoEnteros();
        for(int i = 0; i < ConjuntoEnteros.RANGO; i++){
            if(a.arreglo[i] || b.arreglo[i])
                c.arreglo[i] = true;
        }
        return c;
    }
    /**
     * Realiza la interseccion de dos conjuntos a y b
     * @param a Conjunto de enteros a
     * @param b Conjunto de enteros b
     * @return Intersección de conjuntos c
     */
    public static ConjuntoEnteros interseccion(ConjuntoEnteros a, ConjuntoEnteros b){
        ConjuntoEnteros c = new ConjuntoEnteros();
        for(int i = 0; i < ConjuntoEnteros.RANGO; i++){
            if(a.arreglo[i] == true && b.arreglo[i] == true)
                c.arreglo[i] = true;
        }
        return c;
    }
    /**
     * Compara dos conjuntos de números a y b.
     * @param a Conjunto a de números
     * @param b Conjunto b de números
     * @return True si son iguales los conjuntos, false si no son iguales
     */
    public static boolean esIgualA(ConjuntoEnteros a, ConjuntoEnteros b){
        int cuenta = 0;
        for(int i = 0; i < ConjuntoEnteros.RANGO; i++){
            if(a.arreglo[i] != b.arreglo[i])
                cuenta++;
        }
        if(cuenta == 0)
            return true;
        else
            return false;
    }
    /**
     * Objeto String con la representacion del conjunto de números
     * @return Objeto String con el conjunto de números
     */
    @Override
    public String toString(){
        int cuenta = 0;
        String s = "";
        for(int i = 0; i < RANGO; i++){
            if(arreglo[i] == true){
                cuenta++;
                s += i + ", ";
            }
        }
        if(cuenta == 0)
            return "---";
        else
            return s;
    }
}
