import java.awt.Color; 
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Invader extends JComponent implements Runnable, KeyListener {

	ArrayList<Enemy> enemy1 = new ArrayList<Enemy>();
	ArrayList<Enemy> enemy2 = new ArrayList<Enemy>();
	Player player = new Player();
	Bullet bullet = new Bullet();
	static boolean b = false;
	static int score = 0;
	static int level = 1;
	
	public Invader() {
		
		int x = 0, y = 70;
		
		for(int i = 0; i < 8; i++){
			x += 70;
			enemy1.add(new Enemy(x, y));
		}
		x = 0;
		y= 140;
		for(int i = 0; i < 8; i++){
			x += 70;
			enemy2.add(new Enemy(x, y));
		}

		Thread t = new Thread(this);
		t.start();
	}

	public void paint(Graphics g) {
		for(Enemy e : enemy1){
			e.paint(g, this);
		}
		for(Enemy e : enemy2){
			e.paint(g, this);
		}		
		bullet.paint(g, this);
		player.paint(g, this);
		g.setColor(Color.green);
		g.drawString("Score: " + Integer.toString(score), 600, 50);
		g.drawString("Level " + Integer.toString(level), 400, 50);
	}

	public static void main(String[] args) {
		Invader in = new Invader();
		JFrame frame = new JFrame("Dencker is better thaN EVERYTHING!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);
		frame.add(in);
		frame.addKeyListener(in);
		frame.getContentPane().setBackground(Color.black);
	}

	@Override
	public void run() {
		while (true) {
			int x = 0;
			int y = 70;
			if(enemy1.size() == 0 && enemy2.size() == 0){
				level++;
				for(int i = 0; i < 8; i++){
					x += 70;
					enemy1.add(new Enemy(x, y));
				}
				x = 0;
				y= 140;
				for(int i = 0; i < 8; i++){
					x += 70;
					enemy2.add(new Enemy(x, y));
				}
				for(Enemy e : enemy1){
					e.vx++;
				}
				for(Enemy e : enemy2){
					e.vx++;
				}
			} 
			
			for(Enemy e : enemy1){
				e.update();
			}
			for(Enemy e : enemy2){
				e.update();
			}
			
			
			if(enemy1.size() > 0 && (enemy1.get(enemy1.size() - 1).reachedEdge(enemy1.get(enemy1.size()-1).x) || enemy1.get(0).reachedEdge(enemy1.get(0).x))){
				for(int i = 0; i < enemy1.size(); i++){
					enemy1.get(i).y += 50;
					enemy1.get(i).vx = -enemy1.get(i).vx;
				} 
				for(int i = 0; i < enemy2.size(); i++){
					enemy2.get(i).y += 50;
					enemy2.get(i).vx = -enemy2.get(i).vx;
				} 
			}
			
			if(b){
				bullet.update();
				if(bullet.y <= 0) {
					bullet.y = 600;
					b = false;
				}
			}
			else{
				bullet.x = player.x + 37;
			}
			for(int i = 0; i < enemy1.size(); i++){
				if(bullet.doesHit(enemy1.get(i).x, enemy1.get(i).y)){
					enemy1.remove(enemy1.get(i));
					bullet.x = player.x + 37;
					bullet.y = 600;
					b = false;
					score += 100;
					break;
				}
			}
			for(int i = 0; i < enemy2.size(); i++){
				if(bullet.doesHit(enemy2.get(i).x, enemy2.get(i).y)){
					enemy2.remove(enemy2.get(i));
					bullet.x = player.x + 37;
					bullet.y = 600;
					b = false;
					score += 100;
					break;
				}
			}
			
			
			/*for(Enemy e : enemy){
				e.update();
			}
			if(enemy.size() > 0){  
				System.out.println(enemy.size());
			if(enemy.get(enemy.size()/2).reachedEdge(enemy.get(enemy.size()/2).x) || enemy.get(0).reachedEdge(enemy.get(0).x)){
				for(int i = 0; i < enemy.size(); i++){
					enemy.get(i).y += 50;
					enemy.get(i).vx = -enemy.get(i).vx; 
				} 
			}
		}
 
			for(int i = enemy.size()-1; i >= 0; i--){
				if(b && !bullet.doesHit(enemy.get(i).x, enemy.get(i).y)){
					bullet.update();
					if(bullet.y <= 0) {
						bullet.y = 600;
						b = false;
					}
				}
				else{
					if(bullet.doesHit(enemy.get(i).x, enemy.get(i).y)) enemy.remove(enemy.get(i));
					bullet.x =  player.x + 37;
					bullet.y = 600;
					b= false;
					score += 100;
					break;
				}
			}*/
			

			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 37){
			player.moveLeft();
		}
		if(e.getKeyCode() == 39){
			player.moveRight();
		}

		
		System.out.println(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 32){
			b = true;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
