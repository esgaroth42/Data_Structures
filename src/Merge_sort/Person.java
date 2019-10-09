/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Merge_sort;

/**
 *
 * @author Adelard
 */
public class Person implements Comparable<Person>
{
    private String m_first;
    private String m_last;
    private int m_age;
     
    Person(String first, String last, int age)
    {
        m_first = first;
        m_last = last;
        m_age = age;
    }
    
    public String getName()
  {
    return m_last;
  }
     
    @Override
    public String toString()
    {
        return m_last + ", " + m_first + " " + m_age;
    }
     
     
    @Override
    public int compareTo (Person other){
        if (m_last.compareTo(other.m_last) == 0)
            return 0;
        else if (m_last.compareTo(other.m_last) > 0)
            return -1;
        else
            return 1;         
     }
}