import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    MyQueue<Character> dnaTesting;
    MyQueue<String> rollCall;
    MyQueue<Integer> numbers;

    @BeforeEach
    void setUp() {
        dnaTesting = new MyQueue<>();
        rollCall = new MyQueue<>();
        numbers = new MyQueue<>();
    }

    @Test
    void constructor() {
        MyQueue<String> forConstructor = new MyQueue<>();
        forConstructor.enqueue("Ken");
        forConstructor.enqueue("Marina");
        assertEquals(2, forConstructor.size());
        forConstructor.dequeue();
        assertEquals(1, forConstructor.size());
        assertEquals("Marina", forConstructor.peek());
    }
    @Test
    void isEmpty() {
        assertTrue(dnaTesting.isEmpty());
        dnaTesting.enqueue('A');
        assertFalse(dnaTesting.isEmpty());

        for (int i = 0; i < 10; i++) {
            dnaTesting.enqueue('P');
        }
        dnaTesting.clear();
        assertTrue(dnaTesting.isEmpty());
        assertEquals(0, dnaTesting.size());
    }

    @Test
    void size() {
        char[] alphabet = new char[] {'f', 'g', 'h', 'i'};
        for (char elem: alphabet) {
            dnaTesting.enqueue((char) elem);
        }

        assertEquals(4, dnaTesting.size());
        dnaTesting.dequeue();
        assertEquals(3, dnaTesting.size());
        dnaTesting.dequeue();
        dnaTesting.dequeue();
        dnaTesting.dequeue();
        assertEquals(0, dnaTesting.size());
    }

    @Test
    void clear() {
        char[] alphabet = new char[] {'f', 'g', 'h', 'i', 'j', 'k'};
        for (int elem: alphabet) {
            dnaTesting.enqueue((char) elem);
        }

        assertEquals(6, dnaTesting.size());
        dnaTesting.clear();
        assertTrue(dnaTesting.isEmpty());
        assertEquals(0, dnaTesting.size());

        rollCall.clear();
        assertTrue(rollCall.isEmpty());
    }

    @Test
    void enqueue() {

        assertThrows(IllegalArgumentException.class, () -> rollCall.enqueue(null));
        dnaTesting.enqueue('k');
        assertEquals('k', dnaTesting.peek());
        dnaTesting.enqueue('e');
        assertEquals('e', dnaTesting.myList.get(1));
        assertEquals(2, dnaTesting.size());

        dnaTesting.enqueue('n');
        dnaTesting.enqueue('o');
        dnaTesting.enqueue('g');
        dnaTesting.enqueue('i');
        assertEquals('i', dnaTesting.myList.get(5));

        dnaTesting.enqueue('h');
        dnaTesting.enqueue('a');
        dnaTesting.enqueue('r');
        dnaTesting.enqueue('a');
        assertEquals(10, dnaTesting.size());

        dnaTesting.enqueue('a');
        assertEquals(11, dnaTesting.size());
    }

    @Test
    void dequeue() {
        assertNull(numbers.dequeue());
        int[] integers = new int[] {1, 2, 3, 4, 5};
        for (int elem: integers) {
            numbers.enqueue((int) elem);
        }
        assertEquals(1, numbers.dequeue());
        assertEquals(2, numbers.dequeue());
        assertEquals(3, numbers.dequeue());

        int[] newIntegers = new int[] {6, 7, 8, 9, 10};
        for (int elem: newIntegers) {
            numbers.enqueue((int) elem);
        }
        numbers.enqueue(11);

        assertEquals(4, numbers.dequeue());
        assertEquals(7, numbers.size());
        assertEquals(5, numbers.dequeue());
        assertEquals(6, numbers.size());
    }

    @Test
    void peek() {
        assertNull(rollCall.dequeue());

        rollCall.enqueue("Ken");

        assertEquals("Ken", rollCall.peek());
        rollCall.dequeue();

        String[] friends = new String[] {"Andrew", "Marina", "Aria", "Ricky"};
        for (String elem: friends) {
            rollCall.enqueue((String) elem);
        }
        assertEquals("Andrew", rollCall.peek());
        assertEquals("Aria", rollCall.myList.get(2));
        rollCall.clear();
        assertNull(rollCall.dequeue());

    }
}