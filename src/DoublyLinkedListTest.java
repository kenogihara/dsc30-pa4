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
        assertEquals("HA77", flights.head.next.next.getElement());
        assertEquals("AS100", flights.tail.prev.getElement());

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(5, 6);
        assertEquals(6, numbers.size());
    }

    @Test
    void clear() {
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.clear();
        assertEquals(0, numbers.size());
        assertSame(numbers.head.next.getElement(), numbers.tail.getElement());
        train.add("1");
        train.clear();
        assertEquals(0, train.size());
    }

    @Test
    void contains() {
        numbers.add(10);
        numbers.add(3);
        numbers.add(18);
        assertTrue(numbers.contains(18));
        assertFalse(numbers.contains(1));
        assertTrue(numbers.contains(3));
    }

    @Test
    void get() {
        flights.add("Q12");
        flights.add("JA80");
        flights.add("HA1");
        assertEquals("HA1", flights.get(2));
        assertEquals("Q12", flights.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> flights.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> flights.get(3));
    }

    @Test
    void isEmpty() {
        numbers.add(800);
        assertFalse(numbers.isEmpty());
        assertTrue(flights.isEmpty());
        numbers.removeFirst();
        assertTrue(numbers.isEmpty());
    }

    @Test
    void remove() {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        assertEquals(3, numbers.remove(2));
        assertEquals(4, numbers.head.next.next.next.getElement());
        assertEquals(5, numbers.remove(3));
        assertEquals(3, numbers.size());
        assertThrows(IndexOutOfBoundsException.class, () -> numbers.remove(3));
    }

    @Test
    void set() {
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        assertEquals(2, numbers.set(2, 99999));
        assertEquals(99999, numbers.get(2));
        assertEquals(numbers.tail.prev.prev.prev.prev.prev.prev.prev.getElement(), numbers.head.next.next.next.next.getElement());
        assertThrows(IndexOutOfBoundsException.class, () -> flights.set(1, "HA70"));
        assertThrows(NullPointerException.class, () -> numbers.set(7, null));

    }

    @Test
    void size() {
        assertEquals(0, flights.size());
        flights.add("AS31");
        flights.remove(0);
        assertEquals(0, flights.size());
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        assertEquals(10, numbers.size());
        numbers.remove(3);
        assertEquals(9, numbers.size());
    }

    @Test
    void testToString() {
        train.add("CAR 1");
        assertEquals("[(head) -> CAR 1 -> (tail)]", train.toString());
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        assertEquals("[(head) -> 1 -> 2 -> 3 -> 4 -> 5 -> (tail)]", numbers.toString());

        assertEquals("[(head) -> (tail)]", flights.toString());

        train.add("CAR 2");
        train.add("CAR 3");
        train.add("CAR 4");
        train.add("CAR 5");
        train.add("CAR 6");
        train.add("CAR 7");
        assertEquals("[(head) -> CAR 1 -> CAR 2 -> CAR 3 -> CAR 4 -> CAR 5 -> CAR 6 -> CAR 7 -> (tail)]", train.toString());
    }
}
