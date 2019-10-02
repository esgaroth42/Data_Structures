/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Remove_Char;

/**
 *
 * @author Adelard
 */

public class Remove_Char {
    
    public static void main(String[] args)
	{
	  Remove_Char main = new Remove_Char();
	  System.out.println(main.removeChar("String", "String"));
	}
    
    public String removeChar(String a, String b){
        
        if (b.indexOf(a) == -1)
            return b;
        
        else {
            b = b.replace(a, "");
            return removeChar(a, b);
        }
            
            
    }
    
}
