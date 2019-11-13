package process;

import java.awt.Container;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public int width = 950;
    public int height = 550;
    public MainPanel mainpanel = new MainPanel();
    public Container container;

    public MainFrame() {
        setTitle("模拟进程并发性");
        setSize(width, height);
        setLocation(300, 200);
        container = getContentPane();
        container.add(mainpanel);
    }

}
