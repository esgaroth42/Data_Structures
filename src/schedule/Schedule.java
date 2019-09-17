/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedule;

import java.util.ArrayList;



public class Schedule {

    private ArrayList<Course> m_courses;
    
    
    public static void main(String[] args) {
        Course c1 = new Course("Java I", "8:00am", "8:50am");
        Course c2 = new Course("Aikido", "6:00pm", "9:00pm");
        
        Schedule s = new Schedule();
        s.addCourse(c1);
        s.addCourse(c2);
        
        System.out.println(s.toString());
        
    }
    
    public Schedule() {
        m_courses = new ArrayList<Course>();
        
    }
    
    public void addCourse (Course c){
        m_courses.add(c);
        
    }
    
    
    @Override
    public String toString(){
        String s = "Your Schedule" + "\n";
        
        for (Course c: m_courses){
        s = s + c.toString();
        }
        
        return s;
    }
}
