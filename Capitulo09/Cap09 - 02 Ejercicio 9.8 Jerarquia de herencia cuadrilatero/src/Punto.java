/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 19/05/2020
 * @time 04:09:41 PM
 */
public class Punto {
    /**
     * Variable x
     */
    private final int x;
    /**
     * Variable y
     */
    private final int y;
    /**
     * Inicializa el punto con una coordenada dada
     * @param x int
     * @param y int
     */
    public Punto(int x, int y){
        if(x < 0)
            throw new IllegalArgumentException("La variable x debe ser >=  0");
        if(y < 0)
            throw new IllegalArgumentException("La variable y debe ser >=  0");
        
        this.x = x;
        this.y = y;
    }
    /**
     * Devuelve x
     * @return int
     */
    public int obtieneX(){
        return x;
    }
    /**
     * Devuelve y
     * @return int
     */
    public int obtieneY(){
        return y;
    }
    /**
     * Deveulve el punto como un objeto String
     * @return String
     */
    @Override
    public String toString(){
        return String.format("(%d, %d", obtieneX(), obtieneY());
    }
}
