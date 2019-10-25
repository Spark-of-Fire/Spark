package fcfs;

import javax.swing.JLabel;

public class FCFSThread2 extends Thread {

	public static int sign = -1;

	protected static boolean flag = false;
	public JLabel label;
	public static int x = 100;
	public static int y = 150;

	public FCFSThread2(JLabel two) {
		this.label = two;
	}

	@Override
	public void run() {
		if (x >= 100 && x < 500) {
			x += 4;
			label.setLocation(x, y);
			try {
				Thread.currentThread();
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			if (x == 500) {
				x++;
				sign = FCFSProcess.sign;
				FCFSProcess.sign++;
			}
			if (sign == 0) {
				CPU();
			}
		}
	}

	public void CPU() {
		if (x > 500 && x <= 850) {
			x += 2;
			label.setLocation(x, y);
			try {
				Thread.currentThread();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			sign = -1;
			FCFSProcess.sign--;
			FCFSThread1.sign--;
			FCFSThread3.sign--;
			FCFSThread4.sign--;
		}
	}
}
