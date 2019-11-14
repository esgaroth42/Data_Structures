/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heaps;

/**
 *
 * @author Adelard
 */
import java.util.*;

public class Heap implements IHeap
{
    private int HeapArray[];
    private int m_count;
   
   public Heap()
   {
       HeapArray =  new int [0];
   }

   @Override
   public void insert(int item) //needs work
   {
       int ary[] = new int[size() + 1];
       
       for (int i = 0; i < size(); i++){
           ary[i] = HeapArray[i];
       }
       ary[size()] = item;
       
       HeapArray = ary;
       
       m_count++;
   }
   
   private void moveUp(int nodeIndex)
   {
       int b = Math.floorDiv((nodeIndex-1), 2);
       
       int a = HeapArray[b];
       
       HeapArray[b] = HeapArray[nodeIndex];
       
       HeapArray[nodeIndex] = a; 
   }

   @Override
   public void insertAll(List items)
   {
       int ary[] = new int[items.size()];
       
       for (int i = 0; i < items.size(); i++){
           ary[i] = (int) items.get(i);
           m_count++;
       }
       HeapArray = ary;
   }
   
   
   @Override 
   public int size()
   {
       return m_count;
   }
   
   @Override 
   public void clear() 
   {
      int ary[] = new int [0]; 
      HeapArray = ary;
      m_count = 0;
   }

   @Override
   public int removeTop()
   {
       int a;
       int ary[] = new int[size()];
       
       a = HeapArray[0];
       
       for (int i = 1; i < size(); i++){
           ary[i-1] = HeapArray[i];
       }
       
       HeapArray = ary;
       
       //not having m_count would add '0's to the end so i left it in here
       m_count--;
       
       return a;
   }
   
   private void moveDown(int nodeIndex)
   {
   }
   
   @Override
   public String toString()
   {
       int count = m_count;
       
       
		StringBuffer sb = new StringBuffer("Root->");
		if (!isEmpty())
		{
                    int ary[] = new int [size()];
       
                    for (int i = 0; i < size(); i++){
                        ary[size() - i - 1] = HeapArray[i];
                    }
                    
                    int n = ary[count - 1];
                    sb.append(n);
                    count  = count - 1;
			while (count > 0)
			{
                            n = ary[count - 1];
                            sb.append(",");
                            sb.append(n);
                            count--;
			}
                        
		}
                else {
                    sb.append("Empty");
                }
	return sb.toString();
   }
   
   private int getParent(int nodeIndex)
   {
       int a;
       
       a = HeapArray[Math.floorDiv((nodeIndex-1), 2)];
       
       return a;
   }
   
   private int getLeft(int nodeIndex, int ary[])
   {
       int a;
       
       a = ary[(2*nodeIndex) + 1];

       return a;
   }
   
   private int getRight(int nodeIndex, int ary[])
   {
       int a;
       
       a = ary[(2*nodeIndex) + 2];

       return a;
   }
   
   public boolean isEmpty()
    {
        return size() == 0;
    }
}

