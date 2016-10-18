package org.laboration.two.model;

/**
 * The <code>Line</code> class represents a line in 2D-space. It contains two
 * instance variables: <code>a(Vertex2D)</code> and <code>b(Vertex2D)</code>.
 * <p>
 * The class inherits two unimplemented instance methods from the superclass <code>Figure</code>. The 
 * <code>translate()</code> method adds directional movement, which makes
 * the <code>Line</code> object movable. The center() method calculates the center of the line. 
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 2.0
 *
 */
public class Line extends Figure implements Scale, Rotate {
	private Vertex2D a;
	private Vertex2D b;

	/**
	 * Constructs a new <code>Line</code> object.
	 * 
	 * @param a - Specifies one of the line's two vertices.
	 * @param b - Specifies one of the line's two vertices.
	 */
	public Line(Vertex2D a, Vertex2D b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public Line translate(double dx, double dy) {
		return new Line(
			new Vertex2D(a.getX() + dx, a.getY() + dy),
			new Vertex2D(b.getX() + dx, b.getY() + dy)
		);
	}
	
	public Line scale(double xFactor, double yFactor) {
		return new Line(
			a.scale(center(), xFactor, yFactor),
			b.scale(center(), xFactor, yFactor)
		);
	}
	
	public Line rotate(double angle) {
		return new Line(
			a.rotate(center(), angle),
			b.rotate(center(), angle)
		);
	}

	@Override
	public Vertex2D center() {
		return new Vertex2D(
			(a.getX() + b.getX()) / 2.0d, 
			(a.getY() + b.getY()) / 2.0d
		);
	}
	
	public Vertex2D getA() {
		return a;
	}
	
	public Vertex2D getB() {
		return b;
	}
	
	@Override
	public String toString() {
		return
			"\nLine {\n" +
			"    A["+ a.getX() +", " + a.getY() + "] : " +
			"B["+ b.getX() +", " + b.getY() + "]\n" +
			"}\n";
	}
}
