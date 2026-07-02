import java.util.Arrays;
public class SearchAlgorithms {
    public static Product linearSearchByName(Product[] products, String targetName) {
        System.out.println("[Linear Search] Searching for: \"" + targetName + "\"");
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equalsIgnoreCase(targetName)) {
                System.out.println("  Found in " + (i+1) + " comparison(s).");
                return products[i];
            }
        }
        System.out.println("  Not found after " + products.length + " comparison(s).");
        return null;
    }
    public static Product binarySearchByName(Product[] sortedProducts, String targetName) {
        System.out.println("[Binary Search] Searching for: \"" + targetName + "\"");
        int low=0, high=sortedProducts.length-1, step=0;
        while (low <= high) {
            int mid = low + (high-low)/2; step++;
            int cmp = sortedProducts[mid].getProductName().compareToIgnoreCase(targetName);
            if (cmp==0) { System.out.println("  Found in " + step + " comparison(s)."); return sortedProducts[mid]; }
            else if (cmp < 0) low = mid+1;
            else high = mid-1;
        }
        System.out.println("  Not found after " + step + " comparison(s).");
        return null;
    }
    public static Product[] sortByName(Product[] products) {
        Product[] sorted = Arrays.copyOf(products, products.length);
        Arrays.sort(sorted);
        return sorted;
    }
}