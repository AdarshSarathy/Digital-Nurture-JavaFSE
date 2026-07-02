public class Task {
    private final int taskId;
    private final String taskName;
    private final String status;
    public Task(int id, String name, String status) { taskId=id; taskName=name; this.status=status; }
    public int    getTaskId()   { return taskId; }
    public String getTaskName() { return taskName; }
    public String getStatus()   { return status; }
    public String toString() { return String.format("Task{id=%3d, name='%-22s', status='%s'}", taskId, taskName, status); }
}