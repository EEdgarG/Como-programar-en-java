/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Realiza operaciones aritméticas con fracciones
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 8/05/2020
 * @time 07:45:09 PM
 */
public class Racional {
    /**
     * Numerador del número racional
     */
    private int numerador;
    /**
     * Denominador del número racional
     */
    private int denominador;
    /**
     * Constructor que recibe dos parametros para inicializar el numerador y denominador
     * @param numerador int Numerador
     * @param denominador int Denominador
     */
    public Racional(int numerador, int denominador){
        if(denominador == 0)
            throw new ArithmeticException("El denominador no puede ser cero");
        
        int m = mcd(numerador, denominador);
        this.numerador = numerador / m;
        this.denominador = denominador / m;
    }
    /**
     * Constructor predeterminado,
     * inicializa el numerador y el denominador a 1
     */
    public Racional(){
        this(1, 1);
    }
    /**
     * Calcula el máximo común divisor de dos números
     * @param a Número a
     * @param b Número b
     * @return Máximo común divisor
     */
    public static int mcd(int a, int b){
        int r = 1;
        while(a != 0){
            r = b % a;
            b = a;//<el número más grande ahora es b
            a = r;//< el residuo ahora es b
        }
        return b;
    }
    /**
     * Realiza la suma de dos números racionales
     * @param a Objeto Racional a
     * @param b Objeto Racional b
     * @return Objeto Racional c
     */
    public static Racional suma(Racional a, Racional b){
        Racional c;
        
        if(a.numerador == 0){//< si el numerador a es cero
            if(b.numerador == 0){//< si ambos numeradores son ceros
                c = new Racional(0, 1);
            }
            else{//< si solo el denomiador de b es diferente de cero
                c = new Racional(b.numerador, b.denominador);
            }
        }
        else{//< si el numerador de a es diferente de cero
            if(b.numerador == 0){//< si solo el numerador de a es cero
                c = new Racional(a.numerador, a.denominador);
            }
            else{//< si ambos numeros son distintos de cero
                int na = a.numerador * b.denominador;
                int nb = b.numerador * a.denominador;
                c = new Racional(na + nb, a.denominador * b.denominador);
            }
        }
        return c;
    }
    /**
     * Realiza la resta de dos números objetos Racional a - b
     * @param a Objeto Racional a
     * @param b Objeto Racional b
     * @return Racional objeto con la resta de a - b
     */
    public static Racional resta(Racional a, Racional b){
        Racional c;
        
        if(a.numerador == 0){//< si el numerador a es cero
            if(b.numerador == 0){//< si ambos numeradores son ceros
                c = new Racional(0, 1);
            }
            else{//< si solo el numerador de b es diferente de cero
                c = new Racional(-b.numerador, b.denominador);
            }
        }
        else{//< si el numerador de a es diferente de cero
            if(b.numerador == 0){//< si solo el numerador de a es cero
                c = new Racional(a.numerador, a.denominador);
            }
            else{//< si ambos numeros son distintos de cero
                int na = a.numerador * (b.denominador);
                int nb = b.numerador * a.denominador;
                c = new Racional(na - nb, a.denominador * b.denominador);
            }
        }
        return c;
    }
    /**
     * Realiza la multiplicación de dos objetos Racional a y b
     * @param a Racional número a
     * @param b Racional número b
     * @return Racional nultiplicación de a y b
     */
    public static Racional multiplicacion(Racional a, Racional b){
        Racional c;
        
        if(a.numerador != 0 && b.numerador != 0){
            c = new Racional(a.numerador * b.numerador, a.denominador * b.denominador);
        }
        else
            c = new Racional(0, 1);
        
        return c;
    }
    /**
     * Realiza la división de dos objetos Racional a y b
     * @param a Racional número racional a
     * @param b Racional número racional b
     * @return Racional división de a / b
     */
    public static Racional division(Racional a, Racional b){
        Racional c;
        if(b.numerador == 0)
            throw new ArithmeticException("No puede ser cero el numerador del elemento Racional b");
        
        c = new Racional(a.numerador * b.denominador, a.denominador * b.numerador);
        return c;
    }
    /**
     * Obtiene el mínimo común múltiplo (mcm) de dos numeros
     * @param a Número a
     * @param b Número b
     * @return int mínimo común múltiplo
     */
    public static int mcm(int a, int b){
        return ((a * b) / Racional.mcd(a, b));
    }
    /**
     * Obtiene el numerador
     * @return Numerador
     */
    public int obtenerNumerador(){
        return numerador;
    }
    /**
     * Obtiene el denominador
     * @return Denominador
     */
    public int obtenerDenominador(){
        return denominador;
    }
    /**
     * Realiza una representación flotante del número racional en un objeto String
     * Si se desea mostrar solo la parte entera introduzca 1
     * Si se desea mostrar los decimales comience con dos
     * @param a Indice de cuantos digitos mostrar a > 0
     * @return String de representación flotante del número Racional
     */
    public String representacionFlotante(int a){
        if(a < 0)
            throw new IllegalArgumentException("El indice debe ser mayor a 0");
        
        String f = "";
        int d = obtenerNumerador();
        int den = obtenerDenominador();
        int cuenta = 0;
        int i = 10;
        if(den < 0 ){
            f = "-";
            den *= -1;
        }
        if(d < 0){
            f = "-";
            d *= -1;
        }
            
        while(cuenta < a){
            int residuo = d % den;
            
            f += d / den;
            d = residuo * i;
            if(cuenta == 0)
                f +=".";
            i *= 10;
            cuenta++;
        }
        return f;
    }
    /**
     * Representacion de número racional como fracción
     * @return Objeto String de un número racional
     */
    @Override
    public String toString(){
        if(obtenerNumerador() == 0)
            return String.format("%d", obtenerNumerador());
        else
            return String.format("%d/%d", obtenerNumerador(), obtenerDenominador());
    }
}
