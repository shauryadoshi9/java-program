
import java.awt.*;

public class BouncingCircle extends Frame implements Runnable {

    int x = 100, y = 100;
    int dx = 5, dy = 5;
    Thread t;

    BouncingCircle() {
        setTitle("Bouncing Circle");
        setSize(600, 400);
        setVisible(true);

        t = new Thread(this);
        t.start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 50, 50);
    }

    public void run() {
        while (true) {
            x = x + dx;
            y = y + dy;

            if (x <= 0 || x >= getWidth() - 50) {
                dx = -dx;
            }

            if (y <= 30 || y >= getHeight() - 50) {
                dy = -dy;
            }

            repaint();

            try {
                Thread.sleep(30);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String args[]) {
        new BouncingCircle();
    }
}
