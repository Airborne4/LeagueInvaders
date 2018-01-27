import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);

		speed = 30;

	}

	void update() {
		super.update();
	}

	void draw(Graphics g) {

		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}

	void moveLeft() {
		x -= speed;
	}

	void moveRight() {
		x += speed;
	}

}
