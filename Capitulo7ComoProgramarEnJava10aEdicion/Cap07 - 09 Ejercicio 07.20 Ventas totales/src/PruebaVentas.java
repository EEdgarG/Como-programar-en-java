/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Cada vendedor puede realizar ventas de entre 5 productos
 * son 4 vendedores
 * @author eedua
 */
public class PruebaVentas {
    public static void main(String[] args){
        Ventas[][] venta = new Ventas[4][5];
        for(int vendedor = 0; vendedor < 4; vendedor++){
            for(int producto = 0; producto < 5; producto++){
                venta[vendedor][producto] = new Ventas(vendedor, producto, (float)(producto + 10.2));
            }
        }
        System.out.println("vendedor 1\tvendedor 2\tvendedor 3\tvendedor4");

        for(int producto = 0; producto < 5; producto++){
            for(int vendedor = 0; vendedor < 4; vendedor++){
                System.out.printf("producto %s\t", venta[vendedor][producto]);
            }
            System.out.println();
        }
    }
}
