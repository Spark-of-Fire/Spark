package process;

import java.util.Random;
import javax.swing.*;

public class Process {

	public static Thread1 thread1;
	public static Thread2 thread2;
	public static Thread3 thread3;

	@SuppressWarnings({ "deprecation", "unused", "static-access" })
	public static void main(String[] args) {

		ThreadFrame thFrame = new ThreadFrame();
		thFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thFrame.show();

		thread1 = new Thread1(ThreadPanel.progressBar1);
		thread2 = new Thread2(ThreadPanel.progressBar2);
		thread3 = new Thread3(ThreadPanel.progressBar3);
		// Thread1.flag=false;
		// Thread2.flag=false;
		// Thread3.flag=false;

		int i = 0, j = 0;
		int[] array = new int[500];
		Random random = new Random(System.currentTimeMillis());
		for (i = 0; i < 500; i++) {
			j = (int) (Math.random() * 10 % 3);
			array[i] = j;
			// System.out.println("array[" + i + "]:" + j);
		}
		while (true) {
			for (i = 0; i < 500; i++) {

				System.out.println("array[" + i + "]:" + array[i]);

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