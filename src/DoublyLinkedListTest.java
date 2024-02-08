import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    DoublyLinkedList<String> train;
    DoublyLinkedList<String> flights;
    DoublyLinkedList<Integer> numbers;

    @BeforeEach
    void setUp() {
        train = new DoublyLinkedList<>();
        flights = new DoublyLinkedList<>();
        numbers = new DoublyLinkedList<>();
    }

    @Test
    void constructor() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        assertNull(linkedList.head.getElement());
        assertNull(linkedList.tail.getElement());
        assertEquals(linkedList.head.next, linkedList.tail);
        assertSame(linkedList.tail.prev, linkedList.head);
    }

    @Test
    void add() {
        assertThrows(NullPointerException.class, () -> flights.add(null));
        assertTrue(flights.add("HA16"));
        flights.add("AS43");
        flights.add("JA991");
        assertEquals(flights.head.next.next.getElement(), flights.tail.prev.prev.getElement());
        assertEquals("HA16", flights.tail.prev.prev.prev.getElement());
    }

    @Test
    void testAdd() {

        assertThrows(IndexOutOfBoundsException.class, () -> flights.add(1, "JA56"));
        assertThrows(IndexOutOfBoundsException.class, () -> flights.add(-1, "JA56"));
        flights.add("DL1");
        assertThrows(NullPointerException.class, () -> flights.add(1, null));
        flights.add(1, "JA6");
        flights.add(1, "HA77");
        flights.add(3, "AS100");
        assertEquals(4, flights.size());
        assertEquals("JA6", flights.head.next.next.getElement());
        assertEquals("DL1", flights.tail.prev.getElement());

    }

    @Test
    void clear() {
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.clear();
        numbers.show();
    }

    @Test
    void contains() {
    }

    @Test
    void get() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void remove() {
    }

    @Test
    void set() {
    }

    @Test
    void size() {
    }

    @Test
    void testToString() {
    }

    @Test
    void removeMultipleOf() {
    }

    @Test
    void swapSegment() {
    }

}

