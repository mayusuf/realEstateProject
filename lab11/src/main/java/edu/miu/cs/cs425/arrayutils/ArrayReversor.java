package edu.miu.cs.cs425.arrayutils;

public class ArrayReversor {

    private final ArrayFlattenerService arrayFlattenerService;

    public ArrayReversor(ArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }

    public int[] reverseArray(int[][] input) {
        int[] flattenedArray = arrayFlattenerService.flattenArray(input);
        if (flattenedArray == null) {
            return null;
        }

        int[] reversedArray = new int[flattenedArray.length];
        for (int index = 0; index < flattenedArray.length; index++) {
            reversedArray[index] = flattenedArray[flattenedArray.length - 1 - index];
        }

        return reversedArray;
    }

    public static void main(String[] args) {
        ArrayFlattenerService arrayFlattenerService = new ArrayFlattener()::flattenArray;
        ArrayReversor arrayReversor = new ArrayReversor(arrayFlattenerService);
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] output = arrayReversor.reverseArray(input);

        for (int value : output) {
            System.out.print(value + " ");
        }
    }
}
