/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 27/05/2020
 * @time 06:24:46 PM
 */
public class Factura implements PorPagar{
    /**
     * Número de pieza
     */
    private final String numeroPieza;
    /**
     * Descripción de la pieza
     */
    private final String descripcionPieza;
    /**
     * Cantidad de piezas compradas. cantidad >= 0
     */
    private int cantidad;
    /**
     * Precio por articulo. precio >= 0.0
     */
    private double precioPorArticulo;
    /**
     * Constructor que inicializa todas las variables de instancia con los argumentos del metodo
     * @param numeroPieza String
     * @param descripcionPieza String
     * @param cantidad int
     * @param precioPorArticulo double 
     */
    public Factura(String numeroPieza, String descripcionPieza, int cantidad, double precioPorArticulo){
        if(cantidad < 0)
            throw new IllegalArgumentException("Cantidad debe ser >= 0");
        
        if(precioPorArticulo < 0.0)
            throw new IllegalArgumentException("El precio por articulo debe ser >= 0.0");
        
        this.cantidad = cantidad;
        this.numeroPieza = numeroPieza;
        this.descripcionPieza = descripcionPieza;
        this.precioPorArticulo = precioPorArticulo;
    }
    /**
     * Devuelve el número de pieza
     * @return String
     */
    public String obtenerNumeroPieza(){
        return numeroPieza;//< Debe validar
    }
    /**
     * Devuelve la descripción de la pieza
     * @return String
     */
    public String obtenerDescripcionPieza(){
        return descripcionPieza;
    }
    /**
     * Establece la cantidad
     * @param cantidad int
     */
    public void establecerCantidad(int cantidad){
        if(cantidad < 0)
            throw new IllegalArgumentException("La cantidad debe ser >= 0");
        
        this.cantidad = cantidad;
    }
    /**
     * Devuelve la cantidad
     * @return int
     */
    public int obtenerCantidad(){
        return cantidad;
    }
    /**
     * Establece el precio por articulo
     * @param precioPorArticulo double
     */
    public void establecerPrecioPorArticulo(double precioPorArticulo){
        if(precioPorArticulo < 0.0)
            throw new IllegalArgumentException("El precio por articulo debe ser >= 0.0");
        
        this.precioPorArticulo = precioPorArticulo;
    }
    /**
     * Devuelve el precio por articulo
     * @return double
     */
    public double obtenerPrecioPorArticulo(){
        return precioPorArticulo;
    }
    /**
     * Devuelve una representación String del objeto
     * @return String
     */
    @Override
    public String toString(){
        return String.format("%s: %n%s: %s (%s) %n%s: %d %n%s: $%,.2f", 
                "factura", "numero de pieza", obtenerNumeroPieza(), obtenerDescripcionPieza(),
                "cantidad", obtenerCantidad(), "precio por articulo", obtenerPrecioPorArticulo());
    }
    /**
     * Devuelve el monto total de pago
     * @return double
     */
    @Override
    public double obtenerMontoPago(){//< metodo requerido para realizar el contraro con la interfaz PorPagar
        return obtenerCantidad() * obtenerPrecioPorArticulo();//< Calcula el costo total
    }
}
