import java.lang.Math;

abstract class Shape {
    public abstract double area();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double lenght;
    private double width;

    public Rectangle(double lenght, double width) {
        this.lenght = lenght;
        this.width = width;
    }

    public double area() {
        return width * lenght;
    }
}

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.format("Area of Circle: %.5f", circle.area());

        Rectangle rectangle = new Rectangle(10.0, 5.0);
        System.out.println("\nArea of Rectangle: " + rectangle.area());
    }
}