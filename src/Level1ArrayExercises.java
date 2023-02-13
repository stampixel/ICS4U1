public class Level1ArrayExercises {
    public static void main(String[] args) {
        int[] numbers = new int[10];

    }

    public static int[] initializeArray(int[] array) {
//        Arrays.fill(array, -1);
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
        return array;
    }
}
