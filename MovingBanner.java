import java.awt.*;
import java.awt.event.*;

public class MovingBanner extends Frame implements ActionListener, Runnable
{
    TextField msg, color, size;
    Choice direction;
    Button start;
    Label banner;
    Thread t;
    int x = 0, y = 100;

    MovingBanner()
    {
        setLayout(new FlowLayout());

        add(new Label("Message:"));
        msg = new TextField(15);
        add(msg);

        add(new Label("Color:"));
        color = new TextField(10);
        add(color);

        add(new Label("Size:"));
        size = new TextField(5);
        add(size);

        add(new Label("Direction:"));
        direction = new Choice();
        direction.add("Left");
        direction.add("Right");
        direction.add("Up");
        direction.add("Down");
        add(direction);

        start = new Button("Start");
        add(start);
        start.addActionListener(this);

        banner = new Label("");
        add(banner);

        setSize(600, 250);
        setTitle("Moving Banner");
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        banner.setText(msg.getText());

        try
        {
            banner.setFont(new Font("Arial", Font.BOLD,
                    Integer.parseInt(size.getText())));
        }
        catch(Exception ex)
        {
            banner.setFont(new Font("Arial", Font.BOLD, 25));
        }

        if(color.getText().equalsIgnoreCase("red"))
            banner.setForeground(Color.RED);
        else if(color.getText().equalsIgnoreCase("blue"))
            banner.setForeground(Color.BLUE);
        else if(color.getText().equalsIgnoreCase("green"))
            banner.setForeground(Color.GREEN);
        else
            banner.setForeground(Color.BLACK);

        x = 0;
        y = 100;

        t = new Thread(this);
        t.start();
    }

    public void run()
    {
        while(true)
        {
            String d = direction.getSelectedItem();

            if(d.equals("Right"))
                x += 5;
            else if(d.equals("Left"))
                x -= 5;
            else if(d.equals("Down"))
                y += 5;
            else if(d.equals("Up"))
                y -= 5;

            banner.setLocation(x, y);

            try
            {
                Thread.sleep(100);
            }
            catch(Exception e)
            {
            }

            if(x > 550 || x < 0 || y > 200 || y < 50)
            {
                x = 0;
                y = 100;
            }
        }
    }

    public static void main(String args[])
    {
        new MovingBanner();
    }
}