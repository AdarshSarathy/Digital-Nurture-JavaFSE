public class Order {
    private final String orderId;
    private final String customerName;
    private final double totalPrice;
    public Order(String id, String name, double price) { orderId=id; customerName=name; totalPrice=price; }
    public String getOrderId()      { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalPrice()   { return totalPrice; }
    public String toString() { return String.format("Order{id='%s', customer='%-15s', total=$%8.2f}", orderId, customerName, totalPrice); }
}