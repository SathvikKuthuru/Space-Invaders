import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Invader extends JComponent implements Runnable {

	ArrayList<Enemy> enemy = new ArrayList<Enemy>();
	
	public Invader() {
		
		int x = 70, y = 50;
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 10; j++){
				enemy.add(new Enemy(j*x, i*y));
			}	
			System.out.println("Y: " + enemy.get(i).y + "X: " + enemy.get(i).x);
		}

		Thread t = new Thread(this);
		t.start();
	}

	public void paint(Graphics g) {
		for(Enemy e : enemy){
			e.paint(g, this);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Dencker is better thaN EVERYTHING!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);
		frame.add(new Invader());
		frame.getContentPane().setBackground(Color.black);
	}

	@Override
	public void run() {
		while (true) {

			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
