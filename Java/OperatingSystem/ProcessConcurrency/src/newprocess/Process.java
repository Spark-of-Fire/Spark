package newprocess;

import java.util.Random;

import javax.swing.JFrame;

public class Process {

	public static Thread1 thread1;
	public static Thread2 thread2;
	public static Thread3 thread3;

	@SuppressWarnings({ "deprecation", "static-access", "unused" })
	public static void main(String[] args) {
		ThreadFrame threadframe = new ThreadFrame();
		threadframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		threadframe.show();

		thread1 = new Thread1(ThreadPanel.tiger);
		thread2 = new Thread2(ThreadPanel.panda);
		thread3 = new Thread3(ThreadPanel.elephant);

		int i, num;
		int[] array = new int[1000];
		Random random = new Random(System.currentTimeMillis());
		for (i = 0; i < 1000; i++) {
			num = (int) (Math.random() * 10 % 3);
			array[i] = num;
		}
		while (true) {
			for (i = 0; i < 1000; i++) {
				switch (array[i]) {
				case 0:
					if (Thread1.flag == true) {
						thread1.run();
					} else {
						thread1.yield();
					}
					break;
				case 1:
					if (Thread2.flag == true) {
						thread2.run();
					} else {
						thread2.yield();
					}
					break;
				case 2:
					if (Thread3.flag == true) {
						thread3.run();
					} else {
						thread3.yield();
					}
					break;
				}
			}
		}
	}
}