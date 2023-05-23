package Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {3, 5, 6, 2, 6, 2, 1};

        for (int i = 1; i < array.length + 1; i++) {
            int j = i-1;
            while (j > 0 & array[j - 1] > array[j]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j = j - 1;
            }
        }
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
