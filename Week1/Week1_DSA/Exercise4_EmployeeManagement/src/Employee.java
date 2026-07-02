public class Employee {
    private final int employeeId;
    private final String name;
    private final String position;
    private final double salary;
    public Employee(int id, String name, String pos, double salary) { employeeId=id; this.name=name; position=pos; this.salary=salary; }
    public int    getEmployeeId() { return employeeId; }
    public String getName()       { return name; }
    public String getPosition()   { return position; }
    public double getSalary()     { return salary; }
    public String toString() { return String.format("Employee{id=%d, name='%-15s', position='%-12s', salary=$%.2f}", employeeId, name, position, salary); }
}