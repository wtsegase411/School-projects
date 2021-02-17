import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	private GradeBook g1;
	private GradeBook g2;

	@BeforeEach
	void setUp()  {
		g1=new GradeBook(5);
		g2=new GradeBook(5);
		g1.addScore(20);
		g1.addScore(30);
		g1.addScore(2);
		g2.addScore(12);
		g2.addScore(40);
		g2.addScore(3);
	}

	@AfterEach
	void tearDown()  {
		g1=null;
		g2=null;
	}

	@Test
	void testAddScore() {
		
		assertTrue(g1.toString().equals("20.0 30.0 2.0 "));
		
		assertTrue(g2.toString().equals("12.0 40.0 3.0 "));
		assertEquals(3,g1.getScoreSize());
		assertEquals(3,g2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(52,g1.sum(),.0001);
		assertEquals(55,g2.sum(),.0001);
	}

	@Test
	void testMinimum() {
		assertEquals(2,g1.minimum(),.001);
		assertEquals(3,g2.minimum(),.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(50,g1.finalScore());
		assertEquals(52,g2.finalScore());
	}

	

	

}
