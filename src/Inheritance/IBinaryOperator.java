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
public interface IBinaryOperator {
    
    public void setOperand1(int o1);
    
    public void setOperand2(int o2);
    
    public int getOperand1();
    
    public int getOperand2();
    
    public int operate();
}
