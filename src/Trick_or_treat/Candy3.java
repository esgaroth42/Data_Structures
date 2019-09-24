/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trick_or_treat;

import java.util.ArrayList;

/**
 *
 * @author Adelard
 */
public class Candy3 {
    
    public static ArrayList<String> m_people;

    
    public static void main(String agrs[]){
        
        m_people = new ArrayList<String>();
        
        m_people.add("mark");
        m_people.add("lou");
        m_people.add("harly");
        m_people.add("buck");
        m_people.add("Joe");

        IDataStruct_2 ds = new DataStruct_2();
        IDataStruct_2 d2 = new DataStruct_2(m_people);
         for (int j = 0; j < 5; j++)
         {
             String i = ds.grabNext();
             String z = d2.grabNext();
             
             System.out.println(z + " has a " + i);  
             
         }
    }
    
}
