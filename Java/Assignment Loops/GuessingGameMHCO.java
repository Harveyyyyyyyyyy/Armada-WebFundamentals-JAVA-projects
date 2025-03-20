import java.util.Random;
import java.util.Scanner;

public class GuessingGameMHCO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(50) + 1;
        int attempts = 0;

        while (true) {
            System.out.print("Guess a number between 1 and 50: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                break;
            }
        }

        scanner.close();
    }
}