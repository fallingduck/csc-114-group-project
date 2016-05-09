

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private static final long serialVersionUID = -3828341052392942903L;
	
	ArrayList<Shape> shapes;
	
	public Canvas() {
		shapes = new ArrayList<Shape>();
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	public void removeLastShape() {
		shapes.remove(shapes.size() - 1);
	}
	
	public void clear() {
		shapes = new ArrayList<Shape>();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Shape shape : shapes) {
			shape.draw(g);
		}
	}

}
