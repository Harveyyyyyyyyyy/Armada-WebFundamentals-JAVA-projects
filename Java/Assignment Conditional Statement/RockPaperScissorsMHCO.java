import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsMHCO {
    public static void main(String[] args) {
        Random random = new Random();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your choice (R, P, S): ");
            String userChoice = scanner.next().toUpperCase();

            if (!isValidChoice(userChoice)) {
                System.out.println("Invalid choice. Please enter R, P, or S.");
                return;
            }

            String computerChoice = generateComputerChoice(random);

            System.out.println("Computer chose: " + computerChoice);

            determineWinner(userChoice, computerChoice);
        }
    }

    public static String generateComputerChoice(Random random) {
        String[] choices = { "R", "P", "S" };
        return choices[random.nextInt(choices.length)];
    }

    public static boolean isValidChoice(String choice) {
        return choice.equals("R") || choice.equals("P") || choice.equals("S");
    }

    public static void determineWinner(String userChoice, String computerChoice) {
        String result = "";
        String user = "You";
        String computer = "Computer";

        switch (userChoice + "," + computerChoice) {
            case "R,R":
            case "P,P":
            case "S,S":
                result = "It's a tie!";
                break;
            case "R,P":
            case "P,S":
            case "S,R":
                result = computer + " wins!";
                break;
            case "R,S":
            case "P,R":
            case "S,P":
                result = user + " win!";
                break;
        }

        System.out.println(result);
    }
}