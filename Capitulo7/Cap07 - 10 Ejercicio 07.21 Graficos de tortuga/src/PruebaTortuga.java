/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Realiza graficos de tortuga
 * @author eedua
 */
import java.util.Scanner;

public class PruebaTortuga {
    /**
     * El tablero donde se desplaza la tortuga
     */
    private static int[][] piso;
    /**
     * Es la posición de la fila actual de la tortuga
     */
    private static int filaActual;
    /**
     * Es la posición de la columna actual de la tortuga
     */
    private static int columnaActual;
    /**
     * Esta variable dibuja el recorrido de la tortuga dependiendo de su posición
     * true (arriba) no escribe
     * false (abajo) escribe
     */
    private static boolean boligrafo;
    /**
     * Controla la dirección de la tortuga
     * Si es par (incluyendo negativos) se moueve de manera horizontal
     *      Si es 0 o multiplo de 4 se mueve de izquierda a derecha
     * Si es multiplo de 2 (excepto 0) se mueve de derecha a izquierda
     * Si es impar positivo se mueve de arriba a abajo
     * Si es impar negativo se mueve de abajo a arriba
     */
    private static int direccion;
    /**
     * Metodo de entrada para la aplicación
     */
    private static Scanner entrada;
    
    public static void main(String[] args){
        inicializarPiso();
        inicializarDatos();
        int comando = 1;
        
        while(comando != 9){//< Mientras el comando sea distinto de 9
            mostrarMenu();//< Muestra el menú
            comando = entrada.nextInt();
            realizarEleccion(comando);
        }
    }
    public static void realizarEleccion(int comando){
        switch(comando){
                case 1://<boligrafo arriba/no escribe
                    boligrafo = true;
                break;
                case 2://<boligrafo abajo/escribe
                    boligrafo = false;
                break;
                case 3://< direccioin derecha
                    direccion++;
                break;
                case 4://< direccion izquierda
                    direccion--;
                break;
                case 5://< cantidad de lugares a desplazarse
                    desplazar();
                break;
                case 6://< mostrar el arreglo
                    mostrarPiso();
                break;
                case 9://< terminar programa
                    System.out.println("Fin de los datos");
                break;
            }
    }
    /**
     * Realiza el desplazamiento de la tortuga
     */
    public static void desplazar(){
        int avanzar = 0;//< cantidad de lugares a avanzar
        System.out.print("Cuantos lugares se desplazara la tortuga: ");
        avanzar = entrada.nextInt();//< casillas a desplazarse

        //rutina de avanzado
        if(direccion % 2 == 0){//< es par (incluyendo negativos), es decir, se mueve de manera horizontal
            if(direccion == 0 || direccion % 4 == 0){// si la direccion es 0 o multiplo de 4 se esta moviendo de izquierda-derecha
//                            se mueven de manera horizontal es decir, fila intacta, columnas varian
                escribirMult4(avanzar);
            }
            else{// si la direccion es multiplo de 2 se esta moviendo de derecha-izquierda
                escribirMult2(avanzar);
            }
        }
        else{//< es impar, es decir, se mueve verticalmente
            if(direccion > 0){// si es positivo se mueve de arriba-abajo
                escribirImparPos(avanzar);
            }
            else{// si es negativo se mueve de abajo-arriba
                escribirImparNeg(avanzar);
            }
        }
    }
    /**
     * Inicializa un arreglo bidimensional de enteros a cero
     */
    public static void inicializarPiso(){
        piso = new int[20][20];
        
        for(int i = 0; i < piso.length; i++){//< inicializacion
            for(int j = 0; j < piso[i].length; j++)
                piso[i][j] = 0;
        }
    }
    /**
     * Muestra el arreglo bidimensional que es el piso por donde se
     * desplaza la tortuga
     */
    public static void mostrarPiso(){
        for(int i = 0; i < piso.length; i++){
            for(int j = 0; j < piso[i].length; j++)
                System.out.printf("%d  ", piso[i][j]);
            System.out.println();
        }
    }
    /**
     * Realiza el movimiento de la tortuga de manera horizontal
     * de izquierda a derecha
     * @param avanzar Cantidad de lugares que avanzara la tortuga
     */
    public static void escribirMult4(int avanzar){
        if((avanzar + columnaActual) < piso[filaActual].length){//< validar si puede avanzar (si no se sale del tablero)
            if(boligrafo == false){//< escribe
                int columnaNueva = columnaActual;
                for(int izqDer = columnaActual; izqDer < avanzar + columnaNueva; izqDer++){
                    piso[filaActual][izqDer] = 1;
                }
            }

            columnaActual += avanzar;//< actualiza la posicion de la tortuga
        }
        else
            System.out.println("El numero supera el piso");
    }
    /**
     * Realiza el movimiento de la tortuga de manera horizontal
     * de derecha a izquierda
     * @param avanzar Cantidad de lugares a avanzar
     */
    public static void escribirMult2(int avanzar){
        if((columnaActual - avanzar) > 0){//< validar si puede avanzar
            if(boligrafo == false){//< escribe
                int columnaNueva = columnaActual;
                for(int derIzq = columnaActual; derIzq > columnaNueva - avanzar; derIzq--){
                    System.out.printf("%d,%d\t", derIzq, columnaActual);
                    piso[filaActual][derIzq] = 1;
                }
            }

            columnaActual -= avanzar;//< actualiza la posición de la tortuga
        }
        else
            System.out.println("El numero supera el piso");
    }
    /**
     * Realiza el movimiento de la tortuga de arriba a abajo
     * @param avanzar Cantidad de casillas a desplazarse
     */
    public static void escribirImparPos(int avanzar){
        if((avanzar + filaActual) < piso.length){//< validar si puede avanzar
            if(boligrafo == false){//< escribe
                int filaNueva = filaActual;
                for(int arrAbaj = filaActual; arrAbaj < avanzar + filaNueva; arrAbaj++){
//                    System.out.printf("%d,%d\t", arrAbaj, columnaActual);
                    piso[arrAbaj][columnaActual] = 1;
                }
            }

            filaActual += avanzar;//< actualiza
        }
        else
            System.out.println("El numero supera el piso");
    }
    /**
     * Realiza el movimiento de la tortuga de abajo a arriba
     * @param avanzar Cantidad de casillas a desplazarse
     */
    public static void escribirImparNeg(int avanzar){
        if((filaActual - avanzar) > 0){//< validar si puede avanzar
            if(boligrafo == false){//< escribe
                int filaNueva = filaActual;
                for(int abajArri = filaActual; abajArri > filaNueva - avanzar; abajArri--){
                    System.out.printf("%d,%d\t", abajArri, columnaActual);
                    piso[abajArri][columnaActual] = 1;
                }
            }

            filaActual -= avanzar;//< actualiza
        }
        else
            System.out.println("El numero supera el piso");
    }
    /**
     * Inicializa todos los atributos y la posición inicial de la tortuga asi como el boligrafo que lleva
     * De manera predeterminada el boligrafo es true i.e se encuentra arriba es decir que no escribe
     */
    public static void inicializarDatos(){
        entrada = new Scanner(System.in);
        direccion = 0;//< controla si va de izquierda-derecha, derecha-izquierda, arriba-abajo, abajo-arriba
        filaActual = 0;//< Se inicializa la posición vertical de la tortuga
        columnaActual = 0;//< Se inicializa la posición horizontal de la tortuga
        boligrafo = true;//< el boligrafo esta arriba/no escribe
    }
    /**
     * Muestra las opciones que contiene el menu para el paseo
     * de la tortuga
     */
    public static void mostrarMenu(){
        System.out.println("1. Boligrafo no escribe (predeterminado)\t2.Boligrafo escribe");
        System.out.println("3. Gira a la derecha\t4.Gira a la izquierda");
        System.out.println("5. Desplazar tortuga\t6.Mostrar el piso");
        System.out.println("9. Terminar programa");
        System.out.print("Ingrese un comando para la tortuga: ");
    }
}
