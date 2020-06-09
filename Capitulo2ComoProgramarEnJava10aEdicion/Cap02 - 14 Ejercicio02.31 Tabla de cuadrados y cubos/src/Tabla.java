/**
 *
 * @author EEdgar
 * @version Alfa 1
 * 27/11/17, 12:55pm
 * Muestra una tbla de cubos y cuadrados de los números del 0 al 10.
 */
public class Tabla {
    public static void main(String[] args){
        System.out.println("numero\tcuadrado\tcubo");
        System.out.printf("%-7d\t%-8d\t%-8d%n%-7d\t%-8d\t%-7d%n", 0, 0 * 0,
                0 * 0 * 0, 1, 1 * 1, 1 * 1 * 1);
        System.out.printf("%-7d\t%-8d\t%-8d%n%-7d\t%-8d\t%-7d%n", 2, 2 * 2,
                2 * 2 * 2, 3, 3 * 3, 3 * 3 * 3);
        System.out.printf("%-7d\t%-8d\t%-8d%n%-7d\t%-8d\t%-7d%n", 4, 4 * 4,
                4 * 4 * 4, 5, 5 * 5, 5 * 5 * 5);
        System.out.printf("%-7d\t%-8d\t%-8d%n%-7d\t%-8d\t%-7d%n", 5, 5 * 5,
                5 * 5 * 5, 6, 6 * 6, 6 * 6 * 6);
        System.out.printf("%-7d\t%-8d\t%-8d%n%-7d\t%-8d\t%-7d%n", 7, 7 * 7,
                7 * 7 * 7, 8, 8 * 8, 8 * 8 * 8);
        System.out.printf("%-7d\t%-8d\t%-8d%n%-7d\t%-8d\t%-7d%n", 9, 9 * 9,
                9 * 9 * 9, 10, 10 * 10, 10 * 10 * 10);
    }
}
