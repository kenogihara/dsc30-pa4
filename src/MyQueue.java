/*
    Name: Ken Ogihara
    PID:  A16969236
 */

/**
 * Implementation of MyQueue class
 *
 * @author Ken Ogihara
 * @since ${2/7/24}
 */

public class MyQueue<T> implements MyQueueInterface<T> {
    
    /* instance variables, feel free to add if you need */
    public DoublyLinkedList<T> myList;
    /* ===separation=== */

    /**
     * Constructor to create a new, double linked list.
     */
    public MyQueue() {
        myList = new DoublyLinkedList<T>();
    }

    /**
     * Method that checks whether the queue is empty.
     *
     * @return whether or not the queue is empty.
     */
    public boolean isEmpty() {
        return myList.isEmpty();
    }

    /**
     * Method that checks the number of elements in the queue.
     *
     * @return an integer that represents the size of the queue.
     */
    public int size() {
        return myList.size();
    }

    /**
     * Method that clears the queue.
     */
    public void clear() {
        myList.clear();
    }

    /**
     * Method that adds an element to the queue.
     *
     * @param data which is an element that will be added to the queue.
     * @throws IllegalArgumentException if the given data is null.
     */
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("data is null");
        }
        myList.add(data);
    }

    /**
     * Method that removes an element at the front of the queue.
     *
     * @return the element at the front of the queue; null if the queue is empty.
     */
    public T dequeue() {
        return myList.remove(0);
    }

    /**
     * Method that returns the element at the front of queue.
     *
     * @return the element at the front of the queue; null if the queue is empty.
     */
    public T peek() {
        return myList.get(0);
    }

    public String toString() {
        if (myList.isEmpty()) {
            return "";
        }
        String output = "";
        for (T elem: myList) output += elem + "";
        return output;
    }
}
