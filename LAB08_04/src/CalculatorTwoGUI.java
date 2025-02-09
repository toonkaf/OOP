import java.awt.*;
import javax.swing.*;
public class CalculatorTwoGUI {
    private JFrame frame;
    private JPanel pan;
    private JTextField output;
    private JButton one,two,three,four,five,six,seven,eight,nine,zero,pl,mi,ti,di,eq,cc;
    public CalculatorTwoGUI(){
        frame = new JFrame("My Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,310);
        frame.setLayout(new BorderLayout());
        output = new JTextField(15);
        output.setEditable(false);
        frame.getContentPane().add(output,BorderLayout.NORTH);
        pan = new JPanel();
        pan.setLayout(new GridLayout(4,4));
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        zero = new JButton("0");
        pl = new JButton("+");
        mi = new JButton("-");
        ti = new JButton("x");
        di = new JButton("/");
        eq = new JButton("=");
        cc = new JButton("c");
        pan.add(seven);
        pan.add(eight);
        pan.add(nine);
        pan.add(pl);
        pan.add(four);
        pan.add(five);
        pan.add(six);
        pan.add(mi);
        pan.add(one);
        pan.add(two);
        pan.add(three);
        pan.add(ti);
        pan.add(zero);
        pan.add(cc);
        pan.add(eq);
        pan.add(di);
        frame.getContentPane().add(pan,BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new CalculatorTwoGUI();
    }
}
