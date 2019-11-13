package timeslice_fail;

import javax.swing.JLabel;

public class TimeThread1 extends Thread {

    public static int sign = -1;

    protected static boolean flag = false;
    public JLabel label;
    public static int x = 100;
    public static int y = 50;

    public TimeThread1(JLabel one) {
        this.label = one;
    }

    @Override
    public void run() {
        if (x >= 100 && x < 500) {
            x += 4;
            label.setLocation(x, y);
            try {
                Thread.currentThread();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            if (x == 500) {
                x++;
                sign = TimeProcess.sign;
                TimeProcess.sign++;
            }
            if (sign == 0) {
                for (int i = 0; i < 10; i++) {
                    CPU();
                }
                Thread.currentThread();
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void CPU() {
        if (x > 500 && x < 850) {
            x += 2;
            label.setLocation(x, y);
            Thread.currentThread();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sign += (TimeProcess.sign - 1);
        } else {
            TimeProcess.sign--;
            sign--;
        }
        TimeThread2.sign--;
        TimeThread3.sign--;
        TimeThread4.sign--;
    }
}
