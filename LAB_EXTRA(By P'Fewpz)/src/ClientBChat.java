import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClientBChat implements ActionListener{
    JFrame frame;
    JTextArea shows;
    JPanel panel;
    JTextField txt;
    JButton btn;
    ClientAChat cliA;
    public ClientBChat(){
        frame = new JFrame("ChatBox Client B");
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
                cliA.saveFile();
            }
        });
        frame.setVisible(true);
        
    }
    public void setcliA(ClientAChat cliA){
        this.cliA = cliA;
    }
    public void addText(String s){
        shows.setText(shows.getText()+s);
    }
    public void saveFile(){
        try(BufferedWriter bout = new BufferedWriter(new FileWriter("chathistoryB.dat"))){
                    bout.write(shows.getText());
                } catch (IOException ex) {
                    Logger.getLogger(ClientBChat.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void loadsFile(){
        try(BufferedReader bin = new BufferedReader(new FileReader("chathistoryB.dat"))){
            shows.read(bin,null);
        } catch (IOException ex) {
            Logger.getLogger(ClientAChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.addText("["+dtf.format(LocalDateTime.now())+"] B (You):"+txt.getText()+"\n");
        cliA.addText("["+dtf.format(LocalDateTime.now())+"] B:"+txt.getText()+"\n");
        txt.setText("");
    }
}
