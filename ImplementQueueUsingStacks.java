import java.util.Stack;
public class ImplementQueueUsingStacks {
    private Stack<Integer> stackEnqueue;
    private Stack<Integer> stackDequeue;
    public ImplementQueueUsingStacks(){
        stackEnqueue=new Stack<>();
        stackDequeue=new Stack<>();
    }
    public void enqueue(int value){
        stackEnqueue.push(value);
    }
    public void dequeue(){
        if(stackEnqueue.isEmpty()){
            System.out.println("NO ele for perform dequeue operation");
            return;
        }
        while(!stackEnqueue.isEmpty()){
            stackDequeue.push(stackEnqueue.pop());
        }
        System.out.println(stackDequeue.pop());
        while(!stackDequeue.isEmpty()){
            stackEnqueue.push(stackDequeue.pop());
        }
    }
    public int peek(){
        if (stackDequeue.isEmpty()) {
            // Transfer elements from stackEnqueue to stackDequeue
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }

        if (stackDequeue.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return stackDequeue.peek();
    }
    public boolean isEmpty() {
        return stackEnqueue.isEmpty() && stackDequeue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks queue=new ImplementQueueUsingStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

       queue.dequeue(); // Output: 1
       queue.dequeue(); // Output: 2

        queue.enqueue(4);
        queue.dequeue(); // Output: 3
        //System.out.println(queue.dequeue());
    }
}
