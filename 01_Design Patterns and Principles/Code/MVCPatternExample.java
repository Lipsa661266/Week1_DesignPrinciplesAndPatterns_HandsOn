// Step 2: Model Class
class Student {
    private String id;
    private String name;
    private String grade;

    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getters and Setters
    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getGrade() { return grade; }

    public void setGrade(String grade) { this.grade = grade; }
}

// Step 3: View Class
class StudentView {
    public void displayStudentDetails(String id, String name, String grade) {
        System.out.println("Student Details:");
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Grade : " + grade);
        System.out.println();
    }
}

// Step 4: Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    // Controller methods
    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public void updateView() {
        view.displayStudentDetails(model.getId(), model.getName(), model.getGrade());
    }
}

// Step 5: Main Class to Test MVC
public class MVCPatternExample {
    public static void main(String[] args) {
        // Creating Model
        Student student = new Student("101", "Parbati Mohanty", "A");

        // Creating View
        StudentView view = new StudentView();

        // Creating Controller
        StudentController controller = new StudentController(student, view);

        // Display original student data
        controller.updateView();

        // Update model data using controller
        controller.setStudentName("Soumya Mohanty");
        controller.setStudentGrade("A+");

        // Display updated data
        controller.updateView();
    }
}
