import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return name + " - " + grade;
    }
}

public class Main {
    private ArrayList<Student> students;
    private Scanner scanner;

    public Main() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // method on adding a new student
    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // consume newline left-over

        students.add(new Student(name, grade));
        System.out.println("Student added!");
    }

    // method to display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            System.out.println("Students List:");
            for (Student student : students) {
                System.out.println(student); // This will print each student on a new line without brackets
            }
        }
    }

    // method to update a students grade
    public void updateGrade() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.name.equalsIgnoreCase(name)) {
                System.out.print("Enter new grade: ");
                double newGrade = scanner.nextDouble();
                scanner.nextLine(); // consume newline lefft-over
                student.grade = newGrade;
                System.out.println("Grade updated!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Method to remove a student
    public void removeStudent() {
        System.out.print("Enter student name to remove: ");
        String name = scanner.nextLine();
        for (Student student : students) {
            if (student.name.equalsIgnoreCase(name)) {
                students.remove(student);
                System.out.println("Student removed!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Main method to handle user interactions
    public void run() {
        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Grade");
            System.out.println("4. Remove Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    updateGrade();
                    break;
                case 4:
                    removeStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        Main tracker = new Main();
        tracker.run();
    }

}