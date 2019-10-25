package priority;

import javax.swing.JLabel;

public class PriorityThread3 extends Thread {

	public static boolean arrive = false;
	public static int priority = 100;
	public static boolean enter = false;

	protected static boolean flag = false;
	public JLabel label;
	public static int x = 100;
	public static int y = 250;

	public PriorityThread3(JLabel three) {
		this.label = three;
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
				x = 545;
				y = 201;
				priority = 3;
				arrive = true;
			}
			if ((!PriorityThread1.enter && !PriorityThread2.enter && !PriorityThread4.enter) || enter) {
				if (enter) {
					CPU();
				} else {
					if ((PriorityThread1.arrive && priority < PriorityThread1.priority) || !PriorityThread1.arrive) {
						if ((PriorityThread2.arrive && priority < PriorityThread2.priority)
								|| !PriorityThread2.arrive) {
							if ((PriorityThread4.arrive && priority < PriorityThread4.priority)
									|| !PriorityThread4.arrive) {
								CPU();
							}
						}
					}
				}
			}
		}
	}

	public void CPU() {
		enter = true;
		if (x >= 545 && x <= 900) {
			x += 2;
			label.setLocation(x, y);
			try {
				Thread.currentThread();
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			arrive = false;
			enter = false;
			priority = 100;
		}
	}
}
