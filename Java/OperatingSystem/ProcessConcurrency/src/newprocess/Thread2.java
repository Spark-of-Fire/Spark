package newprocess;

import javax.swing.JLabel;

public class Thread2 extends Thread {

	protected static boolean flag = false;
	JLabel panda;
	public static int x = 67;
	public static int y = 180;

	public Thread2(JLabel panda) {
		this.panda = panda;
	}

	@Override
	public void run() {
		if (x >= 67 && x < 729) {
			x += 2;
			panda.setLocation(x, y);
			try {
				Thread.currentThread();
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			x = 67;
			panda.setLocation(x, y);
		}
	}
}
