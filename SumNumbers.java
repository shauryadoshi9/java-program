import java.io.FileInputStream;
import java.io.IOException;

public class SumNumbers {
    public static void main(String[] args) {

        try {
            FileInputStream input = new FileInputStream("number.txt");

            int sum = 0;
            int number = 0;
            int data;

            while ((data = input.read()) != -1) {

                if (data >= '0' && data <= '9') {
                    number = number * 10 + (data - '0');
                } 
                else if (data == '\n' || data == ' ' || data == '\r') {
                    sum = sum + number;
                    number = 0;
                }
            }

            // Add the last number
            sum = sum + number;

            input.close();

            System.out.println("Sum of all numbers = " + sum);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
