public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("[Excel] Opening...");
    }

    @Override
    public void close() {
        System.out.println("[Excel] Closing.");
    }

    @Override
    public void save() {
        System.out.println("[Excel] Saving .xlsx.");
    }

    @Override
    public String getDocumentType() {
        return "Excel Spreadsheet (.xlsx)";
    }
}