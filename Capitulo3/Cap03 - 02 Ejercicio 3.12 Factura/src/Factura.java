/**
 *
 * @author EEdgar
 * @version Alfa 1
 * 6/12/17, 5:14pm
 * Clase factura con 4 variables de instancia
 */
public class Factura {
    /**
     * Número de articulo
     */
    private String numeroPz;
    /**
     * Descripcion del articulo
     */
    private String descripcionPz;
    /**
     * Cantidad de articulos comprados
     */
    private int cantidadPz;
    /**
     * Precio del articulo
     */
    private double precioPz;
    
    /**
     * Crea una nueva factura con la informacion de numero de articulos comprados,
     * su descripcion, y el numero de articulo
     * @param numeroPz Numero de articulo
     * @param descripcionPz Decripcion del articulo
     * @param cantidadPz Cantidad de articulos adquiridos
     * @param precioPz Precio por articulo
     */
    public Factura(String numeroPz, String descripcionPz, int cantidadPz,
            double precioPz){
        if(cantidadPz < 0)
            throw new IllegalArgumentException("La cantidad de piezas no puede ser < 0");
        if(precioPz < 0.0)
            throw new IllegalArgumentException("El precio no puede ser < 0.0");
        
        this.numeroPz = numeroPz;
        this.descripcionPz = descripcionPz;
        this.cantidadPz = cantidadPz;
        this.precioPz = precioPz;
    }
    
    /**
     * Obtiene el numero del articulo
     * @return Numero del articulo
     */
    public String obtenerNumero(){
        return numeroPz;
    }
    
    /**
     * Establece el numero de articulo
     * @param numeroPz Numero del articulo
     */
    public void establecerNumero(String numeroPz){
        this.numeroPz = numeroPz;
    }
    
    /**
     * Obtiene la descripcion del articulo
     * @return Descripcion del articulo
     */
    public String obtenerDescripcion(){
        return descripcionPz;
    }
    
    /**
     * Establece la descripcion del articulo
     * @param descripcionPz La descripcion del articulo
     */
    public void establecerDescripcion(String descripcionPz){
        this.descripcionPz = descripcionPz;
    }
    /**
     * Obtiene la cantidad de articulos comprados
     * @return Cantidad de articulos comprados
     */
    public int obtenerCantidad(){
        return cantidadPz;
    }
    
    /**
     * Establece la cantidad de articulos comprados
     * @param cantidadPz Cantidad de articulos comprados
     */
    public void establecerCantidad(int cantidadPz){
        if(cantidadPz < 0)
            throw new IllegalArgumentException("La cantidad de articulos no puede ser < 0");
        
        this.cantidadPz = cantidadPz;
    }
    
    /**
     * Obtiene el precio por articulo
     * @return Precio del articulo por pieza
     */
    public double obtenerPrecio(){
        return precioPz;
    }
    
    /**
     * Establece el precio del articulo
     * @param precioPz Precio del articulo
     */
    public void establecerPrecio(double precioPz){
        if(precioPz < 0.0)
            throw new IllegalArgumentException("El precio no puede ser < 0.0");
        
        this.precioPz = precioPz;
    }
    
    /**
     * Calcula el precio total de la factura
     * @return Precio de la factura
     */
    public double obtenerMontoFactura(){
        return cantidadPz * precioPz;
    }
    /**
     * Representación String del objeto Factura
     * @return String
     */
    @Override
    public String toString(){
        return String.format("Número de articulo: %s%nDescripcion: %s%nPrecio: $%.2f%nCantidad: %d%n",
                obtenerNumero(), obtenerDescripcion(), obtenerPrecio(), obtenerCantidad());
    }
}
