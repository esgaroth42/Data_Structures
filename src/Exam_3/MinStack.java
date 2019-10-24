/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam_3;

/**
 *
 * @author Adelard
 * @param <T>
 */
public class MinStack<T extends Comparable<T>> implements IStack<T>{

        private Node m_head;
	private int m_count;
        
        private IStack<T> stack1 = new StackLL<T>();
        private IStack<T> stack2 = new StackLL<T>();
        
        public static void main(String[] args)
	{
	  MinStack main = new MinStack();
	  main.go();
	}
        
        
        public void go(){
            IStack<String> stack3 = new MinStack<String>();
            stack3.push("Tom");
            stack3.push("Mark");
            stack3.push("Ave");
            stack3.push("Lou");
            
            System.out.println();  
            // cannot get stack2 here to have any things in it
        }
        
        
        

	public MinStack()
	{
		m_head = new Node(null);
	}
	
	@Override
	public void push(T item)
	{
		// runs in constant time...
            
                

		Node n = new Node(item);
		n.m_next = m_head.m_next;
		m_head.m_next = n;
		m_count++;
                
                if (stack2.isEmpty())
                    stack2.push(item);
                
                if (stack2.top().compareTo(item) > 0)
                    stack2.push(item);
                
                /*
                System.out.println(stack2.top());
                
                this prints out right minimum
                */
       
	}

	@Override
	public T pop()
	{
		// runs in constant time...

		if (isEmpty())
			throw new IllegalStateException("pop error: stack is empty!");

		m_count--; 
		T ret = m_head.m_next.m_data;
		m_head.m_next = m_head.m_next.m_next;
                
                if(ret.compareTo(stack2.top()) == 0)
                    stack2.pop();
                
                //havent tried this part yet
                    

		return ret;
	}

	@Override
	public T top()
	{
		// runs in constant time...

		if (isEmpty())
			throw new IllegalStateException("top error: stack is empty!");
		return  m_head.m_next.m_data;
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

		StringBuffer sb = new StringBuffer("top->");
		if (!isEmpty())
		{
			Node node = m_head.m_next;
			sb.append(node.m_data.toString());
			while (node.m_next != null)
			{
				node = node.m_next;
				sb.append("->");
				sb.append(node.m_data.toString());
			}
		}
		return sb.toString();
	}
        public T min (){
            return stack2.top();
            
            //should work but nit showing up...
        }


	/**
	 * <p>Internal class used to represent a link in a linked list
	 * structure.  Each node in the list contains the element
	 * that was added to the stack, as well as a reference to the
	 * next item in the stack.</p>
	 */
	private class Node
	{
	 	private T m_data;
	 	private Node m_next;

		public Node(T data)
		{
			m_data = data;
			m_next = null;
		}
	}
        
}

