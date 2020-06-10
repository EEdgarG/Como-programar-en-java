/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Crea un patron de damas chinas usando ciclos y condiciones
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 22/04/2020
 * @time 09:06:02 PM
 */
public class PatronDamas {
    public static void main(String[] args){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 16; j++){
                if(i % 2 == 0){
                    if(j % 2 == 0)
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
                else{
                    if(j % 2 == 0)
                        System.out.print("  ");
                    else
                        System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
