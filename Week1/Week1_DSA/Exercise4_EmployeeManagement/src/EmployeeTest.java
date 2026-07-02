public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("=== Employee Management System (Array-based) ===\n");
        EmployeeArray empArray = new EmployeeArray(10);
        System.out.println("--- Adding Employees ---");
        empArray.addEmployee(new Employee(1001, "Alice Johnson",  "Manager",   85000));
        empArray.addEmployee(new Employee(1002, "Bob Smith",      "Developer", 72000));
        empArray.addEmployee(new Employee(1003, "Carol Williams", "Designer",  68000));
        empArray.addEmployee(new Employee(1004, "Diana Prince",   "Analyst",   74000));
        empArray.addEmployee(new Employee(1005, "Ethan Hunt",     "DevOps",    78000));
        empArray.traverse();
        System.out.println("\n--- Search ID 1003 ---");
        Employee found = empArray.getById(1003);
        if (found != null) System.out.println("  Found: " + found);
        System.out.println("\n--- Search non-existent 9999 ---");
        System.out.println("  Result: " + (empArray.getById(9999) == null ? "Not found." : ""));
        System.out.println("\n--- Delete 1002 ---");
        empArray.deleteEmployee(1002);
        System.out.println("\n--- Delete non-existent 9999 ---");
        empArray.deleteEmployee(9999);
        empArray.traverse();
        System.out.println("\n--- Complexity ---");
        System.out.println("add()      -> O(1)  -- append to next slot");
        System.out.println("search()   -> O(n)  -- linear scan");
        System.out.println("traverse() -> O(n)  -- visit every element");
        System.out.println("delete()   -> O(n)  -- search + left-shift");
        System.out.println("\n[OK] Employee array management verified.");
    }
}