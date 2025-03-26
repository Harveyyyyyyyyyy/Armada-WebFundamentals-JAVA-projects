class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {
    String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayGrade() {
        System.out.println("Grade: " + grade);
    }
}

public class Main {

    public static void main(String[] args) {
        Student student = new Student("Alice", 20, "A");
        student.displayInfo();
        student.displayGrade();
    }
}