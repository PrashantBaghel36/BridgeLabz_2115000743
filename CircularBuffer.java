
// Circular Buffer Simulation
// Implement a circular buffer (fixed-size queue) using an array-based queue. When full, overwrite the oldest element.
// Example:
// Buffer size=3: Insert 1, 2, 3 → Insert 4 → Buffer: [2, 3, 4].


import java.util.*;
public class CircularBuffer {
    private int[] buffer;
    private int head, tail, size, capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void insert(int value) {
        if (size == capacity) {
            head = (head + 1) % capacity;
        } else {
            size++;
        }
        buffer[tail] = value;
        tail = (tail + 1) % capacity;
    }

    public List<Integer> getBufferContents() {
        List<Integer> contents = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            contents.add(buffer[(head + i) % capacity]);
        }
        return contents;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4);
        System.out.println(cb.getBufferContents()); // Output: [2, 3, 4]
    }
}
