import java.util.*;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public void display() {
        System.out.println("Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: " + totalPrice);
    }
}

public class OrderSortDemo {

    // Bubble Sort Implementation
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort Implementation
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        // Sample data
        Order[] orders1 = {
            new Order(1, "Alice", 250.00),
            new Order(2, "Bob", 100.00),
            new Order(3, "Charlie", 450.50),
            new Order(4, "Diana", 300.00)
        };

        Order[] orders2 = {
            new Order(1, "Alice", 250.00),
            new Order(2, "Bob", 100.00),
            new Order(3, "Charlie", 450.50),
            new Order(4, "Diana", 300.00)
        };

        // Bubble Sort demonstration
        System.out.println("Orders sorted using Bubble Sort:");
        bubbleSort(orders1);
        for (Order order : orders1) {
            order.display();
        }

        // Quick Sort demonstration
        System.out.println("\nOrders sorted using Quick Sort:");
        quickSort(orders2, 0, orders2.length - 1);
        for (Order order : orders2) {
            order.display();
        }
    }
}
