

import java.util.*;
import java.io.*;

public class ZhouJesse2 {

    static Scanner sc = new Scanner(System.in);

    /* TO DO:
    - Check over scoring categories to see if they work properly
    - Check to see if there is any redundancy in the code -> make more efficient
    - Check for logical/runtime errors
    - CHECK AI Interface/Decision-making
    - Fix SmallStraight detection, sometimes detects when the values are like {1,2,3,5,5}
    - add try catch to file I/O methods to tell user whether or not they have the file downloaded or not to avoid run-time errors
     */
    public static void main(String[] args) throws Exception {


        Scanner scan = new Scanner(System.in);
        String answer = "";
        int category = 0;
        int counter = 0;
        int num = 0;
        int diceNumKept = 0;
        String lastDiceKept = "";
        int[] diceRollUser = new int[5];
        int[] diceRollAI = new int[5];
        int[] userSelectionScore = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int[] aiSelectionScore = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int[] aiScores = new int[13];
        boolean[] keptAI = new boolean[5];
        boolean[] keptUser = new boolean[5];
        int duplicateYahtzeeScore = 0;
        int duplicateYahtzeeScoreAI = 0;

        int leaderboardLength = getFileLength()+2;

        int[] leaderboardScores = new int[leaderboardLength];
        String[] leaderboardUsernames = new String[leaderboardLength];

        String[] categoryNames = new String[]{"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes",
                "Three of a Kind", "Four of a Kind", "Full House", "Small Straight", "Large Straight", "Chance", "Yahtzee"};

        welcomeScreen();
        do {
            System.out.print("========== Main Menu ==========");
            System.out.println("\nP. Play\n"
                    + "R. Rules\n"
                    + "L. Leaderboard\n"
                    + "Q. Quit\n=================================\n");

            System.out.print("Please enter the first letter of your wanted action: ");

            answer = scan.nextLine();
            if (answer.equalsIgnoreCase("Q")) {
                System.out.println("Thank you for playing Yahtzee!");
                return;
            } else if (answer.equalsIgnoreCase("R")) {
                rules();
            } else if (answer.equalsIgnoreCase("L")) {
                leaderboard(leaderboardScores, leaderboardUsernames);
            }
        } while (!answer.equalsIgnoreCase("p"));

        System.out.println();
        System.out.println("Welcome to Yahtzee!");
        System.out.print("Please enter a unique username for us to remember you by: ");
        // maybe read file to see if the name is already taken
        String username = scan.nextLine();

        for (int t = 1; t < 14; t++) {
            System.out.println("\n============ TURN " + t + " =============");
            System.out.print("\n============ " + username + "'s Turn =============");
            do {
                aiScores = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
                for (int j = 0; j < diceRollUser.length; j++) {
                    if (!keptUser[j])
                        diceRollUser[j] = roll();
                }
                keptUser = new boolean[5];

                System.out.println("\nYour Dice rolled are: ");
                for (int j = 0; j < diceRollUser.length; j++) {
                    System.out.print(diceRollUser[j] + " - ");
                }
                // Detects end of player's rolling turn and calculates scores for the player's respective dice
                if (counter == 2) {
                    System.out.println("\nCalculating Potential Scores...\nCalculation Complete!");
                    calculateScore(diceRollUser, aiScores, userSelectionScore, duplicateYahtzeeScore);
                    counter = 0;

                    boolean validCategorySelectedRC = false;
                    boolean validCategorySelectedZC = false;

                    while (!validCategorySelectedRC) {

                        try {
                            System.out.print("Enter a valid scoring category number: ");
                            category = scan.nextInt();
                            if (category > 13 || category < 1) {
                                System.out.println("Invalid Input! Please enter a valid scoring category number!");
                            } else {
                                for (int y = 0; y < userSelectionScore.length; y++) {
                                    if (userSelectionScore[y] == -1 && category == y + 1 && aiScores[y] != -1) {
                                        validCategorySelectedRC = true;
                                        // Adds calculated score to user's specified scoring category in the scoresheet array
                                        userSelectionScore[category - 1] = aiScores[category - 1];
                                    }
                                    else if(userSelectionScore[y] == -1 && category == y+1 && aiScores[y] == 0) {
                                        validCategorySelectedZC = true;
                                        // Sets the score in the user's specified scoring category in the scoresheet array to equal 0
                                        userSelectionScore[y] = 0;
                                    }
                                }
                                if(validCategorySelectedRC) {
                                    break;
                                }
                                if(validCategorySelectedZC) {
                                    break;
                                }

                            }
                        } catch (Exception e) {
                            System.out.println("Invalid Input! Please enter your choice as an integer! ");
                            scan.nextLine();
                        }
                    }
                    // CHECKPOINT TO TEST WHETHER Storing Values Works
                    // MAKESHIFT SCORESHEET UNTIL KEVIN FINISHES

                    String dash = "━";
                    String scoreSheetTitle = "┃       "+username + "'s Scoresheet    ┃";
                    for(int f = 0; f < scoreSheetTitle.length(); f++) {
                        System.out.print(dash);
                    }
                    System.out.println("\n"+scoreSheetTitle);
                    for(int f = 0; f < scoreSheetTitle.length(); f++) {
                        System.out.print(dash);
                    }
                    System.out.println();
                    for (int m = 0; m < userSelectionScore.length; m++) {
                        if (userSelectionScore[m] != -1) {
                            System.out.printf("%-18s --- %d%n", categoryNames[m], userSelectionScore[m]);
                        } else {
                            System.out.printf("%-18s --- %s%n", categoryNames[m], "N/A");
                        }
                    }
                    // System.out.println("checked"); Used to check whether valid input check has been run correctly
                    break;
                }
                System.out.println();
                // change to try catch in case a double is entered
                do {
                    try {
                        System.out.println("How many dice would you like to keep from being rerolled?");
                        num = scan.nextInt();
                        if (num >= 0 && num <= 5) {
                            break;
                        } else {
                            System.out.println("Invalid Input! Please Enter an Integer between 0-5");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input! Please Enter an Integer between 0-5");
                        scan.next(); // Consume the invalid input
                    }
                } while (true);

                counter++;

                // change to try catch in case a double is entered
                if (num == 5) {
                    for (int j = 0; j < keptUser.length; j++) {
                        keptUser[j] = true;
                    }
                }
                if (num != 0 && num != 5) {
                    lastDiceKept = ""; // RESETTING SINCE THIS IS THE START OF A NEW TURN
                    for (int j = 0; j < num; j++) {
                        boolean validInput = false;
                        while (!validInput) {
                            try {
                                System.out.print("Enter A Dice Number You Wish To Keep (1-5) Dice numbers not in this range will not be accepted: ");
                                diceNumKept = scan.nextInt();
                                if (diceNumKept > 5 || diceNumKept < 1) {
                                    System.out.println("Invalid Input! Please Enter an Integer between 1-5.");
                                } else if (lastDiceKept.contains(Integer.toString(diceNumKept))) {
                                    System.out.println("Not allowed to keep a dice you've already kept before.");
                                } else {
                                    validInput = true;
                                    lastDiceKept += diceNumKept; // ADDING THE CURRENT CHOICE ONTO THE STRING
                                }
                            } catch (Exception e) {
                                System.out.println("Invalid Input! Please Enter an Integer between 1-5.");
                                scan.nextLine(); // Consume the invalid input
                            }
                        }
                        keptUser[diceNumKept - 1] = true;
                        scan.nextLine();
                    }
                }

            } while (true);
            //Reset Array aiScores to prepare AI's Turn
            aiScores = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};;
            //Maybe change later so there are multiple names for AI that are stored in an array and randomly chosen each game instance?
            System.out.print("\n\n============ AI's Turn =============");

            int counterAI = 0;
            do {
                for (int j = 0; j < diceRollAI.length; j++) {
                    if (!keptAI[j])
                        diceRollAI[j] = roll();
                }
                System.out.println("\nAI's dice rolled are: ");
                for (int j = 0; j < diceRollAI.length; j++) {
                    System.out.print(diceRollAI[j] + " - ");
                }

                if (counterAI == 2) {
                    System.out.println("\nCalculating Potential Scores...\nCalculation Complete!");
                    String[] categoryNamesDuplicate = new String[]{"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes",
                            "Three of a Kind", "Four of a Kind", "Full House", "Small Straight", "Large Straight", "Chance", "Yahtzee"};
                    calculateScore(diceRollAI, aiScores, aiSelectionScore, duplicateYahtzeeScoreAI);
                    //CALCULATING HIGHEST SCORING CATEGORY FOR THE CURRENT AI DICE
                    int highestValue = 0;
                    int highestValueIndex = 0;
                    for (int i = 0; i < aiScores.length; i++) {
                        if (i == 0) {
                            highestValue = aiScores[0];
                        } else {
                            if (aiScores[i] > highestValue) {
                                highestValue = aiScores[i];
                                highestValueIndex = i;

                            }
                        }
                    }
                    counterAI = 0;

                    for (int i = 0; i < aiScores.length - 1; i++) {
                        for (int j = 0; j < aiScores.length - i - 1; j++) {
                            if (aiScores[j] < aiScores[j + 1]) {
                                int temp = aiScores[j];
                                String nameTemp = categoryNamesDuplicate[j];
                                aiScores[j] = aiScores[j + 1];
                                categoryNamesDuplicate[j] = categoryNamesDuplicate[j + 1];
                                aiScores[j + 1] = temp;
                                categoryNamesDuplicate[j + 1] = nameTemp;
                            }
                        }
                    }

                    System.out.println("\n> The AI has chosen " + categoryNamesDuplicate[0] + " and scored " + aiScores[0] + " points!");

                    aiSelectionScore[highestValueIndex] = highestValue;
                    // Print out AI's scoresheet
                    String dash = "━";
                    String scoreSheetTitle = "┃     AI's Scoresheet    ┃";
                    for(int f = 0; f < scoreSheetTitle.length(); f++) {
                        System.out.print(dash);
                    }
                    System.out.println("\n"+scoreSheetTitle);
                    for(int f = 0; f < scoreSheetTitle.length(); f++) {
                        System.out.print(dash);
                    }
                    System.out.println();
                    for (int m = 0; m < aiSelectionScore.length; m++) {
                        if (aiSelectionScore[m] != -1) {
                            // aligns text and stuff
                            System.out.printf("%-17s --- %d%n", categoryNames[m], aiSelectionScore[m]);


                        } else {
                            System.out.printf("%-17s --- %s%n", categoryNames[m], "N/A");
                        }
                    }
                    for(int f = 0; f < scoreSheetTitle.length(); f++) {
                        System.out.print(dash);
                    }
                    break;
                }

                int rollCount = (int) (Math.random() * (3) + 1);
                ;
                for (int i = 0; i < rollCount; i++) {

                    int diceKept = (int) (Math.random() * 5);
                    // Array to store which dice will be kept
                    keptAI = new boolean[5];

                    for (int k = 0; k < diceKept; k++) {
                        int diceIndex = (int) (Math.random() * 5);
                        keptAI[diceIndex] = true;
                    }
                }
                counterAI++;
            } while (true);
        }

        int aiTotalScore = 0;
        int userTotalScore = 0;

        for (int i = 0; i < userSelectionScore.length; i++) {
            aiTotalScore += aiSelectionScore[i];
            userTotalScore += userSelectionScore[i];
            if (i == 5 && aiTotalScore >= 63) {
                aiTotalScore += 35;
            }
            if (i == 5 && userTotalScore >= 63) {
                userTotalScore += 35;
            }
        }
        userTotalScore += duplicateYahtzeeScore;
        aiTotalScore += duplicateYahtzeeScoreAI;

        System.out.println("Your score versus the opponent was " + userTotalScore + " vs. " + aiTotalScore);

        if (userTotalScore > aiTotalScore) {
            System.out.println("\nCongratulations " + username + "! You have won!");
        } else if (userTotalScore == aiTotalScore) {
            System.out.println("\nYou have tied with the opponent! Great job!");
        } else {
            System.out.println("\nYou Lost! Try again next time!");
        }


        addToLeaderboard(leaderboardScores, leaderboardUsernames, userTotalScore, username);

    }

