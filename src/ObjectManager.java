import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	Rocketship rocket;

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;

	}

	void update() {
		rocket.update(); // step 5
	}

	void draw(Graphics g) {
		rocket.draw(g);
	}

	public void addProjectile(Projectile pr) {
		projectiles.add(pr);
	}
}
