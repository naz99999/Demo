package queue;

import Exceptions.QueueException;
import Exceptions.StackException;

public class CustomQueue {
    private int data[];
    private static final int DEFAULT_SIZE = 10;
    private int pointer = 0;
    public CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public void enqueue(int element) throws StackException {
        if (isFull()) {
            throw new StackException("Cannot push if the Queue is Full!");
        }
        this.data[pointer++] = element;
    }

    public int dequeue() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Cannot pop if the Queue is Empty!");
        }
        int element = data[0];

        //shift elements to left
        for (int i=1; i<data.length; i++) {
            data[i-1] = data[i];
        }
        pointer--;
        return element;
    }

    public int peek() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Cannot peek if the Queue is Empty!");
        }
        return data[0];
    }

    private boolean isFull() {
        return pointer == data.length;
    }

    private boolean isEmpty() {
        return pointer == 0;
    }
}
