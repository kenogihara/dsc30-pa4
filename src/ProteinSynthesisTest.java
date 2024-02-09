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
        assertEquals("", genetics.transcribeDNA("").myList.toTestString());
        assertFalse(genetics.transcribeDNA("GAATGCCGGTCAGCA").myList.toTestString().contains("T"));
    }

    @Test
    void translateRNA() {
        assertEquals("MYS", genetics.translateRNA(genetics.transcribeDNA("ATGTATTCT")).myList.toTestString());
        assertEquals("MS", genetics.translateRNA(genetics.transcribeDNA("AGGATGTCT")).myList.toTestString());
        assertEquals("M*", genetics.translateRNA(genetics.transcribeDNA("ACAGAGATGTAATAC")).myList.toTestString());
        assertEquals("MELPY", genetics.translateRNA(genetics.transcribeDNA("ATGGAGTTGCCGTAC")).myList.toTestString());
        assertEquals("MY*", genetics.translateRNA(genetics.transcribeDNA("TATTATATGTATTAA")).myList.toTestString());
        assertEquals("MIS*", genetics.translateRNA(genetics.transcribeDNA("ATGATCTCGTAA")).myList.toTestString());
        assertEquals("", genetics.translateRNA(genetics.transcribeDNA("CCCCTGTCATAA")).myList.toTestString());
        assertEquals("MLC", genetics.translateRNA(genetics.transcribeDNA("ATGCTATGT")).myList.toTestString());
        assertTrue(genetics.translateRNA(genetics.transcribeDNA("GAATGCCGGTCAGCA")).isEmpty());
        assertTrue(genetics.translateRNA(genetics.transcribeDNA("")).isEmpty());
        assertEquals("", genetics.translateRNA(genetics.transcribeDNA("")).myList.toTestString());
    }
}