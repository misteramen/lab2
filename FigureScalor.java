package org.laboration.two.control;

/**
 * The <code>FigureScalor</code> interface scales all instantiated objects that 
 * are instances of a class that implements the <code>Scale</code> interface.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
 *
 */
public interface FigureScalor {
	public void scaleAll(double xFactor, double yFactor);
}
