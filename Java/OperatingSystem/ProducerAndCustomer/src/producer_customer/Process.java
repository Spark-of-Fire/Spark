package producer_customer;

import javax.swing.JFrame;

public class Process {

    public static int sign=0;

    @SuppressWarnings({ "deprecation", "static-access" })

    public static void main(String[] args) {

        MainFrame mainframe = new MainFrame();
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.show();

        ProducerThread producerthread = new ProducerThread(MainPanel.produce_goods);
        CustomerThread customerthread = new CustomerThread(MainPanel.consume_goods);

        while (true) {
            if (ProducerThread.flag) {
                if (sign < 6) {
                    producerthread.run();
                } else {
                    producerthread.yield();
                }
            } else {
                producerthread.yield();
            }

            if (CustomerThread.flag) {
                if (sign > 0) {
                    customerthread.run();
                } else {
                    customerthread.yield();
                }
            } else {
                customerthread.yield();
            }
        }
    }
}
