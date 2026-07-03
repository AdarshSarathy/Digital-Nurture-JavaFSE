public class SearchTest {
    public static void main(String[] args) {
        System.out.println("=== E-commerce Search Function ===\n");
        SearchProduct[] catalogue = {
            new SearchProduct(101, "Smartphone",        "Electronics"),
            new SearchProduct(102, "Running Shoes",     "Footwear"),
            new SearchProduct(103, "Coffee Maker",      "Appliances"),
            new SearchProduct(104, "Yoga Mat",          "Fitness"),
            new SearchProduct(105, "Bluetooth Speaker", "Electronics"),
            new SearchProduct(106, "Desk Lamp",         "Furniture"),
            new SearchProduct(107, "Notebook",          "Stationery"),
            new SearchProduct(108, "Water Bottle",      "Fitness"),
        };
        SearchProduct[] sortedCatalogue = SearchAlgorithms.sortByName(catalogue);
        System.out.println("--- Linear Search (unsorted array) ---");
        SearchProduct r1 = SearchAlgorithms.linearSearchByName(catalogue, "Yoga Mat");
        if (r1 != null) System.out.println("  Result: " + r1);
        System.out.println();
        SearchAlgorithms.linearSearchByName(catalogue, "Gaming Chair");
        System.out.println("\n--- Binary Search (sorted array) ---");
        System.out.println("Sorted order:");
        for (SearchProduct p : sortedCatalogue) System.out.println("  " + p);
        System.out.println();
        SearchProduct r3 = SearchAlgorithms.binarySearchByName(sortedCatalogue, "Yoga Mat");
        if (r3 != null) System.out.println("  Result: " + r3);
        System.out.println();
        SearchAlgorithms.binarySearchByName(sortedCatalogue, "Gaming Chair");
        System.out.println("\n--- Complexity Comparison ---");
        System.out.println("Linear Search : O(n)     -- works on unsorted data");
        System.out.println("Binary Search : O(log n) -- requires sorted data");
        System.out.println("For n=1,000,000 products:");
        System.out.println("  Linear: up to 1,000,000 comparisons");
        System.out.println("  Binary: up to ~20 comparisons (log2 1,000,000 ~ 20)");
        System.out.println("\n[OK] Use Binary Search for large, sorted product catalogues.");
    }
}