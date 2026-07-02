public class EmployeeArray {
    private final Employee[] employees;
    private int count;
    private final int capacity;
    public EmployeeArray(int cap) { capacity=cap; employees=new Employee[cap]; count=0; }
    public boolean addEmployee(Employee emp) {
        if (count >= capacity) { System.out.println("[ERROR] Array full."); return false; }
        employees[count++] = emp;
        System.out.println("[ADD] " + emp);
        return true;
    }
    public int searchById(int id) { for (int i=0; i<count; i++) if (employees[i].getEmployeeId()==id) return i; return -1; }
    public Employee getById(int id) { int i=searchById(id); return i!=-1 ? employees[i] : null; }
    public void traverse() {
        System.out.println("\n--- Employee Records (" + count + "/" + capacity + ") ---");
        for (int i=0; i<count; i++) System.out.println("  [" + i + "] " + employees[i]);
    }
    public boolean deleteEmployee(int id) {
        int index=searchById(id);
        if (index==-1) { System.out.println("[ERROR] Employee not found: " + id); return false; }
        String n=employees[index].getName();
        for (int i=index; i<count-1; i++) employees[i]=employees[i+1];
        employees[--count]=null;
        System.out.println("[DELETE] Removed: " + n + " (id=" + id + ")");
        return true;
    }
    public int getCount() { return count; }
}