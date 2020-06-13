/**
 *
 * @author EEdgar
 * @version Relase Candidate 3
 * 06/12/17, 5:06pm
 * Clase cuenta (ej 3.11)
 */
public class Cuenta {
    /**
     * Nombre del titular de la cuenta
     */
    private String nombre;
    /**
     * Saldo en la cuenta
     */
    private double saldo;
    /**
     * Constructor que inicializa la cuenta con un nombre y un saldo definido
     * @param nombre String
     * @param saldo double
     */
    public Cuenta(String nombre, double saldo){
        if(saldo < 0.0)
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        
        this.nombre = nombre;
        this.saldo = saldo;
    }
    /**
     * Realiza un retiro en la cuenta
     * @param retiro double Cantidad a retirar de la cuenta
     */
    public void retirar(double retiro){
        if(retiro < 0.0 || retiro > saldo)
            throw new IllegalArgumentException("La cantidad a retirar no es valida");
        
        saldo = saldo - retiro;
    }
    /**
     * Realiza un deposito en la cuenta
     * @param montoDeposito double Cantidad a depositar en la cuenta
     */
    public void depositar(double montoDeposito){
        if(montoDeposito < 0.0)
            throw new IllegalArgumentException("El monto a depositar no puede ser negativo");
        
        saldo = saldo + montoDeposito;
    }
    /**
     * Obtiene el saldo en la cuenta
     * @return El saldo de la cuenta
     */
    public double obtenerSaldo(){
        return saldo;
    }
    /**
     * Cambia el nombre de la cuenta
     * @param nombre El nombre de la cuenta
     */
    public void establecerNombre(String nombre){
        this.nombre = nombre;
    }
    /**
     * Obtiene el nombre del titular de la cuenta
     * @return El nombre del titular de la cuenta
     */
    public String obtenerNombre(){
        return nombre;
    }
    /**
     * Representacion String del objeto cuenta
     * @return String
     */
    @Override
    public String toString(){
        return String.format("Saldo de: %s $%.2f",
                obtenerNombre(), obtenerSaldo());
    }
}
