package com.Task.JUnit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TDDTaskTest {
    @Test
    void testRemoval() {
        assertEquals("BAA",TDDTask.removal("AABAA"));
        assertEquals("BCD",TDDTask.removal("ABCD"));
        assertEquals("CD",TDDTask.removal("AACD"));
        assertEquals("BCD",TDDTask.removal("BACD"));
        assertEquals("BBAA",TDDTask.removal("BBAA"));
    }
}