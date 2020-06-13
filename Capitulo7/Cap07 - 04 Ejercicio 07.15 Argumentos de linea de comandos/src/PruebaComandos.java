/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Crea un arreglo de n elementos definidos por medio del primer argumento
 * de la linea de comandos, si no se especifica valor se crea un arreglo de tamaño 10
 * En netbeans se accede a los argumentos de linea de comandos dando click secundario
 * sobre el proyecto, se selecciona propiedades, se accede a la opción de ejecutar y
 * en la opción de argumentos se ingresan los argumentos que se pasaran al metodo main()
 * @author eedua
 */
public class PruebaComandos {
    public static void main(String[] args){
        int[] arreglo;//< arreglo no inicializado
        if(args.length == 0){//< Si no se especifica un tamaño en el argumento de linea de comandos
            arreglo = new int[10];
        }
        else{//< Si se especifica un tamaño en el argumento de la linea de comandos
            int longitudArreglo = Integer.parseInt(args[0]);//< Se convierte el argumento a numero entero
            arreglo = new int[longitudArreglo];//< Se crea el argumento
        }
        
        System.out.printf("%s%8s%n", "Indice", "Valor");
        
        for(int contador = 0; contador < arreglo.length; contador++)
            System.out.printf("%5d%8d%n", contador, arreglo[contador]);
    }
}
