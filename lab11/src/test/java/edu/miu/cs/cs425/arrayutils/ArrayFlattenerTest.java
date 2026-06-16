package edu.miu.cs.cs425.arrayutils;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class ArrayFlattenerTest {

    private final ArrayFlattener arrayFlattener = new ArrayFlattener();

    @Test
    public void flattenArrayReturnsFlattenedArrayForValidInput() {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] expectedOutput = {1, 3, 0, 4, 5, 9};

        int[] actualOutput = arrayFlattener.flattenArray(input);

        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void flattenArrayReturnsNullForNullInput() {
        int[] actualOutput = arrayFlattener.flattenArray(null);

        assertNull(actualOutput);
    }
}
