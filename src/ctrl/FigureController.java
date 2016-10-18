package ctrl;

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
 * Klassen “FigureController” har som syfte att hantera den logiska och styrande 
 * delen av programmet. Den skapar och sorterar de olika figurerna i listor som 
 * beskriver beteenden. Det finns tre beteenden som figurerna klassificeras enligt 
 * med genom operationen classify(): movableFigures, scalableFigures och 
 * rotatableFigures. Alla figurer är flyttbara och vissa figurer har alla tre 
 * beteenden.
 * 
 * @author Andreas Brodin
 * @author Niklas Lindfors
 * @author Joshua Lutakome Yawe
 * @version 1.0
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

	@Override
	public void createPoint(double x, double y) {
		movableFigures.add(new Point(position));
	}

	@Override
	public void createLine(double x0, double y0, double x1, double y1) {
		Line line = new Line(
			new Vertex2D(x0, y0), 
			new Vertex2D(x1, y1)
		);
		
		movableFigures.add(line);
		scalableFigures.add(line);
		rotatableFigures.add(line);
	}

	@Override
	public void createTriangle(double x0, double y0, double x1, double y1, double x2, double y2) {
		Trianglene triangle = new Triangle(
			new Vertex2D(x0, y0), 
			new Vertex2D(x1, y1),
			new Vertex2D(x2, y2)
		);
		
		movableFigures.add(triangle);
		scalableFigures.add(triangle);
		rotatableFigures.add(triangle);
	}

	@Override
	public void createCircle(double x, double y, double radius) {
		Circle circle = new Circle(
			new Vertex2D(x, y), 
			radius
		);
		
		movableFigures.add(circle);
		scalableFigures.add(circle);
	}

	@Override
	public void createRectangle(double x, double y, double width, double width) {
		Rectangle rectangle = new Rectangle(
			new Vertex2D(x, y), 
			width, 
			height
		);
		
		movableFigures.add(rectangle);
		scalableFigures.add(rectangle);
		rotatableFigures.add(rectangle);
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
}
