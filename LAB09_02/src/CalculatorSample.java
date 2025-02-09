import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CalculatorSample implements ActionListener {
    private double summary = 0;
    private boolean checker = true;
    private char kept;
    private JFrame frame;
    private JPanel pan;
    private JTextField output;
    private JButton one,two,three,four,five,six,seven,eight,nine,zero,pl,mi,ti,di,eq,cc;
    public CalculatorSample(){
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
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);
        
        pl = new JButton("+");
        mi = new JButton("-");
        ti = new JButton("x");
        di = new JButton("/");
        pl.addActionListener(this);
        mi.addActionListener(this);
        ti.addActionListener(this);
        di.addActionListener(this);
        
        eq = new JButton("=");
        cc = new JButton("c");
        eq.addActionListener(this);
        cc.addActionListener(this);
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
        new CalculatorSample();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(pl)){
            if (checker){
                summary = Double.parseDouble(output.getText());
                checker = false;
            }else{
                summary += Double.parseDouble(output.getText());
            }
            output.setText("");
            kept = '+';
        }else if(e.getSource().equals(mi)){
            if (checker){
                if (String.valueOf(output.getText()).equals("")){
                    output.setText(output.getText() + ("-"));
                    kept = '-';
                    return;
                }else{
                    summary = Double.parseDouble(output.getText());
                }
                checker = false;
            }else{
                summary -= Double.parseDouble(output.getText());
            }
            output.setText("");
            kept = '-';
        }else if(e.getSource().equals(ti)){
            if (checker){
                summary = Double.parseDouble(output.getText());   
                checker = false;
            }else{
                summary *= Double.parseDouble(output.getText());
            }
            output.setText("");
            kept = '*';
        }else if(e.getSource().equals(di)){
            if (checker){
                summary = Double.parseDouble(output.getText());                
                checker = false;
            }else{
                summary /= Double.parseDouble(output.getText());
            }
            output.setText("");
            kept = '/';
        }else if(e.getSource().equals(eq)){
            if (kept == '+'){
                summary += Double.parseDouble(output.getText());
            }else if (kept == '-'){
                summary -= Double.parseDouble(output.getText());
            }else if (kept == '*'){
                summary *= Double.parseDouble(output.getText());
            }else if (kept == '/'){
                summary /= Double.parseDouble(output.getText());
            }
            output.setText(""+summary);
            kept = ' ';
            checker = true;
        }else if(e.getSource().equals(cc)){
            output.setText("");
            summary = 0;
            checker = true;
        }else{
            output.setText(output.getText() + ((JButton)e.getSource()).getText());
        }
//        System.out.println(summary);
    }
}
