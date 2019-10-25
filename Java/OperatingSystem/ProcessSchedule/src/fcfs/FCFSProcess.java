package fcfs;

import javax.swing.JFrame;

public class FCFSProcess {

	public static int sign = 0;

	@SuppressWarnings({ "deprecation", "static-access" })
	public static void main(String[] args) {

		MainFrame mainframe = new MainFrame();
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.show();

		FCFSThread1 thread1 = new FCFSThread1(MainPanel.one);
		FCFSThread2 thread2 = new FCFSThread2(MainPanel.two);
		FCFSThread3 thread3 = new FCFSThread3(MainPanel.three);
		FCFSThread4 thread4 = new FCFSThread4(MainPanel.four);

		while (true) {
			if (FCFSThread1.flag) {
				thread1.run();
			} else {
				thread1.yield();
			}
			if (FCFSThread2.flag) {
				thread2.run();
			} else {
				thread2.yield();
			}
			if (FCFSThread3.flag) {
				thread3.run();
			} else {
				thread3.yield();
			}
			if (FCFSThread4.flag) {
				thread4.run();
			} else {
				thread4.yield();
			}
		}
	}
}
