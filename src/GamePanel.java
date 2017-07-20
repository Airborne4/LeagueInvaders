import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer t;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	public void paintComponent(Graphics g) {

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

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {

	}

	void drawGameState(Graphics g) {

	}

	void drawEndState(Graphics g) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Test1");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Test2");

	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Test3");

	}

}
