import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClientAChat implements ActionListener{
    JFrame frame;
    JTextArea shows;
    JPanel panel;
    JTextField txt;
    JButton btn;
    ClientBChat cliB;
    public ClientAChat(){
        frame = new JFrame("ChatBox Client A");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        
        shows = new JTextArea();
        shows.setEditable(false);
        loadsFile();
        frame.add(shows , BorderLayout.CENTER);
        
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        txt = new JTextField();
        panel.add(txt, BorderLayout.CENTER);
        
        btn = new JButton("Send");
        btn.addActionListener(this);
        panel.add(btn,BorderLayout.EAST);
        
        frame.add(panel,BorderLayout.SOUTH);
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                saveFile();
                cliB.saveFile();
            }
        });
        frame.setVisible(true);
    }
    
    public void setcliB(ClientBChat cliB){
        this.cliB = cliB;
    }
    public void addText(String s){
        shows.setText(shows.getText()+s);
    }
    public void saveFile(){
        try(BufferedWriter bout = new BufferedWriter(new FileWriter("chathistoryA.dat"))){
                    bout.write(shows.getText());
                } catch (IOException ex) {
                    Logger.getLogger(ClientBChat.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void loadsFile(){
        try(BufferedReader bin = new BufferedReader(new FileReader("chathistoryA.dat"))){
            shows.read(bin,null);
        } catch (IOException ex) {
            Logger.getLogger(ClientAChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.addText("["+dtf.format(LocalDateTime.now())+"] A (You):"+txt.getText()+"\n");
        cliB.addText("["+dtf.format(LocalDateTime.now())+"] A:"+txt.getText()+"\n");
        txt.setText("");
    }
    
}
