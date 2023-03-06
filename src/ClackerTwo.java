import java.util.Scanner;

public class ClackerTwo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scan.next();
        int rollAmount = 0;
        int totalRollAmount = 0;
        int highScore = 10000000;
        boolean win = false;

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


        while (true) {
            while (true) {
                System.out.print("Enter amount of rolls (1-30): ");
                rollAmount = scan.nextInt();
                if (rollAmount < 1) {
                    System.out.println("Number of rolls has to be higher than 1.");
                } else if (rollAmount > 30) {
                    System.out.println("Number of rolls has to be 30 or under.");
                } else {
                    totalRollAmount += rollAmount;
                    break;
                }
            }

            while (rollAmount > 0) {
                int roll1 = (int) (Math.random() * 6 + 1);
                int roll2 = (int) (Math.random() * 6 + 1);

                System.out.println("You rolled the following numbers: " + roll1 + " and " + roll2);

                if ((roll1 == 1 && roll2 == 6) || (roll1 == 6 && roll2 == 1) && one && six) {
                    seven = true;
                    System.out.println("It covers 7");
                } else if ((roll1 == 2 && roll2 == 5) || (roll1 == 5 && roll2 == 2) && two && five) {
                    seven = true;
                    System.out.println("It covers 7");
                } else if ((roll1 == 2 && roll2 == 6) || (roll1 == 6 && roll2 == 2) && two && six) {
                    eight = true;
                    System.out.println("It covers 8");
                } else if ((roll1 == 3 && roll2 == 4) || (roll1 == 4 && roll2 == 3) && three && four) {
                    seven = true;
                    System.out.println("It covers 7");
                } else if ((roll1 == 3 && roll2 == 5) || (roll1 == 5 && roll2 == 3) && three && five) {
                    eight = true;
                    System.out.println("It covers 8");
                } else if ((roll1 == 3 && roll2 == 6) || (roll1 == 6 && roll2 == 3) && three && six) {
                    nine = true;
                    System.out.println("It covers 9");
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
                System.out.println();

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
                System.out.println();

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
                rollAmount -= 1;

                win = one && two && three && four && five && six && seven && eight && nine && ten && eleven
                        && twelve;

                if (win) {
                    break;
                }
            }


            if (!win) {
                System.out.println("You didn't finish the game in " + totalRollAmount + " yet");
                System.out.println("Try rolling some more");
            } else {
                System.out.println("you rolled all 12 numbers in " + totalRollAmount);
                if (totalRollAmount < highScore) {
                    highScore = totalRollAmount;
                    System.out.println("You made a new high score!");
                }
                System.out.print("Wanna play again (0 for no, 1 for yes): ");
                if (scan.nextInt() == 1) {
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
                } else {
                    break;
                }
            }
        }
        scan.close();
    }
}
