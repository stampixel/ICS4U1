import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author kevin.tang
 * 2023.03.07
 */

public class ArrayList2DArraySummativeKevinTang {
    /**
     * Card game where a deck of cards is created using a 2D array
     * 2D array is converted into a list
     * A game is then played, whoever has an 8 first in their deck wins
     *
     * @param args
     */
    public static void main(String[] args) {

        // Creating 2D array of cards
        // S, H, D, C represents Spades, Hearts, Diamonds, and Clubs in the specified order
        // The numberings start from 1 (Ace) all the way to 14 (King)
        String[][] cards = new String[][]{{"S1", "H1", "D1", "C1"}, {"S2", "H2", "D2", "C2"}, {"S3", "H3", "D3",
                "C3"}, {"S4", "H4", "D4", "C4"}, {"S5", "H5", "D5", "C5"}, {"S6", "H6", "D6", "C6"}, {"S7", "H7", "D7"
                , "C7"}, {"S8", "H8", "D8", "C8"}, {"S9", "H9", "D9", "C9"}, {"S10", "H10", "D10", "C10"}, {"S11",
                "H11", "D11", "C11"}, {"S12"
                , "H12", "D12", "C12"}, {"S13", "H13", "D13", "C13"}, {"S14", "H14", "D14", "C14"}};

        // Creates/Prints the deck
        createDeck(cards);

        // Creates a single deck using the currentl 2D array of cards that we have
        ArrayList<String> singleDeck = createArrayList(cards);

        shuffle(singleDeck); // Shuffling the deck

        // Assume that there are 4 players, so we create a deck of cards for each player
        // 8 Cards per player
        ArrayList<String> player1 = deal(singleDeck, new ArrayList<>());
        ArrayList<String> player2 = deal(singleDeck, new ArrayList<>());
        ArrayList<String> player3 = deal(singleDeck, new ArrayList<>());
        ArrayList<String> player4 = deal(singleDeck, new ArrayList<>());

        display(singleDeck); // Prints teh deck of cards in appropriate formatting

        // Creating an Arraylist to keep track of each player's 8's index
        ArrayList<Integer> playerEightIndices = new ArrayList<>();
        // Using the findEight method and adding the index of the 8 into the array list
        playerEightIndices.add(findEight(player1));
        playerEightIndices.add(findEight(player2));
        playerEightIndices.add(findEight(player3));
        playerEightIndices.add(findEight(player4));


        int min = 10000;

        // Booleans to check if its a win or a tie
        boolean winner = false;
        boolean tie = false;
        for (int i = 0; i < playerEightIndices.size() - 1; i++) {
            if (playerEightIndices.get(i) == min) { // If the current minimum index of 8 is equal to a previous one,
                // we turn tie to true
                tie = true;
            }
            if (playerEightIndices.get(i) != -1 && playerEightIndices.get(i) < min) {
                winner = true;
                min = playerEightIndices.get(i);
            }
        }

        // Conditional statements to print specific messages of each condition, win, tie, or no winners.
        if (!winner) {
            System.out.println("No eights found in all 4 player's hands! No winners.");
        } else if (tie) {
            System.out.print("There is a tie between these players: ");
            for (int i = 0; i < playerEightIndices.size() - 1; i++) {
                if (playerEightIndices.get(i) == min) {
                    System.out.print("Player" + (i + 1) + ", ");
                }
            }
        } else {
            System.out.println("The winner is Player " + (playerEightIndices.indexOf(min) + 1) + "!");
        }

    }

    /**
     * Creaing the deck
     *
     * @param cards
     */
    public static void createDeck(String[][] cards) {
        for (int i = 0; i < cards[0].length; i++) {
            for (int j = 0; j < cards.length; j++) {
                System.out.print(cards[j][i] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Creating an array list using the 2D array
     *
     * @param cards
     * @return
     */
    public static ArrayList<String> createArrayList(String[][] cards) {
        ArrayList<String> singleDeck = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            singleDeck.addAll(Arrays.asList(cards[i]).subList(0, cards[0].length));
        }
        System.out.println("Successfully created ArrayList using 2D array.");
        return singleDeck;
    }

    /**
     * Shouffling the deck of cards at least lenght/2 times, to ensure its well shuffled
     *
     * @param cards
     */
    public static void shuffle(ArrayList<String> cards) {
        for (int i = 0; i < cards.size() / 2; i++) {
            int randomPos1 = (int) (Math.random() * cards.size());

            // These 3 lines are needed in order to swap indices of specific elements
            String temp = cards.get(0);
            cards.set(0, cards.get(randomPos1));
            cards.set(randomPos1, temp);
        }
    }

    /**
     * Distribute cards to each player
     *
     * @param cards
     * @param playerHand
     * @return
     */
    public static ArrayList<String> deal(ArrayList<String> cards, ArrayList<String> playerHand) {
        for (int i = 0; i < 8; i++) { // 8 cards each
            String card = cards.get(0);
            playerHand.add(card);

            cards.remove(0); // after distribiting the card, it gets deleted from the main deck
        }
        return playerHand;
    }

    /**
     * prints deck
     *
     * @param cards
     */
    public static void display(ArrayList<String> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            System.out.print(cards.get(i) + " ");
        }
    }

    /**
     * Find the index of 8 and returning it, returns -1 if it is not found
     *
     * @param playerHand
     * @return
     */
    public static int findEight(ArrayList<String> playerHand) {
        for (int i = 0; i < playerHand.size() - 1; i++) {
            if (playerHand.get(i).endsWith("8")) {
                return i;
            }
        }
        return -1;
    }
}
