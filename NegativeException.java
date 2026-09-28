import java.awt.*;
import java.awt.event.*;

class NegativeNumberException extends Exception {

    public NegativeNumberException(String message) {
        super(message);
    }

    public String toString() {
        return "NegativeNumberException: " + getMessage();
    }
}

public class NegativeException extends Frame
        implements ActionListener {

    Label numberLabel;
    Label resultLabel;

    TextField numberTextField;

    Button checkButton;
    Button clearButton;

    // Constructor
    NegativeException() {

        setTitle("Number Exception Handling");

        // Increased GUI size
        setSize(700, 450);

        setLayout(null);

        // Number Label
        numberLabel = new Label("Enter Number:");
        numberLabel.setBounds(100, 80, 150, 40);
        add(numberLabel);

        // TextField
        numberTextField = new TextField();
        numberTextField.setBounds(270, 80, 250, 40);
        add(numberTextField);

        // Check Button
        checkButton = new Button("Check");
        checkButton.setBounds(180, 160, 120, 45);
        add(checkButton);

        // Clear Button
        clearButton = new Button("Clear");
        clearButton.setBounds(350, 160, 120, 45);
        add(clearButton);

        // Result Label
        resultLabel = new Label("Result will appear here");
        resultLabel.setBounds(100, 250, 500, 40);
        add(resultLabel);

        // ActionListener
        checkButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Close window
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // Display window
        setVisible(true);
    }

    // Check number
    static void checkNumber(int n)
            throws NegativeNumberException {

        if (n < 0) {

            throw new NegativeNumberException(
                    "Number is negative"
            );
        }

        if (n > 100) {

            int[] arr = new int[1];

            System.out.println(arr[5]);
        }
    }

    // Action performed
    public void actionPerformed(ActionEvent e) {

        // Check button
        if (e.getSource() == checkButton) {

            try {

                int n = Integer.parseInt(
                        numberTextField.getText()
                );

                checkNumber(n);

                resultLabel.setText(
                        "Number is positive and valid"
                );

            }

            catch (NegativeNumberException ex) {

                resultLabel.setText(
                        ex.toString()
                );

            }

            catch (ArrayIndexOutOfBoundsException ex) {

                resultLabel.setText(
                        "Error: ArrayIndexOutOfBoundsException"
                );

            }

            catch (NumberFormatException ex) {

                resultLabel.setText(
                        "Error: Enter a valid number"
                );
            }
        }

        // Clear button
        if (e.getSource() == clearButton) {

            numberTextField.setText("");

            resultLabel.setText(
                    "Result will appear here"
            );
        }
    }

    // Main
    public static void main(String[] args) {

        new NegativeException();
    }
}