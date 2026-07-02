public class SortingTest {
    public static void main(String[] args) {
        System.out.println("=== Sorting Customer Orders ===\n");
        Order[] orders = {
            new Order("ORD-001", "Alice Johnson",     450.00),
            new Order("ORD-002", "Bob Smith",        1200.50),
            new Order("ORD-003", "Carol Williams",     89.99),
            new Order("ORD-004", "Diana Prince",     3500.00),
            new Order("ORD-005", "Eve Davis",         220.75),
            new Order("ORD-006", "Frank Miller",      750.00),
            new Order("ORD-007", "Grace Lee",          55.00),
            new Order("ORD-008", "Henry Wilson",     2100.00),
        };
        System.out.println("--- Original (unsorted) ---");
        OrderSorter.printOrders(orders);
        System.out.println("\n--- Bubble Sort (by totalPrice ascending) ---");
        long t1 = System.nanoTime();
        Order[] bubble = OrderSorter.bubbleSort(orders);
        long t2 = System.nanoTime();
        OrderSorter.printOrders(bubble);
        System.out.println("  Time: " + (t2-t1) + " ns");
        System.out.println("\n--- Quick Sort (by totalPrice ascending) ---");
        long t3 = System.nanoTime();
        Order[] quick = OrderSorter.quickSort(orders);
        long t4 = System.nanoTime();
        OrderSorter.printOrders(quick);
        System.out.println("  Time: " + (t4-t3) + " ns");
        System.out.println("\n--- Complexity ---");
        System.out.println("Bubble: O(n^2) worst/avg | O(n) best");
        System.out.println("Quick : O(n log n) avg   | O(n^2) worst (rare)");
        System.out.println("\n[OK] Sorting complete.");
    }
}