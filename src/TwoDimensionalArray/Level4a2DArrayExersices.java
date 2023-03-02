package TwoDimensionalArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Level4a2DArrayExersices {
    public static void main(String[] args) throws FileNotFoundException {
        int[][] array = new int[3][4];

        populate2(array);
        transpose(array);
    }

    public static void populate(int[][] array) {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print("Enter value for row " + (i + 1) + ", column " + (j + 1) + ": ");
                array[i][j] = scan.nextInt();
            }
        }
    }

    public static void populate2(int[][] array) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("arraylist.txt"));

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = scan.nextInt();
            }
        }
    }

    public static void display(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void transpose(int[][] array) {
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j][i] + " ");
            }
            System.out.println();
        }
    }

    public static void sum(int[][] array) {

    }
}



