package shortprocess_similar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public JButton start;
    public JButton reset;
    public JButton exit;
    public static JLabel one;
    public static JLabel two;
    public static JLabel three;
    public static JLabel four;
    public JLabel channel1;
    public JLabel channel2;
    public JLabel channel3;
    public JLabel channel4;
    public JLabel wait_channel;
    public JLabel CPU;

    public MainPanel() {
        setLayout(null);
        setSize(1000, 600);

        start = new JButton("开始");
        reset = new JButton("复位");
        exit = new JButton("退出");

        one = new JLabel(new ImageIcon("src/images/1.png"));
        two = new JLabel(new ImageIcon("src/images/2.png"));
        three = new JLabel(new ImageIcon("src/images/3.png"));
        four = new JLabel(new ImageIcon("src/images/4.png"));

        channel1 = new JLabel("短进程", SwingConstants.CENTER);
        channel2 = new JLabel("较短进程", SwingConstants.CENTER);
        channel3 = new JLabel("较长进程", SwingConstants.CENTER);
        channel4 = new JLabel("长进程", SwingConstants.CENTER);
        wait_channel = new JLabel("等待中…", SwingConstants.CENTER);
        CPU = new JLabel("CPU", SwingConstants.CENTER);

        channel1.setBounds(100, 50, 400, 50);
        channel1.setOpaque(true);
        channel1.setBackground(new Color(186, 85, 211));
        channel2.setBounds(100, 150, 400, 50);
        channel2.setOpaque(true);
        channel2.setBackground(new Color(255, 255, 0));
        channel3.setBounds(100, 250, 400, 50);
        channel3.setOpaque(true);
        channel3.setBackground(new Color(0, 191, 255));
        channel4.setBounds(100, 350, 400, 50);
        channel4.setOpaque(true);
        channel4.setBackground(new Color(255, 48, 48));
        wait_channel.setBounds(500, 30, 50, 390);
        wait_channel.setOpaque(true);
        wait_channel.setBackground(new Color(255, 228, 181));
        CPU.setBounds(500, 196, 400, 60);
        CPU.setOpaque(true);
        CPU.setBackground(new Color(72, 209, 204));
        CPU.setFont(new Font("ITALIC", Font.BOLD, 50));

        one.setBounds(ShortThread1.x, ShortThread1.y, 50, 50);
        two.setBounds(ShortThread2.x, ShortThread2.y, 50, 50);
        three.setBounds(ShortThread3.x, ShortThread3.y, 50, 50);
        four.setBounds(ShortThread4.x, ShortThread4.y, 50, 50);

        start.setBounds(345, 450, 70, 40);
        reset.setBounds(105, 450, 70, 40);
        exit.setBounds(585, 450, 70, 40);

        add(start);
        add(reset);
        add(exit);
        add(one);
        add(two);
        add(three);
        add(four);
        add(channel1);
        add(channel2);
        add(channel3);
        add(channel4);
        add(wait_channel);
        add(CPU);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (start.getText() == "暂停") {
                    ShortThread1.flag = false;
                    ShortThread2.flag = false;
                    ShortThread3.flag = false;
                    ShortThread4.flag = false;
                    start.setText("继续");
                } else {
                    ShortThread1.flag = true;
                    ShortThread2.flag = true;
                    ShortThread3.flag = true;
                    ShortThread4.flag = true;
                    start.setText("暂停");
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShortThread1.x = 100;
                ShortThread1.y = 50;
                ShortThread2.x = 100;
                ShortThread2.y = 150;
                ShortThread3.x = 100;
                ShortThread3.y = 250;
                ShortThread4.x = 100;
                ShortThread4.y = 350;

                one.setLocation(ShortThread1.x, ShortThread1.y);
                two.setLocation(ShortThread2.x, ShortThread2.y);
                three.setLocation(ShortThread3.x, ShortThread3.y);
                four.setLocation(ShortThread4.x, ShortThread4.y);

                ShortThread1.arrive = false;
                ShortThread2.arrive = false;
                ShortThread3.arrive = false;
                ShortThread4.arrive = false;

                ShortThread1.flag = false;
                ShortThread2.flag = false;
                ShortThread3.flag = false;
                ShortThread4.flag = false;

                start.setText("开始");
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
