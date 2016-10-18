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
	/**
	 * This method moves a figure in the x-axis by a distance of <code>dx</code> and
	 * in the y-axis by a distance of <code>dy</code>, from the figures original
	 * location.
	 * 
	 * @param dx - The distance moved in the x-axis
	 * @param dy - The distance moved in the y-axis
	 * @return Figure - A new translated instance of the <code>Figure</code> class is returned.
	 */
	public abstract Figure translate(double dx, double dy);
}
