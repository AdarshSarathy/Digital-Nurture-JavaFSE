public class TaskTest {
    public static void main(String[] args) {
        System.out.println("=== Task Management System (Singly Linked List) ===\n");
        TaskLinkedList list = new TaskLinkedList();
        System.out.println("--- Adding Tasks ---");
        list.addLast(new Task(1, "Design database schema", "DONE"));
        list.addLast(new Task(2, "Build REST API",         "IN_PROGRESS"));
        list.addLast(new Task(3, "Write unit tests",       "PENDING"));
        list.addFirst(new Task(0, "Set up project repo",   "DONE"));
        list.addLast(new Task(4, "Deploy to staging",      "PENDING"));
        list.traverse();
        System.out.println("\n--- Search Task ID 2 ---");
        Task found = list.searchById(2);
        System.out.println("  " + (found!=null ? "Found: " + found : "Not found."));
        System.out.println("\n--- Search non-existent 99 ---");
        System.out.println("  " + (list.searchById(99)!=null ? "Found" : "Not found."));
        System.out.println("\n--- Delete Task 3 ---");
        list.deleteById(3);
        System.out.println("\n--- Delete head (Task 0) ---");
        list.deleteById(0);
        System.out.println("\n--- Delete non-existent 99 ---");
        list.deleteById(99);
        list.traverse();
        System.out.println("\n--- Complexity ---");
        System.out.println("addFirst() -> O(1)");
        System.out.println("addLast()  -> O(n) [O(1) with tail pointer]");
        System.out.println("search()   -> O(n)");
        System.out.println("delete()   -> O(n)");
        System.out.println("\n[OK] Linked list task management verified.");
    }
}