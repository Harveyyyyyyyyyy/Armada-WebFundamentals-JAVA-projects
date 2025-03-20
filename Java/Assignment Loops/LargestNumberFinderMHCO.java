import java.util.Scanner;

public class LargestNumberFinderMHCO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number (-1 to stop): ");
        int number = scanner.nextInt();
        int largest = Integer.MIN_VALUE;

        while (number != -1) {
            if (number > largest) {
                largest = number;
            }

            System.out.print("Enter a number (-1 to stop): ");
            number = scanner.nextInt();
        }

        if (largest == Integer.MIN_VALUE) {
            System.out.println("No numbers were entered.");
        } else {
            System.out.println("The largest number entered is: " + largest);
        }

        scanner.close();
    }
}