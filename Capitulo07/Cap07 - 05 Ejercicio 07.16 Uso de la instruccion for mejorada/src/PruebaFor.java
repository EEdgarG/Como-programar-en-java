/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Obtiene valores tipo double por medio de los argumentos de la linea de comandos
 * y se suman estos valores usando la instrucción for mejorada
 * En netbeans se accede a los argumentos de linea de comandos dando click secundario
 * sobre el proyecto, se selecciona propiedades, se accede a la opción de ejecutar y
 * en la opción de argumentos se ingresan los argumentos que se pasaran al metodo main()
 * @author eedua
 */
public class PruebaFor {
    public static void main(String[] args){
        if(args.length == 0)//< si no hay argumentos en la linea de comandos
            System.out.printf("No hay nada que sumar%n");
        else//< si hay argumentos en la linea de comandos
            System.out.printf("La suma es: %f%n", sumaD(args));
    }
    /**
     * Obtiene un String con los argumentos de la linea de comandos
     * y los suma
     * @param args Un arreglo de String de la linea de comandos con los numeros que se sumaran
     * @return Suma de los valores ingresados en la linea de comandos
     */
    public static double sumaD(String[] args){
        double suma = 0;
        for(String num : args){
            suma += Double.parseDouble(num);//< Cada argumento en la linea de comandos se convierte a tipo double
        }
        return suma;
    }
}
