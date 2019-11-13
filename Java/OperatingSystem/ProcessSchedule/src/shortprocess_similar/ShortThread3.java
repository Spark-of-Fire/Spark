package shortprocess_similar;

import javax.swing.*;

public class ShortThread3 extends Thread {

    public static boolean arrive = false;
    public static int time = 100;
    public static boolean enter = false;

    protected static boolean flag = false;
    public JLabel label;
    public static int x = 100;
    public static int y = 250;

    public ShortThread3(JLabel three) {
        this.label = three;
    }

    @Override
    public void run() {
        if (x >= 100 && x < 500) {
            x += 4;
            label.setLocation(x, y);
            try {
                Thread.currentThread();
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            if (x == 500) {
                x = 545;
                y = 201;
                time = 3;
                arrive = true;
            }
            if ((!ShortThread1.enter && !ShortThread2.enter && !ShortThread4.enter) || enter) {
                if (enter) {
                    CPU();
                } else {
                    if ((ShortThread1.arrive && time < ShortThread1.time) || !ShortThread1.arrive) {
                        if ((ShortThread2.arrive && time < ShortThread2.time)
                                || !ShortThread2.arrive) {
                            if ((ShortThread4.arrive && time < ShortThread4.time)
                                    || !ShortThread4.arrive) {
                                CPU();
                            }
                        }
                    }
                }
            }
        }
    }

    public void CPU() {
        enter = true;
        if (x >= 545 && x <= 900) {
            x += 2;
            label.setLocation(x, y);
            try {
                Thread.currentThread();
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            arrive = false;
            enter = false;
            time = 100;
        }
    }
}
