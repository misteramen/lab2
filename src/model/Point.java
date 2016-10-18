package org.laboration.two.model;

/**
 * The <code>Point</code> class represents a point in 2D-space. It contains one
 * instance variable: <code>position(Vertex2D)</code>.
 * <p>
 * The class inherits two unimplemented instance methods from the superclass <code>Figure</code>. The 
 * <code>translate()</code> method makes the object movable. The <code>center()</code> 
 * method informs of the point's center, which is held by its <code>position</code> variable. 
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 2.0
 *
 */
public class Point extends Figure {
	/**
	 * Holds the values of the Point's coordinates.
	 * 
	 */
	private Vertex2D position;
	
	/**
	 * Constructs a new <code>Point</code> object.
	 * 
	 * @param position - Specifies the position of the point.
	 */
	public Point(Vertex2D position) {
		this.position = position;
	}
	
	@Override
	public Point translate(double dx, double dy) {
		return new Point(position.moveBy(dx, dy));
	}

	@Override
	public Vertex2D center() {
		return position;
	}
	
	@Override
	public String toString() {
		return 
			"\nPoint {\n" +
			"    P["+ position.getX() +", " + position.getY() + "]\n" +
			"}\n";
	}
}





