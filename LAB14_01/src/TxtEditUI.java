import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class TxtEditUI implements ActionListener{
    JFrame frame;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem item[];
    JTextArea txtArea;
    String itmName[] = {"New","Open","Save","Close"};
    public TxtEditUI(){
        frame = new JFrame("My Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(500,500);
        
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        item = new JMenuItem[4];
        
        for (int i = 0;i < item.length;i++){
            if (i == 3){
                menu.addSeparator();
            }
            item[i] = new JMenuItem(itmName[i]);
            item[i].addActionListener(this);
            menu.add(item[i]);
        }
        menuBar.add(menu);
        
        txtArea = new JTextArea();
        
        
        frame.add(menuBar,BorderLayout.NORTH);
        frame.add(txtArea,BorderLayout.CENTER);
        
        
        
        
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new TxtEditUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {//{"New","Open","Save","Close"}
        if(e.getSource().equals(item[0])){
            txtArea.setText("");
        }else if(e.getSource().equals(item[1])){
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(frame);
            File f = fc.getSelectedFile();
            try(BufferedReader br = new BufferedReader(new FileReader(f));) {
                txtArea.read(br,null);
            } catch (IOException ex) {
                Logger.getLogger(TxtEditUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(item[2])){
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(frame);
            File f = fc.getSelectedFile();
            try(BufferedWriter br = new BufferedWriter(new FileWriter(f));) {
                br.write(txtArea.getText());
            }catch (IOException ex) {
                Logger.getLogger(TxtEditUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(item[3])){
            System.exit(0);
        }
    }
}
