/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Imprime la canción de los doce días de navidad en inglés
 * On the first day of Christmas my true love sent to me
 * A partridge in a pear tree
 * 
 * On the second day of Christmas my true love sent to me
 * Two turtle doves
 * And a partridge in a pear tree
 * 
 * On the third day of Christmas my true love sent to me
 * Three French hens, two turtle doves
 * And a partridge in a pear tree
 * 
 * On the fourth day of Christmas my true love sent to me
 * Four calling birds, three French hens, two turtle doves
 * And a partridge in a pear tree
 * 
 * On the fifth day of Christmas my true love sent to me
 * Five gold rings, four calling birds, three French hens, two turtle doves
 * And a partridge in a pear tree
 * 
 * On the sixth day of Christmas my true love sent to me
 * Six geese a laying, five gold rings, four calling birds
 * Three French hens, two turtle doves
 * And a partridge in a pear tree
 * 
 * On the seventh day of Christmas my true love sent to me
 * Seven swans a swimming, six geese a laying, five gold rings
 * Four calling birds, three French hens, two turtle doves
 * And a partridge in a pear tree
 * 
 * On the eighth day of Christmas my true love sent to me
 * Eight maids a milking, seven swans a swimming, six geese a laying
 * Five gold rings, four calling birds, three French hens, two turtle doves
 * And a partridge in a pear tree
 * 
 * On the ninth day of Christmas my true love sent to me
 * Nine drummers drumming
 * 
 * On the tenth day of Christmas my true love sent to me
 * Ten pipers piping
 * Nine drummers drumming, ten pipers piping
 * Drumming, piping, drumming, piping
 * Eight maids a milking, seven swans a swimming, six geese a laying
 * Five gold rings, four calling birds, three French hens, two turtle doves
 * And a partridge in a pear tree
 * 
 * On the eleventh day of Christmas my true love sent to me
 * Eleven ladies dancing, ten pipers piping, nine drummers drumming
 * Eight maids a milking, seven swans a swimming, six geese a laying
 * Five gold rings, four calling birds, three French hens, two turtle doves
 * And a partridge in a pear tree
 * 
 * On the twelfth day of Christmas my true love sent to me
 * Twelve Lords a leaping, eleven ladies dancing, ten pipers piping
 * Nine, drummers drumming, eight maids a milking
 * Seven swans a swimming, six geese a laying
 * And five gold rings, four calling birds, three French hens, two turtle doves
 * And a partridge in a pear tree, and a partridge in a pear tree
 * @author EEdgarG <eedduardo33@gmail.com>
 * @date 26/04/2020
 * @time 03:17:52 PM
 */
public class Navidad {
    public static void main(String[] args){
        String intro = "On the ";
        String first = "first ";
        String christmas = "day of christmas my true love sent to me ";
        String a = "A ";
        String and = "And a ";
        String b = "partridge in a pear tree ";
        String second = "second ";
        String c = "Two turtle doves ";
        String third = "third ";
        String d = "Three French hens, ";
        String fourth = "fourth ";
        String e = "Four calling birds, ";
        String fifth = "fifth ";
        String f = "Five gold rings, ";
        String sixth = "sixth ";
        String g = "Six geese a laying, ";
        String seventh = "seventh ";
        String h = "Seven swans a swimming, ";
        String eighth = "eighth ";
        String i = "Eight maids a milking, ";
        String ninth = "ninth ";
        String j = "Nine drummers drumming, ";
        String tenth = "tenth ";
        String k = "Ten pipers piping, ";
        String bonus = "Drumming, piping, drumming, piping";
        String eleventh = "eleventh ";
        String l = "Eleven ladies dancing, ";
        String twelfth = "twelfth ";
        String m = "Twelve Lords a leaping, ";
        for(int  dia = 1; dia <= 12; dia++){
            switch(dia){
                case 1:
                    System.out.println(intro + first + christmas + "\n" + a + b + "\n");
                    break;
                case 2:
                    System.out.println(intro + second + christmas + "\n" + c + "\n" + and + b + "\n");
                    break;
                case 3:
                    System.out.println(intro + third + christmas + "\n" + d + c + "\n" + and + b + "\n");
                    break;
                case 4:
                    System.out.println(intro + fourth + christmas + "\n" + e + d + c + "\n" + and + b + "\n");
                    break;
                case 5:
                    System.out.println(intro + fifth + christmas + "\n" + f + e + d + c + "\n" + and + b + "\n");
                    break;
                case 6:
                    System.out.println(intro + sixth + christmas + "\n" + g + f + e + "\n" + d + c + "\n" + and + b + "\n");
                    break;
                case 7:
                    System.out.println(intro + seventh + christmas + "\n" + h + g + f + "\n" + e  + d + c + "\n" + and + b + "\n");
                    break;
                case 8:
                    System.out.println(intro + eighth + christmas + "\n" + i + h + g + f + "\n" + e  + d + c + "\n" + and + b + "\n");
                    break;
                case 9:
                    System.out.println(intro + ninth + christmas + "\n" + j + "\n");
                    break;
                case 10:
                    System.out.println(intro + tenth + christmas + "\n" + k + "\n"
                            + j + k + bonus + "\n" + i + h + g + f + "\n" + e  + d + c + "\n" + and + b + "\n");
                    break;
                case 11:
                    System.out.println(intro + eleventh + christmas + "\n" + l + "\n"
                            + k + j + i + "\n" + h + g + f + "\n" + e  + d + c + "\n" + and + b + "\n");
                    break;
                case 12:
                    System.out.println(intro + twelfth + christmas + "\n" + m + l + "\n"
                            + k + j + i + "\n" + h + g + f + "\n" + e  + d + c + "\n" + and + b + and + b + "\n");
                    break;
            }
        }
    }
}
