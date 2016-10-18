package model;

/**
 * The <code>Triangle</code> class represents a triangle in 2D-space. It contains three
 * instance variables: <code>a(Vertex2D)</code>, <code>b(Vertex2D)</code> and <code>c(Vertex2D)</code>.
 * <p>
 * The class inherits two unimplemented instance methods from the superclass <code>Figure</code>. The 
 * <code>translate()</code> method adds directional movement, which makes
 * the <code>Triangle</code> object movable. The <code>center()</code> method calculates the center of the triangle. 
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 2.0
 *
 */
public class Triangle extends Figure implements Scale, Rotate {
	private Vertex2D a;
	private Vertex2D b;
	private Vertex2D c;
	
	/**
	 * Constructs a new <code>Triangle</code> object.
	 * 
	 * @param a - Specifies one of the triangle's three vertices.
	 * @param b - Specifies one of the triangle's three vertices.
	 * @param c - Specifies one of the triangle's three vertices.
	 */
	
	public Triangle(Vertex2D vertex1, Vertex2D vertex2, Vertex2D vertex3) {
		a = vertex1;
		b = vertex2;
		c = vertex3;
	}

	@Override
	public Triangle translate(double dx, double dy) {
		return new Triangle(
			new Vertex2D(a.getX() + dx, a.getY() + dy),
			new Vertex2D(b.getX() + dx, b.getY() + dy),
			new Vertex2D(c.getX() + dx, c.getY() + dy)
		);
	}
	
	public Triangle scale(double xFactor, double yFactor) {
		return new Triangle(
			a.scale(center(), xFactor, yFactor),
			b.scale(center(), xFactor, yFactor),
			c.scale(center(), xFactor, yFactor)
		);
	}
	
	public Triangle rotate(double angle) {
		return new Triangle(
			a.rotate(center(), angle),
			b.rotate(center(), angle),
			c.rotate(center(), angle)
		);
	}

	@Override
	public Vertex2D center() {
		double minX = Double.MAX_VALUE;
		double minY = Double.MAX_VALUE;
		double maxX = Double.MIN_VALUE;
		double maxY = Double.MIN_VALUE;
		
		{ // Minimum X-value
			if(a.getX() < minX) {
				minX = a.getX();
			}
			
			if(b.getX() < minX) {
				minX = b.getX();
			}
			
			if(c.getX() < minX) {
				minX = c.getX();
			}
		}
		
		{ // Minimum y-value
			if(a.getY() < minY) {
				minY = a.getY();
			}
			
			if(b.getY() < minY) {
				minY = b.getY();
			}
			
			if(c.getY() < minY) {
				minY = c.getY();
			}
		}
		
		{ // Maximum x-value
			if(a.getX() > maxX) {
				maxX = a.getX();
			}
			
			if(b.getX() > maxX) {
				maxX = b.getX();
			}
			
			if(c.getX() > maxX) {
				maxX = c.getX();
			}
		}
		
		{ // Maximum y-value
			if(a.getY() > maxY) {
				maxY = a.getY();
			}
			
			if(b.getY() > maxY) {
				maxY = b.getY();
			}
			
			if(c.getY() > maxY) {
				maxY = c.getY();
			}
		}
		
		return new Vertex2D(minX + (maxX - minX) / 2, minY + (maxY - minY) / 2);
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
	
	@Override
	public String toString() {
		return 
			"\nTriangle {\n" +
			"    A["+ a.getX() +", " + a.getY() + "] : " +
			"B["+ b.getX() +", " + b.getY() + "] : " +
			"C["+ c.getX() +", " + c.getY() + "]\n" +
			"}\n";
	}
}
