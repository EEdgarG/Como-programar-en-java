/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 31/05/2020
 * @time 01:39:15 PM
 */
import java.security.SecureRandom;

public class EnunciadosAleatorios {
    /**
     * Arreglo de articulos
     */
    private static final String[] articulo = {"el", "un", "algún", "ningún"};
    /**
     * Arreglo de sustantivos
     */
    private static final String[] sustantivo = {"chico", "circo", "foco", "periodico", "carro", "perro", "cerro", "gato", "auto",
        "anillo", "cuchillo", "tornillo", "cuaderno", "enano", "microfono", "camisa"};
    /**
     * Arreglo de verbos
     */
    private static final String[] verbo = {"manejo", "salto", "corrio", "camino", "vino", "prueba", "manifiesta", "finaliza", "revela",
    "practica", "arriesga", "ordena", "evidencia", "duda", "contenta"};
    /**
     * Arreglo de preposiciones
     */
    private static final String[] preposicion = {"a", "desde", "encima de", "debajo de", "sobre"};
    /**
     * Genera números aleatorios
     */
    private static final SecureRandom aleatorio = new SecureRandom();
    /**
     * Obtiene una oración aleatoria a través de el uso de operadores  +
     * @return String
     */
    public static String oracionAleatoria(){
        //articulo, sustantivo, verbo, preposicion, articulo, sustantivo
        int palabra = aleatorio.nextInt(articulo.length);
        Character a = Character.toUpperCase(articulo[palabra].charAt(0));//<Primer letra
        
        return a.toString() + articulo[palabra].substring(1) + " " +
                sustantivo[aleatorio.nextInt(sustantivo.length)] + " " +
                verbo[aleatorio.nextInt(verbo.length)] + " " +
                preposicion[aleatorio.nextInt(preposicion.length)] + " " +
                articulo[aleatorio.nextInt(articulo.length)] + " " +
                sustantivo[aleatorio.nextInt(sustantivo.length)] + ".";
    }
    /**
     * Devuelve una oración aleatoria por medio de concat de String
     * @return String
     */
    public static String oracionAleatoriaConConcat(){
        String oracion = new String();
        
        int palabra = aleatorio.nextInt(articulo.length);
        Character a = Character.toUpperCase(articulo[palabra].charAt(0));//<Primer letra
        
        oracion = oracion.concat(a.toString());
        oracion = oracion.concat(articulo[palabra].substring(1));
        oracion = oracion.concat(" ");
        oracion = oracion.concat(sustantivo[aleatorio.nextInt(sustantivo.length)]);
        oracion = oracion.concat(" ");
        oracion = oracion.concat(verbo[aleatorio.nextInt(verbo.length)]);
        oracion = oracion.concat(" ");
        oracion = oracion.concat(preposicion[aleatorio.nextInt(preposicion.length)]);
        oracion = oracion.concat(" ");
        oracion = oracion.concat(articulo[aleatorio.nextInt(articulo.length)]);
        oracion = oracion.concat(" ");
        oracion = oracion.concat(sustantivo[aleatorio.nextInt(sustantivo.length)]);
        oracion = oracion.concat(".");
        
        return oracion;
    }
    
    public static String enunciadoRima(String rima){
        String oracion = oracionAleatoria();
        while(!oracion.endsWith(rima)){
            oracion = oracionAleatoria();
        }
        
        return oracion;
    }
}
