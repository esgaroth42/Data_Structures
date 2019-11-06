/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

import java.io.*;
import java.util.*;

/**
 *
 * @author Adelard
 */
public class Main
{
   	public static void main(String[] args) throws Exception
	{
	    Huffman huff = new Huffman();
            

	    List nodes = new ArrayList();
	    huff.populateNodesFromFile("tree.txt", nodes);
	    //System.out.println(nodes);
					
	    // build a huffman tree from the list of nodes...
            
	    Tree root = huff.buildTreeFromNodes(nodes);
            
			
	    // print the tree...
            huff.printTree(root);
            
            System.out.println("");
 
            StackLL z = huff.getCode(root, 'X');
            System.out.print("Your code is from root to leaf: ");
            System.out.println(z);
            
            System.out.println("");
 		
            StackLL c = huff.getCode(root, 'D');
            System.out.print("Your code is from root to leaf: ");
            System.out.println(c);	
            
            System.out.println("");

            String code = "1111100";
            System.out.printf(code + " decoded as: ");					
            System.out.println(huff.decode(root, code));
            
            


	}
}
