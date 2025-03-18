import javax.swing.*;
import java.awt.*;

public class Login {
    JFrame frame;
    JPanel panel,panel2;
    JLabel usernameL,passwordL;
    JTextField usernameT,passwordT;
    JButton btn;
    public Login(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setSize(400,300);
        frame.getContentPane().add(Box.createVerticalStrut(50));
        
        panel = new JPanel();
        panel.setSize(650,75);
        
        usernameL = new JLabel("Username");
        panel.add(usernameL);
        panel.add(Box.createHorizontalStrut(100));
        usernameT = new JTextField("",20);
        panel.add(usernameT);
        
        panel2 = new JPanel();
        panel.setSize(650,75);
        
        passwordL = new JLabel("Password");
        panel2.add(passwordL);
        panel2.add(Box.createHorizontalStrut(100));
        
        passwordT = new JTextField("",20);
        panel2.add(passwordT);
        
        frame.getContentPane().add(panel);
        frame.getContentPane().add(panel2);
        frame.getContentPane().add(Box.createVerticalStrut(20));
        
        JPanel btnp = new JPanel();
        btnp.setSize(650,30);
        btn = new JButton("Login");
        btn.setSize(new Dimension(300,20));
        btn.addActionListener(e -> login());
        btnp.add(btn);
        frame.getContentPane().add(btnp);
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }
    private void login(){
        if(usernameT.getText().equals("jisoo") & passwordT.getText().equals("flower_me")){
            frame.getContentPane().removeAll();
            frame.revalidate();
            frame.repaint();
            new Dashboard(frame);
        }
    }
}
