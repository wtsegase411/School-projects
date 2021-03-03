import java.util.ArrayList;
/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 2
 *Instructor: Farnaz Eivazi
 *Summary of Description: This is a generic stack data structure
 *Due Date: 3/03/20
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 *@param <T> the data type
 */
public class NotationStack<T> implements StackInterface<T> {
	private int top;
	private T[] array;
	private static final int DEFAULT_CAPACITY=50;
	/**
	 * 
	 */
	public NotationStack() {
		this(DEFAULT_CAPACITY);
	}
	/**
	 * A constructor to initialize the fields
	 * @param i size that is passed  
	 */
	public NotationStack(int i) {		
		T[] temp=(T[])new Object[i];
		array=temp;
		top=-1;
	}
	/**
	 * This method checks if the stack is full
	 * @return returns true if stack is full, false otherwise
	 */
	@Override
	public boolean isFull() {
		return top==array.length-1;
	}
	/**
	 * This methods pops values from the top of the stack and removes it from the stack
	 * @return e the top element in the stack
	 * @throws StackUnderflowException exception to be thrown if the stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException {
		T e;
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		else {
			e=array[top];
			array[top]=null;
			top--;
			return e;
		}

	}
	/**
	 * This method returns the top element on the stack without removing it 
	 * @return the top element in the stack
	 * @throws StackUnderflowException an exception to be thrown if the stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();			
		}
		else {
			return array[top];
		}
	}
	/**
	 * This method returns the size of the stack 
	 * @return the size of the stack
	 */
	@Override
	public int size() {
		return top+1;
	}
	/**
	 * This method pushes elements to the stack 
	 * @param e the element to be pushed to the stack
	 * @return true if the method succeed 
	 * @throws StackOverflowException the exception to be thrown if the stack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {

		if(isFull()) {
			throw new StackOverflowException();
		}
		else {
			array[++top]=e;
		}
		return true;
	}
	/**
	 * This method is checks if the stack is empty
	 * @return true if the stack is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return top==-1;
	}
	/**
	 * This is a toString method that prints the stack with delimiter included
	 * @param delimiter the delimiter passed 
	 * @return the elements in the stack
	 */

	@Override
	public String toString(String delimiter) {
		StringBuilder str=new StringBuilder();
		for(int i=0;i<size();i++) {
			if(i==size()-1) {
				str.append(array[i]);
			}
			else {
				str.append(array[i]+delimiter);
			}
		}
		return str.toString();
	}
	/**
	 * This method fills the stack with items from the ArrayList 
	 * @param list the elements in the ArrrayList
	 */

	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> newlist=new ArrayList<>(list);
		for(int i=0;i<newlist.size();i++) {
			push(newlist.get(i));
		}

	}
	/**
	 * A toString method without the delimiters 
	 * @return the elements in the Stack
	 */
	public String toString() {
		return toString("");
	}
}





