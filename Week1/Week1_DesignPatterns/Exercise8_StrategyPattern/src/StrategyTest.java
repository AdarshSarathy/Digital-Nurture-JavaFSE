public class StrategyTest {
    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern Test ===\n");
        PaymentContext ctx = new PaymentContext();
        ctx.setStrategy(new CreditCardPayment("4111111111111234"));
        ctx.executePayment(150.00);
        System.out.println();
        ctx.setStrategy(new PayPalPayment("user@example.com"));
        ctx.executePayment(89.99);
        System.out.println("\n[OK] Strategy pattern verified.");
    }
}