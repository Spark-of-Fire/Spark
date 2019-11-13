package timeslice_fail;

import javax.swing.*;

public class TimeProcess {

    public static int sign = 0;

    public static void main(String[] args) {

        MainFrame mainframe = new MainFrame();
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.show();

        TimeThread1 thread1 = new TimeThread1(MainPanel.one);
        TimeThread2 thread2 = new TimeThread2(MainPanel.two);
        TimeThread3 thread3 = new TimeThread3(MainPanel.three);
        TimeThread4 thread4 = new TimeThread4(MainPanel.four);

        /*
        int i, num;
        int[] array = new int[1000];
        Random random = new Random(System.currentTimeMillis());
        for (i = 0; i < 1000; i++) {
            num = (int) (Math.random() * 100 % 4);
            array[i] = num;
        }
        while (true) {
            for (i = 0; i < 1000; i++) {
                switch (array[i]) {
                    case 0:
                        if (TimeThread1.flag == true) {
                            thread1.run();
                        } else {
                            thread1.yield();
                        }
                        break;
                    case 1:
                        if (TimeThread2.flag == true) {
                            thread2.run();
                        } else {
                            thread2.yield();
                        }
                        break;
                    case 2:
                        if (TimeThread3.flag == true) {
                            thread3.run();
                        } else {
                            thread3.yield();
                        }
                        break;
                    case 3:
                        if (TimeThread4.flag == true) {
                            thread4.run();
                        } else {
                            thread4.yield();
                        }
                        break;
                }
            }
        }
        */
        while (true) {
            if (TimeThread1.flag) {
                thread1.run();
            }
            else {
                thread1.yield();
            }
            if (TimeThread2.flag) {
                thread2.run();
            } else {
                thread2.yield();
            }
            if (TimeThread3.flag) {
                thread3.run();
            } else {
                thread3.yield();
            }
            if (TimeThread4.flag) {
                thread4.run();
            } else {
                thread4.yield();
            }
        }
    }
}