package process;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ThreadPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JProgressBar progressBar1;
	public static JProgressBar progressBar2;
	public static JProgressBar progressBar3;
	JButton button1;
	JButton button2;
	JButton button3;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font font = new Font("宋体", Font.BOLD + Font.ITALIC, 16);
		g.setFont(font);
		g.drawString("进程一", 20, 90);
		g.drawString("进程二", 20, 210);
		g.drawString("进程三", 20, 320);
	}

	public ThreadPanel() {
		setLayout(null);
		setSize(800, 400);
		progressBar1 = new JProgressBar();
		progressBar2 = new JProgressBar();
		progressBar3 = new JProgressBar();
		button1 = new JButton("准备");
		button2 = new JButton("准备");
		button3 = new JButton("准备");
		progressBar1.setBackground(new Color(0, 255, 255));
		progressBar1.setForeground(new Color(0, 100, 100));
		progressBar1.setBounds(100, 70, 480, 40);
		button1.setBounds(650, 70, 80, 40);
		add(progressBar1);
		add(button1);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (Thread1.flag == false) {
					Thread1.flag = true;
					button1.setText("暂停");
				} else {
					Thread1.flag = false;
					button1.setText("继续");
				}
			}

		});
		
		progressBar2.setBackground(new Color(255, 0, 255));
		progressBar2.setForeground(new Color(100, 0, 100));
		progressBar2.setBounds(100, 190, 480, 40);
		button2.setBounds(650, 190, 80, 40);
		add(progressBar2);
		add(button2);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (Thread2.flag == false) {
					Thread2.flag = true;
					button2.setText("暂停");
				} else {
					Thread2.flag = false;
					button2.setText("继续");
				}
			}

		});

		progressBar3.setBackground(new Color(255, 255, 0));
		progressBar3.setForeground(new Color(100, 100, 0));
		progressBar3.setBounds(100, 300, 480, 40);
		button3.setBounds(650, 300, 80, 40);
		add(progressBar3);
		add(button3);
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (Thread3.flag == false) {
					Thread3.flag = true;
					button3.setText("暂停");
				} else {
					Thread3.flag = false;
					button3.setText("继续");
				}
			}

		});
	}
}