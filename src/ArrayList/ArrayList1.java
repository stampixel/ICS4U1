package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        enterFromKeyboard(list);

        // Menu goes here, suppose to let user pick which method to run.
        System.out.println("Menu.");
    }

    public static void enterFromKeyboard(ArrayList<Integer> list) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter 10 integers to store inside the ArrayList.");
        for (int i = 0; i < 10; i++) {
            list.add(scan.nextInt());
        }
    }

    public static void countWhole(ArrayList<Integer> list) {
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 0) {
                count++;
            }
        }

        System.out.println("The number of whole numbers inside the ArrayList is " + count);
    }

    public static void display(ArrayList<Integer> list) {
        System.out.print("The integers in order entered are ");

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }

    public static void displayReverse(ArrayList<Integer> list) {
        System.out.print("The integers in reverse order entered are ");

        for (int i = list.size() - 1; i > 0; i--) {
            System.out.print(list.get(i));
        }
    }

    public static void sum(ArrayList<Integer> list) {
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        System.out.println("The sum of all numbers in the list is " + sum);
    }

    public static void average(ArrayList<Integer> list) {
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        int average = ((sum * 10) / 10) / list.size();

        System.out.println("The average of all numbers in the list is " + average);
    }

    public static void findMax(ArrayList<Integer> list) {
        int max = list.get(0);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }

        System.out.println("The maximum number inside the list is " + max);
    }

    public static void findMin(ArrayList<Integer> list) {
        int min = list.get(0);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }

        System.out.println("The minimum number inside the list is " + min);
    }

    public static void search(ArrayList<Integer> list, int number) {
        System.out.print("The number " + number + " is found in the following positions: ");

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == number) {
                System.out.print(i + ", ");
            }
        }
    }
}
