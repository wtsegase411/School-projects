import java.util.Comparator;
/**
 *Class: CMSC204 CRN 32461
 *Program: Assignment 3
 *Instructor: Farnaz Eivazi
 *Summary of Description: A generic sorted double list that uses a comparator.
 *Due Date: 3/24/21
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *@author Wengel
 *@param <T> the data type
 */

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	Comparator<T> compare;
	/**
	 * Creates an empty list that is associated with the comparator 
	 * @param comparator the comparator used to compare elements
	 */	
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		compare=comparator;

	}
	/**
	 * This operation is invalid
	 * @throws UnsupportedOperationException exception to be thrown if method is called
	 */
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T string)throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	/**
	 * This operation is invalid
	 * @throws UnsupportedOperationException exception to be thrown if method is called
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T string)throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	/**
	 * This methods adds an element at a correct position
	 * @param a the element to be inserted
	 * @return a reference to the current object
	 */
	public SortedDoubleLinkedList<T> add(T a) {

		Node newNode=new Node(a);
		Node element=head;
		if(isEmpty()) {
			head=newNode;
			tail=newNode;
			size++;
			return this;
		}
		else if(getSize()==1) {
			if (compare.compare(a, head.getData())<0) {
				head=newNode;
				head.setNext(tail);
				tail.setPrev(head);
				size++;
				return this;
			}
			else {
				tail=newNode;
				tail.setPrev(head);
				head.setNext(tail);
				size++;
				return this;
			}
		}
		else if (compare.compare(a, head.getData())<0) {
			head.setPrev(newNode);
			newNode.setNext(head);
			head=newNode;
			size++;
			return this;

		}
		else if(compare.compare(a, tail.getData())>0) {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail=newNode;
			size++;
			return this;
		}
		else {
			while (compare.compare(a, element.getData())>0) {
				element=element.next;
			}
			element.prev.next=newNode;
			newNode.prev=element.prev;
			element.prev=newNode;
			newNode.next=element;
			size++;
			return this;
		}


	}



}
