package newprocess;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SmileFace extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int[] x = { 80, 80, 80 };
	public int[] y = { 50, 180, 310 };
	public int sign;

	public SmileFace() {

	}

	public void paint(Graphics pen) {
		super.paint(pen);
		if (this.sign == 0) {
			pen.setColor(new Color(0, 255, 255));
		} else if (this.sign == 1) {
			pen.setColor(new Color(255, 0, 255));
		} else if (this.sign == 2) {
			pen.setColor(new Color(255, 255, 0));
		}
		pen.fillOval(x[this.sign], y[this.sign], 50, 50);
		pen.setColor(Color.black);
		pen.fillOval(x[this.sign] + 15, y[this.sign] + 15, 3, 5);
		pen.fillOval(x[this.sign] + 35, y[this.sign] + 15, 3, 5);
		pen.drawArc(x[this.sign] + 13, y[this.sign] + 27, 25, 12, 180, 180);

	}
}
