package TwoDimensionalArray;

import java.util.Scanner;

public class Level4a2DArrayExersices {
    public static void main(String[] args) {
        int[][] array = new int[3][4];
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

    public static void populate2() {

    }
}
