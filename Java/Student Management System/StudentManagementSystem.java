import java.util.ArrayList;
import java.util.Scanner;

// Define a class for Student
class Student {
    private String name;
    private int id;
    private double grade;

    // Constructor to initialize student attributes
    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Instance methods to get and set student attributes
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Method to display the main menu
    private static void displayMenu() {
        System.out.println("\nWelcome to the Student Management System");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student Grade");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to add a new student
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine();

        Student student = new Student(name, id, grade);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Method to view all students
    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }

        System.out.println("--- Student Records ---");
        System.out.println("School: Greenwood High School");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Grade: " + student.getGrade());
        }
    }

    // Method to update a student's grade
    private static void updateStudentGrade() {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Enter new grade: ");
                double newGrade = scanner.nextDouble();
                scanner.nextLine();
                student.setGrade(newGrade);
                System.out.println("Grade updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    updateStudentGrade();
                    break;
                case 4:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 4);
    }
}