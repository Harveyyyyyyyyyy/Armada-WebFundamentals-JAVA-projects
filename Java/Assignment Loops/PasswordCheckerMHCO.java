import java.util.Scanner;

public class PasswordCheckerMHCO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = "java123";
        boolean correctPassword = true;

        do {
            System.out.print("Enter password: ");
            String ps = scanner.nextLine();

            if (ps.equals(password)) {
                System.out.println("Access granted!");
                correctPassword = true;
            } else {
                System.out.println("Incorrect password. Try again.");
            }
        } while (!correctPassword);

        scanner.close();
    }
}