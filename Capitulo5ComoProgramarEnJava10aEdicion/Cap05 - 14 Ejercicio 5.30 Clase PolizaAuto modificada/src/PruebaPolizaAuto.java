/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Se añaden nuevos estados del ejemplo de la figura 5.11 y se modifica metodo establecerEstado()
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 26/04/2020
 * @time 08:58:22 PM
 */
public class PruebaPolizaAuto {
    public static void main(String[] args){
        PolizaAuto poliza1 = new PolizaAuto(11111111, "Toyota Camry", "NJ");
        PolizaAuto poliza2 = new PolizaAuto(22222222, "Ford Fusion", "ME");
        
        polizaEnEstadoSinCulpa(poliza1);
        polizaEnEstadoSinCulpa(poliza2);
    }
    public static void polizaEnEstadoSinCulpa(PolizaAuto poliza){
        System.out.println("La poliza de auto: ");
        System.out.printf("Cuenta #: %d; Auto: %s; Estado %s %s un estado sin culpa%n%n", 
                poliza.obtenerNumeroCuenta(), poliza.obtenerMarcaYModelo(), poliza.obtenerEstado(),
                (poliza.esEstadoSinCulpa() ? "esta en": "no esta en"));
    }
}
