import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive;
	Rectangle collisionBox;

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {
	}

	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.isAlive = true;
		this.collisionBox= new Rectangle(x,y,width,height);
	}
}