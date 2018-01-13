import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	public Alien(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void update() {
		y++;
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);

	}
}