package Sorting;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TeamCanadaSequentialSearch {
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

        for (int i = 0; i < count / 2; i += 2) {
            System.out.println(nameArray[i] + ": " + jerseyArray[i] + "\t" + nameArray[i + 1] + ": " + jerseyArray[i + 1]);
        }

        insertionSort(jerseyArray, nameArray);

        PrintWriter write = new PrintWriter("SortedPlayers.txt");

        for (int i = 0; i < nameArray.length; i++) {
            write.println(nameArray[i]);
            write.println(jerseyArray[i]);
        }
        write.close();


        scan = new Scanner(System.in);

        System.out.println("Enter a name to find their jersey number: ");
        String jerseyName = scan.nextLine();
        boolean found = false;

        for (int i = 0; i < nameArray.length; i++) {
            if (nameArray[i].equals(jerseyName)) {
                System.out.println("The jersey number for that name is: " + jerseyArray[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Name not found, please try again.");
        }
    }

    public static void insertionSort(int[] array, String[] name) {
        for (int i = 1; i < array.length+1; i++) {
            int j = i - 1;
            while (j > 0 && array[j - 1] > array[j]) {
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
}
