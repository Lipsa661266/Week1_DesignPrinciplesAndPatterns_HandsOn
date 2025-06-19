import java.util.Scanner;

// Task class
class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public void display() {
        System.out.println("Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status);
    }
}

// Singly Linked List for Task Management
public class TaskManagementSystem {
    static Task head = null;

    // Add task at end
    public static void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
        System.out.println("Task added successfully.");
    }

    // Search task by ID
    public static void searchTask(int taskId) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == taskId) {
                System.out.println("Task found:");
                temp.display();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }

    // Traverse tasks
    public static void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        System.out.println("All Tasks:");
        Task temp = head;
        while (temp != null) {
            temp.display();
            temp = temp.next;
        }
    }

    // Delete task by ID
    public static void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }
        if (head.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Task current = head;
        Task prev = null;

        while (current != null && current.taskId != taskId) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task not found.");
        } else {
            prev.next = current.next;
            System.out.println("Task deleted successfully.");
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Task Management System ---");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Status: ");
                    String status = sc.nextLine();
                    addTask(id, name, status);
                    break;
                case 2:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = sc.nextInt();
                    searchTask(searchId);
                    break;
                case 3:
                    traverseTasks();
                    break;
                case 4:
                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = sc.nextInt();
                    deleteTask(deleteId);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
