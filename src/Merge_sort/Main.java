/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Merge_sort;

/**
 *
 * @author Adelard
 */
import java.util.*;

public class Main
{    
    public static void main(String args[])
    {
      // -----------------------------------
      // do not edit main...       
      // -----------------------------------
        
      // My added main
//      List P2 = new ArrayList();
//      P2.add(new Person("Frank", "Marsh", 73));
//      P2.add(new Person("Mark", "Kaol", 44)); 
//      P2.add(new Person("Tim", "Smin", 22));
//      P2.add(new Person("Steve", "Johnson", 16)); 
//      P2.add(new Person("Andy", "Asher", 44)); 
//      P2.add(new Person("Albert", "Dent", 58)); 
//        
      //------------------------------------
      List people = new ArrayList();
      
      people.add(new Person("Frank", "Denton", 73));
      people.add(new Person("Mark", "Cohen", 44)); 
      people.add(new Person("Tim", "Smith", 22));
      people.add(new Person("Steve", "Denton", 16)); 
      people.add(new Person("Andy", "Ashton", 44)); 
      people.add(new Person("Albert", "Denton", 58)); 
      
      
//      List ans = merge(people, P2);
//      System.out.println(ans);
      
      List ans = mergeSort(people);
      System.out.println(ans);
      // -----------------------------------
    }
    
    public static List mergeSort(List items)
    {
        List sorted = new ArrayList();
        if (items.size() == 1) // base case...
        {
            // -----------------------------------
            // put your code here...
            return items;
            
            // -----------------------------------
        }
        else // recursive call...
        {
            // -----------------------------------
            // put your code here...
            List fHalf = new ArrayList();
            List sHalf = new ArrayList();
            int i = items.size() / 2;
            
            for (int j = 0; j < items.size(); j++){
                if (j < i)
                    fHalf.add(items.get(j));
                else
                    sHalf.add(items.get(j));
            }   

            sorted = merge(mergeSort(fHalf), mergeSort(sHalf));
            

            // -----------------------------------
        }
        return sorted;
    }
    
    private static List merge(List partA, List partB)
    {
         List merged = new ArrayList();
         
         // -----------------------------------
         // put your code here...

         
         while(!partA.isEmpty() || !partB.isEmpty()){
            

             
             
             if (partA.isEmpty()){
                 merged.addAll(partB);
                 partB.removeAll(partB);
                 break;
             }
             if(partB.isEmpty()){
                 merged.addAll(partA);
                 partA.removeAll(partA);
                 break;
             }

            Person p1 = (Person)partA.get(0);
            Person p2 = (Person)partB.get(0);

             
             if (p1.compareTo(p2) < 0){
                 merged.add(partB.get(0));
                 partB.remove(0);
             }
                 
             else{
                 merged.add(partA.get(0));
                 partA.remove(0);
             }       
         }
         // -----------------------------------

         return merged;
    }
}
