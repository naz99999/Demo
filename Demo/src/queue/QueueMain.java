package queue;

import Exceptions.QueueException;

public class QueueMain {
    public static void main(String args[]) throws QueueException {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.display();
        System.out.println(queue.dequeue());
        queue.display();
    }
}
