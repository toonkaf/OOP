import javax.swing.*;
import java.awt.*;

public class BookAdd {
    private JFrame frame;
    private JPanel panel[];
    private JLabel label[];
    private JTextField bk[];
    private JComboBox com;
    private JButton ins;
    private final String labelName[] = {"Name","Price","Type"};
    private final String type[] = {"General","Computer","Math&Sci","Photo"};
    public BookAdd(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300,200);
        frame.setLayout(new GridLayout(4,1));
        panel = new JPanel[4];
        label = new JLabel[3];
        bk = new JTextField[2];
        for (int i = 0; i < 3; i++){
            panel[i] = new JPanel();
            panel[i].setLayout(new GridLayout(1, 2));
            
            label[i] = new JLabel(labelName[i]);
            panel[i].add(label[i]);
            
            if (i < 2){
                bk[i] = new JTextField();
                panel[i].add(bk[i]);
            }else{
                com = new JComboBox(type);
                panel[i].add(com);
            }
            frame.add(panel[i]);
        }
        panel[3] = new JPanel();
        panel[3].setLayout(new FlowLayout(FlowLayout.CENTER));
        
        ins = new JButton("Insert");
        ins.addActionListener(e -> insertBook());
        panel[3].add(ins);
        frame.add(panel[3]);
        frame.setVisible(true);
    }
    
    public void insertBook(){
        BookViewer.book.add(new Book(bk[0].getText(),Double.parseDouble(bk[1].getText()),String.valueOf(com.getSelectedItem())));
        frame.dispose();
        JOptionPane.showMessageDialog(null, "Done it.","",JOptionPane.PLAIN_MESSAGE);
    }
}
