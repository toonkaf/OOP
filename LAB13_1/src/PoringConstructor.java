import javax.swing.*;
public class PoringConstructor {
    JFrame frame;
    JButton btn;
    public PoringConstructor(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        btn = new JButton("Add");
        btn.addActionListener(e -> new Poring());
        frame.getContentPane().add(btn);
        frame.pack();
        frame.setVisible(true);
    }
}
