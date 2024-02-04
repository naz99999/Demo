package stack;

import Exceptions.StackException;

public class CustomStack {
    private int data[];
    private static final int DEFAULT_SIZE = 10;
    private int pointer = -1;
    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

        public void push(int element) throws StackException {
        if (isFull()) {
            throw new StackException("Cannot push if the Stack is Full!");
        }
        this.data[pointer] = element;
        pointer++;
    }

    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot pop if the Stack is Empty!");
        }
        return data[pointer--];
    }

    public int peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot peek if the Stack is Empty!");
        }
        return data[pointer];
    }

    private boolean isFull() {
        return pointer == data.length - 1;
    }

    private boolean isEmpty() {
        return pointer == -1;
    }
}
