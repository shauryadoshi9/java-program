import java.awt.*;
import java.awt.event.*;

public class form extends Frame implements ActionListener {

    // Instance variables
    Label l1, l2;
    TextField t1, t2;
    Button b1;

    // Constructor
    form() {
        setSize(500, 500);
        setTitle("Form");

        setLayout(new GridLayout(3, 2));

        l1 = new Label("Number 1");
        l2 = new Label("Number 2");

        t1 = new TextField();
        t2 = new TextField();

        b1 = new Button("Submit");

        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(b1);

        // Adding ActionListener
        b1.addActionListener(this);

        setVisible(true);
    }

    // actionPerformed method
    public void actionPerformed(ActionEvent e) {
        String n1 = t1.getText();
        String n2 = t2.getText();

        System.out.println("Number 1 = " + n1);
        System.out.println("Number 2 = " + n2);
    }

    // Main method
    public static void main(String args[]) {
        form f1 = new form();
    }
}
