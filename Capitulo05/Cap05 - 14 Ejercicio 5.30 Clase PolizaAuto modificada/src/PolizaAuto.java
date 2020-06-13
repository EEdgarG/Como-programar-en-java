/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 26/04/2020
 * @time 08:46:18 PM
 */
public class PolizaAuto {
    private int numeroCuenta;//<número de cuenta de la póliza
    private String marcaYModelo;//<auto al nque se aplica la póliza
    private String estado;//<abreviación del estado en dos letras
    /**
     * Inicaliza el objeto con valores proporcionados
     * @param numeroCuenta Número de cuenta
     * @param marcaYModelo Marca y modelo del auto
     * @param estado Abreviación del estado en dos letras
     */
    public PolizaAuto(int numeroCuenta, String marcaYModelo, String estado){
        this.numeroCuenta = numeroCuenta;
        this.marcaYModelo = marcaYModelo;
        this.estado = estado;
    }
    /**
     * Establece el número de cuenta
     * @param numeroCuenta Número de cuenta
     */
    public void establecerNumeroCuenta(int numeroCuenta){
        this.numeroCuenta = numeroCuenta;
    }
    /**
     * Devuelve el número de cuenta
     * @return Número de cuenta
     */
    public int obtenerNumeroCuenta(){
        return numeroCuenta;
    }
    /**
     * Establece la marca y modelo
     * @param marcaYModelo Marca y modelo
     */
    public void establecerMarcaYModelo(String marcaYModelo){
        this.marcaYModelo = marcaYModelo;
    }
    /**
     * Devuelve la marca y el modelo
     * @return Marca y modelo
     */
    public String obtenerMarcaYModelo(){
        return marcaYModelo;
    }
    /**
     * Establece el estado
     * @param estado Estado
     */
    public void establecerEstado(String estado){
        if(estado == "MA" || estado == "Massachusetts")
            this.estado = estado;
        else if(estado == "NJ" || estado == "Nueva Jersey")
            this.estado = estado;
        else if(estado == "PA" || estado == "Pensilvania")
            this.estado = estado;
        else if(estado == "CT" || estado == "Connecticut")
            this.estado = estado;
        else if(estado == "ME" || estado == "Maine")
            this.estado = estado;
        else if(estado == "NH" || estado == "Nuevo Hampshire")
            this.estado = estado;
        else if(estado == "NY" || estado == "Nueva York")
            this.estado = estado;
        else if(estado == "VT" || estado == "Vermont")
            this.estado = estado;
        else{
            this.estado = "MA";
            System.out.print("Error al asignar estado, se asigna predeterminado \"ME\"");
        }
    }
   /**
    * Devuelve el estado
    * @return Estado
    */
    public String obtenerEstado(){
        return estado;
    }
    /**
     * Muestra si el estado es un estado sin culpa
     * @return True si es sin culpa, false si es con culpa
     */
    public boolean esEstadoSinCulpa(){
        boolean estadoSinCulpa;
        
        switch(obtenerEstado()){
            case "MA": case "NJ": case "PA": case "CT": case "ME": case "NH": case "NY": case "VT":
                estadoSinCulpa = true;
                break;
            default:
                estadoSinCulpa = false;
                break;
        }
        return estadoSinCulpa;
    }
}
