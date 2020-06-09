/**
 *
 * @author EEdgar
 * @version Alfa 1
 * 6/12/17, 5:31pm
 * Clase prueba de la clase factura
 */

public class PruebaFactura {
    public static void main(String[] args){
        Factura pedido1 = new Factura("0001", "Arbol", 2, 25.5);
        
        System.out.printf("%s%n", pedido1);
    }
}
