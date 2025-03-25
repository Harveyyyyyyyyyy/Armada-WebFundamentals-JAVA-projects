public class Employee {
    private String name;
    private int employeeID;
    private double salary;
    private String department;

    // Default constructor
    public Employee() {
        this.name = "";
        this.employeeID = 0;
        this.salary = 0.0;
        this.department = "";
    }

    // Parameterized constructor
    public Employee(String name, int employeeID, double salary, String department) {
        this.name = name;
        this.employeeID = employeeID;
        this.salary = salary;
        this.department = department;
    }

    // Display employee information
    public void displayInfo() {
        System.out.printf("Name: %s\nID: %d\nSalary: $%.2f\nDepartment: %s\n\n",
                name, employeeID, salary, department);
    }

    // Calculate annual salary
    public double calculateAnnualSalary() {
        return salary * 12;
    }

    // Raise salary by percentage
    public void raiseSalary(double percentage) {
        salary += salary * (percentage / 100);
    }

    // Getters
    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}