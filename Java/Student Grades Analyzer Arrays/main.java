import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        // array to store grades
        int[] grades = new int[numStudents];

        // input grades for each student
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }

        // variables to track highest and lowest grades
        int highestGrade = grades[0];
        int lowestGrade = grades[0];

        // accumulator for sum of grades
        double sumGrades = 0;

        // loop through grades to find highest, lowest, and sum
        for (int grade : grades) {
            if (grade > highestGrade) {
                highestGrade = grade;
            }
            if (grade < lowestGrade) {
                lowestGrade = grade;
            }
            sumGrades += grade;
        }

        // calculate average grade
        double averageGrade = sumGrades / numStudents;

        // display results
        System.out.println("\nHighest Grade: " + highestGrade);
        System.out.println("Lowest Grade: " + lowestGrade);
        System.out.printf("Average Grade: %.1f%n", averageGrade);

        scanner.close();
    }
}
