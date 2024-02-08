/*
 * NAME: Ken Ogihara
 * PID: A16969236
 */

import java.sql.SQLOutput;
import java.util.AbstractList;

/**
 * Implementation of DoubleLinkedList class and Node subclass.
 * @author Ken Ogihara
 * @since A16969236
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    public Node head;
    public Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            data = element;
            next = null;
            prev = null;
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            data = element;
            next = nextNode;
            prev = prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            data = element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {
            return data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            return next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            return prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            prev.setNext(next);
            next.setPrev(prev);
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        if (nelems == 0) {
            head.next = new Node(element, tail, head);
            tail.prev = head.next;
            nelems++;
            return true;
        } else {
            tail.prev.next = tail.prev = new Node(element, tail, tail.prev);
            nelems++;
            return true;
        }
    }


    /**
     * Adds an element to a certain index in the list, shifting existing elements
     * create room. Does not accept null values.
     *
     * @param index   in which the element is inserted.
     * @param element that will be inserted.
     * @throws IndexOutOfBoundsException if the index is outside the specified range.
     * @throws NullPointerException      if the element is null.
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        if (index < 0 || index > nelems) {
            throw new IndexOutOfBoundsException("Index outside of range");
        }
        Node newNode = new Node(element);
        Node node = head.next;
        int count = 1;
        while (count < index) {
            node = node.next;
            count++;
        }
        Node current;
        current = node.next;
        newNode.next = current;
        newNode.prev = node;
        node.next = newNode;
        current.prev = newNode;
        nelems++;
    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        head.next = tail;
        tail.prev = head;
        nelems = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     *
     * @param element that may or may not be in the list.
     * @return whether or not the list contains the element.
     */
    @Override
    public boolean contains(Object element) {
        T data = (T) element;
        Node current = head.next;
        while (current != null) {
            if (current.data == element) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     *
     * @param index in which the element is stored in.
     * @return the element that the node at the specified index is currently storing.
     * @throws IndexOutOfBoundsException if the index is outside the specified range.
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > nelems - 1) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return this.getNth(index).getElement();
    }

    /**
     * Helper method to get the Nth node in our list
     *
     * @return the node at the specified index.
     * @index in which the element is stored in.
     */
    private Node getNth(int index) {
        Node current = head;
        for (int i = 0; i < index + 1; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Method that prints all elements in a list in the order of their index.
     */
    public void show() {
        Node node = head;
        while (node.next != null) {
            System.out.print(node.data + ", ");
            node = node.next;
        }
        System.out.print(node.data);
    }


    /**
     * Determine if the list empty
     *
     * @return whether or not the list is empty.
     */
    @Override
    public boolean isEmpty() {
        return nelems == 0;
    }

    /**
     * Remove the element from position index in the list
     *
     * @param index in which the element is removed.
     * @return element that's removed from the list.
     * @throws IndexOutOfBoundsException if the index is outside the specified range.
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > nelems - 1) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Node current = head;
        for (int i = 0; i < index + 1; i++) {
            current = current.next;
        }
        current.next.prev = current.prev;
        current.prev.next = current.next;
        nelems--;
        return current.data;
    }

    /**
     * Set the value of an element at a certain index in the list.
     *
     * @param index   in which the element will be altered.
     * @param element the new data that will replace the old data.
     * @return the data that was previously stored at the specified location.
     * @throws IndexOutOfBoundsException if the index is outside the specified range.
     * @throws NullPointerException      if the element received is null.
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        if (index < 0 || index > nelems - 1) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        Node current = head;
        for (int i = 0; i < index + 1; i++) {
            current = current.next;
        }
        T temp = current.data;
        current.data = element;
        return temp;

    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     * @return the number of elements in a list.
     */
    @Override
    public int size() {
        return nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     * <p>
     * @return a string that represents a linked list.
     */
    @Override
    public String toString() {
        String headStringFormat = "[(head)";
        String tailStringFormat = " (tail)]";
        String output = "";
        Node current = head.next;

        if (this.isEmpty()) {
            return headStringFormat + " ->" + tailStringFormat;
        }
        while (current != null) {
            output += String.format(" -> %s", current.data);
            if (current.next == tail) {
                return headStringFormat + output + " ->" + tailStringFormat;
            }
            current = current.next;
        }
        return headStringFormat + output + tailStringFormat;
    }

    public String toTestString() {
        String output = "";
        Node current = head.next;
        while (current != null) {
            output += String.valueOf(current.data);
            if (current.next == tail) {
                return output;
            }
            current = current.next;
        }
        return output;
    }

}
