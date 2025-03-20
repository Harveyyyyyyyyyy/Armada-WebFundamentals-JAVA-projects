import java.util.Scanner;

public class ElectricityBillMHCO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of units consumed: ");
        int unitsConsumed = scanner.nextInt();

        double totalBill = calculateBill(unitsConsumed);

        System.out.println("Your total electricity bill is: " + String.format("%.1f", totalBill));

        scanner.close();
    }

    public static double calculateBill(int units) {
        double bill = 0.0;

        if (units <= 100) {
            bill = units * 1.50;
        } else if (units <= 300) {
            bill = (100 * 1.50) + ((units - 100) * 2.50);
        } else {
            bill = (100 * 1.50) + (200 * 2.50) + ((units - 300) * 3.50);
        }

        return bill;
    }
}
