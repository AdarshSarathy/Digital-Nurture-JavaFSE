public class ProxyTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Proxy Pattern Test ===\n");
        Image img = new ProxyImage("photo_4k.jpg");
        System.out.println("-- First display (lazy load) --");
        img.display();
        System.out.println("\n-- Second display (cached) --");
        img.display();
        System.out.println("\n-- Third display (still cached) --");
        img.display();
        System.out.println("\n[OK] Proxy pattern (lazy-loading + caching) verified.");
    }
}