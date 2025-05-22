import java.util.Scanner;
import java.util.Arrays;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String[] transactionHistory;
    private double interestRate;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        setAccountNumber(accountNumber);
        setAccountHolder(accountHolder);
        setBalance(initialBalance);
        this.transactionHistory = new String[0];
        this.interestRate = 5.0; // default 5% annual interest
        addTransaction("Deposit " + formatAmount(initialBalance));
    }

    private String formatAmount(double amount) {
        if (amount == (long) amount) {
            return String.format("$%d", (long) amount);
        }
        return String.format("$%.2f", amount);
    }

    private void addTransaction(String transaction) {
        transactionHistory = Arrays.copyOf(transactionHistory, transactionHistory.length + 1);
        transactionHistory[transactionHistory.length - 1] = transaction;
    }

    // setters with validation
    public void setAccountNumber(String accountNumber) {
        if (!accountNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Account number must be exactly 10 digits");
        }
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        this.balance = balance;
    }

    // transaction methods
    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
        addTransaction("Deposit " + formatAmount(amount));
    }

    public void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (amount > balance)
            throw new IllegalArgumentException("Insufficient funds.");
        balance -= amount;
        addTransaction("Withdrawal " + formatAmount(amount));
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        addTransaction("Interest Applied: " + formatAmount(interest));
    }

    // getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public String[] getTransactionHistory() {
        return transactionHistory.clone();
    }

    public double getInterestRate() {
        return interestRate;
    }
}

public class BankingSystem {
    private static String formatBalance(double balance) {
        if (balance == (long) balance) {
            return String.format("$%d", (long) balance);
        }
        return String.format("$%.2f", balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\nWelcome to the Secure Banking System\n");
            System.out.println("1. Create Account");
            System.out.println("2. View Account Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Apply Interest");
            System.out.println("6. View Transaction History");
            System.out.println("7. Exit");
            System.out.print("\nEnter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        if (account != null) {
                            System.out.println("Account already exists!");
                            break;
                        }
                        System.out.print("Enter Account Number (10 digits): ");
                        String accNumber = scanner.nextLine();
                        System.out.print("Enter Account Holder Name: ");
                        String accHolder = scanner.nextLine();
                        System.out.print("Enter Initial Deposit: ");
                        double initial = Double.parseDouble(scanner.nextLine());

                        account = new BankAccount(accNumber, accHolder, initial);
                        System.out.println("Account created successfully!");
                        break;

                    case 2:
                        if (account == null) {
                            System.out.println("No account found!");
                            break;
                        }
                        System.out.println("\n--- Account Details ---");
                        System.out.println("Account Number: " + account.getAccountNumber());
                        System.out.println("Account Holder: " + account.getAccountHolder());
                        System.out.println("Balance: " + formatBalance(account.getBalance()));
                        break;

                    case 3:
                        if (account == null) {
                            System.out.println("No account found!");
                            break;
                        }
                        System.out.print("Enter deposit amount: ");
                        double deposit = Double.parseDouble(scanner.nextLine());
                        try {
                            account.deposit(deposit);
                            System.out.println("Deposit successful. New Balance: " +
                                    formatBalance(account.getBalance()));
                            String[] depositHistory = account.getTransactionHistory();
                            System.out.println("Transaction recorded: " +
                                    depositHistory[depositHistory.length - 1]);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 4:
                        if (account == null) {
                            System.out.println("No account found!");
                            break;
                        }
                        System.out.print("Enter withdrawal amount: ");
                        double withdraw = Double.parseDouble(scanner.nextLine());
                        try {
                            account.withdraw(withdraw);
                            System.out.println("Withdrawal successful. New Balance: " +
                                    formatBalance(account.getBalance()));
                            String[] withdrawHistory = account.getTransactionHistory();
                            System.out.println("Transaction recorded: " +
                                    withdrawHistory[withdrawHistory.length - 1]);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 5:
                        if (account == null) {
                            System.out.println("No account found!");
                            break;
                        }
                        account.applyInterest();
                        System.out.printf("Interest applied. New Balance: %s (Interest Rate: %.0f%% annual)%n",
                                formatBalance(account.getBalance()), account.getInterestRate());
                        break;

                    case 6:
                        if (account == null) {
                            System.out.println("No account found!");
                            break;
                        }
                        System.out.println("\n--- Transaction History ---");
                        String[] history = account.getTransactionHistory();
                        for (String t : history)
                            System.out.println("- " + t);
                        break;

                    case 7:
                        System.out.println("Exiting program...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numbers only.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}