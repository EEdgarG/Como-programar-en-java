/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * En division 700,000,000 entre 1 se tarda mas de 1 minuto
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 10/05/2020
 * @time 01:27:31 PM
 */
public class PruebaEnteroEnorme {
    public static void main(String[] args){    
        //Se crean y se muestran dos objetos EnteroEnormeSinSigno
        EnteroEnormeSinSigno n1 = new EnteroEnormeSinSigno("12");//"7000000000000000000000000000000000000000"
        EnteroEnormeSinSigno n2 = new EnteroEnormeSinSigno("11");//"2999999999999999999999999999999999999999"
        System.out.printf("El número n1 es: %s%nEl número n2 es: %s%n%n", n1, n2);
        
         //Se suma n2 y n1 y se asigna a un nuevo objeto EnteroEnormeSinSigno
        EnteroEnormeSinSigno n4 = n1.suma(n2);
        System.out.printf("La suma de n1 y n2 es: %s%n%n", n4);
         
        //Se resta n2 a n1 y se asigna a un nuevo EnteroEnorme por método no estatico
        EnteroEnormeSinSigno n5 = n1.resta(n2);
        System.out.printf("La resta es: %s%n%n", n5);
        
        //Se multiplica n1 por n2 y se asigna a un nuevo objeto EnteroEnormeSinSigno
        EnteroEnormeSinSigno n6 = n1.multiplicar(n2);
        System.out.printf("La multiplicacion es: %s%n%n", n6);
        
        //Se divide n1 entre n2 y se asigna a un nuevo objeto EnteroEnormeSinSigno
        EnteroEnormeSinSigno n7 = n1.dividir(n2);
        System.out.printf("La division es: %s%n%n", n7);
        
        //Se obtiene el modulo n1 entre n2 y se asigna a un nuevo objeto EnteroEnormeSinSigno
        EnteroEnormeSinSigno n8 = n1.residuo(n2);
        System.out.printf("El residuo es: %s%n%n", n8);
        
        //Compara si n1 > n2
        System.out.printf("n1 es mayor a n2: %b%n", n1.esMayorQue(n2));
        //Compara si n1 >= n2
        System.out.printf("n1 es mayor o igual a n2: %b%n", n1.esMayorOIgualA(n2));
        //Compara si n1 < n2
        System.out.printf("n1 es menor a n2: %b%n", n1.esMenorQue(n2));
        //Compara si n1 <= n2
        System.out.printf("n1 es menor o igual a n2: %b%n", n1.esMenorOIgualA(n2));
        //Compara si n1 es igual que n2
        System.out.printf("n1 es igual a n2: %b%n", n1.esIgualA(n2));
        //Compara si n1 no es igual que n2
        System.out.printf("n1 no es igual a n2: %b%n", n1.noEsIgualA(n2));
        //Compara si n1 es cero
        System.out.printf("n1 es cero: %b%n", n1.esCero());
        
         
//        //Se crean y se muestran dos enteros enormes
//        EnteroEnorme n1 = new EnteroEnorme("-", "0");//"7000000000000000000000000000000000000000"
//        EnteroEnorme n2 = new EnteroEnorme("+", "1");//"2999999999999999999999999999999999999999"
//        System.out.printf("El número n1 es: %s%nEl número n2 es: %s%n%n", n1, n2);
//        
////        //Se suma n2 y n1 y se asigna a un nuevo entero enorme por método estatico
////        EnteroEnorme n3 = EnteroEnorme.sumar(n1, n2);
////        System.out.printf("La suma de n1 y n2 usando el método estatico es: %s%n", n3);
//        //Se suma n2 en n1 y se asigna a un nuevo entero enorme por método no estatico
//        
//        EnteroEnorme n4 = n1.sumar(n2);
//        System.out.printf("La suma de n1 y n2 usando el método no estatico es: %s%n%n", n4);
//        
//        
////        Se resta n2 a n1 y se asigna a un nuevo EnteroEnorme por método no estatico
//        EnteroEnorme n5 = n1.resta(n2);
//        System.out.printf("La resta es: %s%n%n", n5);
//        
//        //Compara si n1 > n2
//        System.out.printf("n1 es mayor a n2: %b%n", n1.esMayorQue(n2));
//        //Compara si n1 >= n2
//        System.out.printf("n1 es mayor o igual a n2: %b%n", n1.esMayorOIgualA(n2));
//        //Compara si n1 < n2
//        System.out.printf("n1 es menor a n2: %b%n", n1.esMenorQue(n2));
//        //Compara si n1 <= n2
//        System.out.printf("n1 es menor o igual a n2: %b%n", n1.esMenorOIgualQue(n2));
//        //Compara si n1 es igual que n2
//        System.out.printf("n1 es igual a n2: %b%n", n1.esIgualA(n2));
//        //Compara si n1 no es igual que n2
//        System.out.printf("n1 no es igual a n2: %b%n", n1.noEsIgualA(n2));
//        //Compara si n1 es cero
//        System.out.printf("n1 es cero: %b%n", n1.esCero());
    }
}
