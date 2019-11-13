package shortprocess_similar;

import javax.swing.*;

public class ShortThread4 extends Thread {

    public static boolean arrive = false;
    public static int time = 100;
    public static boolean enter = false;

    protected static boolean flag = false;
    public JLabel label;
    public static int x = 100;
    public static int y = 350;

    public ShortThread4(JLabel four) {
        this.label = four;
    }

    @Override
    public void run() {
        if (x >= 100 && x < 500) {
            x += 5;
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
                time = 4;
                arrive = true;
            }
            if ((!ShortThread1.enter && !ShortThread2.enter && !ShortThread3.enter) || enter) {
                if (enter) {
                    CPU();
                } else {
                    if ((ShortThread1.arrive && time < ShortThread1.time) || !ShortThread1.arrive) {
                        if ((ShortThread2.arrive && time < ShortThread2.time)
                                || !ShortThread2.arrive) {
                            if ((ShortThread3.arrive && time < ShortThread3.time)
                                    || !ShortThread3.arrive) {
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
            x += 1;
            label.setLocation(x, y);
            try {
                Thread.currentThread();
                Thread.sleep(40);
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
