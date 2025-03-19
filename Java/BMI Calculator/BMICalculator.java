import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter weight in (KG): ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height in (Meters): ");
        double height = scanner.nextDouble();

        double BMI = weight / (height * height);

        scanner.close();

        System.out.println("=== BMI Report ===");
        System.out.println("Your BMI: " + BMI);

        if (BMI < 18.5) {
            System.out.println("Health Status: Underweight");
        } else if (BMI >= 18.5 && BMI < 24.9) {
            System.out.println("Health Status: Normal");
        } else if (BMI >= 25 && BMI < 29.9) {
            System.out.println("Health Status: Overweight");
        } else if (BMI >= 30) {
            System.out.println("Health Status: Obese");
        }
    }
}