package fcfs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JButton start;
	public JButton reset;
	public JButton exit;
	public static JLabel one;
	public static JLabel two;
	public static JLabel three;
	public static JLabel four;
	public JLabel channel1;
	public JLabel channel2;
	public JLabel channel3;
	public JLabel channel4;
	public JLabel wait_channel;
	public JLabel main_channel;
	public JLabel CPU;

	// public int width = 350;
	// public int height = 350;
	// public ImageIcon cpu;

	public MainPanel() {
		setLayout(null);
		setSize(1000, 600);

		start = new JButton("开始");
		reset = new JButton("复位");
		exit = new JButton("退出");

		one = new JLabel(new ImageIcon("src/images/1.png"));
		two = new JLabel(new ImageIcon("src/images/2.png"));
		three = new JLabel(new ImageIcon("src/images/3.png"));
		four = new JLabel(new ImageIcon("src/images/4.png"));

		// 下面这句意思是：
		// 得到此图标的 Image（image.getImage()）
		// 在此基础上创建它的缩放版本：
		// 缩放版本的宽度，高度与JLble一致（getScaledInstance(width,height,Image.SCALE_DEFAULT)）
		// 最后该图像就设置为得到的缩放版本（image.setImage）
		// cpu = new ImageIcon("src/images/CPU.png");
		// cpu.setImage(cpu.getImage().getScaledInstance(width, height,
		// Image.SCALE_DEFAULT));
		// Image image = cpu.getImage();
		// image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		// cpu.setImage(image);

		channel1 = new JLabel("进程一", SwingConstants.CENTER);
		channel2 = new JLabel("进程二", SwingConstants.CENTER);
		channel3 = new JLabel("进程三", SwingConstants.CENTER);
		channel4 = new JLabel("进程四", SwingConstants.CENTER);
		wait_channel = new JLabel("等待中…", SwingConstants.CENTER);
		main_channel = new JLabel();
		CPU = new JLabel("CPU", SwingConstants.CENTER);

		channel1.setBounds(100, 50, 400, 50);
		channel1.setOpaque(true);
		channel1.setBackground(new Color(186, 85, 211));
		channel2.setBounds(100, 150, 400, 50);
		channel2.setOpaque(true);
		channel2.setBackground(new Color(255, 255, 0));
		channel3.setBounds(100, 250, 400, 50);
		channel3.setOpaque(true);
		channel3.setBackground(new Color(0, 191, 255));
		channel4.setBounds(100, 350, 400, 50);
		channel4.setOpaque(true);
		channel4.setBackground(new Color(255, 48, 48));
		wait_channel.setBounds(500, 30, 50, 390);
		wait_channel.setOpaque(true);
		wait_channel.setBackground(new Color(255, 228, 181));
		main_channel.setBounds(550, 30, 300, 390);
		main_channel.setOpaque(true);
		main_channel.setBackground(new Color(72, 209, 204));
		CPU.setBounds(640, 160, 120, 120);
		CPU.setOpaque(true);
		CPU.setBackground(new Color(205, 183, 158));
		CPU.setFont(new java.awt.Font("ITALIC", Font.BOLD, 50));

		one.setBounds(FCFSThread1.x, FCFSThread1.y, 50, 50);
		two.setBounds(FCFSThread2.x, FCFSThread2.y, 50, 50);
		three.setBounds(FCFSThread3.x, FCFSThread3.y, 50, 50);
		four.setBounds(FCFSThread4.x, FCFSThread4.y, 50, 50);
		// CPU.setBounds(550, 50, width, height);

		start.setBounds(345, 450, 70, 40);
		reset.setBounds(105, 450, 70, 40);
		exit.setBounds(585, 450, 70, 40);

		add(start);
		add(reset);
		add(exit);
		add(one);
		add(two);
		add(three);
		add(four);
		add(CPU);
		add(channel1);
		add(channel2);
		add(channel3);
		add(channel4);
		add(wait_channel);
		add(CPU);
		add(main_channel);

		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (start.getText() == "暂停") {
					FCFSThread1.flag = false;
					FCFSThread2.flag = false;
					FCFSThread3.flag = false;
					FCFSThread4.flag = false;
					start.setText("继续");
				} else {
					FCFSThread1.flag = true;
					FCFSThread2.flag = true;
					FCFSThread3.flag = true;
					FCFSThread4.flag = true;
					start.setText("暂停");
				}
			}
		});

		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FCFSThread1.x = 100;
				FCFSThread2.x = 100;
				FCFSThread3.x = 100;
				FCFSThread4.x = 100;
				one.setLocation(FCFSThread1.x, FCFSThread1.y);
				two.setLocation(FCFSThread2.x, FCFSThread2.y);
				three.setLocation(FCFSThread3.x, FCFSThread3.y);
				four.setLocation(FCFSThread4.x, FCFSThread4.y);
				
				FCFSProcess.sign=0;
				FCFSThread1.sign=-1;
				FCFSThread2.sign=-1;
				FCFSThread3.sign=-1;
				FCFSThread4.sign=-1;
				
				FCFSThread1.flag=false;
				FCFSThread2.flag=false;
				FCFSThread3.flag=false;
				FCFSThread4.flag=false;
				
				start.setText("开始");
			}
		});

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
