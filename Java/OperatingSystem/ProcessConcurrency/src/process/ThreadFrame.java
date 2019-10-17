package process;

import java.awt.Container;
import javax.swing.JFrame;

public class ThreadFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int WIDTH = 800;
	public int HEIGHT = 500;
	public ThreadPanel threadPanel = new ThreadPanel();
	public Container container;

	public ThreadFrame() {
		setTitle("模拟进程并发");
		setSize(WIDTH, HEIGHT);
		setLocation(250, 150);
		container = getContentPane();
		container.add(threadPanel);
	}
}
