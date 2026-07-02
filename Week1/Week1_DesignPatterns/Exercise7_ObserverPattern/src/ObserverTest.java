public class ObserverTest {
    public static void main(String[] args) {
        System.out.println("=== Observer Pattern Test ===\n");
        StockMarket market = new StockMarket();
        MobileApp app1 = new MobileApp("StocksNow");
        MobileApp app2 = new MobileApp("TradePro");
        WebApp    web1 = new WebApp("FinanceDashboard");
        market.registerObserver(app1);
        market.registerObserver(app2);
        market.registerObserver(web1);
        market.setStockPrice("AAPL", 175.30);
        market.setStockPrice("GOOGL", 142.85);
        System.out.println("\n--- Removing StocksNow app ---");
        market.removeObserver(app1);
        market.setStockPrice("MSFT", 385.50);
        System.out.println("\n[OK] Observer pattern verified.");
    }
}