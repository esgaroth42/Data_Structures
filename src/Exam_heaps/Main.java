/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam_heaps;

/**
 *
 * @author Adelard
 */
import java.util.*;
import java.util.Scanner;

public class Main 
{
   public static void main(String[] args) 
   {
      Main main = new Main();
      main.go();
   }

   public void go()
   {
      int ary[] = {82, 79, 46, 16, 12, 39, 41, 6, 4, 11};
      
      
      int root = getRoot(ary);
      System.out.printf("Root: %s%n", root);

      List leaves = getAllLeaves(ary);
      System.out.printf("Leaves: %s%n", leaves);

      List parents = getAllParents(ary);
      System.out.printf("Parents: %s%n", parents);
      
      boolean isMaxHeap1 = isMaxHeap(0, ary);
      System.out.printf("Is MaxHeap: %s%n", isMaxHeap1);
   }
   
   // ---------------------------------------------------------------
   // return the value of the root of the tree represented by ary
   // ---------------------------------------------------------------
   public int getRoot(int ary[])
   {
      // your code goes here ...
       int a  = ary[0];
      
      return a;
   }
   
   // ---------------------------------------------------------------
   // return a list containing the values for all of the nodes in the 
   // tree that are leaves
   // ---------------------------------------------------------------
   public List getAllLeaves(int ary[])
   {
      List l = new ArrayList();
      //leftChildIndex = (2 * nodeIndex) + 1
      //rightChildIndex = (2 * nodeIndex) + 2
      
      
      // your code goes here ...
      for (int i = 0; i < ary.length; i++){
          int c = (2 * i) + 1;
          if (c > ary.length){
              l.add(ary[i]);
          }
          
      }
      return l;
   }

   // ---------------------------------------------------------------
   // return a list containing the values for all of the nodes in the 
   // tree that are parents
   // ---------------------------------------------------------------
   public List getAllParents(int ary[])
   {
       //parentIndex = (nodeIndex - 1)/2
       
      List l = new ArrayList();
      
      // your code goes here ...
      for (int i = 0; i < ary.length; i++){
          int c = (2 * i) + 1;
          if (c < ary.length){
              l.add(ary[i]);
          }
      }
      
      return l;
   }
   
   // ---------------------------------------------------------------   
   // return true if the tree represented by ary is a valid max heap
   // ---------------------------------------------------------------
   public boolean isMaxHeap(int rootIndex, int ary[])
   {
       // your code goes here ...
       boolean x = false;
       int a = ary.length/2;
       if (ary.length%2 == 1){
            for (int i = 0; i < a; i++){
                if (ary[i] >= ary[(2 * i) + 1] && ary[i] >= ary[(2 * i) + 2]){
                    x = true;
                }
            }
       }
       else {
           for (int j = 0; j < a - 1; j++){
               if (ary[j] >= ary[(2 * j) + 1] && ary[j] >= ary[(2 * j) + 2] && ary[j] >= ary[(2 * (j+1)) + 1]){
                    x = true;
                }
           }
       }
       
       return x;
    }
}

