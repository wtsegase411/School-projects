import java.util.ArrayList;
/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 2
 *Instructor: Farnaz Eivazi
 *Summary of Description: This is a generic queue data structure
 *Due Date: 3/03/20
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 *@param <T> the data type
 */
public class NotationQueue<T>implements QueueInterface<T> {
	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private static final int DEFAULT_CAPACITY=50;
	private int count=0;
	/**
	 * A default constructor
	 */
	public NotationQueue() {
		this(DEFAULT_CAPACITY);
	}
	/**
	 * This is a constructor that initializes the fields
	 * @param i the size being passed 
	 */
	public NotationQueue(int i) {
		T[] temp=(T[])new Object[i];
		queue=temp;
		frontIndex=0;
		backIndex=i-1;
	}
	/**
	 * This method checks if the queue is empty
	 * @return returns true if the queue is empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return count==0;
	}
	/**
	 * This method checks if the queue is full
	 * @return true if the queue is full, false otherwise
	 */
	@Override
	public boolean isFull() {
		return frontIndex==((backIndex+1)%queue.length)&&queue[backIndex]!=null;
	}
	/**
	 * This method returns element from the front of the queue and removes it 
	 * @return front the element at the front of the queue
	 * @throws QueueUnderflowException the exception to be thrown if the queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		else {
			T front=queue[frontIndex];
			queue[frontIndex]=null;
			frontIndex=(frontIndex+1)%queue.length;
			count--;
			return front;

		}

	}
	/**
	 * This is a method that returns the size of the queue
	 * @return count the size of the queue
	 */

	@Override
	public int size() {
		return count;
	}
	/**
	 * This method adds an element to the back of the queue
	 * @param e the element being added to the queue
	 * @return return true if the add was successful
	 * @throws QueueOverflowException the exception to be thrown if the queue is full
	 */

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {

		if(isFull()) {
			throw new QueueOverflowException();
		}
		else {
			backIndex=(backIndex+1)%queue.length;
			queue[backIndex]=e;
			count++;
			return true;
		}

	}
	/**
	 * A toString method that includes a delimiter 
	 * @param delimiter the delimiter being passed 
	 * @return the string representation of all the elements in the queue 
	 */
	@Override
	public String toString(String delimiter) {

		StringBuilder str=new StringBuilder();
		for(int i=0; i<size(); i++) {
			if(i==size()-1) {
				str.append(queue[i]);
			}
			else {
				str.append(queue[i]+delimiter);
			}
		}

		return str.toString();
	}
	/**
	 * A toString method without the delimiters 
	 * @return the string representation of the elements in the queue
	 */
	public String toString() {		
		return toString("");
	}
	/**
	 * This method fills the queue from elements in the ArrayList
	 * @param list the elements in the ArrayList
	 */
	@Override
	public void fill(ArrayList<T> list) {

		ArrayList<T> newlist=new ArrayList<>(list);
		for(int i=0;i<newlist.size();i++) {
			enqueue(newlist.get(i));
		}


	}
}


