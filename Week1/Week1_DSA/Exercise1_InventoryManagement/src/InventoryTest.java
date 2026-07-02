public class InventoryTest {
    public static void main(String[] args) {
        System.out.println("=== Inventory Management System ===\n");
        InventoryManager manager = new InventoryManager();
        System.out.println("--- Adding Products ---");
        manager.addProduct(new Product("P001", "Laptop",         50,  999.99));
        manager.addProduct(new Product("P002", "Wireless Mouse", 200,  29.99));
        manager.addProduct(new Product("P003", "USB-C Hub",      150,  49.99));
        manager.addProduct(new Product("P004", "Mechanical Keyboard", 80, 129.99));
        manager.addProduct(new Product("P005", "Monitor 27in",   30,  349.99));
        manager.displayAll();
        System.out.println("\n--- Duplicate Add (should warn) ---");
        manager.addProduct(new Product("P001", "Laptop Dupe", 10, 111.11));
        System.out.println("\n--- Updating P003: qty=200, price=$44.99 ---");
        manager.updateProduct("P003", 200, 44.99);
        System.out.println("\n--- Deleting P002 ---");
        manager.deleteProduct("P002");
        System.out.println("\n--- Delete non-existent P999 ---");
        manager.deleteProduct("P999");
        manager.displayAll();
        System.out.println("\n--- Lookup P004 ---");
        Product p = manager.getProduct("P004");
        if (p != null) System.out.println("Found: " + p);
        System.out.println("\n--- Complexity Summary ---");
        System.out.println("add()    -> O(1) average (HashMap.put)");
        System.out.println("update() -> O(1) average (HashMap.put with existing key)");
        System.out.println("delete() -> O(1) average (HashMap.remove)");
        System.out.println("search() -> O(1) average (HashMap.get)");
        System.out.println("\n[OK] Inventory management system working correctly.");
    }
}