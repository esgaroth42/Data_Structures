/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trick_or_treat;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Adelard
 */
public class Candy2 {
    
    public static ArrayList<String> m_candy;
    
    public static void main(String [] agrs){
        
        Random rand = new Random();
        m_candy = new ArrayList<>();
        
        int a = -1;
        int b = -1;
        int c = -1;
        int d = -1;
        int e = -1;
        
        while(a == -1){
            a = rand.nextInt(6);
            m_candy.add(getCandy(a));
        
            while (b == -1 || b == a){
                b = rand.nextInt(6);
                if (b != a){
                    m_candy.add(getCandy(b));
                    
                    
                    while (c == -1 || c == a || c == b){
                        c = rand.nextInt(6);
                        if(c != b && c != a){
                            m_candy.add(getCandy(c));
                            
                            
                            while (d == -1 || d == a || d == b || d == c){
                                d = rand.nextInt(6);
                                if (d != c && d != b && d != a){
                                    m_candy.add(getCandy(d));
                                    
                                    
                                    while (e == -1 || e == a || e == b || e == c || e == d){
                                    e = rand.nextInt(6);
                                        if (e != d && e != c && e != b && e != a){
                                            m_candy.add(getCandy(e));
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
        
        for (int i = 0; i < m_candy.size(); i++){
            System.out.println("Person " + (i + 1) + " has a " + m_candy.get(i));
        }  
    }
    
    public static String getCandy (int a){
        
        switch (a) {
            case 0:
                return "KitKat";
            case 1:
                return "Snicker";
            case 2:
                return "Milky Way";
            case 3:
                return "Gummy Bear";
            case 4:
                return "Apple";
            case 5:
                return "Lolly Pop";
            default:
                return "Nothing";
                        
        } 
            
    }
}
