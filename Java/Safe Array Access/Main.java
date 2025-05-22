import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int[] array = { 10, 20, 30, 40, 50 };

            System.out.print("Enter an index (0-4): ");
            int index = scanner.nextInt();
            System.out.println(array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index. Please enter a number between 0 and 4.");
        }
    }
}