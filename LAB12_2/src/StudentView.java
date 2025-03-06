import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
public class StudentView implements ActionListener{
    JFrame frame;
    JPanel panel[] = new JPanel[4];
    JLabel label[] = new JLabel[3];
    JTextField textfield[] = new JTextField[3];
    String kept[] = {"ID:","Name:","Money:"};
    String kept2[] = {"Deposit","Withdraw"};
    JButton btn[] = new JButton[2];
    public StudentView() throws ClassNotFoundException{
        frame = new JFrame("");
        frame.getContentPane().setLayout(new GridLayout(4,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);
        for(int i = 0;i < panel.length;i++){
            panel[i] = new JPanel();
            if (i < 3){
                label[i] = new JLabel();
                textfield[i] = new JTextField();
                panel[i].setLayout(new GridLayout(1,2));
                label[i].setText(kept[i]);
                if(i == 2){
                    textfield[i].setEditable(false);
                    textfield[i].setText("0");
                }
                panel[i].add(label[i]);
                panel[i].add(textfield[i]);
            }else{
                panel[i].setLayout(new FlowLayout(FlowLayout.CENTER));
                for (int j = 0; j < 2;j++){
                    btn[j] = new JButton();
                    btn[j].setText(kept2[j]);
                    btn[j].addActionListener(this);
                    panel[i].add(btn[j]);
                }
            }
            frame.getContentPane().add(panel[i]);
        }
        this.loads();
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                Student s = new Student(textfield[1].getText(),Integer.parseInt(textfield[0].getText()),Integer.parseInt(textfield[2].getText()));
                try{
                    FileOutputStream fileOut = new FileOutputStream("StudentM.dat");
                    ObjectOutputStream stdOut = new ObjectOutputStream(fileOut);
                    stdOut.writeObject(s);
                    stdOut.close();
                    fileOut.close();
                }catch (IOException i){
                    i.printStackTrace();
                }
            }
        });
        frame.setVisible(true);
    
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        new StudentView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int money = Integer.parseInt(this.textfield[2].getText());
        if(e.getSource().equals(btn[0])){
            this.textfield[2].setText(String.valueOf(money - 100));
        }else if(e.getSource().equals(btn[1])){
            this.textfield[2].setText(String.valueOf(money + 100));
        }
    }
    
    public void loads() throws ClassNotFoundException{
        File file = new File("StudentM.dat");
        Student s = null;
        if (file.exists()) {
            try {
                FileInputStream fileIn = new FileInputStream("StudentM.dat");
                ObjectInputStream stdIn = new ObjectInputStream(fileIn);
                s = (Student)stdIn.readObject();
                this.textfield[0].setText(String.valueOf(s.getID()));
                this.textfield[1].setText(String.valueOf(s.getName()));
                this.textfield[2].setText(String.valueOf(s.getMoney()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
