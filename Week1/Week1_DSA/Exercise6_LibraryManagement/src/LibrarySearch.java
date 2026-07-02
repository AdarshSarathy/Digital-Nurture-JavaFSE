import java.util.Arrays;
public class LibrarySearch {
    public static Book linearSearchByTitle(Book[] books, String targetTitle) {
        System.out.println("[Linear Search] Looking for: \"" + targetTitle + "\"");
        for (int i=0; i<books.length; i++) {
            if (books[i].getTitle().equalsIgnoreCase(targetTitle)) {
                System.out.println("  Found at index " + i + " after " + (i+1) + " comparison(s).");
                return books[i];
            }
        }
        System.out.println("  Not found after " + books.length + " comparison(s).");
        return null;
    }
    public static Book linearSearchByAuthor(Book[] books, String authorName) {
        System.out.println("[Linear Search by Author] Looking for: \"" + authorName + "\"");
        for (int i=0; i<books.length; i++) {
            if (books[i].getAuthor().toLowerCase().contains(authorName.toLowerCase())) {
                System.out.println("  Found at index " + i + "."); return books[i];
            }
        }
        System.out.println("  Not found."); return null;
    }
    public static Book binarySearchByTitle(Book[] sorted, String targetTitle) {
        System.out.println("[Binary Search] Looking for: \"" + targetTitle + "\"");
        int low=0, high=sorted.length-1, step=0;
        while (low<=high) {
            int mid=low+(high-low)/2; step++;
            int cmp=sorted[mid].getTitle().compareToIgnoreCase(targetTitle);
            if (cmp==0) { System.out.println("  Found at index " + mid + " after " + step + " comparison(s)."); return sorted[mid]; }
            else if (cmp<0) low=mid+1;
            else high=mid-1;
        }
        System.out.println("  Not found after " + step + " comparison(s)."); return null;
    }
    public static Book[] sortByTitle(Book[] books) { Book[] s=Arrays.copyOf(books,books.length); Arrays.sort(s); return s; }
}