package org.laboration.two;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.laboration.two.model.Point;
import org.laboration.two.model.Vertex2D;

/**
 * This class test a set of predefined values against the <code>Point</code> class's 
 * instance methods and constructor.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
 *
 */
public class PointTest {
	Point p;
	
	@Before
	public void setUp() throws Exception {
		p = new Point(new Vertex2D(2, 1));
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void testConstructor() {
		assertEquals(2, (int) p.center().getX());
		assertEquals(1, (int) p.center().getY());
	}
	
	@Test
	public void testTranslate() {
		p = p.translate(3, 3);
		
		assertEquals(5, (int) p.center().getX());
		assertEquals(4, (int) p.center().getY());
	}
}
