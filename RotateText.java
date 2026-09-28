
import java.awt.*;

public class RotateText extends Frame implements Runnable
{
    String text = "Dharmsinh Desai University";
    int angle = 0;
    Thread t;

    RotateText()
    {
        setTitle("Rotating Text");
        setSize(500, 300);
        setVisible(true);

        t = new Thread(this);
        t.start();
    }

    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;

        g2.setFont(new Font("Arial", Font.BOLD, 30));

        int x = 200;
        int y = 150;

        g2.translate(x, y);
        g2.rotate(Math.toRadians(angle));

        g2.drawString(text, 0, 0);
    }

    public void run()
    {
        while(true)
        {
            angle = angle + 10;

            if(angle >= 360)
                angle = 0;

            repaint();

            try
            {
                Thread.sleep(100);
            }
            catch(Exception e)
            {
            } 
        }
    }

    public static void main(String args[])
    {
        new RotateText();
    }
}
