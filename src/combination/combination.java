/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combination;

/**
 *
 * @author Adelard
 */
public class combination {
    
    public static void main (String[] args){
        combination main = new combination();
        System.out.println(main.foo(49, 6));
    }
    
    
    public int foo(int n, int k){
        
        if (k == 0 || n == 0 || k == n)
            return 1;
        
        else 
            return foo(n-1, k) + foo(n-1, k-1); 
    }
    
}
