import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Task {
    int taskId;
    String taskName;
    int priority;
    LocalDate dueDate;
    Task next;

    Task(int taskId, String taskName, int priority, LocalDate dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return "ID: " + taskId + ", Name: " + taskName + ", Priority: " + priority + ", Due: " + dueDate.format(formatter);
    }
}

public class TaskScheduler {
    Task head;
    Scanner scanner = new Scanner(System.in);

    public void addTaskBeginning(int taskId, String taskName, int priority, LocalDate dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            newTask.next = head;
            tail.next = newTask;
            head = newTask;
        }
    }

    public void addTaskEnd(int taskId, String taskName, int priority, LocalDate dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
        } else {
            Task tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = newTask;
            newTask.next = head;
        }
    }

    public void addTaskAtPosition(int taskId, String taskName, int priority, LocalDate dueDate, int position) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position <= 0) {
            addTaskBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        if (head == null) {
            return;
        }

        Task current = head;
        int count = 0;
        while (current.next != head && count < position - 1) {
            current = current.next;
            count++;
        }
        newTask.next = current.next;
        current.next = newTask;
    }

    public void removeTask(int taskId) {
        if (head == null) return;

        if (head.taskId == taskId) {
            if (head.next == head) {
                head = null;
            } else {
                Task tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                tail.next = head.next;
                head = head.next;
            }
            return;
        }

        Task current = head;
        while (current.next != head && current.next.taskId != taskId) {
            current = current.next;
        }

        if (current.next == head) return;

        current.next = current.next.next;
    }

    public void viewNextTask() {
        if (head == null) return;

        System.out.println(head);
        head = head.next;
    }

    public void displayAllTasks() {
        if (head == null) return;

        Task current = head;
        do {
            System.out.println(current);
            current = current.next;
        } while (current != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) return;
        Task current = head;
        do {
            if (current.priority == priority) {
                System.out.println(current);
            }
            current = current.next;
        } while (current != head);
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTask Scheduler Menu");
            System.out.println("1. Add task at beginning");
            System.out.println("2. Add task at end");
            System.out.println("3. Add task at position");
            System.out.println("4. Remove task");
            System.out.println("5. View next task");
            System.out.println("6. Display all tasks");
            System.out.println("7. Search by priority");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task ID: ");
                    int id1 = scanner.nextInt();
                    System.out.print("Enter task name: ");
                    String name1 = scanner.next();
                    System.out.print("Enter priority: ");
                    int prio1 = scanner.nextInt();
                    System.out.print("Enter due date (yyyy-MM-dd): ");
                    String dateStr1 = scanner.next();
                    LocalDate date1 = LocalDate.parse(dateStr1);
                    scheduler.addTaskBeginning(id1, name1, prio1, date1);
                    break;
                case 2:
                    System.out.print("Enter task ID: ");
                    int id2 = scanner.nextInt();
                    System.out.print("Enter task name: ");
                    String name2 = scanner.next();
                    System.out.print("Enter priority: ");
                    int prio2 = scanner.nextInt();
                    System.out.print("Enter due date (yyyy-MM-dd): ");
                    String dateStr2 = scanner.next();
                    LocalDate date2 = LocalDate.parse(dateStr2);
                    scheduler.addTaskEnd(id2, name2, prio2, date2);
                    break;
                case 3:
                    System.out.print("Enter task ID: ");
                    int id3 = scanner.nextInt();
                    System.out.print("Enter task name: ");
                    String name3 = scanner.next();
                    System.out.print("Enter priority: ");
                    int prio3 = scanner.nextInt();
                    System.out.print("Enter due date (yyyy-MM-dd): ");
                    String dateStr3 = scanner.next();
                    LocalDate date3 = LocalDate.parse(dateStr3);
                    System.out.print("Enter position: ");
                    int pos = scanner.nextInt();
                    scheduler.addTaskAtPosition(id3, name3, prio3, date3, pos);
                    break;
                case 4:
                    System.out.print("Enter task ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    scheduler.removeTask(idToRemove);
                    break;
                case 5:
                    scheduler.viewNextTask();
                    break;
                case 6:
                    scheduler.displayAllTasks();
                    break;
                case 7:
                    System.out.print("Enter priority to search: ");
                    int prioToSearch = scanner.nextInt();
                    scheduler.searchByPriority(prioToSearch);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
    }
}
