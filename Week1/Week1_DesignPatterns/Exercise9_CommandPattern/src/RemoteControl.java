import java.util.Stack;
public class RemoteControl {
    private final Stack<Command> history = new Stack<Command>();
    public void pressButton(Command c) { c.execute(); history.push(c); }
    public void pressUndo() { if (!history.isEmpty()) { Command c = history.pop(); System.out.println("[Remote] Undoing..."); c.undo(); } else { System.out.println("[Remote] Nothing to undo."); } }
}