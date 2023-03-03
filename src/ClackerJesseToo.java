import java.util.*;

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
        // total # of times rolled
        int totalRollAmount = 0;
        // high-score variable
        int highScore = Integer.MAX_VALUE;

        // counts # of rolls the program has run
        int counter = 0;

        // initializes and stores values of 'false' in boolean variables
        // used to check and mark respective boolean values as true when they are marked during the game program
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

        // prompts user to enter the amount of rolls they would like to try entering
        while (true) {
            while (true) {
                System.out.print("Enter amount of rolls (1-30): ");
                rollAmount = sc.nextInt();

                // if the roll amount inputed by the user is not between 1 and 30 inclusive, repeatedly prompt user to re-enter roll values
                // this persists until the user enters a value within the specified range
                if (rollAmount < 1) {
                    System.out.println("Number of rolls has to be higher than 1.");
                } else if (rollAmount > 30) {
                    System.out.println("Number of rolls has to be 30 or under.");
                } else {
                    // stores the total roll amount of the user for use in calculating their final score
                    totalRollAmount += rollAmount;
                    break;
                }

            }

            // Condition: while the amount of rolls left to the user is still greater than 0, this program will still execute
            while (rollAmount > 0) {
                // using math.random to generate a random number between 1 and 6 inclusive for both dice 1 and dice 2
                int roll1 = (int) (Math.random() * (6) + 1);
                int roll2 = (int) (Math.random() * (6) + 1);

                // tells the user which numbers from 1 to 6 they rolled on the dice
                System.out.println("You rolled the following numbers: " + roll1 + " and " + roll2);

                // Condition: if both numbers rolled are already checked off and marked, calculate the sum of the dice and check off the sum value as well
                // checks the combination of two rolls and assigns a number to it depending on the roll values. The numbers are seven, eight, nine, ten, eleven, and twelve.
                // The if-statements check if the two rolls are equal to any of these numbers, and if they are, it prints out the corresponding number.
                //  If the two rolls are not equal to any of these numbers, it prints out the total of the two rolls.
                if ((roll1 == 3 && roll2 == 4) || (roll1 == 4 && roll2 == 3) && three && four) {
                    seven = true;
                    System.out.println("It covers 7");
                } else if ((roll1 == 3 && roll2 == 5) || (roll1 == 5 && roll2 == 3) && three && five) {
                    eight = true;
                    System.out.println("It covers 9");
                } else if ((roll1 == 3 && roll2 == 6) || (roll1 == 6 && roll2 == 3) && three && six) {
                    nine = true;
                    System.out.println("It covers 8");
                } else if ((roll1 == 4 && roll2 == 4) && four) {
                    eight = true;
                    System.out.println("It covers 8");
                } else if ((roll1 == 4 && roll2 == 5) || (roll1 == 5 && roll2 == 4) && four && five) {
                    nine = true;
                    System.out.println("It covers 9");
                } else if ((roll1 == 4 && roll2 == 6) || (roll1 == 6 && roll2 == 4) && four && six) {
                    ten = true;
                    System.out.println("It covers 10");
                } else if ((roll1 == 5 && roll2 == 5) && five) {
                    ten = true;
                    System.out.println("It covers 10");
                } else if ((roll1 == 5 && roll2 == 6) || (roll1 == 6 && roll2 == 5) && six && five) {
                    eleven = true;
                    System.out.println("It covers 11");
                } else if ((roll1 == 6 && roll2 == 6) && six) {
                    twelve = true;
                    System.out.println("It covers 12");
                } else {
                    System.out.print("It covers ");

                    // checking the values of two variables, roll1 and roll2, to determine if they are equal to any of the numbers 1-6.
                    // If either variable is equal to one of the numbers, it sets the corresponding boolean (one, two, three, etc.) to true and then prints out the number.
                    // REDO ROLL1 AND ROLL2 SEPARATELY TO HAVE THE "AND" IN THE MIDDLE
                    if (roll1 == 1 || roll2 == 1) {
                        one = true;
                        System.out.print(" 1");
                    }
                    if (roll1 == 2 || roll2 == 2) {
                        two = true;
                        System.out.print(" 2");
                    }
                    if (roll1 == 3 || roll2 == 3) {
                        three = true;
                        System.out.print(" 3");
                    }
                    if (roll1 == 4 || roll2 == 4) {
                        four = true;
                        System.out.print(" 4");
                    }
                    if (roll1 == 5 || roll2 == 5) {
                        five = true;
                        System.out.print(" 5");
                    }
                    if (roll1 == 6 || roll2 == 6) {
                        six = true;
                        System.out.print(" 6");
                    }
                }
                // at the end, prints out an empty line
                System.out.println();

                // This code prints out the numbers from 1 to 12 that have been declared as true.
                // uses if statements to check if each number is true, and if so, prints it out, followed by a space.
                System.out.print("Numbers covered: ");
                if (one) {
                    System.out.print("1 ");
                }
                if (two) {
                    System.out.print("2 ");
                }
                if (three) {
                    System.out.print("3 ");
                }
                if (four) {
                    System.out.print("4 ");
                }
                if (five) {
                    System.out.print("5 ");
                }
                if (six) {
                    System.out.print("6 ");
                }
                if (seven) {
                    System.out.print("7 ");
                }
                if (eight) {
                    System.out.print("8 ");
                }
                if (nine) {
                    System.out.print("9 ");
                }
                if (ten) {
                    System.out.print("10 ");
                }
                if (eleven) {
                    System.out.print("11 ");
                }
                if (twelve) {
                    System.out.print("12 ");
                }
                // at the end, prints out an empty line
                System.out.println();


                // This code is printing out the numbers from 1 to 12 that have not yet been covered.
                // uses series of if-statements to check each boolean for a value. If the boolean is false indicating that the number has not been covered, it is printed out.
                System.out.print("Numbers not yet covered: ");
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
                rollAmount -= 1;
                counter++;

                boolean win = one && two && three && four && five && six && seven && eight && nine && ten && eleven
                        && twelve;

                if (win) {
                    break;
                }
            }

            // Checks for a win by the user: if all the boolean values are true, win will be set to true.
            // Otherwise, it will be set to false.
            boolean win = one && two && three && four && five && six && seven && eight && nine && ten && eleven
                    && twelve;

            // checks to see if the user has won the game by checking the boolean "win"
            // If "win" is false, it prints a message to the user letting them know how many attempts they had and to try rolling some more.
            if (!win) {
                System.out.println("> You didnt finish the game yet :( You had " + counter + " attempts");
                System.out.println("> Try rolling some more");

                //  If the user has successfully rolled all 12 numbers, then the code checks to see if the total amount of rolls made is lower than the previous high score.
                // If it is, then the new total roll amount is set as the new high score and the user is informed that they made a new high score.
            } else {
                System.out.println("> You rolled all 12 numbers in " + counter + " attempts!");

                if (counter < highScore) {
                    highScore = counter;
                    System.out.println("!! You made a new high score of " + highScore + " rolls!");
                }

                // resets Scanner
                sc.nextLine();

                // code asks the user if they would like to play again.
                // If the answer is yes, the code will continue the loop.
                System.out.print("> Wanna play again? (YES/NO): ");
                String repeat = sc.nextLine();
                if (repeat.equalsIgnoreCase("YES")) {
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

                    continue;
                    // If the answer is no, the loop will be broken and the program will end.
                } else {
                    break;

                }
            }
        }
        // closes scanner
        sc.close();
    }
}