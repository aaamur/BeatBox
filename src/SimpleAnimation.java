import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sasha on 12.01.2017.
 */
public class SimpleAnimation implements ActionListener {
    int x = 70;
    int y = 70;

    SimpleAnimation() {

    }

    public static void main (String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
        JFrame frame = new JFrame();

        //DrawPanel drawPanel = new DrawPanel();

        JButton button = new JButton("Start");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //button.addActionListener(this);

        //frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setSize(300,400);
        frame.setVisible(true);
    }


    public void go(){


    }



   @Override
    public void actionPerformed(ActionEvent e) {
    }

    class DrawPanel extends JPanel {

        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0,0,this.getWidth(),this.getHeight());

            g.setColor(Color.green);
            g.fillOval(x,y,40,40);
            x++;
            y++;
        }
    }
}
