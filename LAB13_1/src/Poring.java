import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.concurrent.Delayed;
public class Poring extends Thread {
    private JFrame frame;
    private JLabel por,num;
    private static int numOfPo = 0;
    private Random rand = new Random();
    public Poring(){
        numOfPo += 1;
        frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocation(rand.nextInt(500),rand.nextInt(500));
        por = new JLabel();
        por.setIcon(new ImageIcon(new ImageIcon("D:/.KMITL/Year 1_2/Object-Oriented Programming/OOP/LAB13_1/src/67c586f0537bb7afb460b9bd.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        por.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent m){
                numOfPo -= 1;
                frame.dispose();
            }
        });
        num = new JLabel(String.valueOf(numOfPo));
        frame.getContentPane().add(por);
        frame.getContentPane().add(num);
        frame.pack();
        frame.setVisible(true);
        start();
    }
    public void run(){
        try{
            while(!interrupted()){
                por.setText(String.valueOf(numOfPo));
                if (rand.nextInt(2) == 1){
                    frame.setLocation(frame.getLocation().x + rand.nextInt(5),frame.getLocation().y + rand.nextInt(5));
                }else{
                    frame.setLocation(frame.getLocation().x - rand.nextInt(5),frame.getLocation().y - rand.nextInt(5));
                }
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            
        }
    }
}
