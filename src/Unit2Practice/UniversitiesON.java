package Unit2Practice;

/**
 * @author kevin.tang
 * 2023.03.06
 */

import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;


public class UniversitiesON {

    /**
     * You will create a University List program to help you with your choice of post-secondary schools.
     * <p>
     * You will need an ArrayList in your main method to store your Ontario Universities.
     * <p>
     * You will need to create a numbered menu loop that will allow you to do the following:
     * addSchools()
     * displaySchools()
     * chooseSchools()
     * areSchoolsChosen()
     * Quit the program
     *
     * @param args
     */

    // Make scanner globalf
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<String> schools = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int menuChoice = 0;

        while (menuChoice != 5) {
            System.out.println("Please enter a choice (1-5)");
            System.out.println("1. addSchools()\n" +
                    "2. displaySchools()\n" +
                    "3. chooseSchools()\n" +
                    "4. areSchoolsChosen()\n" +
                    "5. Quit the program\n");
            menuChoice = scan.nextInt();

            if (menuChoice == 1) {

            } else if (menuChoice == 2) {

            } else if (menuChoice == 3) {

            } else if (menuChoice == 4) {

            } else if (menuChoice == 5) {

            }
        }


    }

    /**
     * This method should take in your ArrayList as a parameter and asks the user to enter up to 6 distinct Ontario
     * universities to be added to the ArrayList.
     *
     * @param schools
     */
    public static void addSchools(ArrayList<String> schools) {

        // Make a way to exit loop, make it so universities are distinct, nested-loop
        System.out.println("Enter 6 Ontario Universities to be added to the list.");

        for (int i = 0; i < 6; i++) {
            System.out.print("Enter school: ");
            schools.add(scan.next());
        }
    }

    /**
     * This method should take in your ArrayList as a parameter and then outputs the list in an appropriate format.
     * It should have a clause included in case the ArrayList is empty.
     *
     * @param schools
     */
    public static void displaySchools(ArrayList<String> schools) {
        if (schools.size() == 0) {
            System.out.println("Array list is empty.");
        } else {
            System.out.println("Here is a list of Ontario schools.");
            for (int i = 0; i < schools.size() - 1; i++) {
                System.out.print(schools.get(i) + " ");
            }
        }
    }

    /**
     * This method should take in your ArrayList and a chosen school as a parameter and then inserts three plus signs
     * as the element after your choice. If should have appropriate messages if the school is not in the ArrayList.
     *
     * @param schools
     * @param school
     */
    public static void chooseSchools(ArrayList<String> schools, String school) {
        if (schools.contains(school)) {
            schools.add(schools.indexOf(school), "+++");
        } else {
            System.out.println("School not in array.");
        }
    }

    /**
     * This method should take in your ArrayList as a parameter and returns true if all schools in the Array are
     * chosen. The main menu can receive this value and produce an appropriate message.
     *
     * @param schools
     * @return
     */
    public static boolean allSchoolsChosen(ArrayList<String> schools) {
        // Count number of non-+++ and number of +++

        int chooseCounter = 0;
        int unchosenCounter = 0;
        for (int i = 0; i < schools.size() - 1; i++)
            if ("+++".equals(schools.get(i))) {
                chooseCounter += 1;
            } else {
                unchosenCounter += 1;
            }
        return chooseCounter == unchosenCounter;
    }
}
