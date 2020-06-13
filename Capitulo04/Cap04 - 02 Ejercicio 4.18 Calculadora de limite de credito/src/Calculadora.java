/*
 * 
 */

/**
 *
 * @author eedua
 */
public class Calculadora {
    /**
     * Numero de cuenta
     */
    private String numCuenta;
    /**
     * Saldo consumido a inicio de mes
     */
    private double saldoInicioMes;
    /**
     * Total de los articulos cargados en el mes
     */
    private double totalArtCargMes;
    /**
     * Total de los creditos aplicados en el mes
     */
    private double totalCredApliMes;
    /**
     * Limite de credito
     */
    private double limCredito;
    
    public Calculadora(String numCuenta, double saldoInicioMes, double totalArtCargMes, double totalCredApliMes, double limCredito){
        if(saldoInicioMes < 0.0)
            throw new IllegalArgumentException("El saldo consumido debe ser >= 0.0");
        
        if(totalArtCargMes < 0.0)
            throw new IllegalArgumentException("El total de articulos cargados en el mes debe ser >= 0.0");
        
        if(totalCredApliMes < 0.0)
            throw new IllegalArgumentException("El total de creditos aplicados en el mes debe ser >= 0.0");
        
        if(limCredito < 0.0)
            throw new IllegalArgumentException("El limite de credito debe ser >= 0.0");
        
        this.numCuenta = numCuenta;
        this.saldoInicioMes = saldoInicioMes;
        this.totalArtCargMes = totalArtCargMes;
        this.totalCredApliMes = totalCredApliMes;
        this.limCredito = limCredito;
    }
    
    public double nuevoSaldo(){
        return saldoInicioMes + totalArtCargMes - totalCredApliMes;
    }
    
    public void limiteDeCredito(){
        if(nuevoSaldo() > limCredito)
            System.out.println("Se excedio el limite de su credito");
    }
}
