import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class StudentFileTest {

    static String fileName = "students.txt";

    public static void main(String[] args) throws IOException {

        // 1. Add four students
        FileWriter fw = new FileWriter(fileName);

        fw.write("Rahul\n");
        fw.write("Priya\n");
        fw.write("Amit\n");
        fw.write("Neha\n");

        fw.close();

        // 2. Check number of students
        ArrayList<String> students = readStudents();

        System.out.println("Students: " + students);
        System.out.println("Number of students: " + students.size());

        // 3. Remove one student
        students.remove("Amit");
        writeStudents(students);

        System.out.println("\nAfter removing Amit:");
        System.out.println(readStudents());

        // 4. Remove all students
        students.clear();
        writeStudents(students);

        System.out.println("\nAfter removing all students:");
        System.out.println(readStudents());
    }

    // Read students using FileReader
    static ArrayList<String> readStudents() throws IOException {

        ArrayList<String> students = new ArrayList<>();
        FileReader fr = new FileReader(fileName);

        String student = "";
        int ch;

        while ((ch = fr.read()) != -1) {

            if (ch == '\n') {
                students.add(student);
                student = "";
            } else {
                student += (char) ch;
            }
        }

        // Add the last student if necessary
        if (!student.isEmpty()) {
            students.add(student);
        }

        fr.close();

        return students;
    }

    // Write students using FileWriter
    static void writeStudents(ArrayList<String> students) throws IOException {

        FileWriter fw = new FileWriter(fileName);

        for (String student : students) {
            fw.write(student + "\n");
        }

        fw.close();
    }
}
