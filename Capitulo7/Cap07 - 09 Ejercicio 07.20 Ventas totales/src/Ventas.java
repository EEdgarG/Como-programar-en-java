/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  
 * @author eedua
 */
public class Ventas {
    private int vendedor;
    private int producto;
    private float precio;
    
    public Ventas(){
        vendedor = 0;
        producto = 0;
        precio = 0.0f;
    }
    public Ventas(int vendedor, int producto, float precio){
        this.vendedor = vendedor;
        this.producto = producto;
        this.precio = precio;
    }
    public String toString(){
        String descripcion ="";
        descripcion += producto;
        return descripcion;
    }
}
