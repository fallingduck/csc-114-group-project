
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle implements Shape {
	
	int x, y, width, height;
	Color c;
	
	public Rectangle(int x, int y, int width, int height, Color c) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.c = c;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, width, height);
	}

}
