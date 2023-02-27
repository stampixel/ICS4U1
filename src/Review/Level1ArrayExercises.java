package Review;

import java.util.Scanner;

/**
 * @author kevin.tang
 * 2022.02.12
 */

public class Level1ArrayExercises {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        numbers = enterFromKeyboard(initializeArray(numbers));
    }

    /**
     * Initialize array with every index filled with -1
     *
     * @param array
     * @return
     */
    public static int[] initializeArray(int[] array) {
        // Arrays.fill(array, -1);
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        return array;
    }

    /**
     * Prompt user to enter array values
     *
     * @param array
     * @return
     */
    public static int[] enterFromKeyboard(int[] array) {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            int num = scan.nextInt();
            array[i] = num;
        }
        return array;
    }

    /**
     * Count all whole numbers
     *
     * @param array
     * @return
     */
    public static int countWhole(int[] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Display array in ordered way
     *
     * @param array
     */
    public static void display(int[] array) {
        System.out.println("The integers in order entered is ");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Display array in reverse order
     *
     * @param array
     */
    public static void displayReverse(int[] array) {
        System.out.println("The integers in reversed order entered is ");

        for (int i = array.length - 1; i > 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Get the sum of all numbers inside the array
     *
     * @param array
     */
    public static void sum(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        System.out.println("The sum of all integers in the array is: " + sum);
    }

    /**
     * Get the average of all numbers in the array
     *
     * @param array
     */
    public static void average(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        double average = Math.round(sum / array.length * 10) / 10.0;

        System.out.println("The average of all numbers is: " + average);
    }

    /**
     * Finding the max value
     *
     * @param array
     */
    public static void findMax(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("The max number is: " + max);
    }

    /**
     * Finding the min value
     *
     * @param array
     */
    public static void findMin(int[] array) {
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        System.out.println("The min number is: " + min);
    }

    /**
     * Search for numbers and getting their location index
     *
     * @param array
     * @param number
     */
    public static void search(int[] array, int number) {
        boolean[] location = new boolean[array.length]; // Value defaults to false

        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                location[i] = true;
            }
        }

        System.out.println("The number " + number + " is found in the following positions: ");

        for (int i = 0; i < location.length; i++) {
            if (location[i]) {
                System.out.print(i + 1);
            }
        }
    }
}
