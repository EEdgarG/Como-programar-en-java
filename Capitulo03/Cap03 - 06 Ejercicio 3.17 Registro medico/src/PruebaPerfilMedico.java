/**
 *
 * @author EEdgar+
 * @version Alfa 1
 * 12/12/17, 10:25am
 * Prueba de clase PerfilMedico
 */

public class PruebaPerfilMedico {
    public static void main(String[] args){
        PerfilMedico persona1 = new PerfilMedico("Benito", "Juarez", "H", 3, 21, 1806, 5, 25, 2020, 168, 70);
        
        System.out.printf("%s%n", persona1);
        
        System.out.printf("Frecuencia cardiaca maxima: %d%n",
                persona1.frecuenciaCardiacaMaxima());
        persona1.frecuenciaCardiacaEsperada();
        System.out.printf("El valor BMI es: %f%nVALORES BMI%nBajo peso: menos de 18.5%n",
                persona1.BMI());
        System.out.println("Normal:\tentre 18.5 y 24.9\nSobrepeso: entre 25 y 29.9");
        System.out.println("Obeso:\t30 o más");
    }
}
