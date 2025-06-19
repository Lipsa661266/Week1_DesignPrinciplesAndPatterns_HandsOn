import java.util.*;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return productId + " | " + productName + " | Qty: " + quantity + " | Price: " + price;
    }
}

public class InventorySystem {
    private Map<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product p) {
        inventory.put(p.productId, p);
    }

    public void updateProduct(int productId, int quantity, double price) {
        if (inventory.containsKey(productId)) {
            Product p = inventory.get(productId);
            p.quantity = quantity;
            p.price = price;
        } else {
            System.out.println("Product not found!");
        }
    }

    public void deleteProduct(int productId) {
        inventory.remove(productId);
    }

    public void showInventory() {
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InventorySystem system = new InventorySystem();

        system.addProduct(new Product(101, "Laptop", 5, 80000));
        system.addProduct(new Product(102, "Monitor", 10, 15000));

        System.out.println("Initial Inventory:");
        system.showInventory();

        system.updateProduct(101, 6, 82000);
        System.out.println("\nAfter Update:");
        system.showInventory();

        system.deleteProduct(102);
        System.out.println("\nAfter Deletion:");
        system.showInventory();
    }
}
