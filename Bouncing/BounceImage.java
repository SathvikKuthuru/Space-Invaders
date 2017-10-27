import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

public class BounceImage {
	
	int x, y;
	double vx = Math.random()*6;
	double vy = Math.random()*6;
	
	Image img = Toolkit.getDefaultToolkit().getImage("super-moon.png");
	
	
	public BounceImage(int x, int y) {
		this.x = (int) x;
		this.y = (int) y;
	}
	
	
	
	
	public void update(){
		this.x += (int) this.vx;
		this.y += (int) this.vy;
	}
	
	public void paint(Graphics g, ImageObserver io){
		g.drawImage(img, x, y, io);
	}



}
