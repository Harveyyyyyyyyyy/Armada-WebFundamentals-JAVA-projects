import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // number of students and subjects
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[][] scores = new int[numStudents][numSubjects];

        // input scores
        for (int student = 0; student < numStudents; student++) {
            System.out.print("\nEnter scores for Student " + (student + 1) + ": ");
            for (int subject = 0; subject < numSubjects; subject++) {
                scores[student][subject] = scanner.nextInt();
            }
        }

        // calculate and display results
        for (int student = 0; student < numStudents; student++) {
            int total = 0;
            for (int subject : scores[student]) {
                total += subject;
            }
            double average = (double) total / numSubjects;
            System.out.println(String.format("\nStudent %d - Total: %d, Average: %.2f", student + 1, total, average));
        }

        scanner.close();
    }
}