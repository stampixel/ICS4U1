public class SelectionSortDescending {
    public static void main(String[] args) {
        int[] array = {3, 5, 6, 2, 6, 2, 9};

        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }

        printArray(array);
    }


    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
