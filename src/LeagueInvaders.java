import javax.swing.JFrame;

public class LeagueInvaders {

	JFrame j = new JFrame();
	GamePanel gp;

	public LeagueInvaders() {
		gp = new GamePanel();
		j.add(gp);
		j.setSize(500, 800);
		j.setDefaultCloseOperation(j.EXIT_ON_CLOSE);
		j.setVisible(true);
j.addKeyListener(gp);
		gp.startGame();
	}

	public static void main(String[] args) {
		new LeagueInvaders();
	}
}
