import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    DoublyLinkedList<String> train;
    DoublyLinkedList<String> flights;
    DoublyLinkedList<Integer> numbers;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        train = new DoublyLinkedList<String>();
        flights = new DoublyLinkedList<String>();
        numbers = new DoublyLinkedList<Integer>();
    }

    @org.junit.jupiter.api.Test
    void constructor() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        assertThrows(NullPointerException.class, () -> linkedList.add(null));



    }
    @org.junit.jupiter.api.Test
    void add() {


    }

    @org.junit.jupiter.api.Test
    void testAdd() {
    }

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void contains() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void set() {
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }

    @org.junit.jupiter.api.Test
    void removeMultipleOf() {
    }

    @org.junit.jupiter.api.Test
    void swapSegment() {
    }
}