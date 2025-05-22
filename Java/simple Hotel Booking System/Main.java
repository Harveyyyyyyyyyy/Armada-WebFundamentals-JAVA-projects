import java.util.*;

// abstract room class
abstract class Room {
    private String roomType;
    private double price;
    private boolean isAvailable;

    public Room(String roomType, double price) {
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        isAvailable = false;
    }

    public void releaseRoom() {
        isAvailable = true;
    }

    public abstract String getDescription();
}

// subclasses of Room
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single", 15000.0);
    }

    @Override
    public String getDescription() {
        return "Single Room with 1 bed.";
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double", 20000.0);
    }

    @Override
    public String getDescription() {
        return "Double Room with 2 beds.";
    }
}

class Suite extends Room {
    public Suite() {
        super("Suite", 30000.0);
    }

    @Override
    public String getDescription() {
        return "Luxury Suite.";
    }
}

// customer class
class Customer {
    private String name;
    private String email;
    private String membershipStatus;

    public Customer(String name, String email, String membershipStatus) {
        this.name = name;
        this.email = email;
        this.membershipStatus = membershipStatus;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }
}

// reservation class
class Reservation {
    private Room room;
    private Customer customer;
    private String checkInDate;
    private String checkOutDate;
    private double totalPrice;

    public Reservation(Room room, Customer customer, String checkInDate, String checkOutDate) {
        this.room = room;
        this.customer = customer;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = room.getPrice();
    }

    public void applyDiscount() {
        String status = customer.getMembershipStatus();
        if (status.equalsIgnoreCase("Gold")) {
            totalPrice *= 0.8; // 20% discount
        } else if (status.equalsIgnoreCase("Silver")) {
            totalPrice *= 0.9; // 10% discount
        }
    }

    public void displayReservationDetails() {
        System.out.println("\n--- Reservation Summary ---");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Membership: " + customer.getMembershipStatus());
        System.out.println("Room Type: " + room.getRoomType());
        System.out.println("Check-in Date: " + checkInDate);
        System.out.println("Check-out Date: " + checkOutDate);
        System.out.println("Total Price: P" + totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

// payment class
class Payment {
    private double amount;
    private String paymentMethod;
    private String creditCardNumber;

    public Payment(double amount, String paymentMethod, String creditCardNumber) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.creditCardNumber = creditCardNumber;
    }

    public void processPayment() {
        System.out.println("\nProcessing payment of P" + amount + " via " + paymentMethod);
        if (paymentMethod.equalsIgnoreCase("Credit Card")) {
            System.out.println("Credit Card Number: " + maskCreditCard());
        }
        System.out.println("Payment Successful!");
    }

    private String maskCreditCard() {
        if (creditCardNumber.length() >= 4) {
            return "**** **** **** " + creditCardNumber.substring(creditCardNumber.length() - 4);
        } else {
            return "Invalid Card";
        }
    }
}

// custom Exception
class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}

// main class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Room> rooms = new ArrayList<>();
        rooms.add(new SingleRoom());
        rooms.add(new DoubleRoom());
        rooms.add(new Suite());

        System.out.println("Welcome to the Hotel Booking System!");

        // display available rooms
        System.out.println("\nAvailable Rooms:");
        int index = 1;
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(index + ". " + room.getDescription() + " - P" + room.getPrice());
            }
            index++;
        }

        try {
            // customer Information
            System.out.print("\nEnter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            System.out.print("Enter membership status (Gold/Silver/Regular): ");
            String membership = scanner.nextLine();

            Customer customer = new Customer(name, email, membership);

            // room selection
            System.out.print("Select a room number: ");
            int roomChoice = scanner.nextInt();
            scanner.nextLine();

            if (roomChoice < 1 || roomChoice > rooms.size()) {
                System.out.println("Invalid room selection.");
                return;
            }

            Room selectedRoom = rooms.get(roomChoice - 1);
            if (!selectedRoom.isAvailable()) {
                System.out.println("Sorry, that room is not available.");
                return;
            }

            // dates
            System.out.print("Enter check-in date (YYYY-MM-DD): ");
            String checkInDate = scanner.nextLine();
            System.out.print("Enter check-out date (YYYY-MM-DD): ");
            String checkOutDate = scanner.nextLine();

            // simple date validation
            if (checkInDate.compareTo(checkOutDate) >= 0) {
                throw new InvalidDateException("Check-in date must be before check-out date.");
            }

            // book the room
            selectedRoom.bookRoom();

            // create reservation
            Reservation reservation = new Reservation(selectedRoom, customer, checkInDate, checkOutDate);
            reservation.applyDiscount();
            reservation.displayReservationDetails();

            // payment
            System.out.print("\nChoose payment method (Cash/Credit Card): ");
            String paymentMethod = scanner.nextLine();
            String creditCardNumber = "";

            if (paymentMethod.equalsIgnoreCase("Credit Card")) {
                System.out.print("Enter credit card number: ");
                creditCardNumber = scanner.nextLine();
            }

            Payment payment = new Payment(reservation.getTotalPrice(), paymentMethod, creditCardNumber);
            payment.processPayment();

        } catch (InvalidDateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please restart the booking process.");
        } finally {
            scanner.close();
        }
    }
}