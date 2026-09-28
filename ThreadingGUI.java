import java.awt.*;
import java.awt.event.*;
public class ThreadingGUI extends Frame implements MouseListerner
{
    ThreadingGUI()
    {
        setSize(500,500);
        setTitle("Moving Object");
        setVisible(true);

        repaint();
    }
    public void paint(Graphics g)
    {
        g.drawOval(50,50,100,100);
    }

    public static void main(String args[])
    {
        new ThreadingGUI();
    }

}
