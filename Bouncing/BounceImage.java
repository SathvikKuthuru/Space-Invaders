import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class BounceImage {
	
	double x, y;
	double vx = Math.random();
	double vy = Math.random();
	
	Image img = Toolkit.getDefaultToolkit().getImage("");
	
	
	public BounceImage(int x, int y) {
		this.x = (int) x;
		this.y = (int) y;
	}
	
	
	
	
	public void update(){
		
	}
	
	public void paint(Graphics g){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
