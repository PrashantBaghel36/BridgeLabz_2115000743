// Reverse a Queue
// Reverse the elements of a queue using only queue operations (e.g., add, remove, isEmpty).
// Example:
// Input: [10, 20, 30] → Output: [30, 20, 10].


import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }

    private static void reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int front = queue.poll();
        reverseQueue(queue);
        queue.add(front);
    }
}





