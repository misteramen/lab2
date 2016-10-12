package org.laboration.two.control;

import org.laboration.two.model.Vertex2D;

/**
 * The <code>FigureHandler</code> interface...
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
 *
 */
public interface FigureHandler {
	public void createCircle(Vertex2D position, double radius);
	public void createLine(Vertex2D a, Vertex2D b);
	public void createPoint(Vertex2D position);
	public void createRectangle(Vertex2D center, double width, double height);
	public void createTriangle(Vertex2D a, Vertex2D b, Vertex2D c);
	public void removeAll();
}
