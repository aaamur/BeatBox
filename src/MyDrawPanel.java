import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;

/**
 * Created by sasha on 08.01.2017.
 */
public class MyDrawPanel extends JPanel implements ControllerEventListener{
    boolean msg = false;

    public void paintComponent (Graphics g) {

        if (msg) {
            Graphics2D g2 =  (Graphics2D) g;

            g.setColor(new Color(getRandomValue(250,0),getRandomValue(250,0),getRandomValue(250,0)));
            g.fillRect(getRandomValue(120,10),getRandomValue(120,10),getRandomValue(40,10),getRandomValue(40,10));
            msg = false;
        }
    }

    public int getRandomValue(int y, int x) {
        return (int) ((Math.random() * y) + x);
    }

    @Override
    public void controlChange(ShortMessage event) {
        msg = true;
        repaint();
    }


}
