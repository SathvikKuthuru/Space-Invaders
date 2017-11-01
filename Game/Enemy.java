import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

public class Enemy {
	
	int x, y;
	double vx = 2;
	//double vy = Math.random()*20;
	
	Image img = Toolkit.getDefaultToolkit().getImage("Space-invader.png");
	
	
	public Enemy(int x, int y) {
		this.x = (int) x;
		this.y = (int) y;
	}
	
	
	public boolean reachedEdge(int xCoord){
		return xCoord >= 650 || xCoord <= 0;
	}
	
	
	
	public void update(){
		this.x += (int) this.vx;
		
		/*if(this.x >= 650 || this.x <= 0){
			this.vx = -this.vx;
			this.y += 50;
		}*/
		
		//this.y += (int) this.vy;
		
		/*if(this.x >= 650 || this.x <= 0){
			this.vx = -this.vx;
		}
		if(this.y >= 650 || this.y <= 0){
			this.vy = -this.vy;
		}*/
	}
	
	public void paint(Graphics g, ImageObserver io){
		g.drawImage(img, this.x, this.y, 50, 50, io);
		
	}



}
