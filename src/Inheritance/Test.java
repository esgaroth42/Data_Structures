/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inheritance;

/**
 *
 * @author Adelard
 */
public class Test {
    
    public static void main(String[] args) {
        IBinaryOperator oper = new Sum(10, 5);
        System.out.println(oper.operate());
        
        
        oper = new Diff(10, 5);
        System.out.println(oper.operate());
    }
    
}
