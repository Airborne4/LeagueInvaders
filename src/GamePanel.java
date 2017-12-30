import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import javafx.scene.input.KeyCode;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer t;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font titleFont = new Font("Arial", Font.PLAIN, 48);
	Font startFont = new Font("Arial", Font.PLAIN, 30);
	Font instructionFont = new Font("Arial", Font.ITALIC, 30);
	Font gameOver = new Font("Arial", Font.BOLD, 50);
	Font killed = new Font("Arial", Font.PLAIN, 30);
	Font restartFont = new Font("Arial", Font.ITALIC, 30);
	Rocketship r = new Rocketship(250, 700, 50, 50);
	ObjectManager om = new ObjectManager(r);

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	public GamePanel() {

		t = new Timer(1000 / 60, this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		repaint();

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	void startGame() {

		t.start();

	}

	void updateMenuState() {

	}

	void updateGameState() {
		om.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.black);
		g.setFont(titleFont);
		g.drawString("LEAGUE INVADERS!", 15, 200);
		g.setFont(startFont);
		g.drawString("Press ENTER to start!", 95, 335);
		g.setFont(instructionFont);
		g.drawString("Press SPACE for instructions", 50, 430);

	}

	void drawGameState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, 500, 800);
		om.draw(g);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.black);
		g.setFont(gameOver);
		g.drawString("GAME OVER", 90, 200);
		g.setFont(killed);
		g.drawString("You killed aliens!", 135, 300);
		g.setFont(restartFont);
		g.drawString("Press BACKSPACE to restart", 55, 400);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			currentState++;

		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		} else if (currentState == GAME_STATE) {

			if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
				r.moveLeft();
				if (r.x < 0) {
					r.x = 0;
				}
			} else if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
				r.moveRight();
				int farRight = LeagueInvaders.GAME_WIDTH - r.width;
				if (r.x > farRight) {
					r.x = farRight;
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
