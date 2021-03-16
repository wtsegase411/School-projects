import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SortedDoubleLinkedListStudentTest {

	SortedDoubleLinkedList<String> linkedString;
	SortedDoubleLinkedList<Double> linkedDouble;
	SortedDoubleLinkedList<Book> linkedBook;
	StringComparator comparator;
	DoubleComparator comparator2;
	BookComparator comparator3;
	
	public Book a=new Book("HarryPotter","Jk.Rowling",32);
	public Book b=new Book("To kill a mocking bird","Harper Lee",10);
	public Book c=new Book("The Great Gatspy","F.Scott Fitzgerald",25);
	public Book d=new Book("The lord of the rings","J.R.R.Tolokien",50);

	@BeforeEach
	void setUp() throws Exception {
		comparator = new StringComparator();
		linkedString = new SortedDoubleLinkedList<String>(comparator);
		
		comparator2 = new DoubleComparator();
		linkedDouble = new SortedDoubleLinkedList<Double>(comparator2);
		
		comparator3 = new BookComparator();
		linkedBook = new SortedDoubleLinkedList<Book>(comparator3);
	}

	@AfterEach
	void tearDown() throws Exception {
		comparator=null;
		comparator2=null;
		comparator3=null;
		linkedString=null;
		linkedDouble=null;
		linkedBook=null;
		
	}

	@Test
	void testAddToEnd() {
		try {
			linkedString.addToEnd("myBook");
			assertTrue(false);
		}
		catch(UnsupportedOperationException e){
			assertTrue(true);
		}
		
		try {
			linkedDouble.addToEnd(3.0);
			assertTrue(false);
		}
		catch(UnsupportedOperationException e){
			assertTrue(true);
		}
		
		try {
			linkedBook.addToEnd(b);
			assertTrue(false);
		}
		catch(UnsupportedOperationException e){
			assertTrue(true);
		}
	}

	@Test
	void testAddToFront() {
		try {
			linkedDouble.addToFront(3.0);
			assertTrue(false);
		}
		catch(UnsupportedOperationException e){
			assertTrue(true);
		}
		
		try {
			linkedString.addToFront("myBook");
			assertTrue(false);
		}
		catch(UnsupportedOperationException e){
			assertTrue(true);
		}
		
		try {
			linkedBook.addToFront(b);
			assertTrue(false);
		}
		catch(UnsupportedOperationException e){
			assertTrue(true);
		}
	}

	@Test
	void testAdd() {
		linkedString.add("Alex");
		linkedString.add("Wengel");
		linkedString.add("Geni");
		linkedString.add("Cmsc");
		assertEquals("Alex",linkedString.getFirst());
		assertEquals("Wengel",linkedString.getLast());
		
		linkedDouble.add(3.0);
		linkedDouble.add(4.0);
		linkedDouble.add(7.0);
		linkedDouble.add(9.0);
		assertEquals(3.0,linkedDouble.getFirst());
		assertEquals(9.0,linkedDouble.getLast());
		
		linkedBook.add(a);
		linkedBook.add(b);
		linkedBook.add(c);
		linkedBook.add(d);
		assertEquals(a,linkedBook.getFirst());
		assertEquals(b,linkedBook.getLast());
		
		
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
