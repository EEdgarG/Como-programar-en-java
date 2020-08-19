import java.io.Serializable;

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Aug 14, 2020
 * @time 11:55:10 AM
 */
public class Cuenta{
    /**
     * Número de cuenta
     */
    private int cuenta;
    /**
     * Nombre del cliente
     */
    private String primerNombre;
    /**
     * Apellido paterno
     */
    private String apellidoPaterno;
    /**
     * Saldo de la cuenta
     */
    private double saldo;
    /**
     * Constructor predeterminado
     */
    public Cuenta(){
        this(0, "", "", 0.0);// Llama a otro constructor
    }
    /**
     * Inicializa un objeto cuenta con los valores proporcionados
     */
    public Cuenta(int cuenta, String primerNombre, String apellidoPaterno, double saldo){
        this.cuenta = cuenta;
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.saldo = saldo;
    }
    /**
     * Establece el número de cuenta
     * @param cuenta número de cuenta int
     */
    public void establecerCuenta(int cuenta){
        this.cuenta = cuenta;
    }
    /**
     * Obtiene el número de cuenta
     */
    public int obtenerCuenta(){
        return cuenta;
    }
    /**
     * Establece el primer nombre
     * @param primerNombre primer nombre del cliente String
     */
    public void establecerPrimerNombre(String primerNombre){
        this.primerNombre = primerNombre;
    }
    /**
     * Obtiene el primer nombre del cliente
     * @return primer nombre String
     */
    public String obtenerPrimerNombre(){
        return primerNombre;
    }
    /**
     * Establece el apellido paterno
     * @param apellidoPaterno apellido paterno String
     */
    public void establecerApellidoPaterno(String apellidoPaterno){
        this.apellidoPaterno = apellidoPaterno;
    }
    /**
     * Obtiene el apellido paterno
     * @return apellido paterno String
     */
    public String obtenerApellidoPaterno(){
        return apellidoPaterno;
    }
    /**
     * Establece el saldo
     * @param saldo saldo de la cuenta double
     */
    public void establecerSaldo(double saldo){
        this.saldo = saldo;
    }
    /**
     * Otiene el saldo de la cuenta
     * @return saldo de la cuenta double
     */
    public double obtenerSaldo(){
        return saldo;
    }
    /**
     * Combina el monto de una transacción en el saldo de una cuenta solo si la cuenta de la transacción
     * es la misma que el objeto Cuenta
     * @param transaccion 
     */
    public void combinar(RegistroTransaccion transaccion){
        saldo += transaccion.obtenerMonto();
    }
    /**
     * Descripción de una Cuenta
     * @return número de cuenta + primer nombre + apellido paterno + saldo
     */
    @Override
    public String toString(){
        return String.format("Cuenta: %d%nNombre: %s %s%nSaldo de la cuenta %f%n", 
                obtenerCuenta(), obtenerPrimerNombre(), obtenerApellidoPaterno(), obtenerSaldo());
    }
}
