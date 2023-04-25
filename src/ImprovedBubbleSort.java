public class ImprovedBubbleSort {
    public static void main(String[] args) {
        int[] array = {2, 123, 125, 5, 12, 9, 4, 1};

        array = new int[]{13, 5, 17, 15, 3, 7};
        int comparisonCounter = 0;

        boolean swapped = true;
        int j = 0;

        while (swapped) {
            swapped = false; // Resetting the swap to false
            j++;
            for (int i = 0; i < array.length - j; i++) {
                comparisonCounter ++;
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true; // Swap was made
                }
            }
            printArray(array);
        }

//        printArray(array);
        System.out.println(comparisonCounter);
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

/**
 * What is improved bubble sort?
 *  Is when we keep track of is the current pass has made a swap or not, if not, it means the array is already sorted, meaning we can terminate the program.
 *
 * Why learn about this?
 *  Traditional bubble sorting is not the fastest, so this is a way to lower the time complexity.
 *
 * How does it work?
 *  Have a boolean variable, set it to false at the beginning of every pass, if we find out that a pass was made, set it to true. Place everything in a while loop that only runs when the varialbe is true.
 *
 * Show how it works for a list of numbers: 3, 6, 5, 4, 2
 *
 *
 * 	Pass 1:						Pass 2:
 *  3 5 4 2 6                   3 4 2 5 6
 *
 *
 *
 *
 * 	Pass 3:						Pass 4:
 *  3 2 4 5 6                   2 3 4 5 6
 *
 *
 *
 *
 * How many comparisons did the computer make?
 *  10 comparisons
 *
 * Compare and contrast bubble sort and improved bubble sort:
 *  - both are sorting algorithms
 *
 *  - improved bubble sort is generally faster
 */