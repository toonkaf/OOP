import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BookViewer implements ActionListener{
    private JFrame frame;
    private JPanel panel[];
    private JLabel label[];
    private JTextField bk[];
    private JComboBox com;
    private JTextField index;
    public static ArrayList<Book> book = new ArrayList<>();
    private JButton btn[];
    private JButton move[];
    private final String labelName[] = {"Name","Price","Type"};
    private final String btnName[] = {"Add","Update","Delete"};
    private final String type[] = {"General","Computer","Math&Sci","Photo"};
    
    public BookViewer(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(300,250);
        frame.setLayout(new GridLayout(5,1));
        
        panel = new JPanel[5];
        label = new JLabel[3];
        bk = new JTextField[2];
        btn = new JButton[3];
        move = new JButton[2];
        for (int i = 0; i < 5;i++){
            panel[i] = new JPanel();
            if (i < 3){
                panel[i].setLayout(new GridLayout(1,2));
                label[i] = new JLabel(labelName[i]);
                panel[i].add(label[i]);
                if(i < 2){
                    bk[i] = new JTextField();
                    panel[i].add(bk[i]);
                }else{
                    com = new JComboBox(type);
                    panel[i].add(com);
                }
            }else if (i == 3){
                panel[i].setLayout(new FlowLayout(FlowLayout.CENTER));
                move[0] = new JButton("<<<");
                move[0].addActionListener(this);
                panel[i].add(move[0]);
                
                index = new JTextField("0");
                index.setPreferredSize(new Dimension(30,20));
                panel[i].add(index);
                
                move[1] = new JButton(">>>");
                move[1].addActionListener(this);
                panel[i].add(move[1]);
            }else{
                panel[i].setLayout(new FlowLayout(FlowLayout.CENTER));
                for (int j = 0;j < 3;j++){
                    btn[j] = new JButton(btnName[j]);
                    btn[j].addActionListener(this);
                    panel[i].add(btn[j]);
                }
            }
            frame.add(panel[i]);    
        }
        loads();
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                if (!book.isEmpty()){
                    try(ObjectOutputStream bookOut = new ObjectOutputStream(new FileOutputStream("Book.data"))){
                        bookOut.writeObject(book);
                    }catch (IOException i){
                        i.printStackTrace();
                    }
                }
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {//{"Add","Update","Delete"};
        if (e.getSource().equals(btn[0])){
            new BookAdd();
        }else if (e.getSource().equals(btn[1])){
            book.set(Integer.parseInt(index.getText()),new Book(bk[0].getText(),Double.parseDouble(bk[1].getText()),String.valueOf(com.getSelectedItem())));
            JOptionPane.showMessageDialog(null, "Done it.","Update Command",JOptionPane.PLAIN_MESSAGE);
        }else if (e.getSource().equals(btn[2])){
            book.remove(Integer.parseInt(index.getText()));
            JOptionPane.showMessageDialog(null, "Done it.","Delete Command",JOptionPane.PLAIN_MESSAGE);
        }else if (e.getSource().equals(move[0])){
            System.out.println(book.size());
            if (Integer.parseInt(index.getText()) - 1 >= 0){
                index.setText(String.valueOf(Integer.parseInt(index.getText()) - 1));
                bk[0].setText(((Book)book.get(Integer.parseInt(index.getText()))).getName());
                bk[1].setText(String.valueOf(((Book)book.get(Integer.parseInt(index.getText()))).getPrice()));
                com.setSelectedItem(((Book)book.get(Integer.parseInt(index.getText()))).getType());
            }
        }else if (e.getSource().equals(move[1])){
            System.out.println(book.size());
            if (Integer.parseInt(index.getText()) + 1 <= book.size() - 1){
                index.setText(String.valueOf(Integer.parseInt(index.getText()) + 1));
                bk[0].setText(((Book)book.get(Integer.parseInt(index.getText()))).getName());
                bk[1].setText(String.valueOf(((Book)book.get(Integer.parseInt(index.getText()))).getPrice()));
                com.setSelectedItem(((Book)book.get(Integer.parseInt(index.getText()))).getType());
            }
        }
    }
    public static void main(String[] args) {
        new BookViewer();
    }
    public void loads(){
        try(ObjectInputStream bookin = new ObjectInputStream(new FileInputStream("Book.data"));) {
            book = ((ArrayList<Book>)bookin.readObject());
            if (!book.isEmpty()){
                bk[0].setText(((Book)book.get(0)).getName());
                bk[1].setText(String.valueOf(((Book)book.get(0)).getPrice()));
                com.setSelectedItem(((Book)book.get(0)).getType());
            }
        }catch (IOException |ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
