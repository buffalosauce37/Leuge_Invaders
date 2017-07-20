import java.awt.Color;
import java.awt.Graphics;

public class Allien extends GameObject{

	 int Allienspeed;

	Allien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		Allienspeed=4;
	}
	void update() {
		super.update();
		y+=Allienspeed;
		if (y>800){
			isAlive=false;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	
}
}
