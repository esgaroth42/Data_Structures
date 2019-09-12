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
public class Pig implements Ianimal {
    private String m_name;
    
    public Pig(String name){
        m_name = name;
    }
    
    @Override
    public String makeSound(){
        
        return m_name + " says: oink oink oink1";

    }
}
