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
     * TODO: Javadoc comments
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
        Node prev = head;
        int count = 1;
        while (count < index) {
            prev = prev.next;
            count++;
        }
        Node current;
        current = prev.next;
        newNode.next = current;
        newNode.prev = prev;
        prev.next = newNode;
        current.prev = newNode;
        nelems++;
    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        Node temp = new Node(null);
        Node delete = null;
        while (head != null) {
            delete = head.next;
            head = null;
            head = delete;
        }
        tail = null;
        nelems = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     *
     * TODO: Javadoc comments
     */
    @Override
    public boolean contains(Object element) {
        T data = (T) element;
        Node current = head;
        while (current != null) {
            if (current == element) {
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
     * @throws IndexOutOfBoundsException if the index is outside the specified range.
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > nelems - 1) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        for (int i = 0; i < nelems; i++) {

        }
        return null;
    }

    /**
     * Helper method to get the Nth node in our list
     *
     * TODO: Javadoc comments
     */
    private Node getNth(int index) {
        // TODO: implement
        return null;
    }


    /**
     * Helper method to get the Nth node in our list
     * <p>
     * TODO: Javadoc comments
     */
    public Node getHead() {
        return this.head;
    }


    /**
     * Helper method to get the Nth node in our list
     *
     * TODO: Javadoc comments
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
     * Helper method to get the Nth node in our list
     *
     * TODO: Javadoc comments
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Determine if the list empty
     *
     * TODO: javadoc comments
     */
    @Override
    public boolean isEmpty() {
        return nelems == 0;
    }

    /**
     * Remove the element from position index in the list
     *
     * TODO: javadoc comments
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    /**
     * Set the value of an element at a certain index in the list.
     *
     * TODO: javadoc comments
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        // TODO: Fill in implmentation
        return null;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     * TODO: javadoc comments
     */
    @Override
    public int size() {
        return nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     *
     * TODO: javadoc comments
     */
    @Override
    public String toString() {
        return null;
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Remove nodes whose index is a multiple of base
     *
     * TODO: javadoc comments
     */
    public void removeMultipleOf(int base) {
        // TODO: complete implementation       
    }

    /**
     * Swap the nodes between index [0, splitIndex] of two lists
     *
     * TODO: javadoc comments
     */
    public void swapSegment(DoublyLinkedList<T> other, int splitIndex) {
        // TODO: complete implementation
    }

}
