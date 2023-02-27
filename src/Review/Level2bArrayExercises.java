package Review;

import java.util.Scanner;

public class Level2bArrayExercises {
    /**
     * Write a procedure called countOccurrences which will prompt the user to enter a
     * natural number from 1 to 10 (stop entering numbers when the user enters a number
     * outside the range). The procedure will output the number of the times each number
     * was entered.
     *
     * @param args
     */
    public static void main(String[] args) {
        countOccurrences2();

    }

    public static void countOccurrences() {
        Scanner scan = new Scanner(System.in);
        int[] numbers = new int[11];

        int num;

        while (true) {
            System.out.print("Please input a number: ");
            num = scan.nextInt();

            if (num >= 1 && num <= 10) {
                numbers[num] += 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < numbers.length; i++) {
            System.out.println("The number " + i + " is entered " + numbers[i] + " times.");
        }
    }

    public static void countOccurrences2() {
        Scanner scan = new Scanner(System.in);
        int[] numbers = new int[26];

        int num;

        while (true) {
            System.out.print("Please input a number: ");
            num = scan.nextInt();

            if (num >= 15 && num <= 25) {
                numbers[num] += 1;
            } else {
                break;
            }
        }

        for (int i = 15; i < numbers.length; i++) {
            System.out.println("The number " + i + " is entered " + numbers[i] + " times.");
        }
    }

    public static void totals() {
        Scanner scan = new Scanner(System.in);
        int[] numbers = new int[101];

        int num;

        while (true) {
            System.out.print("Please input a number: ");
            num = scan.nextInt();

            if (num >= 1 && num <= 100) {
                numbers[num] += 1;
            } else {
                break;
            }
        }

        int sum = 0;
        for (int i = 1; i < numbers.length; i++) {

            if (i % 10 == 0) {
                System.out.println("The sum of numbers entered between the range is " + sum);
                sum = 0;
                sum += i * numbers[i];
            }
            sum += i * numbers[i];

        }
    }
}
