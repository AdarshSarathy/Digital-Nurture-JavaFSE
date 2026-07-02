public class FactoryMethodTest {
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Test ===");
        DocumentFactory[] f = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };
        for (DocumentFactory fac : f) {
            System.out.println("---");
            Document d = fac.openNewDocument();
            d.save();
            d.close();
        }
        System.out.println("[OK] Factory Method verified.");
    }
}