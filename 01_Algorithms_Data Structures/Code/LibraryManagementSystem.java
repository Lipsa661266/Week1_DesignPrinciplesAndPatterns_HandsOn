import java.util.Arrays;
import java.util.Scanner;

class Book implements Comparable<Book> {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title.toLowerCase(); // for case-insensitive search
        this.author = author;
    }

    public void display() {
        System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }

    // Required for sorting by title
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}

public class LibraryManagementSystem {
    static Book[] books = new Book[100];
    static int count = 0;

    // Add sample books
    public static void addSampleBooks() {
        books[count++] = new Book(1, "Data Structures", "Mark Allen");
        books[count++] = new Book(2, "Java Programming", "James Gosling");
        books[count++] = new Book(3, "Operating Systems", "Andrew Tanenbaum");
        books[count++] = new Book(4, "Computer Networks", "Forouzan");
        books[count++] = new Book(5, "Clean Code", "Robert C. Martin");
    }

    // Linear Search by title
    public static void linearSearch(String title) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                System.out.println("Book found (Linear Search):");
                books[i].display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found using Linear Search.");
        }
    }

    // Binary Search by title
    public static void binarySearch(String title) {
        // Sort the array before binary search
        Arrays.sort(books, 0, count);

        int low = 0, high = count - 1;
        title = title.toLowerCase();
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareTo(title);
            if (cmp == 0) {
                System.out.println("Book found (Binary Search):");
                books[mid].display();
                return;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Book not found using Binary Search.");
    }

    public static void main(String[] args) {
        addSampleBooks();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Search Book by Title (Linear Search)");
            System.out.println("2. Search Book by Title (Binary Search)");
            System.out.println("3. Display All Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title to search: ");
                    String title1 = sc.nextLine();
                    linearSearch(title1);
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    String title2 = sc.nextLine();
                    binarySearch(title2);
                    break;
                case 3:
                    System.out.println("Book List:");
                    for (int i = 0; i < count; i++) {
                        books[i].display();
                    }
                    break;
                case 4:
                    System.out.println("Exiting Program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();4
        
    }
}
