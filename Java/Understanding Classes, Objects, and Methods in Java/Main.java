class Car {
    String brand;
    int year;

    public void displayInfo(){
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }
}

public class Main {
    public static void main(String[] args) {
        Car mycar = new Car();
        mycar.brand = "Honda";
        mycar.year = 2002;
        mycar.displayInfo();
    }
}