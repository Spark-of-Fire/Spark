package priority;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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

        channel1 = new JLabel("进程一，优先数：1", SwingConstants.CENTER);
        channel2 = new JLabel("进程二，优先数：2", SwingConstants.CENTER);
        channel3 = new JLabel("进程三，优先数：3", SwingConstants.CENTER);
        channel4 = new JLabel("进程四，优先数：4", SwingConstants.CENTER);
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
        CPU.setFont(new java.awt.Font("ITALIC", Font.BOLD, 50));

        one.setBounds(PriorityThread1.x, PriorityThread1.y, 50, 50);
        two.setBounds(PriorityThread2.x, PriorityThread2.y, 50, 50);
        three.setBounds(PriorityThread3.x, PriorityThread3.y, 50, 50);
        four.setBounds(PriorityThread4.x, PriorityThread4.y, 50, 50);

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
                    PriorityThread1.flag = false;
                    PriorityThread2.flag = false;
                    PriorityThread3.flag = false;
                    PriorityThread4.flag = false;
                    start.setText("继续");
                } else {
                    PriorityThread1.flag = true;
                    PriorityThread2.flag = true;
                    PriorityThread3.flag = true;
                    PriorityThread4.flag = true;
                    start.setText("暂停");
                }
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PriorityThread1.x = 100;
                PriorityThread1.y = 50;
                PriorityThread2.x = 100;
                PriorityThread2.y = 150;
                PriorityThread3.x = 100;
                PriorityThread3.y = 250;
                PriorityThread4.x = 100;
                PriorityThread4.y = 350;

                one.setLocation(PriorityThread1.x, PriorityThread1.y);
                two.setLocation(PriorityThread2.x, PriorityThread2.y);
                three.setLocation(PriorityThread3.x, PriorityThread3.y);
                four.setLocation(PriorityThread4.x, PriorityThread4.y);

                PriorityThread1.arrive = false;
                PriorityThread2.arrive = false;
                PriorityThread3.arrive = false;
                PriorityThread4.arrive = false;

                PriorityThread1.flag = false;
                PriorityThread2.flag = false;
                PriorityThread3.flag = false;
                PriorityThread4.flag = false;

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
