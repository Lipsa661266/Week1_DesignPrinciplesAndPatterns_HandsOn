import java.util.*;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName='" + productName + '\'' + ", category='" + category + '\'' + '}';
    }
}

public class ECommerceSearch {

    // Linear Search
    public static Product linearSearch(List<Product> products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(List<Product> products, String targetName) {
        int left = 0, right = products.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products.get(mid).productName.compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(101, "Laptop", "Electronics"));
        products.add(new Product(102, "Phone", "Electronics"));
        products.add(new Product(103, "Shoes", "Fashion"));
        products.add(new Product(104, "Watch", "Accessories"));

        // Sort for Binary Search
        products.sort(Comparator.comparing(p -> p.productName.toLowerCase()));

        // Searching
        String searchItem = "Phone";

        // Linear Search
        Product linearResult = linearSearch(products, searchItem);
        System.out.println("Linear Search Result: " + (linearResult != null ? linearResult : "Not Found"));

        // Binary Search
        Product binaryResult = binarySearch(products, searchItem);
        System.out.println("Binary Search Result: " + (binaryResult != null ? binaryResult : "Not Found"));
    }
}