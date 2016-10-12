package org.laboration.two.control;

/**
 * The <code>FigureMover</code> interface moves all instantiated objects that 
 * are instances of classes whose parent class is <code>Figure</code>.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
 *
 */
public interface FigureMover {
	public void moveAll(double dx, double dy);
}
