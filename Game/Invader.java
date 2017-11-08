import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Invader extends JComponent implements Runnable, KeyListener {

	ArrayList<Enemy> enemy = new ArrayList<Enemy>();
	Player player = new Player();
	Bullet bullet = new Bullet();
	
	public Invader() {
		
		int x = 70, y = 70;
		
		for(int i = 1; i < 3; i++){
			for(int j = 2; j < 8; j++){
				enemy.add(new Enemy(j*x, i*y));
			}	
			
		}
		

		Thread t = new Thread(this);
		t.start();
	}

	public void paint(Graphics g) {
		for(Enemy e : enemy){
			e.paint(g, this);
		}
		
		bullet.paint(g, this);
		player.paint(g, this);

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
			for(Enemy e : enemy){
				e.update();
			}
			if(enemy.get(5).reachedEdge(enemy.get(5).x) || enemy.get(0).reachedEdge(enemy.get(0).x)){
				for(int i = 0; i < 6; i++){
					enemy.get(i).y += 50;
					enemy.get(i).vx = -enemy.get(i).vx; 
				}
			}
			if(enemy.get(11).reachedEdge(enemy.get(11).x) || enemy.get(6).reachedEdge(enemy.get(6).x)){
				for(int i = 6; i < 12; i++){
					enemy.get(i).y += 50;
					enemy.get(i).vx = -enemy.get(i).vx; 
				}
			}
			
			bullet.x = player.x;
			
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
		if(e.getKeyCode() == 32){
			bullet.update();
		}
		
		System.out.println(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
