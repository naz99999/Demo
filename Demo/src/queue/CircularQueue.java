package queue;

import Exceptions.QueueException;

public class CircularQueue {
    protected int data[];
    private static final int DEFAULT_SIZE = 10;
    protected int start, end = 0;
    private int size = 0;
    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public void enqueue(int element) throws QueueException {
        if (isFull()) {
            throw new QueueException("Cannot push if the Queue is Full!");
        }
        this.data[end++] = element;
        end = end % data.length;
        size++;
    }

    public int dequeue() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Cannot pop if the Queue is Empty!");
        }
        int element = data[start++];

        start = start % data.length;
        size--;
        return element;
    }

    public int peek() throws QueueException {
        if (isEmpty()) {
            throw new QueueException("Cannot peek if the Queue is Empty!");
        }
        return data[start];
    }

    public void display() throws QueueException {
        int i = start;
        do {
            System.out.print(data[i] + " ");
            i++;
            i%=data.length;
        } while (i!=end);
        System.out.println("END");
    }
    private boolean isFull() {
        return size == data.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
