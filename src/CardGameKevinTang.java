import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author kevin.tang
 * 2023.03.07
 */

public class CardGameKevinTang {
    /**
     * Card game created using the standard 52-card French-suited deck comprises 13 ranks in each of the four suits: clubs (♣), diamonds
     * ( ♦ ), hearts (♥) and spades (♠). Each suit includes three court cards (face cards), King, Queen and Jack,
     * with reversible (double-headed) images.
     * <p>
     * <p>
     * Create a deck of cards using a 2D array
     * Convert the 2D array deck of cards to a singular dimension array list
     * Shuffle the deck of card
     * Assuming there are a total of 4 players, distribute a total of 8 cards each
     * The player who’s 8 comes first wins (tie and no winner are also possible)
     *
     * @param args
     */
    public static void main(String[] args) {
        // Creating and printing the deck of cards
        String[][] cardDeck = createDeck();

        // Creates a singular dimensioned deck as an array list using the 2D array deck of cards
        ArrayList<String> singleDeck = new ArrayList<>();
        for (int i = 0; i < cardDeck.length; i++) {
            for (int j = 0; j < cardDeck[0].length; j++) {
                singleDeck.add(cardDeck[i][j]);
            }
        }
        System.out.println("Successfully created ArrayList using 2D array.");


        shuffle(singleDeck); // Shuffling the array list deck

        // Assume that there are 4 players, so we create a deck of cards for each player
        // 8 Cards per player
        ArrayList<String> player1 = deal(singleDeck, new ArrayList<>());
        ArrayList<String> player2 = deal(singleDeck, new ArrayList<>());
        ArrayList<String> player3 = deal(singleDeck, new ArrayList<>());
        ArrayList<String> player4 = deal(singleDeck, new ArrayList<>());

        display(singleDeck); // Prints the deck of cards in appropriate formatting

        // Creating an array list to keep track of each player's 8's index
        ArrayList<Integer> playerEightIndices = new ArrayList<>();

        // Using the findEight method and adding the index of the 8 into the array list
        playerEightIndices.add(findEight(player1));
        playerEightIndices.add(findEight(player2));
        playerEightIndices.add(findEight(player3));
        playerEightIndices.add(findEight(player4));
        System.out.println(playerEightIndices);


        int minIndexOf8 = Integer.MAX_VALUE; // Keep track of the lowest 8 index
        // Booleans to check for win/ties
        boolean winner = false;
        boolean tie = false;

        for (int i = 0; i < playerEightIndices.size(); i++) {
            if (playerEightIndices.get(i) == minIndexOf8) { // If the current minimum index of 8 is equal to a previous one
                // we turn tie to true
                tie = true;
            }
            // Checks for winner (a.k.a. the player with the lowest 8 index)
            if (playerEightIndices.get(i) != -1 && playerEightIndices.get(i) < minIndexOf8) {
                winner = true;
                minIndexOf8 = playerEightIndices.get(i);
            }
        }

        // Conditional statements to print specific messages of each condition, win, tie, or no winners.
        if (tie) { // Check for tie first because there's always a winner if there is a tie, but the same thing doesn't apply vice-versa
            System.out.print("There is a tie between these players: ");
            for (int i = 0; i < playerEightIndices.size(); i++) {
                if (playerEightIndices.get(i) == minIndexOf8) {
                    System.out.print("Player " + (i + 1) + "\t");
                }
            }
        } else if (!winner) {
            System.out.println("No eights found in all 4 player's hands! No winners.");
        } else {
            System.out.println("The winner is Player " + (playerEightIndices.indexOf(minIndexOf8) + 1) + "!");
        }
    }

    /**
     * Use a 2D array to create a standard deck of cards and display them to the screen in an organized format
     *
     * @return
     */
    public static String[][] createDeck() {
        // Creating 2D array of cards
        // S, H, D, C represents Spades, Hearts, Diamonds, and Clubs in the specified order
        // The numberings start from 1 (Ace) all the way to 14 (King)
        String[][] cards = new String[][]{
                {"S1", "H1", "D1", "C1"}, {"S2", "H2", "D2", "C2"}, {"S3", "H3", "D3", "C3"},
                {"S4", "H4", "D4", "C4"}, {"S5", "H5", "D5", "C5"}, {"S6", "H6", "D6", "C6"},
                {"S7", "H7", "D7", "C7"}, {"S8", "H8", "D8", "C8"}, {"S9", "H9", "D9", "C9"},
                {"S10", "H10", "D10", "C10"}, {"S11", "H11", "D11", "C11"}, {"S12", "H12", "D12", "C12"},
                {"S13", "H13", "D13", "C13"}, {"S14", "H14", "D14", "C14"}
        };

        for (int i = 0; i < cards[0].length; i++) {
            for (int j = 0; j < cards.length; j++) {
                System.out.print(cards[j][i] + " ");
            }
            System.out.println();
        }
        return cards;
    }

    /**
     * This method will take in your ArrayList as a parameter and shuffle the order of the elements
     * You may achieve this by traversing the ArrayList, generating a random number and then swapping elements.
     *
     * @param cards
     */
    public static void shuffle(ArrayList<String> cards) {
        for (int i = 0; i < cards.size() / 2; i++) { // Swap cards at least the length of the deck divided by two
            int randomPos1 = (int) (Math.random() * cards.size());

            // These 3 lines are needed in order to swap indices of specific elements
            String temp = cards.get(0);
            cards.set(0, cards.get(randomPos1));
            cards.set(randomPos1, temp);
        }
    }

    /**
     * this method should receive the playing deck and a players hand as parameters
     * It should then deal 8 cards to the player hand
     *
     * @param cards
     * @param playerHand
     * @return
     */
    public static ArrayList<String> deal(ArrayList<String> cards, ArrayList<String> playerHand) {
        for (int i = 0; i < 8; i++) { // 8 cards each
            String card = cards.get(0);
            playerHand.add(card); // Add card to player hand
            cards.remove(0); // After distributing the specific card, delete it from the main deck
        }
        return playerHand;
    }

    /**
     * Prints any deck of card in a singular line
     *
     * @param cards
     */
    public static void display(ArrayList<String> cards) {
        System.out.print("The current deck contains: ");
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(cards.get(i) + " ");
        }
        System.out.println();
    }

    /**
     * Find the index of 8 and returning it, returns -1 if it is not found
     *
     * @param playerHand
     * @return
     */
    public static int findEight(ArrayList<String> playerHand) {
        for (int i = 0; i < playerHand.size(); i++) {
            if (playerHand.get(i).endsWith("8")) { // If the specific card ends with 8
                return i;
            }
        }
        return -1;
    }
}
