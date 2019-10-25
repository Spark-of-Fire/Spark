package newprocess;

import java.awt.Container;

import javax.swing.JFrame;

public class ThreadFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int width = 950;
	public int height = 550;
	public ThreadPanel threadpanel = new ThreadPanel();
	public Container container;

	public ThreadFrame() {
		setTitle("模拟进程并发性");
		setSize(width, height);
		setLocation(300, 200);
		container = getContentPane();
		container.add(threadpanel);
	}

}
