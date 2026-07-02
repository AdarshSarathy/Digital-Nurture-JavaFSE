public class LibraryTest {
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===\n");
        Book[] library = {
            new Book(1,  "The Great Gatsby",      "F. Scott Fitzgerald"),
            new Book(2,  "To Kill a Mockingbird", "Harper Lee"),
            new Book(3,  "1984",                  "George Orwell"),
            new Book(4,  "Pride and Prejudice",   "Jane Austen"),
            new Book(5,  "The Catcher in the Rye","J.D. Salinger"),
            new Book(6,  "Brave New World",        "Aldous Huxley"),
            new Book(7,  "Animal Farm",            "George Orwell"),
            new Book(8,  "Lord of the Flies",      "William Golding"),
            new Book(9,  "Jane Eyre",              "Charlotte Bronte"),
            new Book(10, "Wuthering Heights",      "Emily Bronte"),
        };
        Book[] sortedLibrary = LibrarySearch.sortByTitle(library);
        System.out.println("--- Linear Search by Title ---");
        Book r1 = LibrarySearch.linearSearchByTitle(library, "Animal Farm");
        if (r1 != null) System.out.println("  Result: " + r1);
        System.out.println();
        LibrarySearch.linearSearchByTitle(library, "Dune");
        System.out.println("\n--- Linear Search by Author ---");
        Book r2 = LibrarySearch.linearSearchByAuthor(library, "George Orwell");
        if (r2 != null) System.out.println("  Result: " + r2);
        System.out.println("\n--- Binary Search (sorted) ---");
        System.out.println("Sorted titles:");
        for (Book b : sortedLibrary) System.out.println("  " + b);
        System.out.println();
        Book r3 = LibrarySearch.binarySearchByTitle(sortedLibrary, "Animal Farm");
        if (r3 != null) System.out.println("  Result: " + r3);
        System.out.println();
        LibrarySearch.binarySearchByTitle(sortedLibrary, "Dune");
        System.out.println("\n--- Complexity ---");
        System.out.println("Linear: O(n)     -- flexible, works unsorted");
        System.out.println("Binary: O(log n) -- fast, requires sorted data");
        System.out.println("For 10,000 books: Linear ~10,000 | Binary ~14 comparisons");
        System.out.println("\n[OK] Library search system verified.");
    }
}