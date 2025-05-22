import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // takes a paragraph as input from the user.
        System.out.print("Enter a paragraph: ");
        String paragraph = scanner.nextLine();

        // counts and displays the number of words in the paragraph.
        String[] words = paragraph.trim().split("\\s+");
        int wordCount = words.length;

        // remove extra spaces between words
        String cleanedParagraph = String.join(" ", words);

        // replace occurrences of "Java" with "Python"
        String modifiedParagraph = cleanedParagraph.replace("Java", "Python");

        // Step 5: Display results
        System.out.println("Word Count: " + wordCount);
        System.out.println("Modified Paragraph: " + modifiedParagraph);

        scanner.close();
    }
}