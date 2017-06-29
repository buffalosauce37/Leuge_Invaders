import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer time;
	Font titleFont;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	private Font subtitleFont;

	GamePanel() {
		time = new Timer(1000 / 61, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subtitleFont = new Font("Arial", Font.PLAIN, 30);
	}

	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("League Invaders", 100, 300);
		g.setFont(subtitleFont);
		g.setColor(Color.BLACK);
		g.drawString("Press Enter to start", 50, 500);
		g.setFont(subtitleFont);
		g.setColor(Color.BLACK);
		g.drawString("Press and hold space for controls", 50, 700);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, 500, 800);
	}

	void startGame() {
		time.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {

			updateMenuState();

		} else if (currentState == GAME_STATE) {

			updateGameState();

		} else if (currentState == END_STATE) {

			updateEndState();

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("glad");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mad");
	}
}
