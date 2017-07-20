import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	ObjectManager manager;
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;


	GamePanel() {
		time = new Timer(1000 / 61, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		subtitleFont = new Font("Arial", Font.PLAIN, 24);
		rocket = new Rocketship(250, 700, 50, 50);
		manager = new ObjectManager();
		manager.addObject(rocket);
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("allien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void updateMenuState() {
		manager.setScore(0);
	}

	void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		if (rocket.isAlive == false) {
			currentState = END_STATE;
			manager.reset();
			rocket = new Rocketship(250, 700, 50, 50);
			manager.addObject(rocket);
		}
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
		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);

		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 50, 100);
		g.setFont(subtitleFont);
		g.setColor(Color.BLACK);
		g.drawString("You killed " + manager.getScore() + " alliens", 50, 300);
		g.setFont(subtitleFont);
		g.setColor(Color.BLACK);
		g.drawString("Press Enter to restart", 50, 500);
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
		if (e.getKeyCode() == KeyEvent.VK_UP) {

			rocket.speedY = 5;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			rocket.speedY = -5;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			rocket.speedX = 5;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			rocket.speedX = -5;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			manager.addObject(new Projectile(rocket.x + rocket.width / 2, rocket.y, 10, 10));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("mad");
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {

			rocket.speedY = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {

			rocket.speedX = 0;
		}
	}
}
