/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Modificación al ejemplo de la figura 7.18 para que pueda recibir a la cantidad de alumnos y examenes en el constructor
 * y el añadido de un metodo que modifica la calificaciones de un alumno y examen especifico
 * @author eedua
 */
import java.util.Scanner;

public class PruebaLibroCalificaciones {
    public static void main(String[] args){
        //Inicio pruebe ejemplo del libro
//        int[][] arregloCalif = {
//            {87, 96, 70},
//            {68, 87, 90},
//            {94, 100, 90},
//            {100, 81, 82},
//            {83, 65, 85},
//            {78, 87, 65},
//            {85, 75, 83},
//            {91, 94, 100},
//            {76, 72, 84},
//            {87, 93, 73}};
//        LibroCalificaciones miLibroCalificaciones = new LibroCalificaciones("CS101 Introduccion a la programacion en Java", arregloCalif);
//        System.out.printf("Bienvenido al libro de calificaciones para%n%s%n%n",
//                miLibroCalificaciones.obtenerNombreDelCurso());
//        miLibroCalificaciones.procesarCalificaciones();
        //fin prueba ejemplo del libro
        
        Scanner entrada = new Scanner(System.in);
        int numero_estudiantes = 3;
        int numero_examenes = 3;
        LibroCalificaciones libroCalificaciones = new LibroCalificaciones(
                "CS101 Introduccion a la programacion en Java", numero_estudiantes, numero_examenes);
        
        for(int i = 0; i < numero_estudiantes; i++){
            for(int j = 0; j < numero_examenes; j++){
                System.out.printf("Ingresa la calificacion del examen %d del alumno %d: ", j + 1, i + 1);
                int calificacion = entrada.nextInt();
                libroCalificaciones.establecerCalificacion(i, j, calificacion);
            }
        }
        
        System.out.printf("Bienvenido al libro de calificaciones para%n%s%n%n",
                libroCalificaciones.obtenerNombreDelCurso());
        libroCalificaciones.procesarCalificaciones();
    }
}
