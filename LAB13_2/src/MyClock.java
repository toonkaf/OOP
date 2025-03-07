import java.awt.Font;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class MyClock extends JLabel implements Runnable{

    @Override
    public void run() {
        try {
            while(true){
                Calendar d = Calendar.getInstance();
                int sec = d.get(Calendar.SECOND);
                int min = d.get(Calendar.MINUTE);
                int hour = d.get(Calendar.HOUR_OF_DAY);                
                setFont(new Font("Aria",Font.PLAIN,40));
                setText(String.format("%02d : %02d : %02d" , hour , min ,sec));
                Thread.sleep(1000);
            }
        }catch (InterruptedException ex) {
                Logger.getLogger(MyClock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
}
