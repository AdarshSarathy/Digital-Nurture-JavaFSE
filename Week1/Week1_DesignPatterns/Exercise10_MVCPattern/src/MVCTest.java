public class MVCTest {
    public static void main(String[] args) {
        System.out.println("=== MVC Pattern Test ===\n");
        Student model = new Student("S001", "Alice Johnson", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        System.out.println("-- Initial State --");
        controller.updateView();
        System.out.println("\n-- After update --");
        controller.setStudentName("Alice J. Smith");
        controller.setGrade("A+");
        controller.updateView();
        System.out.println("\n[OK] MVC pattern verified.");
    }
}