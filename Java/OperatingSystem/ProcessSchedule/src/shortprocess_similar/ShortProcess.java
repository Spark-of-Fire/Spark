package shortprocess_similar;

import javax.swing.*;

public class ShortProcess {

    @SuppressWarnings({ "deprecation", "static-access" })
    public static void main(String[] args) {

        MainFrame mainframe = new MainFrame();
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.show();

        ShortThread1 thread1 = new ShortThread1(MainPanel.one);
        ShortThread2 thread2 = new ShortThread2(MainPanel.two);
        ShortThread3 thread3 = new ShortThread3(MainPanel.three);
        ShortThread4 thread4 = new ShortThread4(MainPanel.four);

        while (true) {

            if (ShortThread1.flag) {
                thread1.run();
            } else {
                thread1.yield();
            }

            if (ShortThread2.flag) {
                thread2.run();
            } else {
                thread2.yield();
            }

            if (ShortThread3.flag) {
                thread3.run();
            } else {
                thread3.yield();
            }
            if (ShortThread4.flag) {
                thread4.run();
            } else {
                thread4.yield();
            }

        }
    }
}
