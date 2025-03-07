import java.awt.Font;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class MyClock extends JLabel implements Runnable{

    @Override
    public void run() {
        try {
            int sec = 0;
            int min = 0;
            int hour = 0;
            while(true){
                sec += 1;
                if (sec == 60){
                    sec = 0;
                    min += 1;
                    if (min == 60){
                        min = 0;
                        hour += 1;
                    }
                }
                setFont(new Font("Aria",Font.PLAIN,40));
                setText(String.format("%02d : %02d : %02d" , hour , min ,sec));
                Thread.sleep(1000);
            }
        }catch (InterruptedException ex) {
                Logger.getLogger(MyClock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
}
