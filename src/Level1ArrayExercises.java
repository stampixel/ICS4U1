import java.util.Scanner;

public class Level1ArrayExercises {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        numbers = enterFromKeyboard(initializeArray(numbers));
    }

    public static int[] initializeArray(int[] array) {
        // Arrays.fill(array, -1);
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        return array;
    }

    public static int[] enterFromKeyboard(int[] array) {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            int num = scan.nextInt();
            array[i] = num;
        }
        return array;
    }

    public static int countWhole(int[] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                count++;
            }
        }
        return count;
    }

    public static void display(int[] array) {
        System.out.println("The integers in order entered is ");

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void displayReverse(int[] array) {
        System.out.println("The integers in reversed order entered is ");

        for (int i = array.length - 1; i > 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    public static void sum(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        System.out.println("The sum of all integers in the array is: " + sum);
    }

    public static void average(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        double average = Math.round(sum / array.length * 10) / 10.0;

        System.out.println("The average of all numbers is: " + average);
    }

    public static void findMax(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("The max number is: " + max);
    }

    public static void findMin(int[] array) {
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        System.out.println("The min number is: " + min);
    }

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
