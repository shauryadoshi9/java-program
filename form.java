import java.awt.*;
import java.awt.event.*;

public class form extends Frame implements ActionListener {

    // Instance variables
    Label l1, l2, l3;
    TextField t1, t2, t3;
    Button b1;

    // Constructor
    form() {
        setSize(500, 500);
        setTitle("Form");

        setLayout(new GridLayout(4, 2));

        l1 = new Label("Number 1");
        l2 = new Label("Number 2");
        l3 = new Label("Mo. No.");

        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();

        b1 = new Button("Submit");

        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(l3);
        add(t3);

        add(b1);

        // Add ActionListener
        b1.addActionListener(this);

        // Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    // Action performed method
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        if (action.equalsIgnoreCase("Submit")) {

            int n1 = Integer.parseInt(t1.getText());
            int n2 = Integer.parseInt(t2.getText());

            System.out.println("Addition = " + (n1 + n2));
            System.out.println("Subtraction = " + (n1 - n2));
            System.out.println("Multiplication = " + (n1 * n2));

            if (n2 != 0) {
                System.out.println("Division = " + (n1 / n2));
            } else {
                System.out.println("Cannot divide by zero");
            }
        }
    }

    // Main method
    public static void main(String args[]) {
        form f1 = new form();
    }
}
//javap.java.awt.event.actionListener