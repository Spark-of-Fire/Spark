package producer_customer;

import javax.swing.JLabel;

public class ProducerThread extends Thread {
	protected static boolean flag = false;
	public JLabel producer;
	public static int x = 90;
	public static int y = 50;

	public ProducerThread(JLabel producer) {
		this.producer = producer;
	}

	@Override
	public void run() {
		if (x >= 90 && x <= 345) {
			x++;
			producer.setLocation(x, y);
			try {
				Thread.currentThread();
				Thread.sleep(8);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			x = 90;
			producer.setLocation(x, y);
			Process.sign++;
			switch (Process.sign) {
			case 1:
				MainPanel.goods1.setBounds(290, 225, 64, 64);
				MainPanel.goods2.setBounds(1000, 1000, 64, 64);
				MainPanel.goods3.setBounds(1000, 1000, 64, 64);
				MainPanel.goods4.setBounds(1000, 1000, 64, 64);
				MainPanel.goods5.setBounds(1000, 1000, 64, 64);
				MainPanel.goods6.setBounds(1000, 1000, 64, 64);
				break;
			case 2:
				MainPanel.goods1.setBounds(290, 225, 64, 64);
				MainPanel.goods2.setBounds(340, 225, 64, 64);
				MainPanel.goods3.setBounds(1000, 1000, 64, 64);
				MainPanel.goods4.setBounds(1000, 1000, 64, 64);
				MainPanel.goods5.setBounds(1000, 1000, 64, 64);
				MainPanel.goods6.setBounds(1000, 1000, 64, 64);
				break;
			case 3:
				MainPanel.goods1.setBounds(290, 225, 64, 64);
				MainPanel.goods2.setBounds(340, 225, 64, 64);
				MainPanel.goods3.setBounds(390, 225, 64, 64);
				MainPanel.goods4.setBounds(1000, 1000, 64, 64);
				MainPanel.goods5.setBounds(1000, 1000, 64, 64);
				MainPanel.goods6.setBounds(1000, 1000, 64, 64);
				break;
			case 4:
				MainPanel.goods1.setBounds(290, 225, 64, 64);
				MainPanel.goods2.setBounds(340, 225, 64, 64);
				MainPanel.goods3.setBounds(390, 225, 64, 64);
				MainPanel.goods4.setBounds(440, 225, 64, 64);
				MainPanel.goods5.setBounds(1000, 1000, 64, 64);
				MainPanel.goods6.setBounds(1000, 1000, 64, 64);
				break;
			case 5:
				MainPanel.goods1.setBounds(290, 225, 64, 64);
				MainPanel.goods2.setBounds(340, 225, 64, 64);
				MainPanel.goods3.setBounds(390, 225, 64, 64);
				MainPanel.goods4.setBounds(440, 225, 64, 64);
				MainPanel.goods5.setBounds(490, 225, 64, 64);
				MainPanel.goods6.setBounds(1000, 1000, 64, 64);
				break;
			case 6:
				MainPanel.goods1.setBounds(290, 225, 64, 64);
				MainPanel.goods2.setBounds(340, 225, 64, 64);
				MainPanel.goods3.setBounds(390, 225, 64, 64);
				MainPanel.goods4.setBounds(440, 225, 64, 64);
				MainPanel.goods5.setBounds(490, 225, 64, 64);
				MainPanel.goods6.setBounds(540, 225, 64, 64);
				break;
			default:
				break;
			}
		}
	}
}