import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProteinSynthesisTest {

    ProteinSynthesis genetics;
    @BeforeEach
    void setUp() {
        genetics = new ProteinSynthesis();
    }
    @Test
    void transcribeDNA() {
        assertEquals("AAGAGAUGUCGGUUUGCUAGUUCACGUAAAGGU", genetics.transcribeDNA("AAGAGATGTCGGTTTGCTAGTTCACGTAAAGGT").myList.toTestString());

        assertEquals("GCCUCGCGCCACCUCUAAGUAAGUGAGCCGUCGAGACAUUAUCCCUGAUUUUCUCACUACUAUUAGUACUCACGGCGCAAUACCACCACAGCCUUGUCU",
                genetics.transcribeDNA("GCCTCGCGCCACCTCTAAGTAAGTGAGCCGTCGAGACATTATCCCTGATTTTCTCACTACTATTAGTACTCACGGCGCAATACCACCACAGCCTTGTCT").myList.toTestString());

        assertThrows(IllegalArgumentException.class, () -> genetics.transcribeDNA("CGCCA"));

        assertFalse(genetics.transcribeDNA("GAATGCCGGTCAGCA").myList.toTestString().contains("T"));
    }

    @Test
    void translateRNA() {
        //assertEquals("MYS", genetics.translateRNA(genetics.transcribeDNA("ATGTATTCT")).myList.toTestString());
        assertEquals("MS", genetics.translateRNA(genetics.transcribeDNA("AGGATGTCT")).myList.toTestString());
        assertEquals("M**", genetics.translateRNA(genetics.transcribeDNA("ACAGAGATGTAATAC")).myList.toTestString());
        assertEquals("MELPY", genetics.translateRNA(genetics.transcribeDNA("ATGGAGTTGCCGTAC")).myList.toTestString());
        assertTrue(genetics.translateRNA(genetics.transcribeDNA("GAATGCCGGTCAGCA")).isEmpty());
    }
}