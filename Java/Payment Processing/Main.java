import java.util.Scanner;

interface PaymentMethod {
    void processPayment(double amount);
}

class CreditCard implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.printf("Processing credit card payment of $ %.1f", amount);
    }
}

class PayPal implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.printf("Processing PayPal payment of $%.2f", amount);
    }
}

class CryptopWallet implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.printf("Processing cryptocurrency payment of $%.2f", amount);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Choose payment method (1: Credit Card, 2: PayPal 3: CryptoWallet): ");
        int choice = scanner.nextInt();

        PaymentMethod paymentMethod;

        if (choice == 1) {
            paymentMethod = new CreditCard();
            paymentMethod.processPayment(100.0);
        } else if (choice == 2) {
            paymentMethod = new PayPal();
            paymentMethod.processPayment(250.50);
        } else if (choice == 3) {
            paymentMethod = new CryptopWallet();
            paymentMethod.processPayment(350.50);
        }

        scanner.close();
    }
}