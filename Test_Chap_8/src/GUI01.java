import javax.swing.*;
public class GUI01 {
    public static void main(String[] args) {
        JFrame f = new JFrame("title");
        JPanel p = new JPanel();
        JButton b = new JButton("Prees me");
        f.setSize(200,200);
        p.add(b);
        f.add(p);
        f.setVisible(true);
    }
}
