package Sorting;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TeamCanadaBinarySearch {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("TeamCanada.txt"));
        int count = 0;

        // Keep track of the number of lines (52)
        while (scan.hasNextLine()) {
            count++;
            scan.nextLine();
        }

        String[] nameArray = new String[count / 2];
        int[] jerseyArray = new int[count / 2];
        scan = new Scanner(new File("TeamCanada.txt"));


        for (int i = 0; i < count / 2; i++) {
            nameArray[i] = scan.nextLine();
            jerseyArray[i] = scan.nextInt();
            scan.nextLine();
        }
//
//        for (int i = 0; i < count / 2; i += 2) {
//            System.out.println(nameArray[i] + ": " + jerseyArray[i] + "\t" + nameArray[i + 1] + ": " + jerseyArray[i + 1]);
//        }

        insertionSort(jerseyArray, nameArray);
        for (int i = 0; i < count / 2; i += 2) {
            System.out.println(nameArray[i] + ": " + jerseyArray[i] + "\t" + nameArray[i + 1] + ": " + jerseyArray[i + 1]);
        }

        PrintWriter write = new PrintWriter("SortedPlayers.txt");

        for (int i = 0; i < nameArray.length; i++) {
            write.println(nameArray[i]);
            write.println(jerseyArray[i]);
        }
        write.close();


        scan = new Scanner(System.in);

        System.out.println("Enter a name to find their jersey number: ");
        String jerseyName = scan.nextLine();

        int jerseyIndex = binarySearch(nameArray, jerseyName);
        if (jerseyIndex != -1) {
            System.out.println("The jersey number for that name is: " + jerseyArray[jerseyIndex]);
        } else {
            System.out.println("Name not found, please try again.");
        }
    }

    public static void insertionSort(int[] array, String[] name) {
        for (int i = 1; i < name.length + 1; i++) {
            int j = i - 1;
            while (j > 0 && name[j - 1].compareTo(name[j]) > 0) {

                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;

                String tempName = name[j];
                name[j] = name[j - 1];
                name[j - 1] = tempName;
                j = j - 1;
            }
        }
    }

    public static int binarySearch(String[] array, String name) {
        int low = 0;
        int high = array.length;
        int mid = (low + high) / 2;

        while (low != high) {
            mid = (low + high) / 2;
            if (name.equals(array[mid])) {
                return mid;
            } else if (name.compareTo(array[mid]) > 0) {
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
}
