import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

public class Player {

	int x, y;
	int lives;
	Image img = Toolkit.getDefaultToolkit().getImage("spaceship.png");
	
	
	public Player() {
		this.x = 350;
		this.y = 550;
		this.lives = 4;
		
	}
	
	
	public void moveLeft(){
		x -= 10;
	}
	
	public void moveRight() {
		x += 10;
	}
	
	public void paint(Graphics g, ImageObserver io){
		g.drawImage(img, this.x, this.y, 75, 75, io);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
