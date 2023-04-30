package Sorting;

import java.util.Scanner;

public class SearchingForAnAssignment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] name = new String[5];
        String[] phoneNumber = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Please enter name: ");
            name[i] = scan.nextLine();
            System.out.print("Enter the phone number for the name: ");
            phoneNumber[i] = scan.nextLine();
        }

        selectionSort(name);
        printArray(name);

        System.out.print("Enter a name to search for: ");
        String searchName = scan.nextLine();

        System.out.println("The specific name is found in index " + binarySearch(name, searchName));
    }

    public static void selectionSort(String[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex].compareTo(array[j]) > 0) {
                    minIndex = j;
                }
            }
            String temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void sequentialSearch(String[] array, String name) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(name)) {
                System.out.println("The index of the name is " + i);
            }
        }
    }

    public static int binarySearch(String[] array, String name) {
        int low = 0;
        int high = array.length;
        int i = 0;
        int mid = (low + high) / 2;

        while (low != high) {
            mid = (low + high) / 2;
            if (array[mid].equals(name)) {
                return mid;
            } else if (array[mid].compareTo(name) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            if (low == high) {
                return -1;
            }
        }
        return mid;
    }

    public static void printArray(String[] array) {
        for (String i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
