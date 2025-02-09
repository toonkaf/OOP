import java.awt.*;
import javax.swing.*;
public class MDIFromGUI {
    private JFrame frame;
    private JMenuBar men;
    private JMenu fi,ed,vi,fi1;
    private JMenuItem fi2,fi3,fi4,ne1,ne2;
    private JDesktopPane desk;
    private int count = 0;
    public MDIFromGUI(){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){
            e.printStackTrace();
        }
        frame = new JFrame("SubMenuItem Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout());
        men = new JMenuBar();
        fi = new JMenu("File");
        fi.setMnemonic('F');
        ed = new JMenu("Edit");
        vi = new JMenu("View");
        frame.setJMenuBar(men);
        men.add(fi);
        men.add(ed);
        men.add(vi);
        fi1 = new JMenu("New");
        fi2 = new JMenuItem("Open");
        fi3 = new JMenuItem("Save");
        fi4 = new JMenuItem("Exit");
        fi.add(fi1);
        fi.add(fi2);
        fi.addSeparator();
        fi.add(fi3);
        fi.addSeparator();
        fi.add(fi4);
        ne1 = new JMenuItem("Window");
        ne2 = new JMenuItem("Message");
        fi1.add(ne1);
        fi1.addSeparator();
        fi1.add(ne2);
        ne1.addActionListener(e -> openFrame());
        desk = new JDesktopPane();
        frame.getContentPane().add(desk,BorderLayout.CENTER);
        frame.setVisible(true);
    }
    private void openFrame(){
        count += 1;
        JInternalFrame inter = new JInternalFrame("Application "+count,true,true,true,true);
        inter.setSize(200,200);
        inter.setVisible(true);
        desk.add(inter);
    }
    public static void main(String[] args) {
        new MDIFromGUI();
    }
}