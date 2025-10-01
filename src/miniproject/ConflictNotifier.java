package miniproject;

// ------------------------- Observer Pattern -------------------------
public interface Observer {
    void notifyConflict(Task newTask, Task existingTask);
}

public class ConflictNotifier implements Observer {
    public void notifyConflict(Task newTask, Task existingTask) {
        System.out.println("❌ Conflict: Task \"" + newTask.getDescription() +
                           "\" overlaps with \"" + existingTask.getDescription() + "\"");
    }
}
