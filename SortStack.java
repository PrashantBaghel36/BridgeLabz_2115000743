import java.util.Stack;

public class SortStack {

    // Recursive method to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        // Base case: If stack is empty, return
        if (stack.isEmpty()) {
            return;
        }

        // Step 1: Pop the top element
        int top = stack.pop();

        // Step 2: Sort the remaining stack
        sortStack(stack);

        // Step 3: Insert the popped element at the correct position
        insertSorted(stack, top);
    }

    // Recursive method to insert an element in a sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        // Base case: If stack is empty or the top element is less than or equal to the current element
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Step 1: Pop the top element
        int top = stack.pop();

        // Step 2: Recursively insert the current element
        insertSorted(stack, element);

        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
