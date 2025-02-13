import java.util.LinkedList;

public class CustomHashMap<K, V> {

    // Node class to store key-value pairs
    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Initial capacity of the hash table
    private static final int INITIAL_CAPACITY = 16;

    // Array of linked lists to handle collisions
    private LinkedList<Node<K, V>>[] buckets;

    // Current size of the hash map
    private int size = 0;

    // Constructor to initialize the buckets array
    public CustomHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
    }

    // Hash function to calculate the index for a key
    private int getBucketIndex(K key) {
        int hashCode = key == null ? 0 : key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    // Put method to insert or update a key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);

        // Initialize the bucket if it's empty
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // Check if the key already exists and update its value
        for (Node<K, V> node : buckets[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        // If the key doesn't exist, add a new node to the bucket
        buckets[index].add(new Node<>(key, value));
        size++;
    }

    // Get method to retrieve the value for a given key
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        // Search the bucket for the key
        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
        }

        // Return null if the key is not found
        return null;
    }

    // Remove method to delete a key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        // Search the bucket for the key and remove the node
        if (bucket != null) {
            for (Node<K, V> node : bucket) {
                if (node.key.equals(key)) {
                    bucket.remove(node);
                    size--;
                    return;
                }
            }
        }
    }
}
