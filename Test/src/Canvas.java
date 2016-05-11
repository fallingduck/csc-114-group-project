

import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private static final long serialVersionUID = -3828341052392942903L;
	
	ArrayList<Shape> shapes;
	
	public Canvas() {
		shapes = new ArrayList<Shape>();
	}
	
	public boolean save(String fileName) {
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(shapes);
			objOut.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean load(String fileName) {
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			shapes = (ArrayList<Shape>) objIn.readObject();
			objIn.close();
			return true;
		} catch (IOException | ClassNotFoundException | ClassCastException e) {
			return false;
		}
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	public void removeLastShape() {
		shapes.remove(shapes.size() - 1);
	}
	
	public void clearShapes() {
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
