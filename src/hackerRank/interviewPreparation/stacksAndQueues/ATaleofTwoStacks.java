package hackerRank.interviewPreparation.stacksAndQueues;

import java.util.Stack;

public class ATaleofTwoStacks<T> {

    Stack<T> stackNewestOnTop = new Stack<>();
    Stack<T> stackOldestOnTop = new Stack<>();

    public void enqueue(T value) { // Push onto newest stack
        stackNewestOnTop.push(value);
        stackOldestOnTop.add(0, value);
    }

    public T peek() {
        return stackOldestOnTop.peek();
    }

    public T dequeue() {
        stackNewestOnTop.remove(0);

        return stackOldestOnTop.pop();
    }

    public static void main(String[] args) {
        ATaleofTwoStacks<Integer> queue = new ATaleofTwoStacks<>();
        queue.enqueue(42);
        queue.dequeue();
        queue.enqueue(14);
        System.out.println(queue.peek());
        queue.enqueue(28);
        System.out.println(queue.peek());
        queue.enqueue(60);
        queue.enqueue(78);
        queue.dequeue();
        queue.dequeue();
    }
}
