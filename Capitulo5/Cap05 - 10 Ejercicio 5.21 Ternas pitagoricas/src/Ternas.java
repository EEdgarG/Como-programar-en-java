/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Muestra una tabla de las ternas pitagóricas para los catetos y la hipotenusa que no son mayores de 500
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 25/04/2020
 * @time 04:42:33 PM
 */
public class Ternas {
    public static void main(String[] args){
        for(int co = 1; co < 500; co++){
            for(int ca = 1; ca < 500; ca++){
                for(int h = 1; h < 500; h++){
                    int hh = (int)Math.pow(h, 2);
                    int ccaa = (int)Math.pow(ca, 2);
                    int ccoo = (int)Math.pow(co, 2);
                    if(hh == (ccaa + ccoo)){
                        System.out.printf("Los números h = %d, ca = %d y co = %d forman una terna pitagorica%n", h, ca, co);
//                        System.out.printf("Los números hh = %d, ccaa = %d y ccoo = %d%n", hh, ccaa, ccoo);
                    }
                }
            }
        }
    }
}
