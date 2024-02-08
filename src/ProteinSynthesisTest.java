import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProteinSynthesisTest {

    ProteinSynthesis genetics;
    MyQueue<Character> forTesting;
    @BeforeEach
    void setUp() {
        genetics = new ProteinSynthesis();
    }
    @Test
    void transcribeDNA() {
        forTesting = genetics.transcribeDNA("AAGAGATGTCGGTTTGCTAGTTCACGTAAAGGT");
        assertEquals("AAGAGAUGUCGGUUUGCUAGUUCACGUAAAGGU", forTesting.myList.toTestString());

        assertEquals("GCCUCGCGCCACCUCUAAGUAAGUGAGCCGUCGAGACAUUAUCCCUGAUUUUCUCACUACUAUUAGUACUCACGGCGCAAUACCACCACAGCCUUGUCU",
                String.valueOf(genetics.transcribeDNA("GCCTCGCGCCACCTCTAAGTAAGTGAGCCGTCGAGACATTATCCCTGATTTTCTCACTACTATTAGTACTCACGGCGCAATACCACCACAGCCTTGTCT").myList));

        assertThrows(IllegalArgumentException.class, () -> genetics.transcribeDNA("CGCCA"));

        assertFalse(String.valueOf(genetics.transcribeDNA("GAATGCCGGTCAGCA").myList).contains("T"));
    }

    @Test
    void translateRNA() {
        assertEquals("MYS", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("ATGTATTCT")).myList));
        assertEquals("MS", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("AGGATGTCT")).myList));
        assertEquals("M\u0000\u0000", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("ACAGAGATGTAATAC")).myList));
        assertEquals("MELPY", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("ATGGAGTTGCCGTAC")).myList));
        assertTrue(genetics.translateRNA(genetics.transcribeDNA("GAATGCCGGTCAGCA")).isEmpty());
    }
}