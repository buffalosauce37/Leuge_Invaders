import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame;
	GamePanel panel;
	final static int widthf = 500;
	final int lengthf = 800;

	LeagueInvaders() {
		frame = new JFrame();
		panel = new GamePanel();
	}

	void setup() {

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(widthf, lengthf);
		panel.startGame();
		frame.addKeyListener(panel);
	}

	public static void main(String[] args) {
		LeagueInvaders Invade = new LeagueInvaders();
		Invade.setup();
	}
}
