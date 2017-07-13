import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
 int speed;
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed=0;
		// TODO Auto-generated constructor stub
	}
void draw(Graphics g){
	g.setColor(Color.BLUE);
	g.fillRect(x, y, width, height);
}
void update(){
	y-=speed;
}
}
