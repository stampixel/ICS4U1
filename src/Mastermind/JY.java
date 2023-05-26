package Mastermind;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Jennifer Yin's gay game
 * 2023.05.25
 * ISP Game
 */

public class JY {
    public static void main(String[] args) throws Exception {
        // Initializing all variables used
        String playAgain = "";
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        char[] correctOrder;
        char[] guess;
        String[] guesses;
        int[] correctPlace;
        int[] correctColor;

        System.out.println("""
                          
                                         __                       .__            .___
                  _____ _____    _______/  |_  ___________  _____ |__| ____    __| _/
                 /     \\\\__  \\  /  ___/\\   __\\/ __ \\_  __ \\/     \\|  |/    \\  / __ |\s
                |  Y Y  \\/ __ \\_\\___ \\  |  | \\  ___/|  | \\/  Y Y  \\  |   |  \\/ /_/ |\s
                |__|_|  (____  /____  > |__|  \\___  >__|  |__|_|  /__|___|  /\\____ |\s
                      \\/     \\/     \\/            \\/            \\/        \\/      \\/\s
                                             
                """);

        do {
            // Resetting all the variables, allowing the user to play again
            correctOrder = new char[4];
            guess = new char[4];
            guesses = new String[10];
            correctPlace = new int[10];
            correctColor = new int[10];

            // Making the file which will store the leaderboard
            File file = new File("Leaderboard.txt");


            ArrayList<String> storedLines = new ArrayList<>(); // Used to track the current lines inside the leaderboard
            ArrayList<Integer> winList = new ArrayList<>(); // Used to track the winning scores
            PrintWriter writer = new PrintWriter(new FileWriter(file, true)); // File writer with append set to true, we can keep adding to the leaderboard
            Scanner fileScan = new Scanner(file); // Used to get content of leaderboard


            // Printing the menu and getting the user to select an option
            System.out.print("Enter 1 for the instructions or 2 to play 3 to quit: ");
            int ans = scan.nextInt();
            scan.nextLine();


            if (ans == 2) {
                // Prompting user for a username
                System.out.print("Enter username: ");
                String username = scan.nextLine();


                String letters = "ROYGBP"; // Here is a string of all the colors that is available inside the game

                // Using the letters, we randomly use each color to populate the correcrOrder array, which stores the answer
                for (int i = 0; i < 4; i++) {
                    correctOrder[i] = letters.charAt(random.nextInt(letters.length()));
                    System.out.print(correctOrder[i]);
                }
                System.out.println(" Red = R, Orange = O, Yellow = Y, Green = G, Blue = B, Purple = P");
                for (int i = 0; i < 10; i++) { // 10 tries in total, so iterate 10 times
                    System.out.println("You have " + (10 - i) + " tries");
                    System.out.print("Enter your guess(without spaces, 4 letter string): ");
                    guesses[i] = scan.nextLine();


                    boolean validColors = true; // Assume each letter that the user guessed is valid
                    for (int j = 0; j < 4; j++) {
                        guess[j] = Character.toUpperCase(guesses[i].charAt(j)); // Make everything consistent by turning it to uppercase
                        if (guess[j] != 'R' && guess[j] != 'O' && guess[j] != 'Y' && guess[j] != 'G' && guess[j] != 'B' && guess[j] != 'P') { // Checks if something is invalid
                            validColors = false; // Flips the validColors boolean to false
                            break;
                        }
                        if (guesses[i].length() != 4) { // Making sure the user enters a 4 letter string
                            validColors = false;
                            break;
                        }
                    }

                    // If the user input is invalid, we go back to the front of the loop and make them enter their guess again
                    if (!validColors) {
                        System.out.println("Invalid guess! Please use: R, O, Y, G, B, or P.");
                        i--;
                        continue;
                    }

                    correctPlace[i] = checkPlace(correctOrder, guess); // Uses the checkPlace method to count the amount of colors in the correct place
                    System.out.println("You have " + correctPlace[i] + " colors in the correct place");
                    if (correctPlace[i] == 4) {
                        boolean sameName = false; // Checks if the current username already exists in the leaderboard
                        System.out.println("You finished the game in " + (i + 1) + " tries! Thank you for playing " + "Mastermind");
                        while (fileScan.hasNext()) { // Checks if file has another line
                            String line = fileScan.nextLine();
                            System.out.println("Line: " + line);

                            // Since each row of the leaderboard is structured like "Jennifer: 1", we find the ": " and split the row into two
                            String[] separation = line.split(": ");

                            // Checking if the current line's username matches the current user's username
                            if (separation[0].equals(username)) {
                                sameName = true;

                                // Since we split the row into 2, the number on the 1'st index would be the amount of points a person has
                                int wins = Integer.parseInt(separation[1]);
                                wins++; // Increase the amount of points
                                separation[1] = ("" + wins);
                                separation[0] = (username + ": ");
                                line = (username + separation[1]); // Concatenating the username and amount of points together
                                storedLines.add(separation[0] + separation[1]); // Adds it to the storedLines array, which temporarily stores all lines of the leaderboard
                            } else {
                                storedLines.add(line); // If the username isn't equal, we can just directly add the current row inside the leaderboard file into the storedLines list
                            }
                            winList.add(Integer.parseInt(separation[1])); // After each iteration of teh amount of rows the leaderboard file has, we also add the point of a person to the winList
                        }

                        if (sameName) {
                            int size = storedLines.size();
                            for (int j = 1; j < size; j++) {  // this is for the number of passes through the array
                                for (int l = 0; l < size - j; l++) {  // this is for the number of comparisons during
                                    // each pass
                                    // if the an element is bigger than the next, swap
                                    if (winList.get(l) < winList.get(l + 1)) {

                                        // Sorting the leaderboard in descending order

                                        // Swaps the indexes in winList which keeps track of each person's amount of point
                                        int intTemp = winList.get(l);
                                        winList.set(l, winList.get(l + 1));
                                        winList.set(l + 1, intTemp);

                                        // Swaps the indexes storedLines
                                        String stringTemp = storedLines.get(l);
                                        storedLines.set(l, storedLines.get(l + 1));
                                        storedLines.set(l + 1, stringTemp);
                                    }
                                }
                            }
                            writer.close();

                            // "Overrites" the old leaderboard using the new leaderboard data which is stored inside storedLines
                            writer = new PrintWriter(new FileWriter(file, true));
                            for (int j = 0; j < size; j++) {
                                writer.println(storedLines.get(j));
                            }

                        } else {
                            writer.println(username + ": 1");
                        }

                        // Closes file writer and file scanner
                        writer.close();
                        fileScan.close();
                        break;
                    }
                    // Using the checkColor function to check if any of the colors guessed by the user is inside the randomly generated array of color
                    correctColor[i] = checkColor(correctOrder, guess, correctPlace);
                    System.out.println("You have " + correctColor[i] + " correct colors on the board");
                    System.out.println();

                    // Print out the current state of the baord
                    System.out.println("This is your board so far.");
                    for (int k = 0; k < 1 + i; k++) {
                        System.out.println(guesses[k] + "    " + correctPlace[k] + " " + correctColor[k]);
                    }
                    System.out.println();
                }

                // Asking user to play again
                System.out.println("Would you like to play agian?? (y/n)");
                playAgain = scan.nextLine();
                if (playAgain.equalsIgnoreCase("y")) {
                    continue;
                } else {
                    System.out.println("quittig...");
                }
            } else if (ans == 1) {
                // Printing all the instructions of the game
                System.out.println("There are 6 colors you can pick from");
                System.out.println("Red, Orange, Yellow, Green, Blue, Purple");
                System.out.println("There is a serect code that you will have to crack");
                System.out.println("You have have ten tries to get the code correct");
                System.out.println("If you guess the code, you earn a point");
            } else if (ans == 3) {
                // Quitting the game
                System.out.println("see u nex timse");
                break;
            } else {
                System.out.println("Invalid input! Try again.");
            }
        } while (!playAgain.equalsIgnoreCase("n")); // If the user input isn't "n," we keep going assuming they want to play again
    }

    /**
     * Checks if any of the colors guessed by the user is inside the randomly generated array of color, counts them, and returns the count
     *
     * @param correctOrder
     * @param guess
     * @param correctPlace
     * @return
     */
    public static int checkColor(char[] correctOrder, char[] guess, int[] correctPlace) {
        int correctColor = 0;

        // Nested for loop so every color in the guess can be compared with every color inside the randomly generated array
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (guess[i] != correctOrder[i] && guess[i] == correctOrder[j] && correctOrder[j] != guess[j]) {
                    correctColor++;
                    break;
                }
            }
        }
        return correctColor;
    }

    /**
     * Returns the amount of colors that are in their correct position
     *
     * @param correctOrder
     * @param guess
     * @return
     */
    public static int checkPlace(char[] correctOrder, char[] guess) {
        int correctPlace = 0;

        // Loops through the guess array and compares it with the correctOrder array
        for (int i = 0; i < 4; i++) {
            if (guess[i] == correctOrder[i]) {
                correctPlace += 1;
            }
        }
        return correctPlace;
    }
}