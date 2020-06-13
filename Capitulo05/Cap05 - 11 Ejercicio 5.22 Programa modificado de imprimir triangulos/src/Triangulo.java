/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Dibuja 4 triángulos rectangulos con asteriscos todos las 4 posibles formas diferentes y uno frente al otro
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 25/04/2020
 * @time 12:58:00 PM
 */
public class Triangulo {
    public static void main(String[] args){
        triangulo();
    }
    /**
     * Dibuja los cuatro difetentes tipos de triángulos acomodados uno frente al otro
     */
    public static void triangulo(){
        for(int i = 0; i < 10; i++){
            trianguloA(i);//<Dibuja el primer triángulo
            trianguloCEspacios(i);
            System.out.print("\t");
            trianguloB(i);
            trianguloDEspacios(i);
            System.out.print("\t");
            trianguloC(i);
            System.out.print("\t");
            trianguloD(i);
            System.out.println();
        }
    }
    /**
     * Triángulo rectangulo con el cateto opuesto del lado izquierdo y el cateto adyacente abajo
     * Es complemento de metodo triangulo(), este metodo dibuja la cantidad de asteriscos necesarios 
     * por linea y decide cuando pasar a la siguiente
     * @param i Indica la linea actual y de esa manera este metodo sabe cuantos asteriscos escribir
     */
    private static void trianguloA(int i){
            for(int j = 0; j < i + 1; j++){
                System.out.print("*");
            }
    }
    /**
     * Triangulo rectangulo con el cateto opuesto a la izquierda y el adyacente arriba
     * Complemento de metodo triangulo(), por si solo no tiene sentido
     * @param i Indica la linea actual y de esa manera el metodo sabe cuantos asteriscos debe escribir
     */
    private static void trianguloB(int i){
            for(int j = 0; j < 10 - i; j++){
                System.out.print("*");
            }
    }
    /**
     * Triángulo rectangulo con el cateto opuesto a la derecha y el dayacente arriba
     * Complemento de metodo triangulo(). Por si solo no sirve
     * @param i Indica la linea actual y de esa manera el metodo sabe cuantos asteriscos debe escribir
     */
    private static void trianguloC(int i){
        for(int k = 0; k < i; k++){
            System.out.print(" ");
        }
        for(int j = i; j < 10; j++){
            System.out.print("*");
        }
    }
    /**
     * Dibuja un triángulo de espacios con el cateto adyacente arriba y el opuesto del lado derecho
     * @param i Indica la cantidad de espacios que "dibujara" antes de pasar a la siguiente linea
     */
    private static void trianguloCEspacios(int i){
        for(int j = i; j < 10; j++){
            System.out.print(" ");
        }
    }
    /**
     * Triángulo rectangulo con el cateto opuesto a la derecha y el adyacente abajo
     * Complemento de metodo triangulo(). Por si solo no sirve
     * @param i Indica la linea actual y de esa manera el metodo sabe cuantos asteriscos debe escribir
     */
    private static void trianguloD(int i){
        for(int k = 0; k < 9 - i; k++){
            System.out.print(" ");
        }
        for(int j = 0; j < i + 1; j++){
            System.out.print("*");
        }
    }
    /**
     * Dibuja un triángulo rectangulo de espacios con el cateto opuesto a la derecha y el adyacente abajo
     * Por si solo no sirve ya que es dependiente del metodo triangulo()
     * @param i Indica la linea actual y con esa información el metodo sabe cuantos espacios debe escribir
     */
    private static void trianguloDEspacios(int i){
        for(int j = 0; j < i + 1; j++){
            System.out.print(" ");
        }
    }
}
