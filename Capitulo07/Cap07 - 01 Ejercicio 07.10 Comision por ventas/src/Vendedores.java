/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Procesa las ventas y comisiones de cada empleado en un arreglo
 * @author eedua
 */
public class Vendedores {
    private int[] ventas;
    private final float COMISION;
    private final int SUELDO_BASE;
    
    public Vendedores(int[] ventas){
        this.ventas = ventas;
        COMISION = 0.09F;
        SUELDO_BASE = 200;
    }
    
    public void procesarSueldos(){
        for(int i = 0; i < ventas.length; i++)
            ventas[i] = SUELDO_BASE + (int)(ventas[i] * COMISION);
    }
    
    public void mostrarSueldos(){
        int[] frecuencia = new int[9];
        for(int venta : ventas){
            if(venta < 1000)
                ++frecuencia[(venta / 100) - 2];
            else
                ++frecuencia[8];
        }
        
        for(int i = 0; i < frecuencia.length; i++){
            if(i == 8)
                System.out.printf("%3d en adelante %2d%n", 1000, frecuencia[i]);
            else
                System.out.printf("%3d - %3d %9d%n", (i + 2) * 100, ((i + 2) * 100) + 99, frecuencia[i]);
        }
    }
}
