import javax.swing.JFrame;

public class LeagueInvaders {
public static final int GAME_WIDTH=500;
public static final int GAME_HEIGHT=800;
	JFrame j = new JFrame();
	GamePanel gp;

	public LeagueInvaders() {
		gp = new GamePanel();
		j.add(gp);
		j.setSize(GAME_WIDTH, GAME_HEIGHT);
		j.setDefaultCloseOperation(j.EXIT_ON_CLOSE);
		j.setVisible(true);
j.addKeyListener(gp);
		gp.startGame();
	}

	public static void main(String[] args) {
		new LeagueInvaders();
	}
}
