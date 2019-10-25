package fcfs;

import javax.swing.JFrame;

public class Process {

	public static int sign = 0;

	@SuppressWarnings({ "deprecation", "static-access" })
	public static void main(String[] args) {

		MainFrame mainframe = new MainFrame();
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.show();

		Thread1 thread1 = new Thread1(MainPanel.one);
		Thread2 thread2 = new Thread2(MainPanel.two);
		Thread3 thread3 = new Thread3(MainPanel.three);
		Thread4 thread4 = new Thread4(MainPanel.four);

		while (true) {
			if (Thread1.flag) {
				thread1.run();
			} else {
				thread1.yield();
			}
			if (Thread2.flag) {
				thread2.run();
			} else {
				thread2.yield();
			}
			if (Thread3.flag) {
				thread3.run();
			} else {
				thread3.yield();
			}
			if (Thread4.flag) {
				thread4.run();
			} else {
				thread4.yield();
			}
		}
	}
}
