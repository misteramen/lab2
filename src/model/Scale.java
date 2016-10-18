package org.laboration.two.model;

/**
 * The <code>Scalable</code> interface adds scale functionality to its 
 * implemented classes.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 2.0
 *
 */
public interface Scale {
	/**
	 * This method applies scaling in the x and y-axis by the factors xFactor and yFactor.
	 * 
	 * @param xFactor - The factor by which the coordinates is to be scaled in the x-axis.
	 * @param yFactor - The factor by which the coordinates is to be scaled in the y-axis.
	 * 
	 * @return Super - A new scaled instance of the <code>Super</code> class is returned.
	 * 
	 */
	public Figure scale(double xFactor, double yFactor);
}
