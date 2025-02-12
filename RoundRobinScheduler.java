import java.util.*;
class Process {
    int processId;
    int burstTime;
    int priority;
    int arrivalTime;
    int waitingTime;
    int turnaroundTime;
    Process next;

    Process(int processId, int burstTime, int priority, int arrivalTime) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }

    @Override
    public String toString() {
        return "ID: " + processId + ", Burst: " + burstTime + ", Priority: " + priority + ", Arrival: " + arrivalTime;
    }
}

public class RoundRobinScheduler {
    Process head;
    Scanner scanner = new Scanner(System.in);

    public void addProcess(int processId, int burstTime, int priority, int arrivalTime) {
        Process newProcess = new Process(processId, burstTime, priority, arrivalTime);
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
        } else {
            Process tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = newProcess;
            newProcess.next = head;
        }
    }

    public void removeProcess(int processId) {
        if (head == null) return;

        if (head.processId == processId) {
            if (head.next == head) {
                head = null;
            } else {
                Process tail = head;
                while (tail.next != head) {
                    tail = tail.next;
                }
                tail.next = head.next;
                head = head.next;
            }
            return;
        }

        Process current = head;
        while (current.next != head && current.next.processId != processId) {
            current = current.next;
        }

        if (current.next == head) return;

        current.next = current.next.next;
    }

    public void schedule(int timeQuantum) {
        if (head == null) return;

        int currentTime = 0;
        Process currentProcess = head;

        while (true) {
            displayProcesses();
            System.out.println("Current Time: " + currentTime);

            if (currentProcess.burstTime > 0) {
                int executionTime = Math.min(timeQuantum, currentProcess.burstTime);
                currentProcess.burstTime -= executionTime;
                currentTime += executionTime;

                if (currentProcess != head) {
                    currentProcess.waitingTime += currentTime - currentProcess.arrivalTime - (currentProcess.turnaroundTime - currentProcess.burstTime);
                }
                currentProcess.turnaroundTime = currentTime - currentProcess.arrivalTime;

                if (currentProcess.burstTime == 0) {
                    removeProcess(currentProcess.processId);
                    if (head == null) break;
                }
            }
            currentProcess = currentProcess.next;
        }
        calculateAverageTimes();
    }

    public void displayProcesses() {
        if (head == null) return;

        Process current = head;
        do {
            System.out.println(current);
            current = current.next;
        } while (current != head);
        System.out.println("---");
    }

    private void calculateAverageTimes() {
        if (head == null) return;

        double totalWaitingTime = 0;
        double totalTurnaroundTime = 0;
        int processCount = 0;

        Process current = head;
        do {
            totalWaitingTime += current.waitingTime;
            totalTurnaroundTime += current.turnaroundTime;
            processCount++;
            current = current.next;
        } while (current != head);

        double avgWaitingTime = totalWaitingTime / processCount;
        double avgTurnaroundTime = totalTurnaroundTime / processCount;

        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter time quantum: ");
        int timeQuantum = scanner.nextInt();

        while (true) {
            System.out.print("Enter process ID (or -1 to start scheduling): ");
            int processId = scanner.nextInt();
            if (processId == -1) break;

            System.out.print("Enter burst time: ");
            int burstTime = scanner.nextInt();
            System.out.print("Enter priority: ");
            int priority = scanner.nextInt();
            System.out.print("Enter arrival time: ");
            int arrivalTime = scanner.nextInt();

            scheduler.addProcess(processId, burstTime, priority, arrivalTime);
        }

        scheduler.schedule(timeQuantum);
    }
}
