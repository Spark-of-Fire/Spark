package newprocess;

import javax.swing.JLabel;

public class Thread3 extends Thread {

	protected static boolean flag = false;
	JLabel elephant;
	public static int x = 67;
	public static int y = 310;

	public Thread3(JLabel elephant) {
		this.elephant = elephant;
	}

	@Override
	public void run() {
		if (x >= 67 && x < 729) {
			x += 2;
			elephant.setLocation(x, y);
			try {
				Thread.currentThread();
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			x = 67;
			elephant.setLocation(x, y);
		}
	}
}
