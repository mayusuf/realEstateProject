package edu.miu.cs.cs425.arrayutils;

public class ArrayFlattener {

    public int[] flattenArray(int[][] input) {
        if (input == null) {
            return null;
        }

        int flattenedLength = 0;
        for (int[] nestedArray : input) {
            if (nestedArray != null) {
                flattenedLength += nestedArray.length;
            }
        }

        int[] flattenedArray = new int[flattenedLength];
        int currentIndex = 0;
        for (int[] nestedArray : input) {
            if (nestedArray != null) {
                for (int value : nestedArray) {
                    flattenedArray[currentIndex] = value;
                    currentIndex++;
                }
            }
        }

        return flattenedArray;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] output = new ArrayFlattener().flattenArray(input);

        for (int value : output) {
            System.out.print(value + " ");
        }
    }
}
