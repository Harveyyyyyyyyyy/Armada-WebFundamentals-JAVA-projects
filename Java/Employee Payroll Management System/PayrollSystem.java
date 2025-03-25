import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollSystem {
    private static List<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    calculateAnnual();
                    break;
                case 4:
                    giveRaise();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n1. Add Employee\n2. View All Employees\n3. Calculate Annual Salary");
        System.out.print("4. Give Salary Raise\n5. Exit\n\nEnter your choice: ");
    }

    private static void addEmployee() {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter department: ");
        String dept = scanner.nextLine();

        employees.add(new Employee(name, id, salary, dept));
        System.out.println("Employee added successfully!");
    }

    private static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
            return;
        }

        System.out.println("--- Employee Records ---");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println("Employee " + (i + 1) + ":");
            employees.get(i).displayInfo();
        }
    }

    private static void calculateAnnual() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Employee emp : employees) {
            if (emp.getEmployeeID() == id) {
                System.out.printf("Annual Salary of %s: $%.2f\n",
                        emp.getName(), emp.calculateAnnualSalary());
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    private static void giveRaise() {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter percentage increase: ");
        double percent = scanner.nextDouble();
        scanner.nextLine();

        for (Employee emp : employees) {
            if (emp.getEmployeeID() == id) {
                emp.raiseSalary(percent);
                System.out.printf("New salary: $%.2f\n", emp.getSalary());
                return;
            }
        }
        System.out.println("Employee not found!");
    }
}