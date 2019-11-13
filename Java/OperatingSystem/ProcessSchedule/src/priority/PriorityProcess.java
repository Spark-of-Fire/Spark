package priority;

import javax.swing.JFrame;
import java.util.Random;

public class PriorityProcess {

    @SuppressWarnings({ "deprecation", "static-access" })
    public static void main(String[] args) {

        MainFrame mainframe = new MainFrame();
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.show();

        PriorityThread1 thread1 = new PriorityThread1(MainPanel.one);
        PriorityThread2 thread2 = new PriorityThread2(MainPanel.two);
        PriorityThread3 thread3 = new PriorityThread3(MainPanel.three);
        PriorityThread4 thread4 = new PriorityThread4(MainPanel.four);

        while (true) {
            if (PriorityThread1.flag) {
                thread1.run();
            }
            else {
                thread1.yield();
            }
            if (PriorityThread2.flag) {
                thread2.run();
            } else {
                thread2.yield();
            }
            if (PriorityThread3.flag) {
                thread3.run();
            } else {
                thread3.yield();
            }
            if (PriorityThread4.flag) {
                thread4.run();
            } else {
                thread4.yield();
            }
        }
    }
}