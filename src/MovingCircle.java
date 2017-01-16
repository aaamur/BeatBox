/**
 * Created by sasha on 13.01.2017.
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class MovingCircle extends JComponent implements ActionListener {
    private Timer timer;
    public int x =10;
    public int y =10;

    public MovingCircle(int delay) {
        timer = new Timer(delay, this);
        setPreferredSize(new Dimension(500, 500));
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,this.getWidth(),this.getHeight());

        g.setColor(Color.green);
        g.fillOval(x,y,40,40);

        x++;
        y++;

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Moving Circle");
                JPanel panel = new JPanel();

                final MovingCircle MovingCircleGreen = new MovingCircle(20);

                panel.add(MovingCircleGreen);
                frame.getContentPane().add(panel);

                final JButton button = new JButton("Start");

                button.addActionListener(new ActionListener() {
                    private boolean pulsing = false;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (pulsing) {
                            pulsing = false;
                            MovingCircleGreen.stop();
                            button.setText("Start");
                            System.out.print(button.getBounds());
                        } else {
                            pulsing = true;
                            MovingCircleGreen.start();
                            button.setText("Stop");

                        }
                    }
                });
                panel.add(button);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600, 550);
                frame.setVisible(true);
            }
        });
    }
}