package org.laboration.two;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.laboration.two.model.Rectangle;
import org.laboration.two.model.Vertex2D;

/**
 * This class test a set of predefined values against the <code>Rectangle</code> class's 
 * instance methods and constructor.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
 *
 */
public class RectangleTest {
	Rectangle rect;

	@Before
	public void setUp() throws Exception {
		rect = new Rectangle(new Vertex2D(2.0, 1.0), 6, 4);
	}

	@After
	public void tearDown() throws Exception {
		rect = null;
	}

	@Test
	public void testConstructor() {
		assertEquals(2, rect.center().getX(), 1);
		assertEquals(1, rect.center().getY(), 1);
		
		assertEquals(-1, rect.getA().getX(), 1);
		assertEquals(-1, rect.getA().getY(), 1);

		assertEquals(5, rect.getB().getX(), 1);
		assertEquals(-1, rect.getB().getY(), 1);
		
		assertEquals(5, rect.getC().getX(), 1);
		assertEquals(3, rect.getC().getY(), 1);
		
		assertEquals(-1, rect.getD().getX(), 1);
		assertEquals(3, rect.getD().getY(), 1);
	}

	@Test
	public void testTranslate() {
		rect = rect.translate(3, 3);
		
		assertEquals(5, rect.center().getX(), 1);
		assertEquals(4, rect.center().getY(), 1);
		
		assertEquals(2, rect.getA().getX(), 1);
		assertEquals(2, rect.getA().getY(), 1);

		assertEquals(8, rect.getB().getX(), 1);
		assertEquals(2, rect.getB().getY(), 1);
		
		assertEquals(8, rect.getC().getX(), 1);
		assertEquals(6, rect.getC().getY(), 1);
		
		assertEquals(2, rect.getD().getX(), 1);
		assertEquals(6, rect.getD().getY(), 1);
	}
	
	@Test
	public void testScale() {
		rect = rect.scale(1.21,  1.21);
		
		assertEquals(2, rect.center().getX(), 1);
		assertEquals(1, rect.center().getY(), 1);
		
		assertEquals(-1.63, rect.getA().getX(), 0.01);
		assertEquals(-1.42, rect.getA().getY(), 0.01);

		assertEquals(5.63, rect.getB().getX(), 0.01);
		assertEquals(-1.42, rect.getB().getY(), 0.01);
		
		assertEquals(5.63, rect.getC().getX(), 0.01);
		assertEquals(3.42, rect.getC().getY(), 0.01);
		
		assertEquals(-1.63, rect.getD().getX(), 0.01);
		assertEquals(3.42, rect.getD().getY(), 0.01);
	}
	
	@Test
	public void testRotate() {
		rect = rect.rotate(30);
		
		assertEquals(2, rect.center().getX(), 1);
		assertEquals(1, rect.center().getY(), 1);
		
		assertEquals(0.402, rect.getA().getX(), 0.001);
		assertEquals(-2.232, rect.getA().getY(), 0.001);

		assertEquals(5.598, rect.getB().getX(), 0.001);
		assertEquals(0.768, rect.getB().getY(), 0.001);
		
		assertEquals(3.598, rect.getC().getX(), 0.001);
		assertEquals(4.232, rect.getC().getY(), 0.001);
		
		assertEquals(-1.598, rect.getD().getX(), 0.001);
		assertEquals(1.232, rect.getD().getY(), 0.001);
	}
}
