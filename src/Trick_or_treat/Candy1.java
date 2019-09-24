/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trick_or_treat;

import java.util.Random;

/**
 *
 * @author Adelard
 */


public class Candy1 {
    
    
    public static void main (String [] args){
        Random rand = new Random();
        
        String Candy [] = {"KitKat", "Snicker", "Milky Way", "Gummy bear", "Apple", "Lolly Pop"};
        String P [] = {"John", "Sally", "Josh", "Mike", "Molly"};
    
        String c1;
        String c2;
        String c3;
        String c4;
        String c5;
        int a = -1;
        int b = -1;
        int c = -1;
        int d = -1;
        int e = -1;

        while(a == -1){
            a = rand.nextInt(6);
            c1 = Candy[a];
            System.out.println(P[0] + " has a " + c1);
            
        
            while (b == -1 || b == a){
                b = rand.nextInt(6);
                if (b != a){
                    c2 = Candy[b];
                    System.out.println(P[1] + " has a " + c2);
                    
                    
                    while (c == -1 || c == a || c == b){
                        c = rand.nextInt(6);
                        if(c != b && c != a){
                            c3 = Candy[c];
                            System.out.println(P[2] + " has a " + c3);
                            
                            
                            while (d == -1 || d == a || d == b || d == c){
                                d = rand.nextInt(6);
                                if (d != c && d != b && d != a){
                                    c4 = Candy[d];
                                    System.out.println(P[3] + " has a " + c4);
                                    
                                    
                                    while (e == -1 || e == a || e == b || e == c || e == d){
                                    e = rand.nextInt(6);
                                        if (e != d && e != c && e != b && e != a){
                                            c5 = Candy[e];
                                            System.out.println(P[4] + " has a " + c5);
                                            break;

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }    
}
