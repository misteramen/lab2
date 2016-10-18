package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.laboration.two.model.Triangle;
import org.laboration.two.model.Vertex2D;

/**
 * This class test a set of predefined values against the <code>Triangle</code> class's 
 * instance methods and constructor.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
 *
 */
public class TriangleTest {
	Triangle tri;

	@Before
	public void setUp() throws Exception {
		tri = new Triangle(
			new Vertex2D(-1, 1),
			new Vertex2D(3, -1),
			new Vertex2D(5, 3)
		);
	}

	@After
	public void tearDown() throws Exception {
		tri = null;
	}
	
	@Test
	public void testConstructor() {
		assertEquals(2, tri.center().getX(), 1);
		assertEquals(1, tri.center().getY(), 1);
	}

	@Test
	public void testTranslate() {
		tri = tri.translate(3, 3);
		
		assertEquals(5, tri.center().getX(), 1);
		assertEquals(4, tri.center().getY(), 1);
		
		assertEquals(2, (int) tri.getA().getX());
		assertEquals(4, (int) tri.getA().getY());

		assertEquals(6, (int) tri.getB().getX());
		assertEquals(2, (int) tri.getB().getY());

		assertEquals(8, (int) tri.getC().getX());
		assertEquals(6, (int) tri.getC().getY());
	}
	
	@Test
	public void testScale() {
		tri = tri.scale(1.21, 1.21);
		
		assertEquals(2, tri.center().getX(), 1);
		assertEquals(1, tri.center().getY(), 1);
		
		assertEquals(-1.63, tri.getA().getX(), 0.01);
		assertEquals( 1, tri.getA().getY(), 0.01);

		assertEquals(3.21, tri.getB().getX(), 0.01);
		assertEquals(-1.42, tri.getB().getY(), 0.01);

		assertEquals(5.63, tri.getC().getX(), 0.01);
		assertEquals(3.42, tri.getC().getY(), 0.01);
	}
	
	@Test
	public void testRotate() {
		tri = tri.rotate(30);
		
		assertEquals(2, tri.center().getX(), 1);
		assertEquals(1, tri.center().getY(), 1);
		
		assertEquals(-0.598, tri.getA().getX(), 0.001);
		assertEquals(  -0.5, tri.getA().getY(), 0.1);

		assertEquals( 3.866, tri.getB().getX(), 0.001);
		assertEquals(-0.232, tri.getB().getY(), 0.001);

		assertEquals(3.598, tri.getC().getX(), 0.001);
		assertEquals(4.232, tri.getC().getY(), 0.001);
	}
}
