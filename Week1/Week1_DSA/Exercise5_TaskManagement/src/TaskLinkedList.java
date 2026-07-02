public class TaskLinkedList {
    private static class Node { Task task; Node next; Node(Task t) { task=t; next=null; } }
    private Node head;
    private int size;
    public void addFirst(Task task) { Node n=new Node(task); n.next=head; head=n; size++; System.out.println("[ADD-HEAD] " + task); }
    public void addLast(Task task) {
        Node n=new Node(task);
        if (head==null) { head=n; } else { Node c=head; while(c.next!=null) c=c.next; c.next=n; }
        size++; System.out.println("[ADD-TAIL] " + task);
    }
    public Task searchById(int id) { Node c=head; while(c!=null) { if(c.task.getTaskId()==id) return c.task; c=c.next; } return null; }
    public void traverse() {
        System.out.println("\n--- Task List (" + size + " tasks) ---");
        Node c=head; int i=1; while(c!=null) { System.out.println("  " + i++ + ". " + c.task); c=c.next; }
        if (size==0) System.out.println("  (empty)");
    }
    public boolean deleteById(int id) {
        if (head==null) { System.out.println("[ERROR] List is empty."); return false; }
        if (head.task.getTaskId()==id) { System.out.println("[DELETE] Removed head: " + head.task.getTaskName()); head=head.next; size--; return true; }
        Node c=head;
        while (c.next!=null) {
            if (c.next.task.getTaskId()==id) { System.out.println("[DELETE] Removed: " + c.next.task.getTaskName()); c.next=c.next.next; size--; return true; }
            c=c.next;
        }
        System.out.println("[ERROR] Task not found: " + id); return false;
    }
    public int getSize() { return size; }
}