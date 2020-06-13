/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eedua
 */
public class LibroCalificaciones {
    /**
     * Contiene el nombre del curso
     */
    private String nombreDelCurso;
    /**
     * Contiene la cantidad de alumnos y la cantidad de examenes del curso
     */
    private int[][] calificaciones;
    
    /**
     * Recibe un arreglo bidimensional de calificaciones y un nombre de curso
     * @param nombreDelCurso
     * @param calificaciones 
     */
    public LibroCalificaciones(String nombreDelCurso, int[][] calificaciones){
        this.nombreDelCurso = nombreDelCurso;
        this.calificaciones = calificaciones;
    }
    /**
     * Crea un arreglo bidimensional dados la cantidad de estudiantes y el numero de examenes del curso
     * @param numero_estudiantes
     * @param numero_examenes 
     */
    public LibroCalificaciones(String nombreDelCurso, int numero_estudiantes, int numero_examenes){
        this.nombreDelCurso = nombreDelCurso;
        calificaciones = new int[numero_estudiantes][numero_examenes];
        for(int i = 0; i < calificaciones.length; i++){
            for(int j = 0; j < calificaciones[i].length; j++){
                calificaciones[i][j] = -1;
            }
        }
    }
    public void establecerCalificacion(int alumno, int examen, int calificacion){
        calificaciones[alumno][examen] = calificacion;
    }
    /**
     * Establece el nombre del curso
     * @param nombreDelCurso 
     */
    public void establecerNombreDelCurso(String nombreDelCurso){
        this.nombreDelCurso = nombreDelCurso;
    }
    /**
     * Obtiene el nombre del curso
     * @return 
     */
    public String obtenerNombreDelCurso(){
        return nombreDelCurso;
    }
    /**
     * Muestra el conjunto de todas las calificaciones, la calificación menor y la mayor, asi como el grafico de barras de
     * la distribución de las calificaciones
     */
    public void procesarCalificaciones(){
        imprimirCalificaciones();
        System.out.printf("%n%s %d%n%s %d%n%n", "La calificacion mas baja en el libro de calificaciones es", obtenerMinima(),
                "La calificacion mas alta en el libro de calificaciones es", obtenerMaxima());
        imprimirGraficoBarras();
    }
    /**
     * Obtiene la calificación mas baja
     * @return 
     */
    public int obtenerMinima(){
        int califBaja = calificaciones[0][0];
        for(int[] califEstudiantes : calificaciones){
            for(int calificacion : califEstudiantes){
                if(calificacion < califBaja)
                    califBaja = calificacion;
            }
        }
        return califBaja;
    }
    /**
     * Obtiene la calificación mas alta
     * @return 
     */
    public int obtenerMaxima(){
        int califAlta = calificaciones[0][0];
        for(int[] califEstudiantes : calificaciones){
            for(int calificacion : califEstudiantes){
                if(calificacion > califAlta)
                    califAlta = calificacion;
            }
        }
        return califAlta;
    }
    /**
     * Obtiene el promedio de un alumno
     * @param conjuntoDeCalif
     * @return 
     */
    public double obtenerPromedio(int[] conjuntoDeCalif){
        int total = 0;
        for(int calificacion : conjuntoDeCalif){
            total += calificacion;
        }
        return (double) total / conjuntoDeCalif.length;
    }
    /**
     * Muestra un grafico de barras de la distribución de calificaciones
     */
    public void imprimirGraficoBarras(){
        System.out.println("Distribucion de calificaciones en general:");
        int[] frecuencia = new int[11];
        for(int[] califEstudiantes : calificaciones){
            for(int calificacion : califEstudiantes)
                ++frecuencia[calificacion / 10];
        }
        for(int cuenta = 0; cuenta < frecuencia.length; cuenta++){
            if(cuenta == 10)
                System.out.printf("%5d: ", 100);
            else
                System.out.printf("%02d-%02d: ", cuenta * 10, cuenta * 10 + 9);
            for(int estrellas = 0; estrellas < frecuencia[cuenta]; estrellas++)
                System.out.print("*");
            System.out.println();
        }
    }
    /**
     * Muestra las calificaciones de cada alumno asi como el promedio
     */
    public void imprimirCalificaciones(){
        System.out.println("Las calificaciones son:\n\n");
        System.out.print("             ");
        for(int prueba = 0; prueba < calificaciones[0].length; prueba++){//imprime los encabezados de las 3 pruebas
            System.out.printf("Prueba %d ", prueba + 1);
        }
        System.out.println("Promedio");//imprime encabezado de promedio
        
        for(int estudiante = 0; estudiante < calificaciones.length; estudiante++){//recorrido de los alumnos
            System.out.printf("Estudiante %2d", estudiante + 1);//imprime el alumno
            for(int prueba : calificaciones[estudiante])//recorrido de las calificaciones
                System.out.printf("%8d", prueba);
            double promedio = obtenerPromedio(calificaciones[estudiante]);//por cada alumno obtiene su promedio
            System.out.printf("%9.2f%n", promedio);
        }
    }
}
