/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedule;

/**
 *
 * @author Adelard
 */
public class Course {
    private String m_title;
    private String m_start;
    private String m_end;
    


    public Course (String title, String start, String end){
        m_title = title;
        m_start = start;
        m_end = end;
    }

    public String getTitle(){
        
        return m_title;
    }
    
    public String getStart(){
        
        return m_start;
    }
    
    public String getEnd(){
        
        return m_end;
    }
    
    @Override
    public String toString (){
        String s = "";
        
        s = s + getTitle() + ": ";
        s = s + getStart() + " - ";
        s = s + getEnd()+ "\n";
        
        return s;
    }
}