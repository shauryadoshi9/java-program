abstract class SessionalExam {
    abstract int appearInExam();
}

class OnlineSessionalExam extends SessionalExam {

    int appearInExam() {
        System.out.println("Exam Type: Sessional Exam");
        System.out.println("Mode: Online");

        int marks = (int)(Math.random() * 37);
        System.out.println("Marks: " + marks);

        return marks;
    }
}
                     
class RegularSessionalExam extends SessionalExam {

    int appearInExam() {
        System.out.println("Exam Type: Sessional Exam");
        System.out.println("Mode: Regular");
        int marks = 0;
        do
        {
             marks = (int)(Math.random() * 100);
            
        }while( marks<90);
        System.out.println("Marks: " + marks);

        return marks;
    }
}

public class Exam {
    public static void main(String[] args) {

        SessionalExam online = new OnlineSessionalExam();
        SessionalExam regular = new RegularSessionalExam();

        online.appearInExam();

        System.out.println();

        regular.appearInExam();
    }
}