import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

public class Bullet {

	int x, y;
	int vx, vy;
	
	
	Image img = Toolkit.getDefaultToolkit().getImage("bullet.png");
	
	
	public Bullet() {
		this.x = 387;
		this.y = 600;
		this.vx = 0;
		this.vy = 9;
	}
	

	public void paint(Graphics g, ImageObserver io){
		g.drawImage(img, this.x, this.y, 7, 18, io);
		
	}
	
	
	public void update() {
		this.y -= this.vy;
	}
	
	public boolean doesHit(int x, int y){
		return this.x <= x + 50 && this.y <= y+50;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
