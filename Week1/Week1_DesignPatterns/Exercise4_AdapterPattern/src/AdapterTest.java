public class AdapterTest {
    public static void main(String[] args) {
        System.out.println("=== Adapter Pattern Test ===\n");
        PaymentProcessor[] processors = { new PayPalAdapter(), new StripeAdapter() };
        for (PaymentProcessor p : processors) {
            System.out.println("-- " + p.getGatewayName() + " --");
            boolean ok = p.processPayment("ORDER-001", 99.99);
            System.out.println("  Payment success: " + ok);
            p.refund("TXN-001");
            System.out.println();
        }
        System.out.println("[OK] Adapter pattern verified.");
    }
}