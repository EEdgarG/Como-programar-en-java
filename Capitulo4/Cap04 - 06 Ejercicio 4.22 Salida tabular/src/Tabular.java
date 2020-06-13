/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 19/04/2020
 * @time 03:25:05 PM
 */
public class Tabular {
    public static void main(String[] args){
        System.out.println("N \t10*N\t100*N\t1000*N");
        for(int i = 0; i < 5; i++){
            System.out.printf("%3d\t%4d\t%5d\t%6d%n", i + 1, 10 * (i + 1), 100 * (i + 1), 1000 * (i +1));
        }
    }
}
