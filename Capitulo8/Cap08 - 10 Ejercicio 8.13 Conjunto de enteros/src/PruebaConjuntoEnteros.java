/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Realiza operaciones de conjuntos con conjuntos de números enteros en el rango de
 * 0 a 100
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 5/05/2020
 * @time 04:20:52 PM
 */
public class PruebaConjuntoEnteros {
    public static void main(String[] args){
        ConjuntoEnteros a = new ConjuntoEnteros();
        ConjuntoEnteros b = new ConjuntoEnteros();
        
        // se insertan elementos en el conjunto a
        a.insertarElemento(33);
        a.insertarElemento(1);
        a.insertarElemento(5);
        a.insertarElemento(8);
        
        // Se insertan elementos en el conjunto b
        b.insertarElemento(11);
        b.insertarElemento(1);
        b.insertarElemento(5);
        b.insertarElemento(2);
        
        //Se muestran los conjuntos a y b
        System.out.printf("Conjunto a: %s%n", a);
        System.out.printf("Conjunto b: %s%n", b);
        
        //Se verifica si a y b son iguales
        System.out.printf("Conjuntos a y b %s%n", ConjuntoEnteros.esIgualA(a, b) ? "son iguales": "no son iguales");
        
        //Se crea un conjunto c como la union de a y b
        ConjuntoEnteros c = ConjuntoEnteros.union(a, b);
        //Se crea un conjunto d como la interseccion de a y b
        ConjuntoEnteros d = ConjuntoEnteros.interseccion(a, b);
        
        //Se muestran los conjuntos c y d
        System.out.printf("La a U b = c: %s%n", c);
        System.out.printf("La intersección de a y b: %s%n", d);
        
        //Se elimina un elemento del conjunto c y se muestra nuevamente
        c.eliminarElementos(5);
        System.out.printf("El conjunto c: %s%n", c);
    }
}
