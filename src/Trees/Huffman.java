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
public class Huffman 
{
    
    private StackLL s = new StackLL();
    private StackLL s2 = new StackLL();
    
    
        public void populateNodesFromFile(String file, List nodes) throws FileNotFoundException
        {
            try (Scanner s = new Scanner(new FileReader(file))) {
                while (s.hasNext()) {
                    nodes.add(s.nextLine());
                }
            }
	}




        public Tree buildTreeFromNodes(List nodes)
        { 
            char ch = 'a';
            Tree t = new Tree (null, null, ch, 0);
            List<Tree> tr = new ArrayList();
            
            while (!nodes.isEmpty()){
                // each node is tree with left and right being null
                //Tree t = new Tree(null, null, nodes.get(x [need to find way to grab number]), nodes.get(y [need to find a way to get letter])
                
                t = new Tree (null, null, nodes.get(0).toString().substring(0, 1).charAt(0), Integer.valueOf(nodes.get(0).toString().substring(2)));
                tr.add(t);
                nodes.remove(0);
            }
  
            while (!tr.isEmpty()){
                if (tr.size() == 1)
                    break;
                
                Collections.sort(tr);

                t = new Tree (tr.get(0), tr.get(1), '*', (tr.get(0).getTotal() + tr.get(1).getTotal()));
                
                tr.add(t);
                tr.remove(0);
                tr.remove(0);
                
            }
            
            return t;
        }
        
       

	public void printTree(Tree root)
	{
            root._printTree(root);
	}   
        
        
        /*
        
        *I have changes this method to return a stack*
        
        So my intention for this meathod is to have two stacks. One to hold numbers until the code is found
        the other is used to store thge code once it is found, and then used as the return value.
        This meathod only finds ONE code, the code for the character. if the code reches back to the top it 
        assumes that the character is not in this tree and will say so.
        Because it uses two stacks the returned stack should be order from root to leaf.
        */
	public StackLL getCode(Tree root, char ch)
	{   
            
            if (root.getLeft() != null){
                s.push("0");
                getCode(root.getLeft(), ch);
            }
            if (root.getRight() != null){
                s.push("1");
                getCode(root.getRight(), ch);
            }
            if (root.getChar() == ch){
                for (int j = 0; j < s.getSize() + 1; j++){
                    s2.push(s.pop());
                }
                for (int k = 0; k < s2.getSize() + 1; k++){
                    s.push("0");
                }
            }
            
            if (root.getChar() != ch){
                
                try {
                    s.pop();
                }
                catch (IllegalStateException exception){
                    System.out.println("Stack is empty! You have no code for that character.");
                }
            }
            
            
            return s2;
	}
        /*
            
        
        */
  			
	public String decode(Tree root, String code)
	{
           String b = "";
           Tree t = root;
           
           if (code.length() == 1){
               return b;
           }
           
           while (t.getChar() == '*'){
               
               if (code.startsWith("1")){
                   t = t.getRight();
                   if (t.getChar() == '*'){
                      b = b + "";
                   }
                   else {
                      b = b + t.getChar() + decode(root, code.substring(1));
                   }
                   
               }
               
               else {
                   t = t.getLeft();
                   if (t.getChar() == '*'){
                      b = b + "";
                   }
                   else {
                      b = b + t.getChar() + decode(root, code.substring(1));
                   }
               }
           }
           
           
           
           return b;
	}
     


}

//              if(code.startsWith("1")){
//               
//               t = t.getRight();
//               if (t.getChar() == '*'){
//                      b = b + decode(t, code.substring(1));
//               }
//               else {
//                   b = b + t.getChar();
//                   while(root.getParent() != null){
//                       root = root.getParent();
//                   }
//                   decode(root, code.substring(0));
//               }
//       
//           }
//           else if (code.substring(0, 1).equals("0")) {
//               t = t.getLeft();
//               if (t.getChar() == '*'){
//                      b = b + decode(t, code.substring(1));
//               }
//               else {
//                   b = b + t.getChar();
//                   while(root.getParent() != null){
//                       root = root.getParent();
//                   }
//                   decode(root, code.substring(0));
//
//               }
//               
//           } 






//               switch (code.substring(0, 1)) {
//                   case "1":
//                       t = t.getRight();
//                       if (t.getLeft() != null && t.getRight() != null){
//                           b = b + t.getChar() + decode(root, code.substring(1));
//                        }
//                       else
//                           b = b + t.getChar() + decode(root, code.substring(1));
//                       break;
//                       
//                   case "0":
//                       t = t.getLeft();
//                       if (t.getLeft() != null && t.getRight() != null){
//                           break;
//                       }
//                       else
//                           b = b + t.getChar() + decode(root, code.substring(1));
//                       break;
//                   default:
//                       return b;
//               }