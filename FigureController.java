package org.laboration.two.control;

import java.util.ArrayList;
import java.util.List;

import org.laboration.two.model.Circle;
import org.laboration.two.model.Figure;
import org.laboration.two.model.Line;
import org.laboration.two.model.Point;
import org.laboration.two.model.Rectangle;
import org.laboration.two.model.Rotate;
import org.laboration.two.model.Scale;
import org.laboration.two.model.Triangle;
import org.laboration.two.model.Vertex2D;

/**
 * The <code>FigureController</code> class represent the base class for the representation of 
 * figures in 2D-space.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 2.0
 *
 */
public class FigureController implements FigureHandler, FigureMover, FigureScalor, FigureRotor, FigurePrinter {
	private List<Figure> movableFigures;
	private List<Scale> scalableFigures;
	private List<Rotate> rotatableFigures;
	
	public FigureController() {
		movableFigures = new ArrayList<Figure>();
		scalableFigures = new ArrayList<Scale>();
		rotatableFigures = new ArrayList<Rotate>();
	}
	
	public FigureController(List<Figure> figures) {
		movableFigures = figures;
		scalableFigures = new ArrayList<Scale>();
		rotatableFigures = new ArrayList<Rotate>();
		
		for(Figure figure : figures) {
			classify(figure);
		}
	}

	@Override
	public void createPoint(Vertex2D position) {
		classify(new Point(position));
	}

	@Override
	public void createLine(Vertex2D a, Vertex2D b) {
		classify(new Line(a, b));
	}

	@Override
	public void createTriangle(Vertex2D a, Vertex2D b, Vertex2D c) {
		classify(new Triangle(a, b, c));
	}

	@Override
	public void createCircle(Vertex2D position, double radius) {
		classify(new Circle(position, radius));
	}

	@Override
	public void createRectangle(Vertex2D center, double width, double height) {
		classify(new Rectangle(center, width, height));
	}

	@Override
	public void moveAll(double dx, double dy) {
		for(Figure figure : movableFigures) {
			figure.translate(dx, dy);
		}
	}

	@Override
	public void scaleAll(double xFactor, double yFactor) {
		for(Scale scalable : scalableFigures) {
			scalable.scale(xFactor, yFactor);
		}
	}

	@Override
	public void rotateAll(double angle) {
		for(Rotate rotate : rotatableFigures) {
			rotate.rotate(angle);
		}
	}

	@Override
	public void removeAll() {
		/*
		 *  This removes all figures from scalableFigures that are in the movableFigures list.
		 *  
		 */
		scalableFigures.removeAll(movableFigures);
		/*
		 *  This removes all figures from rotatableFigures that are in the movableFigures list.
		 *  
		 */
		rotatableFigures.removeAll(movableFigures);
		/*
		 *  This removes all figures from the movableFigures list.
		 *  
		 */
		movableFigures.removeAll(movableFigures);
	}

	@Override
	public void printAll() {
		for(Figure figure : movableFigures) {
			System.out.println(figure);
		}
	}
	
	private void classify(Figure unclassifiedFigure) {
		/*
		 * This small verification snippet prevents the program from returning a ConcurrentModificationException 
		 * exception, in the event of unclassifiedFigure already existing in the list.
		 * 
		 */
		if(!movableFigures.contains(unclassifiedFigure)) {
			movableFigures.add(unclassifiedFigure);
		}
		
		try {
			Scale scalable = (Scale) unclassifiedFigure;
			scalableFigures.add(scalable);
		} catch(ClassCastException e) {
		}
		
		try {
			Rotate rotatable = (Rotate) unclassifiedFigure;
			rotatableFigures.add(rotatable);
		} catch(ClassCastException e) {
		}
	}
	
	public List<Figure> getMovableFigures() {
		return movableFigures;
	}
	
	public List<Scale> getScalableFigures() {
		return scalableFigures;
	}
	
	public List<Rotate> getRotatableFigures() {
		return rotatableFigures;
	}
	
	public static void main(String[] args) {
		FigureController controller = new FigureController();
		
		controller.createPoint(new Vertex2D(2, 1));
		controller.createLine(new Vertex2D(2, 1), new Vertex2D(6, 5));
		controller.createTriangle(new Vertex2D(-3, 1), new Vertex2D(-1, 5), new Vertex2D(8, -4));		
		controller.createCircle(new Vertex2D(2, 1), 5);
		controller.createLine(new Vertex2D(-5, 1), new Vertex2D(-1, 2));
		controller.createRectangle(new Vertex2D(2, 1), 5, 4);

		System.out.println("Movable figures: \n\n" + controller.getMovableFigures());
		System.out.println("\n------------------------------------------------------------------------------\n");
		System.out.println("Scalable figures: \n\n" + controller.getScalableFigures());
		System.out.println("\n------------------------------------------------------------------------------\n");
		System.out.println("Rotatable figures: \n\n" + controller.getRotatableFigures());
	}
}
