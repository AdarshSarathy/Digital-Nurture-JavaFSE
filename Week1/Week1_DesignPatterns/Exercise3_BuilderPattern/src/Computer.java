public class Computer {
    private final String cpu;
    private final String ram;
    private final String storage;
    private final String gpu;
    private final boolean bluetooth;
    private final boolean wifi;
    private Computer(Builder b) { cpu=b.cpu; ram=b.ram; storage=b.storage; gpu=b.gpu; bluetooth=b.bluetooth; wifi=b.wifi; }
    public String toString() { return "Computer{cpu='" + cpu + "', ram='" + ram + "', storage='" + storage + "', gpu='" + gpu + "', bt=" + bluetooth + ", wifi=" + wifi + "}"; }
    public static class Builder {
        private final String cpu;
        private final String ram;
        private String storage = "256GB SSD";
        private String gpu = "Integrated";
        private boolean bluetooth = false;
        private boolean wifi = false;
        public Builder(String cpu, String ram) { this.cpu = cpu; this.ram = ram; }
        public Builder storage(String v) { storage = v; return this; }
        public Builder gpu(String v) { gpu = v; return this; }
        public Builder bluetooth(boolean v) { bluetooth = v; return this; }
        public Builder wifi(boolean v) { wifi = v; return this; }
        public Computer build() { return new Computer(this); }
    }
}