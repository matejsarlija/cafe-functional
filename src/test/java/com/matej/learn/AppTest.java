package com.matej.learn;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    public void whenReverseIsCalled_ThenCorrectStringIsReturned() {
        String reversed = App.reverse("matej");
        String reversedNull = App.reverse(null);
        String reversedEmpty = App.reverse("");

        // edge case je i samo jedno slovo

        assertEquals("jetam", reversed);
        assertEquals(null, reversedNull);
        assertEquals("", reversedEmpty);
        


    }
}
