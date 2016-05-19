//MoffettC JacobD

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
	ArrayList<Shape> deletedShapes;
	
	public Canvas() {
		shapes = new ArrayList<Shape>();
		deletedShapes = new ArrayList<Shape>();
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
			shapes = (ArrayList<Shape>) (objIn.readObject());
			objIn.close();
			return true;
		} catch (IOException | ClassNotFoundException | ClassCastException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	public void removeLastShape() {
		if (shapes.size() == 0) return;
		deletedShapes.add(shapes.remove(shapes.size() - 1));
	}
	
	public void redoLastShape() {
		if (deletedShapes.size() == 0) return;
		shapes.add(deletedShapes.remove(deletedShapes.size() - 1));
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
