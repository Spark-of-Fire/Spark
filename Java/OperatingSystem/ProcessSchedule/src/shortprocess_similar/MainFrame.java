package shortprocess_similar;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public int WIDTH = 1000;
    public int HEIGHT = 600;
    public MainPanel mainpanel = new MainPanel();
    public Container container;

    public MainFrame() {
        setTitle("短进程优先进程调度模拟");
        setSize(WIDTH, HEIGHT);
        setLocation(200,120);
        container = getContentPane();
        container.add(mainpanel);
    }
}
