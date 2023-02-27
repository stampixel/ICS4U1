package Review;

public class MethodsPractice {
    public static void main(String[] args) {

    }

    /**
     * METHODS
     */
    public static int sum(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
