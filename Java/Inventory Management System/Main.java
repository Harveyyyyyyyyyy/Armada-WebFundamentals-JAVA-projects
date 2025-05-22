import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private Map<Integer, String> inventory;
    private Scanner scanner;

    public Main() {
        this.inventory = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProductName();
                    break;
                case 3:
                    findProductById();
                    break;
                case 4:
                    removeProduct();
                    break;
                case 5:
                    displayInventory();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n1. Add Product");
        System.out.println("2. Update Product Name");
        System.out.println("3. Find Product by ID");
        System.out.println("4. Remove Product");
        System.out.println("5. Display Inventory");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void addProduct() {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        if (inventory.containsKey(productId)) {
            System.out.println("Product ID already exists. Please choose another ID.");
            return;
        }

        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();

        inventory.put(productId, productName);
        System.out.println("Product added!");
    }

    private void updateProductName() {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        if (!inventory.containsKey(productId)) {
            System.out.println("Product not found. Please add the product first.");
            return;
        }

        System.out.print("Enter new Product Name: ");
        String newProductName = scanner.nextLine();

        inventory.put(productId, newProductName);
        System.out.println("Product updated!");
    }

    private void findProductById() {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        if (!inventory.containsKey(productId)) {
            System.out.println("Product not found.");
            return;
        }

        String productName = inventory.get(productId);
        System.out.println("Product Found: " + productName);
    }

    private void removeProduct() {
        System.out.print("Enter Product ID to remove: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        if (!inventory.containsKey(productId)) {
            System.out.println("Product not found.");
            return;
        }

        inventory.remove(productId);
        System.out.println("Product removed!");
    }

    private void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("Current Inventory:");
        for (Map.Entry<Integer, String> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Main inventorySystem = new Main();
        inventorySystem.run();
    }
}