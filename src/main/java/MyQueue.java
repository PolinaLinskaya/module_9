import java.util.NoSuchElementException;

public class MyQueue {
    private Node front;
    private Node rear;
    private int size;

    public MyQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value);

        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }


    public Object peek() {
        if (front == null) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.value;
    }

    public Object poll() {
        if (front == null) {
            throw new NoSuchElementException("Queue is empty");
        }

        Object value = front.value;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }

        return value;
    }

    private class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }
}
