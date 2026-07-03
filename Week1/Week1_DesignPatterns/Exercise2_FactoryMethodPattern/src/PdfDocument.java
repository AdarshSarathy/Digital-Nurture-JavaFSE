public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("[PDF] Opening...");
    }

    @Override
    public void close() {
        System.out.println("[PDF] Closing.");
    }

    @Override
    public void save() {
        System.out.println("[PDF] Saving .pdf.");
    }

    @Override
    public String getDocumentType() {
        return "PDF Document (.pdf)";
    }
}