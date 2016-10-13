public interface Movable {
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