    public static int getFileLength() throws Exception {
        File file = new File("Leaderboard.txt");
        Scanner fileScan = new Scanner(file);
        int counter = 0;
        while (fileScan.hasNextLine()) {
            counter++;
            fileScan.nextLine();
        }
        return counter;
    }

    public static void addToLeaderboard(int[] leaderboardScores, String[] leaderboardUsernames, int userTotalScore, String username) throws Exception {
        File file = new File("Leaderboard.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(file, true), true);

        try (Scanner fileScan = new Scanner(file)) {
            for (int i = 0; i < 5; i++) {
                if (fileScan.hasNextLine()) {
                    String currentLine = fileScan.nextLine();
                    int locateDash1 = currentLine.indexOf("-");
                    int locateDash2 = currentLine.lastIndexOf("-");
                    String getScoreLocation = currentLine.substring(locateDash1 + 1, locateDash2);
                    leaderboardScores[i] = Integer.parseInt(getScoreLocation);
                    leaderboardUsernames[i] = currentLine.substring(0, locateDash1);
                } else {
                    // Handle the case where there are fewer than 5 lines in the file
                    leaderboardScores[i] = 0;
                    leaderboardUsernames[i] = "";
                }
            }
        }

        int fileLength = getFileLength();
        leaderboardScores[fileLength] = userTotalScore;
        leaderboardUsernames[fileLength] = username;

        // Sorts all scores in the leaderboard file in descending order
        for (int i = 0; i < leaderboardScores.length - 1; i++) {
            for (int j = 0; j < leaderboardScores.length - i - 1; j++) {
                if (leaderboardScores[j] < leaderboardScores[j + 1]) {
                    int temp = leaderboardScores[j];
                    String tempName = leaderboardUsernames[j];
                    leaderboardScores[j] = leaderboardScores[j + 1];
                    leaderboardUsernames[j] = leaderboardUsernames[j + 1];
                    leaderboardScores[j + 1] = temp;
                    leaderboardUsernames[j + 1] = tempName;
                }
            }
        }

        // Clears leaderboard file
        pw.close();
        pw = new PrintWriter(new FileWriter(file));

        // Prints all scores in order to the leaderboard file
        for (int i = 0; i < leaderboardScores.length; i++) {
            if (leaderboardUsernames[i] != null && leaderboardScores[i] != 0) {
                pw.println(leaderboardUsernames[i] + "-" + leaderboardScores[i] + "-");
            }
        }

        // Reset Scanner
        try (Scanner newFileScan = new Scanner(file)) {
            int checkRanking = 0;
            int ranking = 0;
            while (newFileScan.hasNextLine()) {
                String currentLine = newFileScan.nextLine();
                int locateDash1 = currentLine.indexOf("-");
                checkRanking++;
                if (currentLine.substring(0, locateDash1).equals(username)) {
                    ranking = checkRanking;
                    break;
                }
            }

            if (ranking >= 5) {
                System.out.println("Congratulations! You ranked as #" + ranking + " in all-time scores!");
            }
        }

        pw.close();
    }

    public static int roll() {
        int roll = (int) (Math.random() * (6) + 1);
        return roll;

    }

    public static void leaderboard(int[] leaderboardScores, String[] leaderboardUsernames) throws Exception {
        File file = new File("Leaderboard.txt");
        Scanner fileScan = new Scanner(file);
        System.out.println();
        System.out.println(" All-Time Yahtzee High Scores ");
        System.out.println("------------------------------");
        int lineCount = 0;
        while (fileScan.hasNextLine() && lineCount < 5) {
            String currentLine = fileScan.nextLine();
            int locateDash1 = currentLine.indexOf("-");
            int locateDash2 = currentLine.lastIndexOf("-");
            String getScoreLocation = currentLine.substring(locateDash1 + 1, locateDash2);
            leaderboardScores[lineCount] = Integer.parseInt(getScoreLocation);
            leaderboardUsernames[lineCount] = currentLine.substring(0, locateDash1);
            System.out.println((lineCount + 1) + ". " + leaderboardUsernames[lineCount] + " - " + leaderboardScores[lineCount]);
            lineCount++;
        }
        System.out.println();
        fileScan.close();
    }

    public static void welcomeScreen() {
        System.out.println("Welcome to Jesse's magnificent: ");
        System.out.println("                                                                                                                      \n" +
                "`8.`8888.      ,8'    .8.          8 8888        8 8888888 8888888888 8888888888',8888' 8 8888888888   8 8888888888   \n" +
                " `8.`8888.    ,8'    .888.         8 8888        8       8 8888              ,8',8888'  8 8888         8 8888         \n" +
                "  `8.`8888.  ,8'    :88888.        8 8888        8       8 8888             ,8',8888'   8 8888         8 8888         \n" +
                "   `8.`8888.,8'    . `88888.       8 8888        8       8 8888            ,8',8888'    8 8888         8 8888         \n" +
                "    `8.`88888'    .8. `88888.      8 8888        8       8 8888           ,8',8888'     8 888888888888 8 888888888888 \n" +
                "     `8. 8888    .8`8. `88888.     8 8888        8       8 8888          ,8',8888'      8 8888         8 8888         \n" +
                "      `8 8888   .8' `8. `88888.    8 8888888888888       8 8888         ,8',8888'       8 8888         8 8888         \n" +
                "       8 8888  .8'   `8. `88888.   8 8888        8       8 8888        ,8',8888'        8 8888         8 8888         \n" +
                "       8 8888 .888888888. `88888.  8 8888        8       8 8888       ,8',8888'         8 8888         8 8888         \n" +
                "       8 8888.8'       `8. `88888. 8 8888        8       8 8888      ,8',8888888888888  8 888888888888 8 888888888888\n");

    }

    public static void rules() throws Exception {
        File file = new File("YahtzeeRules.txt");
        Scanner fileScan = new Scanner(file);
        System.out.println();
        while (fileScan.hasNextLine()) {
            System.out.println(fileScan.nextLine());
        }
        System.out.println();
        fileScan.close();
    }

    // return type array that adds up the sum of dice rolled
    public static int sumDice(int[] diceRoll) {
        int sum = 0;
        for (int i = 0; i < diceRoll.length; i++) {
            sum += diceRoll[i];
        }
        return sum;
    }

    public static void calculateScore(int[] diceRoll, int[] potentialScore, int[] selectionScore,int duplicateYathzeeScore) {

        int[] numCount = new int[]{0, 0, 0, 0, 0, 0};
        String[] upperNames = new String[]{"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes"};
        boolean[] checkValid = new boolean[13];

        for (int i = 0; i < diceRoll.length; i++) {
            if (diceRoll[i] == 1) {
                numCount[0]++;
            }
            if (diceRoll[i] == 2) {
                numCount[1]++;
            }
            if (diceRoll[i] == 3) {
                numCount[2]++;
            }
            if (diceRoll[i] == 4) {
                numCount[3]++;
            }
            if (diceRoll[i] == 5) {
                numCount[4]++;
            }
            if (diceRoll[i] == 6) {
                numCount[5]++;
            }
        }
        // checks for valid dice combinations in the upper section, and prompts the choices to the user through the console

        // Yahtzee Calculations
        // TEST THIS
        boolean yahtzeeFound = false;
        boolean duplicateYahtzeeCheck = false;

        for (int i = 0; i < numCount.length; i++) {
            if (numCount[i] == 5) {
                yahtzeeFound = true;
                break;
            }
        }
        if (yahtzeeFound && selectionScore[12] == -1) {
            potentialScore[12] = 50;
            checkValid[12] = true;
        }
        if (yahtzeeFound && selectionScore[12] != -1) {
            System.out.println("A Yahtzee was found! Adding 100 bonus points to final score...");
            duplicateYathzeeScore += 100;
            duplicateYahtzeeCheck = true;

            if (selectionScore[0] == -1) {
                potentialScore[0] = 6;
                checkValid[0] = true;
                System.out.println("1. Ones - Potential Score: " + potentialScore[0]);
            }
            if (selectionScore[1] == -1) {
                potentialScore[1] = 12;
                System.out.println("2. Twos - Potential Score: " + potentialScore[1]);
            }
            if (selectionScore[2] == -1) {
                potentialScore[2] = 18;
                System.out.println("3. Threes - Potential Score: " + potentialScore[2]);
            }
            if (selectionScore[3] == -1) {
                potentialScore[3] = 24;
                System.out.println("4. Fours - Potential Score: " + potentialScore[3]);
            }
            if (selectionScore[4] == -1) {
                potentialScore[4] = 30;
                System.out.println("5. Fives - Potential Score: " + potentialScore[4]);
            }
            if (selectionScore[5] == -1) {
                potentialScore[5] = 36;
                System.out.println("6. Sixes - Potential Score: " + potentialScore[5]);
            }
            if (selectionScore[6] == -1) {
                potentialScore[6] = 36;
                System.out.println("7. Three Of A Kind - Potential Score: " + potentialScore[6]);
            }
            if (selectionScore[7] == -1) {
                potentialScore[7] = 36;
                System.out.println("8. Four Of A Kind - Potential Score: " + potentialScore[7]);
            }
            if (selectionScore[8] == -1) {
                potentialScore[8] = 25;
                System.out.println("9. Full House - Potential Score: " + potentialScore[8]);
            }
            if (selectionScore[9] == -1) {
                potentialScore[9] = 30;
                System.out.println("10. Small Straight - Potential Score: " + potentialScore[9]);
            }
            if (selectionScore[10] == -1) {
                potentialScore[10] = 40;
                System.out.println("11. Large Straight - Potential Score: " + potentialScore[10]);
            }
            if (selectionScore[11] == -1) {
                potentialScore[11] = 36;
                System.out.println("12. Chance - Potential Score: " + potentialScore[11]);
            }
        }

        if (!duplicateYahtzeeCheck) {
            for (int j = 0; j < 6; j++) {
                if (selectionScore[j] == -1 && numCount[j] > 0) {
                    potentialScore[j] = numCount[j] * (j + 1);
                    checkValid[j] = true;
                }
            }
            // Starts Calculating lower Section Scores

            for (int i = 0; i < diceRoll.length; i++) {
                int counter = 0;
                for (int j = 0; j < diceRoll.length; j++) {
                    if (diceRoll[i] == diceRoll[j]) {
                        counter++;
                    }
                }
                if (counter >= 3 && selectionScore[6] == -1) {
                    potentialScore[6] = sumDice(diceRoll);
                    checkValid[6] = true;
                }
            }

            for (int i = 0; i < diceRoll.length; i++) {
                int counter = 0;
                for (int j = 0; j < diceRoll.length; j++) {
                    if (diceRoll[i] == diceRoll[j]) {
                        counter++;
                    }
                }
                if (counter >= 4 && selectionScore[7] == -1) {
                    potentialScore[7] = sumDice(diceRoll);
                    checkValid[7] = true;
                }
            }
            // TEST THIS
            //full house calculations
            boolean threeOfAKind = false;
            boolean pair = false;

            for (int i = 0; i < diceRoll.length; i++) {
                int counter = 0;
                for (int j = 0; j < diceRoll.length; j++) {
                    if (diceRoll[i] == diceRoll[j]) {
                        counter++;
                    }
                }
                if (counter == 3) {
                    threeOfAKind = true;
                } else if (counter == 2) {
                    pair = true;
                }
                // if 4 dice are the same, full house is impossible
                // POSSIBLY REDUNDANT IDK
                if (counter == 4) {
                    threeOfAKind = false;
                    pair = false;
                }
                if (threeOfAKind && pair && selectionScore[8] == -1) {
                    potentialScore[8] = 25;
                    checkValid[8] = true;
                }
            }
            // Small String Calculations
            // TEST THIS
            boolean smallStraightFound = true;

            int[] arr = new int[5];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = diceRoll[i];
            }


            boolean[] dup = {false, false, false, false, false};

            // SMALL STRIAGHT HERE STARTS HERE JE SEEEEEEEE
            bubbleSort(arr);
            int dups = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == arr[i - 1]) {
                    dups++;
                    dup[i] = true; // Is a duplicate
                }
            }
            int duplicateCount = arr.length - dups;


