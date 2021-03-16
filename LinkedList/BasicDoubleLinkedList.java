import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 3
 *Instructor: Farnaz Eivazi
 *Summary of Description: A generic doublelinked list that uses a comparator and implements a listIterator.
 *Due Date: 3/24/21
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 *@param <T> the data type
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{
	protected Node head;
	protected Node tail;
	protected int size;
	public BasicDoubleLinkedList() {
		this.head = null;
		this.tail = null;
		size=0;
	}
	/**
	 * Adds an element to the end if the list
	 * @param data the element being added
	 * @return a reference to this object
	 */
	public  BasicDoubleLinkedList<T> addToEnd(T data) {
		Node newNode=new Node(data);
		if (isEmpty()) {
			tail=newNode;
			head=newNode;
		}
		else {
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail=newNode;
		}
		size++;
		return this;

	}
	/**
	 * Adds an element to the beginning of the list
	 * @param data the element being added 
	 * @return a reference to this object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) {
		Node newNode=new Node(data);
		if (isEmpty()) {
			tail=newNode;
			head=newNode;
		}
		else {
			newNode.next=head;
			head.setPrev(newNode);
			head=newNode;
		}
		size++;
		return this;		
	}
	/**
	 * This method checks if the list is empty
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size==0;

	}
	/**
	 * This method returns the size of the list 
	 * @return size the size of the list 
	 */
	public int getSize() {
		return size;
	}
	/**
	 * Returns the last element in the list that's referenced by the tail without removing it 
	 * @return the last element in the list
	 */
	public T getLast() {
		return tail.getData();
	}
	/**
	 * Returns the first element in the list that's referenced by the head without removing it 
	 * @return the first element in the list
	 */
	public T getFirst() {
		return head.getData();
	}
	/**
	 * This method is implemented using an inner class that implements ListIterator
	 * @throws NoSuchElementException an exception thrown from the next method
	 * @throws UnsupportedOperationException an exception thrown from the methods that are unsupported
	 * @return an iterator object that's implemented in an inner class
	 */
	public ListIterator<T> iterator()throws NoSuchElementException,UnsupportedOperationException {
		return new BasicDoubleIterator();
	}
	/**
	 * Removes the targeted data from the list my using comparator to compare
	 * @param targetedData the targeted data
	 * @param comparator the comparator used to compare the data
	 * @return a reference to the object
	 */
	public BasicDoubleLinkedList<T> remove(T targetedData ,Comparator<T> comparator) {
		Node element=head.next;
		if(isEmpty()) {
			return this;
		}		
		else if(size==1) {
			if(comparator.compare(targetedData,head.getData())==0) {
				head=null;
				tail=null;
				size--;
				return this;
			}
			else {
				return this;
			}
		}
		else if(comparator.compare(targetedData, head.getData())==0) {
			head=head.next;
			head.prev=null;
			size--;
			return this;
		}
		else if (comparator.compare(targetedData, tail.getData())==0) {
			tail=tail.prev;
			tail.next=null;
			size--;
			return this;
		}
		while(element!=null&&comparator.compare(targetedData,element.getData())!=0){
			element=element.next;
		}
		if (element==null) {
			return this;
		}
		else {
			element.prev.next=element.next;
			element.next.prev=element.prev;
			size--;
			return this;
		}

	}
	/**
	 * Returns the first element and removes it from the list
	 * @return the first element in the list
	 * @throws NoSuchElementException an exception to be thrown if the list is empty
	 */
	public T retrieveFirstElement()throws NoSuchElementException {
		T first;
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		else if(size==1){	
			first=tail.getData();
			tail=null;
			head=null;
			size--;
			return first;

		}
		else {
			Node newFirst;
			first=head.getData();
			newFirst=head.getNext();                                
			head=newFirst;
			head.setPrev(null);
			size--;
			return first;
		}
	}
	/**
	 * Returns the last element in the list and removes it 
	 * @return the last element in the list
	 * @throws NoSuchElementException an exception to be thrown if the list is empty
	 */
	public T retrieveLastElement() throws NoSuchElementException{
		T last;
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		else if(size==1) {
			last=tail.getData();
			tail=null;
			head=null;
			size--;
			return last;
		}
		else {
			Node newLast;
			last=tail.getData();
			newLast=tail.getPrev();
			tail=newLast;
			tail.setNext(null);
			size--;
			return last;
		}
	}
	/**
	 * converts the linkedlist to an ArrayList
	 * @return an array list
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> list = new ArrayList<>();
		Node first = head;
		while (first != null) {
			list.add(first.getData());
			first = first.next;
		}
		return list;
	}
	
	class Node{
		private T data;
		protected Node next;
		protected Node prev;
		public Node(T data) {
			this.data=data;
			next=null;
			prev=null;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}

	}
	class BasicDoubleIterator implements ListIterator<T>{


		Node current;
		Node previous;
		public BasicDoubleIterator() {
			current=head;
			previous=null;
		}

		@Override
		public boolean hasNext() {
			return(current!=null);

		}

		@Override
		public T next() throws NoSuchElementException {
			if(hasNext()) {
				T curr=current.getData();
				previous=current;
				current=current.next;
				return curr;
			}
			else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public boolean hasPrevious() {
			return (previous!=null);
		}

		@Override
		public T previous()throws NoSuchElementException {
			if (hasPrevious()) {
				T prev=previous.getData();
				current=previous;
				previous=previous.prev;
				return prev;

			}
			else {
				throw new NoSuchElementException();
			}

		}

		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();

		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();

		}

		@Override
		public void set(T e)throws UnsupportedOperationException {
			throw new UnsupportedOperationException();

		}

		@Override
		public void add(T e)throws UnsupportedOperationException {
			throw new UnsupportedOperationException();

		}

	}

}
