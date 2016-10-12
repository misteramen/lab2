package org.laboration.two.model;

/**
 * The <code>Circle</code> class represents a circle in 2D-space. It contains two 
 * instance variables: <code>position(Vertex2D)</code> and <code>radius(double)</code>. 
 * <p>
 * The class inherits two unimplemented instance methods from the superclass <code>Figure</code>. The 
 * <code>translate()</code> method adds directional movement, which makes
 * the <code>Circle</code> object movable. The <code>center()</code> method calculates 
 * the center of the circle. 
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 2.0
 *
 */
public class Circle extends Figure implements Scale {
	private Vertex2D position;
	private double radius;
	/**
	 * Constructs a new <code>Circle</code> object.
	 * 
	 * @param position
	 * @param radius
	 */
	public Circle(Vertex2D position, double radius) {
		this.position = position;
		this.radius = radius;
	}

	@Override
	public Circle translate(double dx, double dy) {
		return new Circle(
			new Vertex2D(position.getX() + dx,  position.getY() + dy),
			radius
		);
	}
	
	public Circle scale(double xFactor, double yFactor) {
		return new Circle(
			position,
			radius * xFactor
		);
	}

	@Override
	public Vertex2D center() {
		return position;
	}
	
	public double getRadius() {
		return radius;
	}
	
	@Override
	public String toString() {
		return
			"\nCircle {\n" +
			"    P[" + position.getX() +", " + position.getY() + "] : " +
			"R[" + radius + "]\n" +
			"}\n";
	}
}
