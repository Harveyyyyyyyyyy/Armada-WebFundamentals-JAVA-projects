import java.lang.Math;

interface Shape {
    double area();
}

class Circle implements Shape {
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class Rectangle implements Shape {
    public double width;
    public double height;

    public Rectangle (double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double area() {
        return width * height;
    }
}

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.printf("Area of Circle: %.5f", circle.area());

        Rectangle rectangle = new Rectangle(10, 5);
        System.out.println("\nArea of Rectangle: " + rectangle.area());
    }
}