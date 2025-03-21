import java.util.Scanner;

public class StudentGradesAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();

        int[] grades = new int [numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter grade for students " + (i + 1) + ": ");

            grades[i] = scanner.nextInt();
        }

        int total = 0;
        int highest = grades[0];
        int lowest = grades[0];

        for (int grade : grades) {
            total += grade;

            if (grade > highest) {
                highest = grade;
            }
            else if (grade < lowest) {
                lowest = grade;
            }
        }

        double average = (double) total / numberOfStudents;

        System.out.println("\n=== Grade Analysis ===");
        System.out.printf("Total Grades: %,d%n", total);
        System.out.printf("Average Grade: %.2f%n", average);
        System.out.printf("Highest Grade: %,d%n", highest);
        System.out.printf("Lowest Grade: %,d%n", lowest);

    }
}