import java.util.*;

/*
 * Name: Jesse Zhou
 * Teacher: Mr. Chu
 * Date: March 3, 2023
 * Description:
 * This programming project is to create a game called Clacker, in which the player throws two dice and covers up numbers from 1 to 12.
 * The goal is to cover all the numbers in the fewest rolls possible. The interface design is user friendly -
 * - and the program tracks the user's number of rolls, validate user inputs, and provide a score board at the end of each game.
 */

public class ClackerJesseToo {

    public static void main(String[] args) {

        // initializes scanner
        Scanner sc = new Scanner(System.in);

        // prompts user for their name and stores it using Scanner
        System.out.print("Enter your name: ");
        String name = sc.next();

        // initializes and stores roll values in integer variables
        // amount the user rolls at a time
        int rollAmount = 0;

        // high-score variable
        int highScore = Integer.MAX_VALUE;
        int secondScore = Integer.MAX_VALUE;
        int thirdScore = Integer.MAX_VALUE;

        // initializing variables that will store the names of the top three players with the highest scores
        String bestPlayer = "-";
        String secondPlace = "-";
        String thirdPlace = "-";

        // string that stores all covered numbers so far within the game program
        String coveredNum = "";
        // string that stores covered numbers per roll of the dice
        String itCovers = "";
        // string that stores the covered numbers from 7-12 that require addition of the
        // numbers (1-6) dice rolls to formulate.
        String sumCovered = "";

        // counts # of rolls the program has run
        int counter = 0;

        // initializes and stores values of 'false' in boolean variables
        // used to check and mark respective boolean values as true when they are marked
        // during the game program
        // if boolean value is true, then the value is marked. If it is false, it has
        // not been marked yet
        boolean one = false;
        boolean two = false;
        boolean three = false;
        boolean four = false;
        boolean five = false;
        boolean six = false;
        boolean seven = false;
        boolean eight = false;
        boolean nine = false;
        boolean ten = false;
        boolean eleven = false;
        boolean twelve = false;
        boolean win = false;

        // Used to identify invalid inputs for users when being asked whether they would like to continue playing
        boolean valid = false;
        String repeat;

        // Condition: while the loop is running, it will prompts user to enter the amount of rolls they would like to try entering
        while (true) {
            while (true) {
                // if 'rollamount' input of user is not an integer, prints out an invalid input message and re-prompts the user for another input until resolved.
                try {
                    sc = new Scanner(System.in);
                    System.out.print("Enter amount of rolls (1-30): ");
                    rollAmount = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid Input. Please enter an Integer");
                    continue;
                }

                // empty line to separate blocks of text
                System.out.println();

                // if the roll amount inputed by the user is not between 1 and 30 inclusive,
                // repeatedly prompt user to re-enter roll values
                // this persists until the user enters a value within the specified range
                if (rollAmount < 1) {
                    System.out.println("Number of rolls has to be higher than 1.");
                } else if (rollAmount > 30) {
                    System.out.println("Number of rolls has to be 30 or under.");
                } else {
                    break;
                }
            }

            // Condition: while the amount of rolls left to the user is still greater than
            // 0, this program will still execute
            while (rollAmount > 0) {
                // using math.random to generate a random number between 1 and 6 inclusive for
                // both dice 1 and dice 2
                int roll1 = (int) (Math.random() * (6) + 1);
                int roll2 = (int) (Math.random() * (6) + 1);

                // tells the user which numbers from 1 to 6 they rolled on the dice
                System.out.println("> You rolled the following numbers: " + roll1 + " and " + roll2);

                // Condition: if both rolled numbers are already checked off and marked,
                // calculate the sum of the dice and check off the sum value as well
                // checks the combination of two rolls and assigns a number to it depending on
                // the roll values. The numbers are seven, eight, nine, ten, eleven, and twelve.
                // The if-statements check if the two rolls are equal to any of these numbers,
                // and if they are, it prints out the corresponding number.
                // If the two rolls are not equal to any of these numbers, it prints out the
                // total of the two rolls.
                if (((roll1 == 1 && roll2 == 6) || (roll1 == 6 && roll2 == 1)) && one && six && (seven != true)) {
                    seven = true;
                    sumCovered += "7 ";
                }
                if (((roll1 == 2 && roll2 == 5) || (roll1 == 5 && roll2 == 2)) && two && five && (seven != true)) {
                    seven = true;
                    sumCovered += "7 ";
                }
                if (((roll1 == 3 && roll2 == 4) || (roll1 == 4 && roll2 == 3)) && three && four && (seven != true)) {
                    seven = true;
                    sumCovered += "7 ";
                }
                if (((roll1 == 3 && roll2 == 5) || (roll1 == 5 && roll2 == 3)) && three && five && (eight != true)) {
                    eight = true;
                    sumCovered += "8 ";
                }
                if (((roll1 == 6 && roll2 == 2) || (roll1 == 2 && roll2 == 6)) && two && six && (eight != true)) {
                    seven = true;
                    sumCovered += "8 ";
                }
                if (((roll1 == 4 && roll2 == 4)) && four && (eight != true)) {
                    eight = true;
                    sumCovered += "8 ";
                }
                if (((roll1 == 3 && roll2 == 6) || (roll1 == 6 && roll2 == 3)) && three && six && (nine != true)) {
                    nine = true;
                    sumCovered += "9 ";
                }
                if (((roll1 == 4 && roll2 == 5) || (roll1 == 5 && roll2 == 4)) && four && five && (nine != true)) {
                    nine = true;
                    sumCovered += "9 ";
                }
                if (((roll1 == 4 && roll2 == 6) || (roll1 == 6 && roll2 == 4)) && four && six && (ten != true)) {
                    ten = true;
                    sumCovered += "10 ";
                }
                if (((roll1 == 5 && roll2 == 5)) && five && (ten != true)) {
                    ten = true;
                    sumCovered += "10 ";
                }
                if (((roll1 == 5 && roll2 == 6) || (roll1 == 6 && roll2 == 5)) && six && five && (eleven != true)) {
                    eleven = true;
                    sumCovered += "11 ";
                }
                if (((roll1 == 6 && roll2 == 6)) && six && (twelve != true)) {
                    twelve = true;
                    sumCovered += "12 ";
                }
                if (sumCovered != "") {
                    System.out.print("> It covers: " + sumCovered);
                    sumCovered = "";
                    System.out.println();
                } else {

                    // checking the values of two variables, roll1 and roll2, to determine if they
                    // are equal to any of the numbers 1-6.
                    // If either variable is equal to one of the numbers and that number is not yet marked, it sets the corresponding
                    // boolean (one, two, three, etc.) to true and then prints out the number.

                    if ((roll1 == 1 || roll2 == 1) && one != true) {
                        one = true;
                        itCovers += "1 ";
                    }
                    if ((roll1 == 2 || roll2 == 2) && two != true) {
                        two = true;
                        itCovers += "2 ";
                    }
                    if ((roll1 == 3 || roll2 == 3) && three != true) {
                        three = true;
                        itCovers += "3 ";
                    }
                    if ((roll1 == 4 || roll2 == 4) && four != true) {
                        four = true;
                        itCovers += "4 ";
                    }
                    if ((roll1 == 5 || roll2 == 5) && five != true) {
                        five = true;
                        itCovers += "5 ";
                    }
                    if ((roll1 == 6 || roll2 == 6) && six != true) {
                        six = true;
                        itCovers += "6 ";
                    }
                    if (itCovers != "") {
                        System.out.print("> It covers: " + itCovers);
                        itCovers = "";
                        System.out.println();
                    }
                }

                // Stores numbers that have been covered so far in the game program in a String
                // called coveredNum
                // uses if statements to check if each boolean condition is true, and if so,
                // adds the number to the 'numbers covered string'

                if (one) {
                    coveredNum += "1 ";
                }
                if (two) {
                    coveredNum += "2 ";
                }
                if (three) {
                    coveredNum += "3 ";
                }
                if (four) {
                    coveredNum += "4 ";
                }
                if (five) {
                    coveredNum += "5 ";
                }
                if (six) {
                    coveredNum += "6 ";
                }
                if (seven) {
                    coveredNum += "7 ";
                }
                if (eight) {
                    coveredNum += "8 ";
                }
                if (nine) {
                    coveredNum += "9 ";
                }
                if (ten) {
                    coveredNum += "10 ";
                }
                if (eleven) {
                    coveredNum += "11 ";
                }
                if (twelve) {
                    coveredNum += "12 ";
                }
                // Prints out covered numbers to the console for the user to see
                if (coveredNum != "") {
                    System.out.print("> Numbers covered: " + coveredNum);
                    coveredNum = "";
                }
                // at the end, prints out an empty line
                System.out.println();

                // This code is printing out the numbers from 1 to 12 that have not yet been
                // covered.
                // uses series of if-statements to check each boolean for a value. If the
                // boolean is false indicating that the number has not been covered, it is
                // printed out.
                System.out.print("> Numbers not yet covered: ");
                if (!one) {
                    System.out.print("1 ");
                }
                if (!two) {
                    System.out.print("2 ");
                }
                if (!three) {
                    System.out.print("3 ");
                }
                if (!four) {
                    System.out.print("4 ");
                }
                if (!five) {
                    System.out.print("5 ");
                }
                if (!six) {
                    System.out.print("6 ");
                }
                if (!seven) {
                    System.out.print("7 ");
                }
                if (!eight) {
                    System.out.print("8 ");
                }
                if (!nine) {
                    System.out.print("9 ");
                }
                if (!ten) {
                    System.out.print("10 ");
                }
                if (!eleven) {
                    System.out.print("11 ");
                }
                if (!twelve) {
                    System.out.print("12 ");
                }
                System.out.println();
                System.out.println();
                // After all the numbers have been checked, the rollAmount is decremented by 1.
                // Counter is also incremented by 1
                rollAmount -= 1;
                counter++;

                // Checks for a win by the user: if all the boolean values are true, win will be
                // set to true.
                // Otherwise, it will be set to false.
                win = one && two && three && four && five && six && seven && eight && nine && ten && eleven && twelve;

                // if a win is detected, the while loop is broken
                if (win) {
                    break;
                }
            }

            // checks to see if the user has won the game by checking the boolean "win"
            // If "win" is false, it prints a message to the user letting them know how many
            // attempts they had and to try rolling some more.
            if (!win) {
                System.out.println("> You didnt finish the game yet :( You had " + counter + " attempts");
                System.out.println("> Try rolling some more");
                System.out.println();

                // If the user has successfully rolled all 12 numbers, then the code checks to
                // see if the total amount of rolls made is lower than the previous high score.
                // If it is, then the new total roll amount is set as the new high score and the
                // user is informed that they made a new high score.
            } else {
                System.out.println("> You rolled all 12 numbers in " + counter + " attempts!");

                // setting up leader board and calculating scores

                // Condition: if the counter is less than the high score(lowest # of rolls), this loop will run
                if (counter <= highScore) {
                    // move down former second place scores and name to third place
                    thirdScore = secondScore;
                    thirdPlace = secondPlace;
                    // move down former first place scores and name down to second place
                    secondScore = highScore;
                    secondPlace = bestPlayer;
                    // set high score and best player's name to equal player's current score and name
                    highScore = counter;
                    bestPlayer = name;
                    // informs user on their top placement with an appropriate message
                    System.out.println("!! Congrats " + name + "! You made a new high score of " + highScore + " rolls!");

                }
                // Condition: if the counter is less than the second highest score(second lowest # of rolls), this loop will run
                else if (counter <= secondScore) {
                    // move down former second place scores and name to third place
                    thirdScore = secondScore;
                    thirdPlace = secondPlace;
                    // set second highest score and second best player's name to the player's current name and score
                    secondScore = counter;
                    secondPlace = name;
                    // informs user on their top-2 placement with an appropriate message
                    System.out.println("!! Congrats " + name + "! You placed second with " + counter + " rolls!");


                }
                // Condition: if the counter is less than the third highest score(third lowest # of rolls), this loop will run
                else if (counter <= thirdScore) {
                    // set third highest score and third best player's name to the player's current name and score
                    thirdScore = counter;
                    thirdPlace = name;
                    // informs user on their top-3 placement with an appropriate message
                    System.out.println("!! Congrats " + name + "! You placed third with " + counter + " rolls!");
                }
                else {
                    // if user does not place in the top 3, the player is informed of how many rolls it took for them to win
                    System.out.println("Congratulations " + name + "! You won in " + counter + " rolls");
                }

                // prints out leader board of best previous scores in the current game session
                System.out.println();
                System.out.println(" Leaderboard of Clacker Champions");
                System.out.println("----------------------------------");
                System.out.println("1. " + bestPlayer + "| Score: " + highScore);

                // Condition: if secondScore is still equal to the integer limit, print out '-' in the place of the score
                // otherwise, print out the score that earns the second place position on the leader board
                // '-' is used to make the interface look nicer to the user without any huge numbers
                // also to clarify that there is no current score for that section
                if (secondScore == Integer.MAX_VALUE) {
                    System.out.println("2. " + secondPlace + "| Score: " + " - ");
                }
                else {
                    System.out.println("2. " + secondPlace + "| Score: " + secondScore);
                }
                // Condition: if thirdScore is still equal to the integer limit, print out '-' in the place of the score
                // otherwise, print out the score that earns the second place position on the leader board
                if (thirdScore == Integer.MAX_VALUE) {
                    System.out.println("3. " + thirdPlace + "| Score: " + " - ");
                }
                else {
                    System.out.println("3. " + thirdPlace + "| Score: " + thirdScore);

                }
                // resets Scanner
                sc.nextLine();

                // code asks the user if they would like to play again.
                // If the answer is yes, the code will continue the loop.
                while (true) {
                    System.out.print("> Wanna play again? (YES/NO): ");
                    repeat = sc.nextLine();

                    // if input is yes, marks the input as a valid input and breaks the loop
                    if (repeat.equalsIgnoreCase("YES")) {
                        valid = true;
                        break;
                    }
                    // If the answer is no, marks the input as a valid input and breaks the loop
                    else if (repeat.equalsIgnoreCase("NO")) {
                        valid = true;
                        System.out.println("Thank you for playing Clacker with us, we hope to see you again soon!");

                        // closes scanner
                        sc.close();
                        break;
                    }
                    // if input is not 'yes' or 'no', continue the while loop
                    else {
                        continue;
                    }
                }
                // if the input is considered valid and is 'yes', the program will reset variables for the next Clacker player
                if (valid && repeat.equalsIgnoreCase("YES")) {
                    // resets counter to 0 in preparation of the next game
                    counter = 0;
                    // resets all boolean values to false in preparation of the next game
                    one = false;
                    two = false;
                    three = false;
                    four = false;
                    five = false;
                    six = false;
                    seven = false;
                    eight = false;
                    nine = false;
                    ten = false;
                    eleven = false;
                    twelve = false;
                    // empty line to space out blocks of text
                    System.out.println();
                    // continues while loop from the beginning

                    // prompts next user for their name and stores it using Scanner
                    System.out.print("Enter your name: ");
                    name = sc.next();
                    // restarts the entire while loop for the program
                    continue;
                }
                else {
                    break;
                }
            }
        }
        // closes main method
    }
// close class
}