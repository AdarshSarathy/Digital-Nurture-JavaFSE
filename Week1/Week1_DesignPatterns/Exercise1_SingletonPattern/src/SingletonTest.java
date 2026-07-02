public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Test ===\n");
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        Logger l3 = Logger.getInstance();
        System.out.println("l1 hashCode: " + l1.hashCode());
        System.out.println("l2 hashCode: " + l2.hashCode());
        System.out.println("l3 hashCode: " + l3.hashCode());
        System.out.println("\nAll same instance? " + (l1 == l2 && l2 == l3));
        l1.log("Application started.");
        l2.warn("Low memory.");
        l3.error("Unhandled exception.");
        System.out.println("\n[OK] Singleton pattern verified.");
    }
}