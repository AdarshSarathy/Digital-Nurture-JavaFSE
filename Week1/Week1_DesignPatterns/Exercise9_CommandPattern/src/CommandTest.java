public class CommandTest {
    public static void main(String[] args) {
        System.out.println("=== Command Pattern Test ===\n");
        Light living = new Light("Living Room");
        Light kitchen = new Light("Kitchen");
        RemoteControl remote = new RemoteControl();
        remote.pressButton(new LightOnCommand(living));
        remote.pressButton(new LightOnCommand(kitchen));
        remote.pressButton(new LightOffCommand(living));
        System.out.println("\n-- Undo last 2 --");
        remote.pressUndo();
        remote.pressUndo();
        System.out.println("\n[OK] Command pattern verified.");
    }
}