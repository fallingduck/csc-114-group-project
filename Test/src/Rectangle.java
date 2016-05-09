
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle implements Shape {
	
	int x1, y1, x2, y2;
	Color c;
	
	public Rectangle(int x1, int y1, int x2, int y2, Color c) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.c = c;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(x1, y1, x2 - x1, y2 - y1);
	}

}
