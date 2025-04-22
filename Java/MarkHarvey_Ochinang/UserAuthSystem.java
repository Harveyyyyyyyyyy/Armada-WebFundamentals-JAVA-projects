import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserAuthSystem {
    private static final String RECORDS_FILE = "records.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose an option: Register or Login: ");
        String option = scanner.nextLine().trim();

        if (option.equalsIgnoreCase("Register")) {
            register(scanner);
        } else if (option.equalsIgnoreCase("Login")) {
            login(scanner);
        } else {
            System.out.println("Invalid option");
        }
        scanner.close();
    }

    private static void register(Scanner scanner) {
        System.out.print("Enter username (alphanumeric only): ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter password (alphanumeric only): ");
        String password = scanner.nextLine().trim();

        if (!isAlphanumeric(username) || !isAlphanumeric(password)) {
            System.out.println("Username and password must be alphanumeric only.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RECORDS_FILE, true))) {
            writer.write(username + ":" + password);
            writer.newLine();
            System.out.println("Registration successful.");
        } catch (IOException e) {
            System.out.println("Error writing to records file.");
        }
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        try (BufferedReader reader = new BufferedReader(new FileReader(RECORDS_FILE))) {
            String line;
            boolean success = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    success = true;
                    break;
                }
            }
            if (success) {
                System.out.println("Successfully logged in");
            } else {
                System.out.println("Incorrect username or password");
            }
        } catch (IOException e) {
            System.out.println("Error reading records file.");
        }
    }

    private static boolean isAlphanumeric(String s) {
        return Pattern.matches("[a-zA-Z0-9]+", s);
    }
}