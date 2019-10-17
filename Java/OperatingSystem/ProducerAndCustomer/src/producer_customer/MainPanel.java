package producer_customer;

import java.awt.Color;
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

	public JButton boot;
	public JButton produce;
	public JButton consume;
	public JButton exit;

	public static JLabel produce_goods;
	public static JLabel consume_goods;
	public static JLabel goods1, goods2, goods3, goods4, goods5, goods6;
	public JLabel produceprocess;
	public JLabel consumeprocess;
	public JLabel storage;

	public MainPanel() {
		setLayout(null);
		setSize(1000, 600);

		boot = new JButton("启动");
		produce = new JButton("准备中……");
		consume = new JButton("准备中……");
		exit = new JButton("退出");

		boot.setBounds(800, 50, 70, 40);
		produce.setBounds(205, 120, 90, 40);
		consume.setBounds(705, 470, 90, 40);
		exit.setBounds(800, 120, 70, 40);

		produce_goods = new JLabel(new ImageIcon("src/images/gift_red.png"));
		consume_goods = new JLabel(new ImageIcon("src/images/gift_red.png"));
		goods1 = new JLabel(new ImageIcon("src/images/gift_red.png"));
		goods2 = new JLabel(new ImageIcon("src/images/gift_red.png"));
		goods3 = new JLabel(new ImageIcon("src/images/gift_red.png"));
		goods4 = new JLabel(new ImageIcon("src/images/gift_red.png"));
		goods5 = new JLabel(new ImageIcon("src/images/gift_red.png"));
		goods6 = new JLabel(new ImageIcon("src/images/gift_red.png"));
		produceprocess = new JLabel("生产者进程", SwingConstants.CENTER);
		consumeprocess = new JLabel("消费者进程", SwingConstants.CENTER);
		storage = new JLabel("仓   库", SwingConstants.CENTER);

		produce_goods.setBounds(ProducerThread.x, ProducerThread.y, 64, 64);
		consume_goods.setBounds(CustomerThread.x, CustomerThread.y, 64, 64);

		produceprocess.setBounds(100, 50, 300, 50);
		produceprocess.setOpaque(true);
		produceprocess.setBackground(new Color(0, 255, 255));
		consumeprocess.setBounds(600, 400, 300, 50);
		consumeprocess.setOpaque(true);
		consumeprocess.setBackground(new Color(0, 255, 255));
		storage.setBounds(300, 225, 300, 50);
		storage.setOpaque(true);
		storage.setBackground(new Color(0, 255, 0));

		add(boot);
		add(produce);
		add(consume);
		add(exit);
		add(produce_goods);
		add(consume_goods);
		add(goods1);
		add(goods2);
		add(goods3);
		add(goods4);
		add(goods5);
		add(goods6);
		add(produceprocess);
		add(consumeprocess);
		add(storage);

		// 启动整个进程
		boot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (boot.getText() == "暂停") {
					ProducerThread.flag = false;
					CustomerThread.flag = false;
					boot.setText("启动");
					produce.setText("准备中……");
					consume.setText("准备中……");

				} else {
					if (!ProducerThread.flag) {
						produce.setText("停止生产");
					}
					if (!CustomerThread.flag) {
						consume.setText("停止消费");
					}
					ProducerThread.flag = true;
					CustomerThread.flag = true;
					boot.setText("暂停");
				}
			}
		});

		// 生产进程
		produce.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!ProducerThread.flag) {
					ProducerThread.flag = true;
					produce.setText("停止生产");
				} else {
					ProducerThread.flag = false;
					produce.setText("开始生产");
				}
			}
		});

		// 消费进程
		consume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!CustomerThread.flag) {
					CustomerThread.flag = true;
					consume.setText("停止消费");
				} else {
					CustomerThread.flag = false;
					consume.setText("开始消费");
				}
			}
		});

		// 退出
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}