package process;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JButton button;
    JButton rebutton;
    JButton exitbutton;
    JButton button1;
    JButton button2;
    JButton button3;

    public static JLabel tiger;
    public static JLabel panda;
    public static JLabel elephant;

    public void paint(Graphics pen) {
        super.paint(pen);
        Font font = new Font("ITALI", Font.BOLD, 16);
        pen.setFont(font);

        // 画提示语
        pen.drawString("进程一：", 10, 80);
        pen.drawString("进程二：", 10, 210);
        pen.drawString("进程三：", 10, 340);

        pen.drawString("一号赛道", 400, 135);
        pen.drawString("二号赛道", 400, 265);
        pen.drawString("三号赛道", 400, 395);

        pen.drawString("起", 120, 405);
        pen.drawString("点", 120, 430);
        pen.drawString("终", 720, 405);
        pen.drawString("点", 720, 430);

        // 画赛道
		/*
		pen.setColor(Color.red);
		pen.fillRect(80, 37, 700, 15);
		pen.fillRect(80, 67, 700, 15);
		pen.fillRect(80, 97, 700, 15);
		pen.fillRect(80, 167, 700, 15);
		pen.fillRect(80, 197, 700, 15);
		pen.fillRect(80, 227, 700, 15);

		pen.fillRect(80, 297, 700, 15);
		pen.fillRect(80, 327, 700, 15);
		pen.fillRect(80, 357, 700, 15);

		pen.setColor(Color.white);
		pen.fillRect(80, 52, 700, 15);
		pen.fillRect(80, 82, 700, 15);

		pen.fillRect(80, 182, 700, 15);
		pen.fillRect(80, 212, 700, 15);

		pen.fillRect(80, 312, 700, 15);
		pen.fillRect(80, 342, 700, 15);
        */

        // 画起始线
        pen.setColor(Color.yellow);
        pen.drawLine(130, 37, 130, 372);
        //pen.drawLine(130, 37, 130, 112);
        //pen.drawLine(130, 167, 130, 242);
        //pen.drawLine(130, 297, 130, 372);

        pen.drawLine(730, 37, 730, 372);
        //pen.drawLine(730, 37, 730, 112);
        //pen.drawLine(730, 167, 730, 242);
        //pen.drawLine(730, 297, 730, 372);

        /*
         * // 画笑脸 pen.setColor(new Color(0, 255, 255)); pen.fillOval(80, 50, 50, 50);
         * pen.setColor(Color.black); pen.fillOval(95, 65, 3, 5); pen.fillOval(115, 65,
         * 3, 5); pen.drawArc(93, 77, 25, 12, 180, 180);
         *
         * pen.setColor(new Color(255, 0, 255)); pen.fillOval(80, 180, 50, 50);
         * pen.setColor(Color.black); pen.fillOval(95, 195, 3, 5); pen.fillOval(115,
         * 195, 3, 5); pen.drawArc(93, 207, 25, 12, 180, 180);
         *
         * pen.setColor(new Color(255, 255, 0)); pen.fillOval(80, 310, 50, 50);
         * pen.setColor(Color.black); pen.fillOval(95, 325, 3, 5); pen.fillOval(115,
         * 325, 3, 5); pen.drawArc(93, 337, 25, 12, 180, 180);
         */
        /*
         * //画图片 Toolkit toolkit = Toolkit.getDefaultToolkit(); Image tiger =
         * toolkit.getImage("src/images/tiger64.png"); Image panda =
         * toolkit.getImage("src/images/panda64.png"); Image elephant =
         * toolkit.getImage("src/images/elephant64.png"); pen.drawImage(tiger,
         * Thread1.x, Thread1.y, this); pen.drawImage(panda, Thread2.x, Thread2.y,
         * this); pen.drawImage(elephant, Thread3.x, Thread3.y, this);
         */
    }

    public MainPanel() {
        setLayout(null);
        setSize(950, 550);
        setBackground(new Color(120, 255, 55));

        button = new JButton("开始");
        rebutton = new JButton("复位");
        exitbutton = new JButton("退出");
        button1 = new JButton("准备");
        button2 = new JButton("准备");
        button3 = new JButton("准备");

        tiger = new JLabel(new ImageIcon("src/images/tiger64.png"));
        panda = new JLabel(new ImageIcon("src/images/panda64.png"));
        elephant = new JLabel(new ImageIcon("src/images/elephant64.png"));

        button.setFont(new java.awt.Font("ITALIC", Font.BOLD, 16));
        rebutton.setFont(new java.awt.Font("ITALIC", Font.BOLD, 16));
        exitbutton.setFont(new java.awt.Font("ITALIC", Font.BOLD, 16));
        button1.setFont(new java.awt.Font("ITALIC", Font.BOLD, 16));
        button2.setFont(new java.awt.Font("ITALIC", Font.BOLD, 16));
        button3.setFont(new java.awt.Font("ITALIC", Font.BOLD, 16));

        add(button);
        add(rebutton);
        add(exitbutton);
        add(button1);
        add(button2);
        add(button3);
        add(tiger);
        add(panda);
        add(elephant);

        button.setBounds(397, 430, 70, 40);
        rebutton.setBounds(247, 430, 70, 40);
        exitbutton.setBounds(547, 430, 70, 40);
        button1.setBounds(820, 55, 70, 40);
        button2.setBounds(820, 185, 70, 40);
        button3.setBounds(820, 315, 70, 40);
        tiger.setBounds(Thread1.x, Thread1.y, 64, 50);
        panda.setBounds(Thread2.x, Thread2.y, 64, 50);
        elephant.setBounds(Thread3.x, Thread3.y, 64, 50);

        // 进程控制总开关
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (button.getText() == "停止") {
                    Thread1.flag = false;
                    Thread2.flag = false;
                    Thread3.flag = false;
                    button.setText("开始");
                    button1.setText("准备");
                    button2.setText("准备");
                    button3.setText("准备");

                } else {
                    if (Thread1.flag == false) {
                        button1.setText("暂停");
                    }
                    if (Thread2.flag == false) {
                        button2.setText("暂停");
                    }
                    if (Thread2.flag == false) {
                        button3.setText("暂停");
                    }
                    Thread1.flag = true;
                    Thread2.flag = true;
                    Thread3.flag = true;
                    button.setText("停止");
                }
            }
        });

        // 重新开始按钮
        rebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Thread1.x = 67;
                tiger.setLocation(Thread1.x, Thread1.y);
                Thread2.x = 67;
                panda.setLocation(Thread2.x, Thread2.y);
                Thread3.x = 67;
                elephant.setLocation(Thread3.x, Thread3.y);

                Thread1.flag = false;
                Thread2.flag = false;
                Thread3.flag = false;

                button.setText("开始");
                button1.setText("准备");
                button2.setText("准备");
                button3.setText("准备");
            }
        });

        // 退出按钮
        exitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        // 进程一控制按钮
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (Thread1.flag == false) {
                    Thread1.flag = true;
                    button1.setText("暂停");
                } else {
                    Thread1.flag = false;
                    button1.setText("继续");
                }
            }
        });

        // 进程二控制按钮
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (Thread2.flag == false) {
                    Thread2.flag = true;
                    button2.setText("暂停");
                } else {
                    Thread2.flag = false;
                    button2.setText("继续");
                }
            }
        });

        // 进程三控制按钮
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (Thread3.flag == false) {
                    Thread3.flag = true;
                    button3.setText("暂停");
                } else {
                    Thread3.flag = false;
                    button3.setText("继续");
                }
            }
        });
    }
}
