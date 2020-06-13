/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eedua
 */
public class Carta {
    /**
     * Cara de la carta ("As", "Dos", ...) 
     */
    private final String cara;
    /**
     * Palo de la carta ("Corazones", "Diamantes", ...)
     */
    private final String palo;
    /**
     * Inicializa las variables de instancia a unas definidas en el parametro del constructor
     * @param caraCarta String la cara de la carta
     * @param paloCarta String el palo de la carta
     */
    public Carta(String caraCarta, String paloCarta){
        this.cara = caraCarta;
        this.palo = paloCarta;
    }
    /**
     * Muestra la cara y el palo de la carta
     * @return String, cara y palo de la carta
     */
    @Override
    public String toString(){
        return obtenerCara() + " de " + obtenerPalo();
    }
    /**
     * Obtiene la cara de la carta
     * @return String cara de la carta
     */
    public String obtenerCara(){
        return cara;
    }
    /**
     * Obtiene el palo de la carta
     * @return String palo de la carta
     */
    public String obtenerPalo(){
        return palo;
    }
}
