package edu.miu.cs.cs425.arrayutils;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArrayReversorTest {

    @Test
    public void reverseArrayReturnsReversedFlattenedArrayForValidInput() {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] flattenedArray = {1, 3, 0, 4, 5, 9};
        int[] expectedOutput = {9, 5, 4, 0, 3, 1};
        ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);
        when(arrayFlattenerService.flattenArray(input)).thenReturn(flattenedArray);
        ArrayReversor arrayReversor = new ArrayReversor(arrayFlattenerService);

        int[] actualOutput = arrayReversor.reverseArray(input);

        assertArrayEquals(expectedOutput, actualOutput);
        verify(arrayFlattenerService, times(1)).flattenArray(input);
    }

    @Test
    public void reverseArrayReturnsNullForNullInput() {
        ArrayFlattenerService arrayFlattenerService = mock(ArrayFlattenerService.class);
        when(arrayFlattenerService.flattenArray(null)).thenReturn(null);
        ArrayReversor arrayReversor = new ArrayReversor(arrayFlattenerService);

        int[] actualOutput = arrayReversor.reverseArray(null);

        assertNull(actualOutput);
        verify(arrayFlattenerService, times(1)).flattenArray(null);
    }
}
