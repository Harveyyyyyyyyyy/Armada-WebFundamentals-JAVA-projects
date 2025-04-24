import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserAuthSystem {
    // File to store user records (username:password)
    private static final String RECORDS_FILE = "records.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to choose between Register or Login
        System.out.print("Choose an option: Register or Login: ");
        String option = scanner.nextLine().trim();

        // Call the appropriate method based on user choice
        if (option.equalsIgnoreCase("Register")) {
            register(scanner);
        } else if (option.equalsIgnoreCase("Login")) {
            login(scanner);
        } else {
            System.out.println("Invalid option");
        }

        scanner.close();
    }

    // Method to register a new user
    private static void register(Scanner scanner) {
        // Ask for username and password
        System.out.print("Enter username (alphanumeric only): ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter password (alphanumeric only): ");
        String password = scanner.nextLine().trim();

        // Check if both username and password contain only letters and numbers
        if (!isAlphanumeric(username) || !isAlphanumeric(password)) {
            System.out.println("Username and password must be alphanumeric only.");
            return; // Stop registration if invalid input
        }

        // Save the username and password to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RECORDS_FILE, true))) {
            writer.write(username + ":" + password); // Store as "username:password"
            writer.newLine();
            System.out.println("Registration successful.");
        } catch (IOException e) {
            System.out.println("Error writing to records file.");
        }
    }

    // Method to login an existing user
    private static void login(Scanner scanner) {
        // Ask for username and password
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        // Read the records file and check if username and password match any entry
        try (BufferedReader reader = new BufferedReader(new FileReader(RECORDS_FILE))) {
            String line;
            boolean success = false;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":"); // Split stored line by ":"
                // Check if username and password match
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

    // Helper method to check if a string contains only letters and numbers
    private static boolean isAlphanumeric(String s) {
        return Pattern.matches("[a-zA-Z0-9]+", s);
    }
}