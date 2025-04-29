import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// book class
class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrowBook() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException("Book is not available for borrowing.");
        }
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return title + " (ISBN: " + isbn + ")";
    }
}

// library member class
class LibraryMember {
    private String name;
    private String memberId;
    private String membershipType;

    public LibraryMember(String name, String memberId, String membershipType) {
        this.name = name;
        this.memberId = memberId;
        this.membershipType = membershipType;
    }

    public String getMembershipType() {
        return membershipType;
    }
}

// transaction class
class Transaction {
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Transaction(Book book, LocalDate borrowDate) {
        this.book = book;
        this.borrowDate = borrowDate;
    }

    public double calculateFine(FineCalculator fineCalculator, LocalDate returnDate) throws InvalidDateException {
        if (returnDate.isBefore(borrowDate)) {
            throw new InvalidDateException("Return date cannot be before borrow date.");
        }
        this.returnDate = returnDate;
        return fineCalculator.calculateFine(borrowDate, returnDate);
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    
}

// fine calculator interface
interface FineCalculator {
    double calculateFine(LocalDate borrowDate, LocalDate returnDate);
}

// regular fine calculator class
class RegularFineCalculator implements FineCalculator {
    @Override
    public double calculateFine(LocalDate borrowDate, LocalDate returnDate) {
        long daysBetween = ChronoUnit.DAYS.between(borrowDate, returnDate);
        if (daysBetween > 7) {
            return (daysBetween - 7) * 10;
        }
        return 0;
    }
}

// premium fine calculator class
class PremiumFineCalculator implements FineCalculator {
    @Override
    public double calculateFine(LocalDate borrowDate, LocalDate returnDate) {
        long daysBetween = ChronoUnit.DAYS.between(borrowDate, returnDate);
        if (daysBetween > 14) {
            return (daysBetween - 14) * 5;
        }
        return 0;
    }
}

// custom exception for book not available
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// custom exception for invalid date
class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}

// main class
public class LibraryManagementSystem {
    private static List<Book> books = new ArrayList<>();
    private static List<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        // adding some sample books
        books.add(new Book("Java Programming", "John Doe", "123456"));
        books.add(new Book("OOP Design", "Jane Smith", "789101"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to laguna city library!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your member id: ");
        String memberId = scanner.nextLine();
        System.out.print("Membership type (regular/premium): ");
        String membershipType = scanner.nextLine();

        LibraryMember member = new LibraryMember(name, memberId, membershipType);

        // showing available books
        System.out.println("\nAvailable books:");
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isAvailable()) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }

        System.out.print("\nChoose a book to borrow (number): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        try {
            Book selectedBook = books.get(choice - 1);
            selectedBook.borrowBook();
            LocalDate borrowDate = LocalDate.now();
            transactions.add(new Transaction(selectedBook, borrowDate));
            System.out.println("\nBook \"" + selectedBook.getTitle() + "\" successfully borrowed on " + borrowDate + ".");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid book choice.");
            return;
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
            return;
        }

        // returning the book
        System.out.println("\n-- Returning the book --");
        System.out.print("Enter return date (yyyy-mm-dd): ");
        String returnDateString = scanner.nextLine();
        LocalDate returnDate = LocalDate.parse(returnDateString);

        Transaction transaction = transactions.get(transactions.size() - 1);
        Book bookToReturn = transaction.getBook();

        try {
            FineCalculator fineCalculator;
            if (member.getMembershipType().equalsIgnoreCase("Regular")) {
                fineCalculator = new RegularFineCalculator();
            } else {
                fineCalculator = new PremiumFineCalculator();
            }

            double fine = transaction.calculateFine(fineCalculator, returnDate);
            bookToReturn.returnBook();

            long overdueDays = ChronoUnit.DAYS.between(transaction.getBorrowDate().plusDays(
                    member.getMembershipType().equalsIgnoreCase("Regular") ? 7 : 14), returnDate);

            overdueDays = Math.max(overdueDays, 0);

            if (fine > 0) {
                System.out.println("returned. overdue by " + overdueDays + " day(s). fine: ₱" + (int) fine + ". thank you!");
            } else {
                System.out.println("Returned on time. no fine. thank you!");
            }

        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
        }
    }
}