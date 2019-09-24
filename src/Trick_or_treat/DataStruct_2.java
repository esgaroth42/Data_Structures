package Trick_or_treat;

import java.util.*;

/**
 *
 * @author Adelard
 */
public class DataStruct_2 implements IDataStruct_2
{
    private int m_curI = -1;
    private String m_curV = "";
    private List<String> m_choices;
    
    Random rand = new Random();

    public static void main(String args[]){
        
        
    }

    public DataStruct_2()
    {
        m_choices = new ArrayList<String>();
        m_choices.add("Kitkit");
        m_choices.add("Snickers");
        m_choices.add("Milky Way");
        m_choices.add("Gummy Bear");
        m_choices.add("Apple");
        m_choices.add("Lolly Pop");
        
        //Collections.shuffle(m_choices);
        //could add loop to randomize
        for (int i = 0; i < 20; i++){
            String a;
            
            int b = rand.nextInt(6);
            a = m_choices.get(b);
            int c = rand.nextInt(6);
            
            m_choices.set(b, m_choices.get(c));
            m_choices.set(c, a);
            
        }
    }

    public DataStruct_2(List<String> l)
    {
        m_choices = new ArrayList<String>();
        m_choices.addAll(l);
    }

    public boolean hasNext()
    {
        int nextI = nextAvailIndex();
        return nextI != -99;
    }

    public String grabNext()
    {     
        int nextI = nextAvailIndex();
        if (nextI == -99)
        {
            throw new IllegalStateException("can't grab next");
        }

        m_curI = nextI;
        m_curV = m_choices.get(nextI);  
        m_choices.set(m_curI, " ");

        return m_curV;
    }

    public void release()
    {  
        m_choices.set(m_curI, m_curV);                 
    }
    
    public IDataStruct_2 copyMe()
    {
        IDataStruct_2 ret = new DataStruct_2(m_choices);
        return ret;
    }

    private int nextAvailIndex()
    {
        int loc = m_curI+1;
        while (loc < m_choices.size() && m_choices.get(loc).equals(" "))
        {
            loc = loc+1;  
        }

        if (loc >= m_choices.size())
        {
            loc = -99;
        }
        
        return loc;
    }
}