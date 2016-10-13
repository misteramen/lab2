package org.laboration.two.model;

/**
 * The <code>Figure</code> class represent the base class for the representation of 
 * figures in 2D-space.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 2.0
 *
 */
public abstract class Figure {
	/**
	 * This method returns the center coordinate of the figure.
	 * 
	 * @return Vertex2D - The center coordinate of the figure.
	 */
	public abstract Vertex2D center();
}
