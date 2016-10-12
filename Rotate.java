package org.laboration.two.model;

/**
 * The <code>Rotate</code> interface adds rotation functionality to its 
 * implemented classes.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 2.0
 *
 */
public interface Rotate {
	/**
	 * This method applies rotation by a supplied <code>angle</code>.
	 * 
	 * @param xFactor - The factor by which the coordinates is to be scaled in the x-axis.
	 * @param yFactor - The factor by which the coordinates is to be scaled in the y-axis.
	 * 
	 * @return Super - A new instance of the <code>Super</code> class is returned.
	 * 
	 */
	public Figure rotate(double angle);
}
