package miniproject;

import java.util.*;

// ------------------------- Main Program -------------------------
public class AstronautScheduleApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.addObserver(new ConflictNotifier());

        while (true) {
            System.out.println("\n=== Astronaut Daily Schedule Organizer ===");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = -1;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter description: ");
                        String desc = sc.nextLine();
                        System.out.print("Enter start time (HH:MM): ");
                        String start = sc.nextLine();
                        System.out.print("Enter end time (HH:MM): ");
                        String end = sc.nextLine();
                        System.out.print("Enter priority (High/Medium/Low): ");
                        String priority = sc.nextLine();

                        Task task = TaskFactory.createTask(desc, start, end, priority);
                        manager.addTask(task);
                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter task description to remove: ");
                    String descRemove = sc.nextLine();
                    manager.removeTask(descRemove);
                    break;
                case 3:
                    manager.viewTasks();
                    break;
                case 4:
                    System.out.println("Exiting... Safe travels, Astronaut! 🚀");
                    return;
                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
