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
Rocketship rocket;
	GamePanel() {
		time = new Timer(1000 / 61, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subtitleFont = new Font("Arial", Font.PLAIN, 24);
		rocket = new Rocketship(250, 700, 50,50);
	}

	void updateMenuState() {

	}

	void updateGameState() {
rocket.update();
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);

		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("League Invaders", 50, 100);
		g.setFont(subtitleFont);
		g.setColor(Color.WHITE);
		g.drawString("Press Enter to start", 50, 300);
		g.setFont(subtitleFont);
		g.setColor(Color.WHITE);
		g.drawString("Press and hold space for controls", 50, 500);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.BLACK);
		
		g.fillRect(0, 0, 500, 800);
		rocket.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 50, 100);
		g.setFont(subtitleFont);
		g.setColor(Color.BLACK);
		g.drawString("You killed _# of alliens", 50, 300);
		g.setFont(subtitleFont);
		g.setColor(Color.BLACK);
		g.drawString("Press backspace to restart", 50, 500);
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
		if (e.getKeyCode() == KeyEvent.VK_UP){
			
			rocket.speed=5;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mad");
	if (e.getKeyCode() == KeyEvent.VK_UP){
			
			rocket.speed =0;
		}
	}
}
