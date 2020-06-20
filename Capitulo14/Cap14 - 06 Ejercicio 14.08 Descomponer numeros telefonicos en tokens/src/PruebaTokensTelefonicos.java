/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date Jun 20, 2020
 * @time 1:43:19 PM
 */
public class PruebaTokensTelefonicos {
    public static void main(String[] args){
        String numero = "(555)555-5555";
        StringBuilder numeroFinal = new StringBuilder();
        
//        for(String token: tokensTelefonicos(numero))
//            System.out.printf("%s%n", token);
        String[] tokens = tokensTelefonicos(numero);
        numeroFinal.append(tokens[1]).append(tokens[2]).append(tokens[3]);
        System.out.printf("%s%n", numeroFinal);
        
    }
    public static String[] tokensTelefonicos(String numero){
        return numero.split("[()]|[-]");
    }
}
