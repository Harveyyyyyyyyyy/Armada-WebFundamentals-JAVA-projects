import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String fullname = scanner.nextLine();

        // convert fullname to uppercase
        String upperCaseName = fullname.toUpperCase();

        // total characters excluding spaces
        int totalCharacters = fullname.replace(" ", "").length();

        // initials and convert them to uppercase
        String[] nameParts = fullname.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String part : nameParts) {
            if (!part.isEmpty()) {
                initials.append(Character.toUpperCase(part.charAt(0))).append(".");
            }
        }

        // display results
        System.out.println("Uppercase Name: " + upperCaseName);
        System.out.println("Total Characters (excluding spaces): " + totalCharacters);
        System.out.println("Initials: " + initials);

        scanner.close();
    }
}