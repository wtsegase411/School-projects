import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

public class BasicDoubleLinkedListStudentTest {
	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Book> linkedBook;
	StringComparator comparator;
	DoubleComparator comparator2;
	BookComparator comparator3;
	
	public Book a=new Book("HarryPotter","Jk.Rowling",32);
	public Book b=new Book("To kill a mocking bird","Harper Lee",10);
	public Book c=new Book("The Great Gatspy","F.Scott Fitzgerald",25);
	public Book d=new Book("The lord of the rings","J.R.R.Tolokien",50);

	public ArrayList<Book> fill=new ArrayList<>();
	
	@BeforeEach
	void setUp() throws Exception {
		linkedString=new BasicDoubleLinkedList<>();
		linkedString.addToEnd("textbook");
		linkedString.addToEnd("Bookbag");
		comparator=new StringComparator();
		
		linkedDouble=new BasicDoubleLinkedList<>();
		linkedDouble.addToEnd(30.0);
		linkedDouble.addToEnd(26.0);
		comparator2=new DoubleComparator();
		
		linkedBook=new BasicDoubleLinkedList<>();
		linkedBook.addToEnd(a);
		linkedBook.addToEnd(d);
		comparator3=new BookComparator();
	}

	@AfterEach
	void tearDown() throws Exception {
		linkedString=null;
		linkedDouble=null;
		linkedBook=null;
		comparator=null;
		comparator2=null;
	}
	@Test
	void testGetSize() {
		assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
		assertEquals(2,linkedBook.getSize());
	}

	@Test
	void testAddToEnd() {
		assertEquals("Bookbag",linkedString.getLast());
		linkedString.addToEnd("School");
		assertEquals("School",linkedString.getLast());
		
		assertEquals(26.0,linkedDouble.getLast());
		linkedDouble.addToEnd(22.0);
		assertEquals(22.0,linkedDouble.getLast());
		
		
		assertEquals(d,linkedBook.getLast());
		linkedBook.addToEnd(c);
		assertEquals(c,linkedBook.getLast());
	}

	@Test
	void testAddToFront() {
		assertEquals("textbook",linkedString.getFirst());
		linkedString.addToFront("Mine");
		assertEquals("Mine",linkedString.getFirst());
		
		assertEquals(30.0,linkedDouble.getFirst());
		linkedDouble.addToFront(44.0);
		assertEquals(44.0,linkedDouble.getFirst());
		
		assertEquals(a,linkedBook.getFirst());
		linkedBook.addToFront(b);
		assertEquals(b,linkedBook.getFirst());
		
	}

	@Test
	void testIsEmpty() {
		assertEquals(false,linkedString.isEmpty());
		linkedString.retrieveFirstElement();
		linkedString.retrieveFirstElement();
		assertEquals(true,linkedString.isEmpty());
		
		assertEquals(false,linkedDouble.isEmpty());
		linkedDouble.retrieveFirstElement();
		linkedDouble.retrieveFirstElement();
		assertEquals(true,linkedDouble.isEmpty());
		
		assertEquals(false,linkedBook.isEmpty());
		linkedBook.retrieveFirstElement();
		linkedBook.retrieveFirstElement();
		assertEquals(true,linkedBook.isEmpty());
	}


	@Test
	void testGetLast() {
		assertEquals("Bookbag",linkedString.getLast());
		linkedString.addToEnd("Carpool");
		assertEquals("Carpool",linkedString.getLast());
		
		assertEquals(26.0,linkedDouble.getLast());
		linkedDouble.addToEnd(22.0);
		assertEquals(22.0,linkedDouble.getLast());
		
		
		assertEquals(d,linkedBook.getLast());
		linkedBook.addToEnd(c);
		assertEquals(c,linkedBook.getLast());
	}

	@Test
	void testGetFirst() {
		assertEquals("textbook",linkedString.getFirst());
		linkedString.addToFront("Hey");
		assertEquals("Hey",linkedString.getFirst());
		
		assertEquals(30.0,linkedDouble.getFirst());
		linkedDouble.addToFront(44.0);
		assertEquals(44.0,linkedDouble.getFirst());
		
		assertEquals(a,linkedBook.getFirst());
		linkedBook.addToFront(b);
		assertEquals(b,linkedBook.getFirst());
	}

	@Test
	void testIterator() {
		linkedString.addToEnd("myBooks");
		ListIterator<String> iterator=linkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("textbook",iterator.next());
		
		linkedDouble.addToEnd(4.0);
		ListIterator<Double> iterator1=linkedDouble.iterator();
		assertEquals(true, iterator1.hasNext());
		assertEquals(30.0,iterator1.next());
		
		linkedBook.addToEnd(d);
		ListIterator<Book> iterator2=linkedBook.iterator();
		assertEquals(true, iterator2.hasNext());
		assertEquals(a,iterator2.next());
		
	}

	@Test
	void testRemove() {
		 assertEquals("textbook",linkedString.getFirst());
		 linkedString.remove("textbook", comparator);
		 assertEquals("Bookbag",linkedString.getFirst());
		 
		 assertEquals(26.0,linkedDouble.getLast());
		 linkedDouble.remove(26.0,comparator2);
		 assertEquals(30.0,linkedDouble.getLast());
		 
		 assertEquals(a,linkedBook.getFirst());
		 linkedBook.remove(a, comparator3);
		 assertEquals(d,linkedBook.getFirst());
	}

	@Test
	void testRetrieveFirstElement() {
		assertEquals("textbook",linkedString.retrieveFirstElement());
		assertEquals("Bookbag",linkedString.getLast());
		
		assertEquals(30.0,linkedDouble.retrieveFirstElement());
		assertEquals(26.0,linkedDouble.getLast());
		
		assertEquals(a,linkedBook.retrieveFirstElement());
		assertEquals(d,linkedBook.getLast());
	}

	@Test
	void testRetrieveLastElement() {
		assertEquals("Bookbag",linkedString.retrieveLastElement());
		assertEquals("textbook",linkedString.getLast());
		
		assertEquals(26.0,linkedDouble.retrieveLastElement());
		assertEquals(30.0,linkedDouble.getLast());
		
		
		assertEquals(d,linkedBook.retrieveLastElement());
		assertEquals(a,linkedBook.getLast());
		
	}

	@Test
	void testToArrayList() {
		ArrayList<Book> list;
		linkedBook.addToFront(c);
		linkedBook.addToEnd(d);
		list = linkedBook.toArrayList();
		assertEquals(c,list.get(0));
		assertEquals(a,list.get(1));
		assertEquals(d,list.get(2));
		assertEquals(d,list.get(3));
	}
	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double o1, Double o2) {
			return o1.compareTo(o2);
		}

		
	}
	
	private class BookComparator implements Comparator<Book>{

		@Override
		public int compare(Book o1, Book o2) {
			return o1.toString().compareTo(o2.toString());
		}
		
	}
	private class Book{
		String title;
		String author;
		int price;
		public Book(String title, String author, int price) {
			this.title=title;
			this.author=author;
			this.price=price;
		}
		public String getTitle() {
			return title;
		}
		public String getAuthor() {
			return author;
		}
		public int getPrice() {
			return price;
		}
		public String toString() {
			return (getTitle()+" "+getAuthor()+" "+getPrice());
		}
		
	}
}
