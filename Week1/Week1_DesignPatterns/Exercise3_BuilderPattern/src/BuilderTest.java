public class BuilderTest {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Test ===\n");
        Computer basic = new Computer.Builder("Intel i3", "8GB").wifi(true).build();
        System.out.println("Basic PC  : " + basic);
        Computer gaming = new Computer.Builder("Intel i9", "32GB").storage("2TB NVMe").gpu("RTX 4090").bluetooth(true).wifi(true).build();
        System.out.println("Gaming PC : " + gaming);
        Computer workstation = new Computer.Builder("AMD Ryzen 9", "64GB").storage("4TB NVMe").gpu("Quadro RTX 6000").bluetooth(true).wifi(true).build();
        System.out.println("Station   : " + workstation);
        System.out.println("\n[OK] Builder pattern verified.");
    }
}