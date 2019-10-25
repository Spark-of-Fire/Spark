package process;

import javax.swing.JProgressBar;

public class Thread1 extends Thread {
	public static boolean flag = true;
	JProgressBar progressBar;
	private static int i = 0;

	public Thread1(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	@Override
	public void run() {
		progressBar.setStringPainted(true);
		if (i < 100) {
			i += 1;
			progressBar.setValue(i);
			progressBar.setString(String.valueOf(i) + "%");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		} else {
			i = 0;
		}
	}
}