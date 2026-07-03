public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("[Word] Opening...");
    }

    @Override
    public void close() {
        System.out.println("[Word] Closing.");
    }

    @Override
    public void save() {
        System.out.println("[Word] Saving .docx.");
    }

    @Override
    public String getDocumentType() {
        return "Word Document (.docx)";
    }
}