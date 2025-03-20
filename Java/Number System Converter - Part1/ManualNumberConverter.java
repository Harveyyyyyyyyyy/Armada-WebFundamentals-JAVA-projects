import java.util.Scanner;

public class ManualNumberConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        String binary = decimalToBase(decimal, 2);
        String octal = decimalToBase(decimal, 8);
        String hex = decimalToBase(decimal, 16);

        System.out.println("\n=== Number System Conversions ===");
        System.out.println("Binary: " + binary);
        System.out.println("Octal: " + octal);
        System.out.println("Hexadecimal: " + hex);

        scanner.close();
    }

    private static String decimalToBase(int n, int base) {
        if (n == 0)
            return "0";

        String result = "";
        while (n > 0) {
            int remainder = n % base;
            char digit = (base == 16 && remainder > 9) ? (char) ('A' + (remainder - 10)) : (char) ('0' + remainder);
            result = digit + result;
            n /= base;
        }
        return result;
    }
}