public class Product {
    private final String productId;
    private String productName;
    private int quantity;
    private double price;
    public Product(String id, String name, int qty, double price) { productId=id; productName=name; quantity=qty; this.price=price; }
    public String getProductId()   { return productId; }
    public String getProductName() { return productName; }
    public int    getQuantity()    { return quantity; }
    public double getPrice()       { return price; }
    public void setProductName(String n) { productName = n; }
    public void setQuantity(int q)       { quantity = q; }
    public void setPrice(double p)       { price = p; }
    public String toString() { return String.format("Product{id='%s', name='%-20s', qty=%4d, price=$%.2f}", productId, productName, quantity, price); }
}