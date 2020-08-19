/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EEdgarG <eedduardo33@gmail.com>
 */
public enum OpcionMenu {
    AGREGAR_CUENTA(1),
    AGREGAR_TRANSACCION(2),
    MOSTRAR_CUENTAS(3),
    MOSTRAR_TRANSACCIONES(4),
    FIN(5);
    
    /**
     * Opción actual del menu
     */
    private final int valor;
    /**
     * Constructor del enum
     * @param valor int
     */
    private OpcionMenu(int valor){
        this.valor = valor;
    }
}
