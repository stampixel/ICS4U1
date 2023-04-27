public class NumberGuessingGame {
    public static void main(String[] args) {
        int randInt = (int) (Math.random() * 100);

        System.out.println("It took Linear Search " + LinearSearch(randInt) + " guesses.");
        System.out.println("It took Binary Search " + BinarySearch(randInt) + " guesses.");

    }

    public static int LinearSearch(int num) {
        int guess = 0;
        while (guess != num) {
            guess += 1;
        }
        return guess;
    }

    public static int BinarySearch(int num) {
        int low = 0;
        int high = 100;
        int guess = 0;
        while (low != high) {
            guess += 1;
            int mid = (low + high) / 2;
            if (num == mid) {
                return guess;
            } else if (num > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return guess;
    }
}
