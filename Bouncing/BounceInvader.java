import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class BounceInvader extends JComponent implements Runnable {


	
	public BounceInvader() {

		Thread t = new Thread(this);
		t.start();
	}
	
	public void paint(Graphics g) {

	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Dencker is better thaN EVERYTHING!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);
		frame.add(new BounceInvader());
		frame.getContentPane().setBackground(Color.black);
	}

	@Override
	public void run() {
		while(true) {

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
