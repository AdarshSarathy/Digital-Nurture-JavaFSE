public class SearchProduct implements Comparable<SearchProduct> {
    private final int id;
    private final String productName;
    private final String category;

    public SearchProduct(int id, String name, String cat) {
        this.id = id;
        productName = name;
        category = cat;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public int compareTo(SearchProduct o) {
        return productName.compareToIgnoreCase(o.productName);
    }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%-22s', category='%s'}", id, productName, category);
    }
}
