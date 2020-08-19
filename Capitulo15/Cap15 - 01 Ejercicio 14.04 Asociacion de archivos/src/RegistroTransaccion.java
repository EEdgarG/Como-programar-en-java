import java.io.Serializable;

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Aug 14, 2020
 * @time 1:49:56 PM
 */
public class RegistroTransaccion{
    /**
     * Número de cuenta
     */
    private int cuenta;
    /**
     * Monto de la transacción
     */
    private double monto;
    /**
     * Constructor predeterminado, inicializa las variables de instancia a 0
     */
    public RegistroTransaccion(){
        this(0, 0.0);
    }
    /**
     * Inicializa las variables de instancia a los valors que se le pasan al constructor
     * @param cuenta
     * @param monto 
     */
    public RegistroTransaccion(int cuenta, double monto){
        this.cuenta = cuenta;
        this.monto = monto;
    }
    /**
     * Establece el número de cuenta
     * @param cuenta int
     */
    public void establecerCuenta(int cuenta){
        this.cuenta = cuenta;
    }
    /**
     * Establece el monto de la transacción
     * @param monto double
     */
    public void establecerMonto(double monto){
        this.monto = monto;
    }
    /**
     * Obtiene el número de cuenta
     * @return int
     */
    public int obtenerCuenta(){
        return cuenta;
    }
    /**
     * Obtiene el monto de la transacción
     * @return double
     */
    public double obtenerMonto(){
        return monto;
    }
    /**
     * Obtiene la representación String de la transacción
     * @return String número de cuenta + monto de la transacción
     */
    @Override
    public String toString(){
        return String.format("Cuenta: %d, Monto de transaccion: $%f%n", obtenerCuenta(), obtenerMonto());
    }
}
