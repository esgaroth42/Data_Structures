/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackHW;

import Queue.*;

/**
 *
 * @author Adelard
 */
public class StackArray<T> implements IStack<T>
{
	private T StackArray[];
	private int m_count;

	public StackArray()
	{
		StackArray = (T[])new Object[0];
	}
	
	@Override
	public void push(T item)
	{
		// runs in constant time...

            T ary[] = (T[])new Object[getSize() + 1];
            for (int i = 0; i < getSize(); i++){
                ary[i] = StackArray[i];
            }
            ary[getSize()] = item;
            
            StackArray = ary;
            m_count++;
	}

	@Override
	public T pop()
	{
		// runs in constant time...

		if (isEmpty())
			throw new IllegalStateException("pop error: stack is empty!");
                
                T n = StackArray[getSize() - 1];
                
		m_count--;
                
                return n;
	}

	@Override
	public T top()
	{
		// runs in constant time...

		if (isEmpty())
			throw new IllegalStateException("top error: stack is empty!");
                
                T n = StackArray[getSize() - 1];
                
		return  n;
	}

	@Override
	public boolean isEmpty()
	{
		// runs in constant time...

		return getSize() == 0;
	}

	@Override
	public int getSize()
	{
		// runs in constant time...

		return m_count;
	}

	@Override
	public String toString()
	{
		// runs in linear time...
            int count = m_count;

		StringBuffer sb = new StringBuffer("top->");
		if (!isEmpty())
		{
                    T n = StackArray[count - 1];
                    sb.append(n.toString());
                    count  = count - 1;
			while (count > 0)
			{
                            n = StackArray[count - 1];
                            sb.append("->");
                            sb.append(n.toString());
                            count--;
			}
                        
		}
		return sb.toString();
	}
}
