package miniproject;

import java.util.*;

// ------------------------- Singleton Schedule Manager -------------------------
public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private ScheduleManager() {}

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public boolean addTask(Task newTask) {
        for (Task t : tasks) {
            if (isOverlap(newTask, t)) {
                for (Observer obs : observers) {
                    obs.notifyConflict(newTask, t);
                }
                return false;
            }
        }
        tasks.add(newTask);
        sortTasks();
        System.out.println("✅ Task added successfully: " + newTask.getDescription());
        return true;
    }

    public boolean removeTask(String description) {
        for (Task t : tasks) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                tasks.remove(t);
                System.out.println("✅ Task removed: " + description);
                return true;
            }
        }
        System.out.println("❌ Task not found: " + description);
        return false;
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    // Helper: check time overlap
    private boolean isOverlap(Task t1, Task t2) {
        int start1 = parseTime(t1.getStartTime());
        int end1 = parseTime(t1.getEndTime());
        int start2 = parseTime(t2.getStartTime());
        int end2 = parseTime(t2.getEndTime());
        return (start1 < end2 && start2 < end1);
    }

    private int parseTime(String time) {
        try {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            return hours * 60 + minutes;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid time format: " + time);
        }
    }

    private void sortTasks() {
        tasks.sort(Comparator.comparingInt(t -> parseTime(t.getStartTime())));
    }
}
