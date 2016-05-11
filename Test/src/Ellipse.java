
import java.awt.Color;
import java.awt.Graphics;

public class Ellipse extends Shape {

	private static final long serialVersionUID = -1502734710051002154L;

	public Ellipse(int x1, int y1, int x2, int y2, Color c) {
		super(x1, y1, x2, y2, c);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval(x1, y1, x2 - x1, y2 - y1);
	}

}
