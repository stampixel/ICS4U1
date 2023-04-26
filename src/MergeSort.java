/**
 * @author kevin.tang
 * 2023.04.25
 * Merge Sorting Algorithm
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {6, 3, 7, 1, 12, 9};
        printArray(array);
        mergeSort(array);
        printArray(array);
    }

    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            // Getting the middle index of the array
            int mid = array.length / 2;

            // Creating sub-array for left side of main array
            int[] L = new int[mid];
            for (int i = 0; i < mid; i++) {
                L[i] = array[i];
            }

            // Creating sub-array for right side of main array
            int[] R = new int[array.length - mid];
            int index = 0;
            for (int i = mid; i < array.length; i++) {
                R[index] = array[i];
                index++;
            }

            // Recursive methods, which will lead up to each sub-array only having 1 element
            mergeSort(L);
            mergeSort(R);

            int i = 0, j = 0, k = 0;

            // Traverse through the two sub-arrays and placing all elements in the correct order in the main array
            while (i < L.length && j < R.length) {
                if (L[i] <= R[j]) {
                    array[k] = L[i];
                    i++;
                } else {
                    array[k] = R[j];
                    j++;
                }
                k++;
            }

            // Place the final element from either array to the main array
            while (i < L.length) {
                array[k] = L[i];
                i++;
                k++;
            }
            while (j < R.length) {
                array[k] = R[j];
                j++;
                k++;
            }

        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
