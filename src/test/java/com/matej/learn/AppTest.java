package com.matej.learn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.Arrays;


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

    @Test
    public void reverseAnArrayInPlaceDestroysIt() {
        
        int[] origArray = {1, 2, 3, 4, 5};
        
        App.reverseIn(origArray);
        
        int[] testArray = {1, 2, 3, 4, 5};
        
        assertFalse(Arrays.equals(origArray, testArray));
    }

    @Test
    public void reverseAnEvenArraySuccessfully() {
        
        int[] origArray = {1, 2, 3, 4};
        
        App.reverseIn(origArray);
        
        int[] testArray = {4, 3, 2, 1};
        
        assertArrayEquals(origArray, testArray);
    }

    @Test
    public void reversesASingleMemberArray() {
        
        int[] origArray = {1};
        
        App.reverseIn(origArray);
        
        int[] testArray = {1};
        
        assertArrayEquals(origArray, testArray);
    }
}
