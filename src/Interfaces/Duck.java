/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Adelard
 */
public class Duck implements Ianimal{
    private String m_name;
    
    public Duck(String name){
        m_name = name;
    }
    
    @Override
    public String makeSound(){
        
        return m_name + " says: quack quack quack!";
        
    }
    
}
