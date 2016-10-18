package org.laboration.two.model;

/**
 * The <code>Rectangle</code> class represents a rectangle in 2D-space. It contains four
 * instance variables: <code>a</code>, <code>b</code>, <code>c</code> and <code>d</code>.
 * They each contribute with forming the rectangles shape.
 * <p>
 * The class inherits two unimplemented instance methods from the superclass <code>Figure</code>. The 
 * <code>translate()</code> method adds directional movement, which makes
 * the <code>Rectangle</code> object movable. The <code>center()</code> method calculates the center of the rectangle. 
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 2.0
 *
 */
public class Rectangle extends Figure implements Scale, Rotate {
	private Vertex2D a; 
	private Vertex2D b;
	private Vertex2D c;
	private Vertex2D d;
	
	public Rectangle(Vertex2D center, double width, double height) {
		a = new Vertex2D(center.getX() - (width/2.0d), center.getY() - (height/2.0d));
		b = new Vertex2D(center.getX() + (width/2.0d), center.getY() - (height/2.0d));
		c = new Vertex2D(center.getX() + (width/2.0d), center.getY() + (height/2.0d));
		d = new Vertex2D(center.getX() - (width/2.0d), center.getY() + (height/2.0d));
	}
	
	private Rectangle(Vertex2D a, Vertex2D b, Vertex2D c, Vertex2D d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	@Override
	public Rectangle translate(double dx, double dy) {
		return new Rectangle(
			new Vertex2D(a.getX() + dx, a.getY() + dy),
			new Vertex2D(b.getX() + dx, b.getY() + dy),
			new Vertex2D(c.getX() + dx, c.getY() + dy),
			new Vertex2D(d.getX() + dx, d.getY() + dy)
		);
	}
	
	public Rectangle scale(double xFactor, double yFactor) {
		return new Rectangle(
			a.scale(center(), xFactor, yFactor),
			b.scale(center(), xFactor, yFactor),
			c.scale(center(), xFactor, yFactor),
			d.scale(center(), xFactor, yFactor)
		);
	}
	
	public Rectangle rotate(double angle) {
		return new Rectangle(
			a.rotate(center(), angle),
			b.rotate(center(), angle),
			c.rotate(center(), angle),
			d.rotate(center(), angle)
		);
	}

	@Override
	public Vertex2D center() {
		return new Vertex2D(
			(a.getX() + c.getX()) / 2.0d, 
			(a.getY() + c.getY()) / 2.0d
		);
	}

	public Vertex2D getA() {
		return a;
	}
	
	public Vertex2D getB() {
		return b;
	}
	
	public Vertex2D getC() {
		return c;
	}
	
	public Vertex2D getD() {
		return d;
	}
	
	@Override
	public String toString() {
		return 
			"\nRectangle {\n" +
			"    A["+ a.getX() +", " + a.getY() + "] : " +
			"B["+ b.getX() +", " + b.getY() + "] : " +
			"C["+ c.getX() +", " + c.getY() + "] : " +
			"D["+ d.getX() +", " + d.getY() + "]\n" +
			"}\n";
	}
}
