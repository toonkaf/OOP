
import javax.swing.*;

public class MyFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyClock clock = new MyClock();
        Thread t = new Thread(clock);
        t.start();
        frame.getContentPane().add(clock);
        frame.setSize(300,100);
        frame.setVisible(true);
    }
}
