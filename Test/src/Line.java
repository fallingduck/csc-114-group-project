
import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	private static final long serialVersionUID = 7515942204193309949L;

	public Line(int x1, int y1, int x2, int y2, Color c) {
		super(x1, y1, x2, y2, c);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.drawLine(x1, y1, x2, y2);
	}

}
