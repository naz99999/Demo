package queue;

import java.util.Stack;

public class QueueUsingStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }

        pushToStack(stack1, stack2);
        int popElement = stack2.pop();
        pushToStack(stack2, stack1);

        return popElement;
    }

    private void pushToStack(Stack<Integer> stack1, Stack<Integer> stack2) {
        while (!stack1.empty()) {
            int element = stack1.pop();
            stack2.push(element);
        }
    }

    public int peek() {
        if (empty()) {
            return -1;
        }

        pushToStack(stack1, stack2);
        int peekElement = stack2.peek();
        pushToStack(stack2, stack1);

        return peekElement;
    }

    public boolean empty() {
        return stack1.empty();
    }
}
