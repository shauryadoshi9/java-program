import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class StudentManagement {

    static String fileName = "studentdata.txt";

    public static void main(String[] args) throws IOException {

        // 1. Add students
        FileOutputStream fos = new FileOutputStream(fileName);

        String data = "Raj\nPriya\nAmit\nNeha\n";
        fos.write(data.getBytes());

        fos.close();

        // 2. Check number of students
        ArrayList<String> students = readStudents();

        System.out.println("Students: " + students);
        System.out.println("Total students: " + students.size());

        // 3. Remove one student
        students.remove("Amit");
        writeStudents(students);

        System.out.println("\nAfter removing Amit:");
        System.out.println("Students: " + readStudents());
        System.out.println("Total students: " + readStudents().size());

        // 4. Remove all students
        students.clear();
        writeStudents(students);

        System.out.println("\nAfter removing all students:");
        System.out.println("Students: " + readStudents());
        System.out.println("Total students: " + readStudents().size());
    }

    // Read students from file
    static ArrayList<String> readStudents() throws IOException {

        ArrayList<String> students = new ArrayList<>();

        FileInputStream fis = new FileInputStream(fileName);

        String student = "";
        int ch;

        while ((ch = fis.read()) != -1) {

            if (ch == '\n') {
                students.add(student);
                student = "";
            } else {
                student = student + (char) ch;
            }
        }

        if (!student.isEmpty()) {
            students.add(student);
        }

        fis.close();

        return students;
    }

    // Write students to file
    static void writeStudents(ArrayList<String> students) throws IOException {

        FileOutputStream fos = new FileOutputStream(fileName);

        for (String student : students) {
            fos.write((student + "\n").getBytes());
        }

        fos.close();
    }
}
