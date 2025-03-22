import java.util.Scanner;

public class StudentGrades {
    private String name;
    private double[] grades;

    // Constructor
    public StudentGrades(String name, double[] grades) {
        this.name = name;
        this.grades = grades;
    }

    // Instance method to calculate average grade
    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    // Instance method to classify grade
    public String classifyGrade(double average) {
        if (average >= 90) {
            return "Excellent";
        } else if (average >= 80) {
            return "Good";
        } else if (average >= 70) {
            return "Average";
        } else {
            return "Needs Improvement";
        }
    }

    // Static method to validate input
    public static boolean validateGrade(double grade) {
        return grade >= 0 && grade <= 100;
    }

    // Overloaded static method to calculate average with variable number of grades
    public static double calculateAverage(double... grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    // Method to display student information
    public void displayInfo() {
        double average = calculateAverage();
        String classification = classifyGrade(average);
        
        System.out.println("Student: " + name);
        System.out.print("Grades: ");

        for (double grade : grades) {
            System.out.print(grade + ", ");
        }

        System.out.println("\b\b"); // Remove trailing comma and space
        System.out.printf("Average: %.2f\n", average);
        System.out.println("Classification: " + classification);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter 3 grades (space-separated): ");

        String[] inputGrades = scanner.nextLine().split(" ");
        double[] grades = new double[inputGrades.length];

        for (int i = 0; i < inputGrades.length; i++) {
            grades[i] = Double.parseDouble(inputGrades[i]);
            if (!validateGrade(grades[i])) {
                System.out.println("Invalid grade. Please enter grades between 0 and 100.");
                return;
            }
        }

        StudentGrades student = new StudentGrades(name, grades);
        student.displayInfo();
    }
}