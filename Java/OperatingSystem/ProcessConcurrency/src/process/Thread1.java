package process;

import javax.swing.JLabel;

public class Thread1 extends Thread {

    protected static boolean flag = false;
    JLabel tiger;
    public static int x = 67;
    public static int y = 50;

    public Thread1(JLabel tiger) {
        this.tiger = tiger;
    }

    @Override
    public void run() {
        if (x >= 67 && x < 729) {
            x += 2;
            tiger.setLocation(x, y);
            try {
                Thread.currentThread();
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            x = 67;
            tiger.setLocation(x, y);
        }
    }
}