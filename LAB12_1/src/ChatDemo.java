import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class ChatDemo implements ActionListener {
    private JFrame frame;
    private JPanel panel,pan;
    private JTextArea txt;
    private JTextField field;
    private JButton sub,re;
    private final String FILE_NAME = "ChatDemo.dat";
    public ChatDemo(){
        frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        frame.getContentPane().setLayout(new BoxLayout(frame, 1));
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        
        txt = new JTextArea(20, 45);
        txt.setEditable(false);
        loadTextFromFile();
        panel.add(txt);
        
        field = new JTextField(45);
        panel.add(field);
        
        pan = new JPanel();
        pan.setLayout(new FlowLayout());
        sub = new JButton("Submit");
        re = new JButton("Reset");
        sub.addActionListener(this);
        re.addActionListener(this);
        pan.add(sub);
        pan.add(re);
        panel.add(pan);
        
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                saveTextToFile();
                System.exit(0);
            }
        });
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        if (e.getSource().equals(sub)){
            if(txt.getText().equals("")){
                txt.setText(txt.getText()+dtf.format(LocalDateTime.now())+" : "+field.getText());
            }else{
                txt.setText(txt.getText() + "\n" +dtf.format(LocalDateTime.now())+" : "+field.getText());
            }

            field.setText("");
            
        }else if(e.getSource().equals(re)){
            txt.setText("");
            field.setText("");
        }
    }
    public static void main(String[] args) {
        new ChatDemo();
    }
    private void saveTextToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(txt.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTextFromFile() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                txt.read(reader, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
