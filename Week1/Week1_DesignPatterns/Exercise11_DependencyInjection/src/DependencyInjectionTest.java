public class DependencyInjectionTest {
    public static void main(String[] args) {
        System.out.println("=== Dependency Injection Test ===\n");
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        service.addCustomer(new Customer("C001", "Alice Johnson", "alice@example.com"));
        service.addCustomer(new Customer("C002", "Bob Smith",     "bob@example.com"));
        service.addCustomer(new Customer("C003", "Carol Williams","carol@example.com"));
        System.out.println("\n-- Find C002 --");
        Customer found = service.getCustomer("C002");
        System.out.println(found != null ? "Found: " + found : "Not found");
        System.out.println("\n-- All customers --");
        for (Customer c : service.getAllCustomers()) System.out.println("  " + c);
        System.out.println("\n-- Delete C001 --");
        service.removeCustomer("C001");
        System.out.println("\n-- All after delete --");
        for (Customer c : service.getAllCustomers()) System.out.println("  " + c);
        System.out.println("\n[OK] Dependency Injection (Constructor Injection) verified.");
    }
}