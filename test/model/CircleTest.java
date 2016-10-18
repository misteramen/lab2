package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.laboration.two.model.Circle;
import org.laboration.two.model.Vertex2D;

/**
 * This class test a set of predefined values against the <code>Circle</code> class's 
 * instance methods and constructor.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
 *
 */
public class CircleTest {
	Circle c;

	@Before
	public void setUp() throws Exception {
		c = new Circle(new Vertex2D(2, 1), 1);
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	@Test
	public void testConstructor() {
		assertEquals(2, c.center().getX(), 1);
		assertEquals(1, c.center().getY(), 1);
		assertEquals(1, c.getRadius(), 1);
	}

	@Test
	public void testTranslate() {
		c = c.translate(3, 3);
		
		assertEquals(5, c.center().getX(), 1);
		assertEquals(4, c.center().getY(), 1);
		assertEquals(1, c.getRadius(), 1);
	}
	
	@Test
	public void testScale() {
		c = c.scale(1.21, 1.21);
		
		assertEquals(2, c.center().getX(), 1);
		assertEquals(1, c.center().getY(), 1);
		assertEquals(1.21, c.getRadius(), 0.01);
	}
}
