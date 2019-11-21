package Heaps2;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> implements IHeap<T>
{
	private boolean m_max;
    private T[] m_items;
    private int m_count;
    private static final int CHUNK_SIZE = 1;
    
    
    public Heap()
    {
    	clear();
        m_count = 0;
        m_max = true;
    }

    public void setMaxHeap(boolean asMax)
    {
    	if (asMax != m_max)
    	{
	    	m_max = asMax;
	    	List<T> temp = new ArrayList<T>();
	    	for (T item : m_items)
	    	{
	    		if (item != null)
	    			temp.add(item);
	    	}
	    	clear();
	    	insertAll(temp);
    	}
    }
    
    public void insert(T item)
    {
    	grow();
    	m_items[size()] = item;
        moveUp(m_count);
        m_count++;
    }

    public void insertAll(List<T> items)
    {
    	for (T i : items)
			insert(i);
    }
    
    public int size()
    {
        return m_count;
    }
    
	@SuppressWarnings("unchecked")
	public void clear() 
	{
		m_items = (T[])new Comparable[0];
		m_count = 0;
	}

    public T peekTop()
    {
        return m_items[0];
    }

    public T removeTop()
    {
    	m_count--;
        T root = m_items[0];
        if (m_count > 0)
        {
            T farLeft = m_items[m_count];
            m_items[0] = farLeft;
            m_items[m_count] = null;
            moveDown(0);
        }
        return root;
    }
    
    @Override
    public String toString()
    {
	List<T> l = Arrays.asList(m_items); 
	Heap<T> temp = new Heap<T>();
	temp.setMaxHeap(m_max);
	temp.insertAll(l);
	StringBuffer sb = new StringBuffer("Heap: ");
    	while(temp.size() > 0)
    	{
		T item = temp.removeTop();
		if (item != null)
    			sb.append(item+"\t");
    	}
        return sb.toString();
    }
    
    private void moveUp(int i)
    {
        // NOTE use the provided private compare method to compare items!

        // if bigger than parent (or smaller if min heap)
        // swap with parent and then recursivly call moveUp again...
        int b = Math.floorDiv((i-1), 2);
        
        if (m_items[i].compareTo(m_items[b]) > 0){
            swap(i, b);
            moveUp(b);
        }
    }

    private void moveDown(int i)
    {
        // NOTE use the provided private compare method to compare items!

        // if no children, can't move down...

        // else two children

            // I am bigger than both children (or smaller if min heap), can't move down...

            // else I am smaller than the right (or bigger if min heap), so down to the right...

            // else I am smaller than both children (or bigger if min heap), so move towards the larger child...

        // else one child to left, move left...

        // else one child to right, move right...
        int l = (2*i) + 1;
        int r = (2*i) + 2;
        if (r > m_items.length){
            r = i;
        }
        if (l > m_items.length){
            l = i;
        }
        if (m_items[r].compareTo(m_items[l]) > 0){
            swap(r, l);
            moveDown(r);
        }
    }
    
    private int getParent(int index)
    {
        return (index == 0) ? -1 : (index - 1)/2;
    }

    private int getLeft(int index)
    {
        return (2 * index) + 1; 
    }

    private int getRight(int index)
    {
        return (2 * index) + 2;
    }

    private void swap(int i1, int i2)
    {
        T item1 = m_items[i1];
        T item2 = m_items[i2];
        m_items[i1] = item2;
        m_items[i2] = item1;
    }
    
    private int compare(T item1, T item2)
    {
    	if (item1 == null || item2 == null)
    		return 0;
    	
    	if (m_max)
    		return item1.compareTo(item2);
    	else
    		return item2.compareTo(item1);
    }
    
	private void grow()
	{
		// runs in linear time if the stack needs to grow... 
		if (size() == m_items.length)
		{
			@SuppressWarnings("unchecked")
			T[] temp = (T[])new Comparable[m_items.length + CHUNK_SIZE];
			for (int i = 0; i < m_items.length; i++)
			{
				temp[i] = m_items[i];
			}
			m_items = temp;
		}
	}

}
