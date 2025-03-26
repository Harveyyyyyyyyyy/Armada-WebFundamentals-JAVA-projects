class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Introducing Person: ");
        System.out.println(getDetails());
    }

    protected String getDetails() {
        return "Name: " + name + ", Age: " + age;
    }

}

class Employee extends Person {
    protected String jobTitle;

    public Employee(String name, int age, String jobTitle) {
        super(name, age);
        this.jobTitle = jobTitle;
    }

    public void introduce() {
        System.out.println("\nIntroducing Employee: ");
        System.out.println(getDetails());
    }

    protected String getDetails() {
        return super.getDetails() + ", Job Title: " + jobTitle;
    }
}

class Manager extends Employee {
    protected String department;

    public Manager(String name, int age, String jobTitle, String department) {
        super(name, age, jobTitle);
        this.department = department;
    }

    public void introduce() {
        System.out.println("\nIntroducing Manager: ");
        System.out.println(getDetails());
    }

    protected String getDetails() {
        return super.getDetails() + ", Department: " + department;
    }
}

class Executive extends Manager {
    protected String CompanyCar;

    public Executive(String name, int age, String jobTitle, String department, String CompanyCar) {
        super(name, age, jobTitle, department);
        this.CompanyCar = CompanyCar;
    }

    public void introduce() {
        System.out.println("\nIntroducing Executive: ");
        System.out.println(getDetails());
    }

    protected String getDetails() {
        return super.getDetails() + ", Company Car: " + CompanyCar;
    }
}

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        Employee employee = new Employee("Bob", 35, "Software Engineer");
        Manager manager = new Manager("Charlie", 40, "Project Manager", "IT");
        Executive executive = new Executive("Dave", 45, "Senior Executive", "Finance", "BMW X5");

        person.introduce();
        employee.introduce();
        manager.introduce();
        executive.introduce();
    }
}