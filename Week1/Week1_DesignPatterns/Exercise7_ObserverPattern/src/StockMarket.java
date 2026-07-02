import java.util.ArrayList;
import java.util.List;
public class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<Observer>();
    public void registerObserver(Observer o) { observers.add(o); System.out.println("[Market] Registered: " + o.getClass().getSimpleName()); }
    public void removeObserver(Observer o)   { observers.remove(o); System.out.println("[Market] Removed: " + o.getClass().getSimpleName()); }
    public void notifyObservers(String stockName, double newPrice) { for (Observer o : observers) o.update(stockName, newPrice); }
    public void setStockPrice(String stockName, double newPrice) { System.out.println("\n[Market] " + stockName + " price -> $" + String.format("%.2f", newPrice)); notifyObservers(stockName, newPrice); }
}