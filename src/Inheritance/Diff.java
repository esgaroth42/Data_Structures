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

public class Diff extends Sum{
    
    
    
    public Diff(int op1, int op2){
        super(op1, op2);
    }
    
    @Override
    public int operate(){
        return (getOperand1() - getOperand2());
    }
}
