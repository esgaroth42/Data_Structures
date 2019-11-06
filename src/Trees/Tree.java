/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

import java.util.*;

/**
 *
 * @author Adelard
 */
public class Tree implements Comparable<Tree>       
{    
	private Tree m_left;
	private Tree m_right;
	private Tree m_parent;
	private char m_char;
	private int m_total;

	public Tree(Tree l, Tree r, char ch, int total)
	{
		m_left = l;
		m_right = r;
		m_char = ch;
		m_total = total;
	}

	public Tree getLeft()
	{ return m_left; }
	
	public Tree getRight()
	{ return m_right; }
	
	public Tree getParent()
	{ return m_parent; }
	
	public void setParent(Tree n)
	{ m_parent = n; }
	   
	public int getTotal()
	{ return m_total; }
	
	public char getChar()
	{ return m_char; }
	
	public void printTree()
	{
	   _printTree(this);
	}
	
	public void _printTree(Tree n)
	{
		// add code here to print the tree 
		// using a preorder traversal...
            
                // print
                // preorder(left)
                // preorder(right)
            
            System.out.println(n.m_char + ", " + n.m_total);
            
            if (n.m_left != null){
                _printTree(n.m_left);
            }
            if (n.m_right != null){
                _printTree(n.m_right);
            }
            
            
	}
	
	@Override
	public String toString()
	{
		return String.format("%s (%2d)", m_char, m_total);
	}
	
	@Override
	public int compareTo(Tree t2)
	{
		// add code here to ensure that the natural ordering 
		// sorts trees in ascending order based on the tree's total, 
		// in the case of a tie sort in ascending order 
		// based on the tree's letter...
            
            if (m_total < t2.m_total){
                return -1;
            }
            else if (m_total == t2.m_total){
                if (m_char < t2.m_char)
                    return -1;
                
                else if (m_char > t2.m_char)
                    return 1;
                
                else
                    return 0;
            }
            else{
                return 1;
            }
	}
}
