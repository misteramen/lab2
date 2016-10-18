package org.laboration.two;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.laboration.two.model.Line;
import org.laboration.two.model.Vertex2D;

/**
 * This class test a set of predefined values against the <code>Line</code> class's 
 * instance methods and constructor.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
 *
 */
public class LineTest {
	Line line;

	@Before
	public void setUp() throws Exception {
		line = new Line(new Vertex2D(0, 0), new Vertex2D(4, 2));
	}

	@After
	public void tearDown() throws Exception {
		line = null;
	}

	@Test
	public void testConstructor() {
		assertEquals(2, (int) line.center().getX());
		assertEquals(1, (int) line.center().getY());
	}
	
	@Test
	public void testTranslate() {
		line = line.translate(3, 3);

		assertEquals(5, (int) line.center().getX());
		assertEquals(4, (int) line.center().getY());
		
		assertEquals(3, (int) line.getA().getX());
		assertEquals(3, (int) line.getA().getY());
		assertEquals(7, (int) line.getB().getX());
		assertEquals(5, (int) line.getB().getY());
	}
	
	@Test
	public void testScale() {
		line = line.scale(1.21, 1.21);

		assertEquals(2, (int) line.center().getX());
		assertEquals(1, (int) line.center().getY());
		
		assertEquals(-0.42, line.getA().getX(), 0.01);
		assertEquals(-0.21, line.getA().getY(), 0.01);
		assertEquals( 4.42, line.getB().getX(), 0.01);
		assertEquals( 2.21, line.getB().getY(), 0.01);
	}
	
	@Test
	public void testRotate() {
		line = line.rotate(30);

		assertEquals(2, line.center().getX(), 1);
		assertEquals(1, line.center().getY(), 1);
		
		assertEquals( 0.768, line.getA().getX(), 0.001);
		assertEquals(-0.866, line.getA().getY(), 0.001);
		assertEquals( 3.232, line.getB().getX(), 0.001);
		assertEquals( 2.866, line.getB().getY(), 0.001);
	}
}
