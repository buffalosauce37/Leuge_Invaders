import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speedY;
	int speedX;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speedY = 0;
		// TODO Auto-generated constructor stub
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}

	void update() {
		super.update();
		y -= speedY;
		x -= speedX;
	}
}
