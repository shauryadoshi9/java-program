import java.io.FileInputStream;
import java.io.IOException;

public class EvenOdd {
    public static void main(String[] args) {

        try {
            FileInputStream input = new FileInputStream("number.txt");

            int number = 0;
            int data;

            while ((data = input.read()) != -1) {
                if (data >= '0' && data <= '9') {
                    number = number * 10 + (data - '0');
                }
            }

            input.close();

            if (number % 2 == 0) {
                System.out.println(number + " is Even");
            } else {
                System.out.println(number + " is Odd");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
