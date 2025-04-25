import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;

// interface payable with computeSalary() method
interface Payable {
    double computeSalary() throws IllegalArgumentException;
}

// interface printable with generatePayslip() method
interface Printable {
    void generatePayslip();
}

// abstract class Employee with basic info
abstract class Employee {
    protected String name;
    protected String id;
    protected String role;
    protected String department;

    public Employee(String name, String id, String role, String department) {
        this.name = name;
        this.id = id;
        this.role = role;
        this.department = department;
    }
}

// fulltime employee subclass
class FullTimeEmployee extends Employee implements Payable, Printable {
    private double rate;
    private double hours;

    public FullTimeEmployee(String name, String id, String department, double rate, double hours) {
        super(name, id, "full-time", department);
        this.rate = rate;
        this.hours = hours;
    }

    // compute gross salary and deduct 10% tax
    public double computeSalary() {
        if (rate < 0 || hours < 0) {
            throw new IllegalArgumentException("rate and hour must be non-negative");
        }
        double gross = rate * hours;
        return gross * 0.9; //deduct 10% tax
    }

    // save payslip to text .txt file
    public void generatePayslip() {
        double netSalary = computeSalary();
        String filename = id + "_payslip.txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Payslip for " + name + "\n");
            writer.write("Employee ID: " + id + "\n");
            writer.write("Role: " + role + "\n");
            writer.write("Department: " + department + "\n");
            writer.write(String.format("Hours Worked: %.2f\n", hours));
            writer.write(String.format("Rate per Hour: %.2f\n", rate));
            writer.write(String.format("Net Salary (after 10%% tax): %.2f\n", netSalary));
            System.out.println("payslip saved to " + filename);
        } catch (IOException e) {
            System.out.println("error saving payslip: " + e.getMessage());
        }
    }
}

// part time employee employee subclass
class PartTimeEmployee extends Employee implements Payable, Printable {
    private double rate;
    private double hours;

    public PartTimeEmployee(String name, String id, String department, double rate, double hours) {
        super(name, id, "part-time", department);
        this.rate = rate;
        this.hours = hours;
    }

    // compute gross salary and deduct 5% tax
    public double computeSalary() {
        if (rate < 0 || hours < 0) {
            throw new IllegalArgumentException("rate and hour must be non-negative");
        }
        double gross = rate * hours;
        return gross * 0.95; //deduct 5% tax
    }

    // save payslip to text .txt file
    public void generatePayslip() {
        double netSalary = computeSalary();
        String filename = id + "_payslip.txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Payslip for " + name + "\n");
            writer.write("Employee ID: " + id + "\n");
            writer.write("Role: " + role + "\n");
            writer.write("Department: " + department + "\n");
            writer.write(String.format("Hours Worked: %.2f\n", hours));
            writer.write(String.format("Rate per Hour: %.2f\n", rate));
            writer.write(String.format("Net Salary (after 5%% tax): %.2f\n", netSalary));
            System.out.println("payslip saved to " + filename);
        } catch (IOException e) {
            System.out.println("error saving payslip: " + e.getMessage());
        }
    }
}

// main class
public class EmployeePayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("choose employee type:");
        System.out.println("1 - full-time");
        System.out.println("2 - part-time");
        int choice = scanner.nextInt();
        scanner.nextLine(); //consume newline

        System.out.print("enter name: ");
        String name = scanner.nextLine();

        System.out.print("enter employee id: ");
        String id = scanner.nextLine();

        System.out.print("enter department: ");
        String department = scanner.nextLine();

        System.out.print("enter hourly rate: ");
        double rate = scanner.nextDouble();

        System.out.print("enter hours worked: ");
        double hours = scanner.nextDouble();

        try {
            if (choice == 1) {
                FullTimeEmployee ft = new FullTimeEmployee(name, id, department, rate, hours);
                double netSalary = ft.computeSalary();
                System.out.printf("net salary: %.2f\n", netSalary);
                ft.generatePayslip();
            } else if (choice == 2) {
                PartTimeEmployee pt = new PartTimeEmployee(name, id, department, rate, hours);
                double netSalary = pt.computeSalary();
                System.out.printf("net salary: %.2f\n", netSalary);
                pt.generatePayslip();
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("error: " + e.getMessage());
        }

        scanner.close();
    }
}