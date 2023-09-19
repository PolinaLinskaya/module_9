public class MyStack {
    private Object[] stackArray;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyStack() {
        stackArray = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void push(Object value) {
        if (size == stackArray.length) {
            resizeArray();
        }
        stackArray[size++] = value;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        for (int i = index; i < size - 1; i++) {
            stackArray[i] = stackArray[i + 1];
        }
        stackArray[size - 1] = null;
        size--;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            stackArray[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stackArray[size - 1];
    }

    public Object pop() {
        Object value = peek();
        stackArray[size - 1] = null;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resizeArray() {
        int newCapacity = stackArray.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(stackArray, 0, newArray, 0, size);
        stackArray = newArray;
    }
}
