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
        assertEquals("AAGAGAUGUCGGUUUGCUAGUUCACGUAAAGGU", genetics.transcribeDNA("AAGAGATGTCGGTTTGCTAGTTCACGTAAAGGT").toString());

        assertEquals("GCCUCGCGCCACCUCUAAGUAAGUGAGCCGUCGAGACAUUAUCCCUGAUUUUCUCACUACUAUUAGUACUCACGGCGCAAUACCACCACAGCCUUGUCU",
                genetics.transcribeDNA("GCCTCGCGCCACCTCTAAGTAAGTGAGCCGTCGAGACATTATCCCTGATTTTCTCACTACTATTAGTACTCACGGCGCAATACCACCACAGCCTTGTCT").toString());

        assertThrows(IllegalArgumentException.class, () -> genetics.transcribeDNA("CGCCA"));

        assertFalse(genetics.transcribeDNA("GAATGCCGGTCAGCA").toString().contains("T"));
    }

    @Test
    void translateRNA() {
        assertEquals("MYS", genetics.translateRNA(genetics.transcribeDNA("ATGTATTCT")).toString());
        assertEquals("MS", genetics.translateRNA(genetics.transcribeDNA("AGGATGTCT")).toString());
        //assertEquals("M*", genetics.translateRNA(genetics.transcribeDNA("ACAGAGATGTAATAC")).myList.toTestString());
        //assertEquals("MELPY", genetics.translateRNA(genetics.transcribeDNA("ATGGAGTTGCCGTAC")).myList.toTestString());
        //assertTrue(genetics.translateRNA(genetics.transcribeDNA("GAATGCCGGTCAGCA")).isEmpty());
        //assertTrue(genetics.translateRNA(genetics.transcribeDNA("")).isEmpty());
        //assertEquals("", genetics.translateRNA(genetics.transcribeDNA("")).myList.toTestString());




    }
}