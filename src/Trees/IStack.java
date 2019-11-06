/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

import Queue.*;

/**
 *
 * @author Adelard
 */
public interface IStack<T>
{
	public void push(T item);
	
	public T pop();
		
	public T top();
	
	public boolean isEmpty();
	
	public int getSize();
}
