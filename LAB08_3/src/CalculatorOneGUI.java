import java.awt.*;
import javax.swing.*;
public class CalculatorOneGUI {
    private JFrame frame;
    private JTextField tIn1,tIn2,out;
    private JButton plusB,minusB,timesB,dividB;
    private JPanel pan;
    public CalculatorOneGUI(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,200);
        pan = new JPanel();
        tIn1 = new JTextField(15);
        tIn2 = new JTextField(15);
        tIn1.setEditable(true);
        frame.setLayout(new GridLayout(4,1));
        frame.getContentPane().add(tIn1);
        frame.getContentPane().add(tIn2);
        pan.setLayout(new FlowLayout());
        plusB = new JButton("Plus");
        minusB = new JButton("Minus");
        timesB = new JButton("Times");
        dividB = new JButton("Divide");
        pan.add(plusB);
        pan.add(minusB);
        pan.add(timesB);
        pan.add(dividB);
        frame.getContentPane().add(pan);
        out = new JTextField(15);
        out.setEditable(false);
        frame.getContentPane().add(out);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new CalculatorOneGUI();
    }
}
