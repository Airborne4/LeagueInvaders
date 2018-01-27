import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Rocketship rocket;
	long enemyTimer = 0;
	int enemySpawnTime = 100;
	int score = 0;

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;

	}

	void update() {
		rocket.update();
		for (Projectile pr : projectiles) {
			pr.update();
		}
		for (Alien al : aliens) {
			al.update();
		}
	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (Projectile pr : projectiles) {
			pr.draw(g);
		}
		for (Alien al : aliens) {
			al.draw(g);
		}

	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isAlive) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isAlive) {
				projectiles.remove(i);
			}
		}

	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.GAME_WIDTH - 50), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	public void checkCollision() {
		for (Alien a : aliens) {

			if (rocket.collisionBox.intersects(a.collisionBox)) {

				rocket.isAlive = false;

			}
			for (Projectile p : projectiles) {
				if (a.collisionBox.intersects(p.collisionBox)) {
					a.isAlive = false;
					p.isAlive = false;
					score++;
				}
			}
		}
	}

	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score=score;
	}
		

	public void resetGame() {
		projectiles = new ArrayList<Projectile>();
		aliens = new ArrayList<Alien>();

	}

	public void addProjectile(Projectile pr) {
		projectiles.add(pr);
	}

	public void addAlien(Alien al) {
		aliens.add(al);
	}

}
