package Mastermind;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class JY {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        char correctOrder[] = new char[4];
        char guess[] = new char[4];
        String guesses[] = new String[10];
        String color[] = new String[10];
        int correctPlace[] = new int[10];
        int correctColor[] = new int[10];
        File file = new File("Mastermind Leader Board");
        if (!file.exists()) {
            file.createNewFile();
        }
        ArrayList<String> storedLines = new ArrayList<>();
        ArrayList<Integer> winList = new ArrayList<>();
        PrintWriter writer = new PrintWriter(new FileWriter(file, true));
        Scanner fileScan = new Scanner(file);
        System.out.println("Welcome to mastermind! Enter 1 for the instructions or 2 to play");
        int ans = scan.nextInt();
        scan.nextLine();


        if (ans == 2) {
            System.out.println("Enter username");
            String username = scan.nextLine();


            String letters = "ROYGBP";
            for (int i = 0; i < 4; i++) {
                correctOrder[i] = letters.charAt(random.nextInt(letters.length()));
                System.out.print(correctOrder[i]);
            }
            System.out.println(" Red = R, Orange = O, Yellow = Y, Green = G, Blue = B, Purple = P");
            for (int i = 0; i < 10; i++) {
                System.out.println("You have " + (10 - i) + " tries");
                System.out.print("Enter your guess(without spaces): ");
                guesses[i] = scan.nextLine();

                boolean validColors = true;
                for (int j = 0; j < 4; j++) {
                    guess[j] = Character.toUpperCase(guesses[i].charAt(j));
                    if (guess[j] != 'R' && guess[j] != 'O' && guess[j] != 'Y' && guess[j] != 'G' && guess[j] != 'B' && guess[j] != 'P') {
                        validColors = false;
                        break;
                    }
                    if (guesses[i].length() != 4) {
                        validColors = false;
                    }
                }
                if (!validColors) {
                    System.out.println("Invalid guess! Please use: R, O, Y, G, B, or P.");
                    i--;
                    continue;
                }

                for (int j = 0; j < 4; j++) {
                    guess[j] = Character.toUpperCase(guesses[i].charAt(j));
                }
                correctPlace[i] = checkPlace(correctOrder, guess);
                System.out.println("You have " + correctPlace[i] + " colors in the correct place");
                if (correctPlace[i] == 4) {
                    boolean sameName = false;
                    System.out.println("You finished the game in " + (i + 1) + " tries! Thank you for playing Mastermind");
                    while (fileScan.hasNext()) {
                        String line = fileScan.nextLine();
                        System.out.println("Line: " + line);
                        String[] separation = line.split(": ");
                        if (separation[0].equals(username)) {
                            int wins = Integer.parseInt(separation[1]);
                            wins++;
                            separation[1] = ("" + wins);
                            separation[0] = (username + ": ");
                            line = (username + separation[1]);
                            sameName = true;
                            storedLines.add(separation[0] + separation[1]);
                        }
                        // System.out.println("0: " + separation[0] + "   1" + separation[1]);
                        else {
                            storedLines.add(line);
                        }
                        winList.add(Integer.parseInt(separation[1]));
                    }

                    if (sameName == true) {
                        int size = storedLines.size();
                        for (int j = 1; j < size; j++) {  // this is for the number of passes through the array
                            for (int l = 0; l < size - j; l++) {  // this is for the number of comparisons during each pass
                                // if the an element is bigger than the next, swap
                                if (winList.get(l) < winList.get(l + 1)) {
                                    int intTemp = winList.get(l);
                                    winList.set(l, winList.get(l + 1));
                                    winList.set(l + 1, intTemp);
                                    String stringTemp = storedLines.get(l);
                                    storedLines.set(l, storedLines.get(l + 1));
                                    storedLines.set(l + 1, stringTemp);
                                }
                            }
                        }

                        writer.close();
                        file.delete();
                        file.createNewFile();
                        writer = new PrintWriter(new FileWriter(file, true));

                        for (int j = 0; j < size; j++) {
                            writer.println(storedLines.get(j));
                        }

                    } else {
                        writer.println(username + ": 1");
                    }

                    writer.close();
                    fileScan.close();
                    break;
                }
                correctColor[i] = checkColor(correctOrder, guess, correctPlace);
                System.out.println("You have " + correctColor[i] + " correct colors on the board");
                System.out.println("");
                System.out.println("This is your board so far.");
                for (int k = 0; k < 1 + i; k++) {
                    System.out.println(guesses[k] + "    " + correctPlace[k] + " " + correctColor[k]);
                }
                System.out.println("");
            }
        } else if (ans == 1) {
            //print instructions
            System.out.println("There are 6 colors you can pick from");
            System.out.println("Red, Orange, Yellow, Green, Blue, Purple");
            System.out.println("There is a serect code that you will have to crack");
            System.out.println("You have have ten tries to get the code correct");
            System.out.println("If you guess the code, you earn a point");
            System.out.println("Are you ready play? (press 2 to play)");
            ans = scan.nextInt();
        } else {
            System.out.println("Invaild input! Try again.");
        }
    }

    public static int checkColor(char correctOrder[], char guess[], int correctPlace[]) {
        int correctColor = 0;
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

    public static int checkPlace(char correctOrder[], char guess[]) {
        int correctPlace = 0;
        for (int i = 0; i < 4; i++) {
            if (guess[i] == correctOrder[i]) {
                correctPlace += 1;
            }
        }
        return correctPlace;
    }
}