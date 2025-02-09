import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class TellerGUI implements ActionListener{
    private double balance = 6000;
    private JFrame frame;
    private JLabel bal,am;
    private JPanel pan;
    private JTextField balT,amT;
    private JButton dep,wit,ex;
    public TellerGUI(){
        frame = new JFrame("Teller GUI");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4,1));
        
        pan = new JPanel();
        pan.setLayout(new GridLayout(1,2));
        bal = new JLabel("Balance");
        balT = new JTextField(String.valueOf(balance),6);
        balT.setEnabled(false);
        pan.add(bal);
        pan.add(balT);
        frame.getContentPane().add(pan);
        
        pan = new JPanel();
        pan.setLayout(new GridLayout(1,2));
        am = new JLabel("Amount");
        amT = new JTextField(6);
        pan.add(am);
        pan.add(amT);
        frame.getContentPane().add(pan);
        
        pan = new JPanel();
        pan.setLayout(new FlowLayout());
        dep = new JButton("Deposit");
        wit = new JButton("Withdraw");
        ex = new JButton("Exit");
        ex.addActionListener(this);
        wit.addActionListener(this);
        dep.addActionListener(this);
        
        pan.add(dep);
        pan.add(wit);
        pan.add(ex);
        frame.getContentPane().add(pan);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new TellerGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(wit)){
            if (balance >= Double.parseDouble(amT.getText())){
                balance -= Double.parseDouble(amT.getText());
                balT.setText(String.valueOf(balance));
            }
        }else if (e.getSource().equals(dep)){
            balance += Double.parseDouble(amT.getText());
            balT.setText(String.valueOf(balance));
        }else{
            System.exit(0);
        }
    }
            
}
