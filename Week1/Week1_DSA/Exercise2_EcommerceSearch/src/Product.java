public class Product implements Comparable<Product> {
    private final int id;
    private final String productName;
    private final String category;
    public Product(int id, String name, String cat) { this.id=id; productName=name; category=cat; }
    public int    getId()          { return id; }
    public String getProductName() { return productName; }
    public String getCategory()    { return category; }
    public int compareTo(Product o) { return productName.compareToIgnoreCase(o.productName); }
    public String toString() { return String.format("Product{id=%d, name='%-22s', category='%s'}", id, productName, category); }
}