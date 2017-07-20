import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{
 int bulletspeed;
 
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		bulletspeed=10;
	}
	void update() {
		super.update();
		y-=bulletspeed;
		if (y<0){
			isAlive=false;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
	}
}
