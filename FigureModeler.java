package org.laboration.two.model;

import org.laboration.two.control.FigureHandler;
import org.laboration.two.control.FigureMover;
import org.laboration.two.control.FigurePrinter;
import org.laboration.two.control.FigureRotor;
import org.laboration.two.control.FigureScalor;

public class FigureModeler implements FigureHandler, FigureMover, FigureScalor, FigureRotor, FigurePrinter {
	@Override
	public void createPoint(Vertex2D position) {
	}

	@Override
	public void createLine(Vertex2D a, Vertex2D b) {
	}

	@Override
	public void createTriangle(Vertex2D a, Vertex2D b, Vertex2D c) {
	}

	@Override
	public void createCircle(Vertex2D position, double radius) {
	}

	@Override
	public void createRectangle(Vertex2D center, double width, double height) {
	}

	@Override
	public void moveAll(double dx, double dy) {
	}

	@Override
	public void scaleAll(double xFactor, double yFactor) {
	}

	@Override
	public void rotateAll(double angle) {
	}

	@Override
	public void removeAll() {
	}

	@Override
	public void printAll() {
	}
}