            int[] tempArr = new int[duplicateCount];

            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (!dup[i]) {
                    tempArr[count] = arr[i];
                    count++;
                }
            }


            if (tempArr.length < 4) {
                smallStraightFound = false;
            } else {
                // bubble sort copied array in ascending order
                // Used for detecting small straights and large straights
                bubbleSort(tempArr);

                for (int i = 0; i < tempArr.length - 1; i++) {
                    if (tempArr[i] + 1 == tempArr[i + 1]) {
                        continue;
                    }
                    smallStraightFound = false;
                    break;
                }
            }

            if (smallStraightFound && selectionScore[9] == -1) {
                potentialScore[9] = 30;
                checkValid[9] = true;
            }

            // Large Straight Calculations
            // TEST THIS

            boolean largeStraightFound = true;

            for (int i = 0; i < arr.length - 1; i++) {
                if ((arr[i] + 1 != arr[i + 1])) {
                    largeStraightFound = false;
                }
            }
            if (largeStraightFound && selectionScore[10] == -1) {
                potentialScore[10] = 40;
                checkValid[10] = true;
            }

            // 'Chance' Calculations
            if (selectionScore[11] == -1) {
                potentialScore[11] = sumDice(diceRoll);
                checkValid[11] = true;
            }
        }
        // Checks if there are any valid categories for the user to score in.
        // If not, then console forces users to choose one category to score 0 points in
        boolean possibleCategories = false;
        for (int i = 0; i < checkValid.length; i++) {
            if (checkValid[i]) {
                possibleCategories = true;
                break;
            }
        }
        if (!possibleCategories && !duplicateYahtzeeCheck) {
            System.out.println("Uh Oh! It seems like there are no available categories for the dice to score in.");
            System.out.println("Choose one of the categories below to score 0 in: ");

            if (selectionScore[0] == -1) {
                potentialScore[0] = 0;
                System.out.println("1. Ones - Potential Score: " + potentialScore[0]);
            }
            if (selectionScore[1] == -1) {
                potentialScore[1] = 0;
                System.out.println("2. Twos - Potential Score: " + potentialScore[1]);
            }
            if (selectionScore[2] == -1) {
                potentialScore[2] = 0;
                System.out.println("3. Threes - Potential Score: " + potentialScore[2]);
            }
            if (selectionScore[3] == -1) {
                potentialScore[3] = 0;
                System.out.println("4. Fours - Potential Score: " + potentialScore[3]);
            }
            if (selectionScore[4] == -1) {
                potentialScore[4] = 0;
                System.out.println("5. Fives - Potential Score: " + potentialScore[4]);
            }
            if (selectionScore[5] == -1) {
                potentialScore[5] = 0;
                System.out.println("6. Sixes - Potential Score: " + potentialScore[5]);
            }
            if (selectionScore[6] == -1) {
                potentialScore[6] = 0;
                System.out.println("7. Three Of A Kind - Potential Score: " + potentialScore[6]);
            }
            if (selectionScore[7] == -1) {
                potentialScore[7] = 0;
                System.out.println("8. Four Of A Kind - Potential Score: " + potentialScore[7]);
            }
            if (selectionScore[8] == -1) {
                potentialScore[8] = 0;
                System.out.println("9. Full House - Potential Score: " + potentialScore[8]);
            }
            if (selectionScore[9] == -1) {
                potentialScore[9] = 0;
                System.out.println("10. Small Straight - Potential Score: " + potentialScore[9]);
            }
            if (selectionScore[10] == -1) {
                potentialScore[10] = 0;
                System.out.println("11. Large Straight - Potential Score: " + potentialScore[10]);
            }
            if (selectionScore[11] == -1) {
                potentialScore[11] = 0;
                System.out.println("12. Chance - Potential Score: " + potentialScore[11]);
            }
            if (selectionScore[12] == -1) {
                potentialScore[12] = 0;
                System.out.println("13. YAHTZEE - Potential Score: " + potentialScore[12]);
            }
        }
        // Print out available scoring categories here:

        if (!duplicateYahtzeeCheck && possibleCategories) {
            System.out.println();
            System.out.println("Available Scoring Categories: ");

            for (int i = 0; i < 6; i++) {
                if (checkValid[i]) {
                    System.out.println((i + 1) + ". " + upperNames[i] + " - Potential Score: " + potentialScore[i]);
                }
            }
            if(checkValid[6]) {
                System.out.println("7. Three of A Kind - Potential Score: " + potentialScore[6]);
            }
            if(checkValid[7]) {
                System.out.println("8. Four of A Kind - Potential Score: " + potentialScore[7]);
            }
            if(checkValid[8]) {
                System.out.println("9. Full House - Potential Score: " + potentialScore[8]);
            }
            if(checkValid[9]) {
                System.out.println("10. Small Straight - Potential Score: " + potentialScore[9]);
            }
            if(checkValid[10]) {
                System.out.println("11. Large Straight - Potential Score: " + potentialScore[10]);
            }
            if(checkValid[11]) {
                System.out.println("12. Chance - Potential Score: " + potentialScore[11]);
            }
            if(checkValid[12]) {
                System.out.println("13. YAHTZEE - Potential Score: " + potentialScore[12]);
            }
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
