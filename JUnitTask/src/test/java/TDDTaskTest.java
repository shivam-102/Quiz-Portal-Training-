import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TDDTaskTest {

    @org.junit.jupiter.api.Test
    void removal() {

    }
    @Test
    void testRemoval() {
        assertEquals("BAA",TDDTask.removal("AABAA"));
        assertEquals("BCD",TDDTask.removal("ABCD"));
        assertEquals("CD",TDDTask.removal("AACD"));
        assertEquals("BCD",TDDTask.removal("BACD"));
        assertEquals("BBAA",TDDTask.removal("BBAA"));
        assertEquals("AA",TDDTask.removal("AA"));
    }
}