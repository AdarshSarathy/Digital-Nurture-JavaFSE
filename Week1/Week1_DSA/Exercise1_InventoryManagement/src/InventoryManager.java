import java.util.HashMap;
import java.util.Map;
public class InventoryManager {
    private final Map<String, Product> inventory = new HashMap<String, Product>();
    public void addProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            System.out.println("[WARN] Product already exists: " + product.getProductId() + ". Use updateProduct() to modify it.");
            return;
        }
        inventory.put(product.getProductId(), product);
        System.out.println("[ADD]  " + product);
    }
    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product == null) { System.out.println("[ERROR] Product not found: " + productId); return; }
        product.setQuantity(newQuantity);
        product.setPrice(newPrice);
        System.out.println("[UPDATE] " + product);
    }
    public void deleteProduct(String productId) {
        Product removed = inventory.remove(productId);
        if (removed == null) { System.out.println("[ERROR] Cannot delete - product not found: " + productId); }
        else { System.out.println("[DELETE] Removed: " + removed.getProductName() + " (" + productId + ")"); }
    }
    public Product getProduct(String productId) { return inventory.get(productId); }
    public void displayAll() {
        if (inventory.isEmpty()) { System.out.println("Inventory is empty."); return; }
        System.out.println("\n--- Inventory (" + inventory.size() + " items) ---");
        for (Product p : inventory.values()) System.out.println("  " + p);
    }
    public int size() { return inventory.size(); }
}