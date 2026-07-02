public class Book implements Comparable<Book> {
    private final int bookId;
    private final String title;
    private final String author;
    public Book(int id, String title, String author) { bookId=id; this.title=title; this.author=author; }
    public int    getBookId() { return bookId; }
    public String getTitle()  { return title; }
    public String getAuthor() { return author; }
    public int compareTo(Book o) { return title.compareToIgnoreCase(o.title); }
    public String toString() { return String.format("Book{id=%3d, title='%-30s', author='%s'}", bookId, title, author); }
}