/**
 *
 * @author EEdgar
 * @version Alfa 1
 * 27/11/17, 12:15pm
 * Muestra el valor de los caracteres: A B C a b c 0 1 2 $ * + / y el espacio
 */
public class Caracter {
    public static void main(String[] args){
        System.out.printf("%c = %d y %c = %d%n", 'A', (int)'A', 'B', (int)'B');
        System.out.printf("%c = %d y %c = %d%n", 'C', (int)'C', 'a', (int)'a');
        System.out.printf("%c = %d y %c = %d%n", 'b', (int)'b', 'c', (int)'c');
        System.out.printf("%c = %d y %c = %d%n", '0', (int)'0', '1', (int)'1');
        System.out.printf("%c = %d y %c = %d%n", '2', (int)'2', '$', (int)'$');
        System.out.printf("%c = %d y %c = %d%n", '*', (int)'*', '+', (int)'+');
        System.out.printf("%c = %d y '%c' = %d%n", '/', (int)'/', ' ', (int)' ');
    }
}
