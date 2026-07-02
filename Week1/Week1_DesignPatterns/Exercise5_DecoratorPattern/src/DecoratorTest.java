public class DecoratorTest {
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern Test ===\n");
        Notifier emailOnly = new EmailNotifier("alice@example.com");
        System.out.println("-- Email only --");
        emailOnly.send("Server is down!");
        System.out.println("\n-- Email + SMS --");
        Notifier emailSms = new SMSNotifierDecorator(new EmailNotifier("bob@example.com"), "+1-555-0100");
        emailSms.send("Disk usage > 90%");
        System.out.println("\n-- Email + SMS + Slack --");
        Notifier all = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier("ops@example.com"), "+1-555-0200"), "alerts");
        all.send("Database CPU spike detected");
        System.out.println("\n[OK] Decorator pattern verified.");
    }
}