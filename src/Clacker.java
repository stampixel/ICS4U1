import java.util.Scanner;

public class Clacker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rollSum = 0;

        System.out.print("Enter your name: ");
        String name = scan.next();
        int rollAmount = 0;
        int totalRollAmount = 0;
        int initialRollAmount = 0;
        int highScore = 100000;


        // 0 means the specific number in the specific location is covered, 1 means its uncovered. or vice versa idk
        String coveredNum = "000000000000";

        while (true) {
            while (true) {
                System.out.print("Enter amount of rolls (1-30): ");
                rollAmount = scan.nextInt();
                initialRollAmount= rollAmount;
                totalRollAmount += rollAmount;

                if (rollAmount < 1) {
                    System.out.println("Number of rolls has to be higher than 1.");
                } else if (rollAmount > 30) {
                    System.out.println("Number of rolls has to be 30 or under.");
                } else {
                    break;
                }
            }

            while (rollAmount > 0) {
                int roll1 = (int) (Math.random() * (6) + 1);
                int roll2 = (int) (Math.random() * (6) + 1);

                System.out.println("You rolled the following numbers: " + roll1 + " and " + roll2);

                if ((coveredNum.charAt(roll1 - 1)) == '1' && coveredNum.charAt(roll2 - 1) == '1') {
                    System.out.println("It covers " + (roll1 + roll2));

                    String temp = "";
                    for (int i = 0; i < coveredNum.length(); i++) {
                        if (i == (roll1 + roll2) - 1) {
                            temp += "1";
                        } else {
                            temp += coveredNum.charAt(i);
                        }
                    }
                    coveredNum = temp;

                    System.out.print("Numbers not yet covered: ");

                    for (int i = 0; i < coveredNum.length(); i++) {
                        if (coveredNum.charAt(i) != '1') {
                            System.out.print((i + 1) + " ");
                        }
                    }
                    System.out.println();
                } else {
                    System.out.println("It covers " + roll1 + " and " + roll2);


                    String temp = "";
                    for (int i = 0; i < coveredNum.length(); i++) {
                        if (i == roll1 - 1) {
                            temp += "1";
                        } else if (i == roll2 - 1) {
                            temp += "1";
                        } else {
                            temp += coveredNum.charAt(i);
                        }
                    }
                    coveredNum = temp;

                    System.out.print("Numbers not yet covered: ");

                    for (int i = 0; i < coveredNum.length(); i++) {
                        if (coveredNum.charAt(i) != '1') {
                            System.out.print((i + 1) + " ");
                        }
                    }
                    System.out.println();
                }
                rollAmount -= 1;
                if (rollAmount == 0) {
                    break;
                }
            }
            boolean win = true;
            for (int i = 0; i < coveredNum.length(); i++) {
                if (coveredNum.charAt(i) == '0') {
                    win = false;
                    break;
                }
            }

            if (!win) {
                System.out.println("You didnt finish the game in " + totalRollAmount + " yet");
                System.out.println("Try rolling some more");
            } else {
                System.out.println("you roled all 12 numbers in " + initialRollAmount);
                if (totalRollAmount < highScore) {
                    highScore = totalRollAmount;
                    System.out.println("You made a new high score!");
                }
                System.out.print("Wanna play again (0 for no, 1 for yes): ");
                if (scan.nextInt() == 1) {
                    continue;
                } else {
                    break;
                }
            }
        }
    }
}
